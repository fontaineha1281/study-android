package com.example.haduyanh_doancanhan;

public class Item
{
    private String maso,tieude;
    private Integer thich;
    public Item() {

    }
    public Item(String maso, String tieude, Integer thich)
    {
        this.maso= maso;
        this.tieude= tieude;
        this.thich= thich;
    }

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public Integer getThich() {
        return thich;
    }

    public void setThich(Integer thich) {
        this.thich = thich;
    }
}

