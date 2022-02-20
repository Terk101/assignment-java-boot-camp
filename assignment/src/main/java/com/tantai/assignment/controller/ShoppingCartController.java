package com.tantai.assignment.controller;

import com.tantai.assignment.domain.OrderDetail;
import com.tantai.assignment.domain.ShoppingCart;
import com.tantai.assignment.dto.ProductToCartDTO;
import com.tantai.assignment.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/")
    public ResponseEntity<List<ShoppingCart>> shoppingCard(@RequestParam("customerId") Integer customerId) {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCardDataByCustomerId(customerId);
        return ResponseEntity.ok().body(shoppingCarts);
    }

    @PostMapping(value = "/",  consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ShoppingCart>> addProductToCart(@RequestParam("customerId") Integer customerId, @RequestBody List<ProductToCartDTO> productToCartDTOS) {
        List<ShoppingCart> shoppingCarts = shoppingCartService.addProductToCart(productToCartDTOS, customerId);
        return ResponseEntity.ok().body(shoppingCarts);
    }

    @PostMapping("/cart-checkout")
    public ResponseEntity<List<OrderDetail>> addProductToCart(@RequestBody List<Integer> cardIds, @RequestParam("customerId") Integer customerId) {
        List<OrderDetail> orderDetails = shoppingCartService.checkoutProduct(cardIds, customerId);
        return ResponseEntity.ok().body(orderDetails);
    }
}
