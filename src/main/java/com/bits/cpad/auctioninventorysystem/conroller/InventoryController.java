package com.bits.cpad.auctioninventorysystem.conroller;

import com.bits.cpad.auctioninventorysystem.model.AuctionItem;
import com.bits.cpad.auctioninventorysystem.model.AuctionItemRequest;
import com.bits.cpad.auctioninventorysystem.repository.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    @GetMapping("/item/{itemId}")
    public AuctionItem getItemById(@PathVariable("itemId") @NotNull Long itemId) {
        if (itemId != 0) {
            Optional<AuctionItem> auctionItem = auctionItemRepository.findById(itemId);
            return auctionItem.orElseGet(AuctionItem::new);
        } else throw new IllegalArgumentException("itemId in path is zero");
    }

    @GetMapping("/item")
    public AuctionItem getItemByUserName(@RequestParam("itemName") @NotNull String itemName) {
        if (!itemName.isEmpty()) {
            Optional<AuctionItem> auctionItem = auctionItemRepository.findByItemName(itemName);
            return auctionItem.orElseGet(AuctionItem::new);
        } else throw new IllegalArgumentException("itemName is null/empty");
    }

    @GetMapping("/item/user")
    public List<AuctionItem> getItemByUserId(@PathVariable("userId") @NotNull Long userId) {
        if (userId != 0) {
            Optional<List<AuctionItem>> auctionItems = auctionItemRepository.findByAuctioneerId(userId);
            return auctionItems.orElseGet(ArrayList::new);
        } else throw new IllegalArgumentException("userId is null/empty");

    }

    @GetMapping("/items")
    public List<AuctionItem> getAllItems() {
        Iterable<AuctionItem> auctionItemList = auctionItemRepository.findAll();
        List<AuctionItem> auctionItems = new ArrayList<>();
        auctionItemList.forEach(auctionItems::add);
        return auctionItems;
    }

    @PostMapping(name = "/item")
    public AuctionItem addUserDetails(@RequestBody @NotNull AuctionItemRequest auctionItemRequest) throws IOException {
        AuctionItem auctionItem = parseAuctionItem(auctionItemRequest);
        return auctionItemRepository.save(auctionItem);
    }

    private AuctionItem parseAuctionItem(AuctionItemRequest auctionItemRequest) throws IOException {
        AuctionItem auctionItem = new AuctionItem();
        auctionItem.setAuctioneerId(auctionItemRequest.getAuctioneerId());
        auctionItem.setItemName(auctionItemRequest.getItemName());
        auctionItem.setDescription(auctionItemRequest.getDescription());
        auctionItem.setReservePrice(auctionItemRequest.getReservePrice());
        auctionItem.setOpeningBidPrice(auctionItemRequest.getOpeningBidPrice());
        auctionItem.setAuctionStartDateTime(auctionItemRequest.getAuctionStartDateTime());
        auctionItem.setAuctionEndDateTime(auctionItemRequest.getAuctionEndDateTime());
        auctionItem.setStatus(auctionItemRequest.getStatus());
        auctionItem.setItemImage(auctionItemRequest.getImage().getBytes());
        return auctionItem;
    }

}
