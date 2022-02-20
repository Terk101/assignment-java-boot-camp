package com.tantai.assignment.service;


import com.tantai.assignment.domain.*;
import com.tantai.assignment.dto.ProductToCartDTO;
import com.tantai.assignment.repository.OrderDetailRepository;
import com.tantai.assignment.repository.OrderRepository;
import com.tantai.assignment.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {
    private ProductService productService;
    private CustomerService customerService;
    private ShoppingCartRepository shoppingCartRepository;
    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;

    public ShoppingCartService(ProductService productService, CustomerService customerService
            , ShoppingCartRepository shoppingCartRepository
            , OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.productService = productService;
        this.customerService = customerService;
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Transactional
    public List<ShoppingCart> addProductToCart(List<ProductToCartDTO> products, Integer customerId) {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        for (ProductToCartDTO productDto : products) {
            Product product = productService.findProductById(productDto.getProductId());
            Customer customer = customerService.getCustomerById(customerId);
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setProduct(product);
            shoppingCart.setCustomer(customer);
            shoppingCart.setItemQty(productDto.getQty());
            shoppingCart.setTotalCost(calProductPrice(productDto.getQty(), product.getProductPrice()));
            shoppingCart.setCartStatus(CartStatus.INITIAL.toString());
            shoppingCarts.add(shoppingCart);
        }
       return shoppingCartRepository.saveAll(shoppingCarts);
    }

    public List<ShoppingCart> getShoppingCardDataByCustomerId(Integer customerId) {
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findShoppingCartDataByCustomerId(customerId);
        return shoppingCarts;
    }

    @Transactional
    public List<OrderDetail> checkoutProduct(List<Integer> shoppingCardIds, Integer customerId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        Customer customer = customerService.getCustomerById(customerId);
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.PENDING.toString());
        Order newOrder = orderRepository.save(order);
        for (Integer shoppingCardId : shoppingCardIds) {
            ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCardId)
                    .orElseThrow(IllegalArgumentException::new);
            shoppingCart.setCartStatus(CartStatus.ORDERED.toString());
            shoppingCartRepository.save(shoppingCart);
            Product product = shoppingCart.getProduct();
            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setCard(shoppingCart);
            orderDetail.setProduct(product);
            orderDetail.setOderQty(shoppingCart.getItemQty());
            orderDetail.setOrder(newOrder);
            orderDetails.add(orderDetail);
        }
       return orderDetailRepository.saveAll(orderDetails);
    }

    private BigDecimal calProductPrice(Integer productQty, BigDecimal productPrice) {
        return productPrice.multiply(BigDecimal.valueOf(productQty));
    }
}
