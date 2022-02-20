package com.tantai.assignment.service;

import com.tantai.assignment.domain.Product;
import com.tantai.assignment.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository repository;

    @Test
    void findProductByIdShouldNotBeNull() {
        Product product = new Product();
        product.setProductName("Nike Revolution 6 Next Nature");
        product.setProductDes("แด่การเริ่มต้นใหม่ระหว่างคุณกับทางเท้าผูกเชือกรองเท้าที่รีไซเคิล 100% " +
                "แล้วตั้งเป้าหมายที่จุดเริ่มต้นในเส้นทางแห่งการวิ่งของคุณด้วยความนุ่มจาก " +
                "Nike Revolution 6 Next Natureเรารู้ดีว่าความสบายคือหลักสำคัญของการวิ่งที่ประสบความสำเร็จ เ" +
                "ราจึงเน้นว่าทุกฝีก้าวของคุณต้องรองรับแรงกระแทกและยืดหยุ่นได้เพื่อย่างก้าวที่นุ่มนวลนี่คือวิวัฒนาการ" +
                "ของไอเท็มยอดนิยมที่มาพร้อมดีไซน์ระบายอากาศ ซึ่งผลิตจากวัสดุรีไซเคิลอย่างน้อย 20% ตามน้ำหนัก");
        product.setProductPrice(BigDecimal.valueOf(2100));
        when(repository.findById(1)).thenReturn(Optional.ofNullable(product));
        Product productReturn = productService.findProductById(1);

        Assertions.assertNotNull(product);
    }

    @Test
    void getProductByNameShouldNotBeEmpty() {
        Product product = new Product();
        product.setProductName("NEW BALANCE 373 V2 รองเท้าลำลองผู้ชาย");
        product.setProductDes("ปรับแต่งรูปทรงให้ปราณีตและแต่งรายละเอียดที่ดูหรูหรา\n" +
                "อัปเปอร์ผลิตจากหนังกลับและผ้าตาข่าย\n" +
                "พื้นรองเท้าแบบ EVA ช่วยลดแรงกระแทกที่พื้นรองเท้าชั้นกลางและส้นเท้าเพิ่มความสบาย\n" +
                "พื้นรองเท้าด้านนอกผลิตจากยาง มีความทนทานและยึดเกาะพื้นผิว");
        product.setProductPrice(BigDecimal.valueOf(1245));
        List<Product> products = Collections.singletonList(product);
        when(repository.findByProductNameContainingIgnoreCase("new balance")).thenReturn(products);
        List<Product> productReturn = productService.getProductByName("new balance");

        Assertions.assertFalse(productReturn.isEmpty());
    }
}