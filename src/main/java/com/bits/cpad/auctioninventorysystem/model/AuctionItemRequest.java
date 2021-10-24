package com.bits.cpad.auctioninventorysystem.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;
import java.sql.Date;


@Data
@ToString
@RequiredArgsConstructor
public class AuctionItemRequest {

    private String itemName;
    private String description;
    private Long auctioneerId;
    private Double reservePrice;
    private Double openingBidPrice;
    private Date auctionStartDateTime;
    private Date auctionEndDateTime;
    private String status;
    @Transient
    private MultipartFile image;

}
