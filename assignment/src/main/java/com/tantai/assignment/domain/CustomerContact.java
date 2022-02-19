package com.tantai.assignment.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerContact {
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "house_no", nullable = false, length = 45)
    private String houseNo;

    @Column(name = "soi", nullable = false, length = 45)
    private String soi;

    @Column(name = "district", nullable = false, length = 45)
    private String district;

    @Column(name = "subdistrict", nullable = false, length = 45)
    private String subdistrict;

    @Column(name = "province", nullable = false, length = 45)
    private String province;

    @Column(name = "phone_no", nullable = false, length = 45)
    private String phoneNo;

    @Column(name = "zip_code", length = 45)
    private String zipCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getSoi() {
        return soi;
    }

    public void setSoi(String soi) {
        this.soi = soi;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
