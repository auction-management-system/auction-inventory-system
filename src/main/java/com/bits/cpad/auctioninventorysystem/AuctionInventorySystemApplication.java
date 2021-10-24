package com.bits.cpad.auctioninventorysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AuctionInventorySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionInventorySystemApplication.class, args);
	}

}
