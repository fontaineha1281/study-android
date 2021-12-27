package com.example.bai12_haduyanh_custom1;

public class Phone {
    private int imgPhone;
    private String namePhone;

    public int getImgPhone() {
        return imgPhone;
    }

    public void setImgPhone(int imgPhone) {
        this.imgPhone = imgPhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }
    //tạo constructor
    public Phone(int imgPhone, String namePhone) {
        this.imgPhone = imgPhone;
        this.namePhone = namePhone;
    }
}
