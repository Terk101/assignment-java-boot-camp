package com.tantai.assignment.controller;

import com.tantai.assignment.domain.ShoppingCart;
import com.tantai.assignment.dto.ProductToCartDTO;
import com.tantai.assignment.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/card")
    public ResponseEntity<List<ShoppingCart>> shoppingCard(@RequestParam("customerId") Integer customerId) {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCardDataByCustomerId(customerId);
        return ResponseEntity.ok().body(shoppingCarts);
    }

    @PostMapping("/card")
    public ResponseEntity addProductToCart(@RequestParam("customerId") Integer customerId, @RequestBody List<ProductToCartDTO> productToCartDTOS) {
        shoppingCartService.addProductToCart(productToCartDTOS, customerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cart-checkout")
    public ResponseEntity addProductToCart(@RequestBody List<Integer>  cardIds, @RequestParam("customerId") Integer customerId) {
        shoppingCartService.checkoutProduct(cardIds, customerId);
        return ResponseEntity.ok().build();
    }
}
