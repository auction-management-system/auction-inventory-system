package com.bits.cpad.auctioninventorysystem.repository;

import com.bits.cpad.auctioninventorysystem.model.AuctionItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuctionItemRepository extends CrudRepository<AuctionItem, Long> {

    Optional<AuctionItem> findByItemName(@Param("itemName") String itemName);

    Optional<List<AuctionItem>> findByAuctioneerId(@Param("auctioneerId") Long auctioneerId);
}
