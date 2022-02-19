package com.tantai.assignment.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentRequestDTO implements Serializable {
    private String paymentMethod;
    private BigDecimal paidAmount;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }
}
