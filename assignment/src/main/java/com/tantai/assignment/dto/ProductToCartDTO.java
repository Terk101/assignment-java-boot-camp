package com.tantai.assignment.dto;


import java.io.Serializable;

public class ProductToCartDTO implements Serializable {
    private Integer productId;
    private Integer qty;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ProductToCartDTO{" +
                "productId=" + productId +
                ", qty=" + qty +
                '}';
    }
}
