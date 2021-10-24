package com.bits.cpad.auctioninventorysystem.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(schema = "auction",name = "auction_item")
public class AuctionItem {

    @Id
    @GeneratedValue
    @Column(name = "itemId")
    private Long itemId;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "description")
    private String description;
    @Column(name = "auctioneerId")
    private Long auctioneerId;
    @Column(name = "reservePrice")
    private Double reservePrice;
    @Column(name = "openingBidPrice")
    private Double openingBidPrice;
    @Column(name = "auctionStartDateTime")
    private Date auctionStartDateTime;
    @Column(name = "auctionEndDateTime")
    private Date auctionEndDateTime;
    @Column(name = "status")
    private String status;
    @Lob
    @Column(name = "itemImage")
    private byte[] itemImage;

}
