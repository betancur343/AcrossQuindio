package com.example.juan.acrossquindio;

public class List_Accommodation {
    private String nameItem;
    private int idImage;
    private String DescItem;
    private String priceItem;

    public List_Accommodation(String nameItem, int idImage,  String DescItem, String priceItem) {
        this.nameItem = nameItem;
        this.idImage = idImage;
        this.DescItem = DescItem;
        this.priceItem = priceItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }
    public void setDescItem(String descItem) {
        DescItem = descItem;
    }
    public void setPriceItem(String priceItem) {
        this.priceItem = priceItem;
    }

    public String getNameItem() {
        return nameItem;
    }
    public int getIdImage() {
        return idImage;
    }
    public String getDescItem() {
        return DescItem;
    }
    public String getPriceItem() {
        return priceItem;
    }
}
