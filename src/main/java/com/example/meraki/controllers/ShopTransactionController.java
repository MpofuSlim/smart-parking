package com.example.meraki.controllers;

import com.example.meraki.services.ShopTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shop-transaction")
public class ShopTransactionController {

    private final ShopTransactionService shopTransactionService;

    @Autowired
    ShopTransactionController(ShopTransactionService shopTransactionService) {
        this.shopTransactionService = shopTransactionService;
    }

    @GetMapping("/testAuth/{token}")
    public ResponseEntity<?> testAuth(@PathVariable String token) {
        return shopTransactionService.testAuth(token);
    }

}
