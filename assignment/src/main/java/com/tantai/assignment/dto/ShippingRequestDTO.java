package com.tantai.assignment.dto;

import java.io.Serializable;

public class ShippingRequestDTO implements Serializable {
    private String email;
    private String name;
    private String address;
    private String postCode;
    private String district;
    private String province;
    private String phoneNo;
    private boolean isUseCurrentAddress;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean getUseCurrentAddress() {
        return isUseCurrentAddress;
    }

    public void setUseCurrentAddress(boolean useCurrentAddress) {
        isUseCurrentAddress = useCurrentAddress;
    }

    @Override
    public String toString() {
        return "ShippingRequestDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", isUseCurrentAddress=" + isUseCurrentAddress +
                '}';
    }
}
