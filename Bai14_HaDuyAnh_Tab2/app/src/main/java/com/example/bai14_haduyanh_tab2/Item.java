package com.example.bai14_haduyanh_tab2;

public class Item {
    private String maSo,tieuDe;
    private Integer like;


    public Item(String maSo, String tieuDe, Integer like) {
        this.maSo=maSo;
        this.tieuDe=tieuDe;
        this.like=like;
    }


    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }
}
