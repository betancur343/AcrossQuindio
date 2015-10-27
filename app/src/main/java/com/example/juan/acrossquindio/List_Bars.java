package com.example.juan.acrossquindio;


public class List_Bars {
    private String nameItem;
    private int idImage;
    private String DescItem;


    public List_Bars(String nameItem, int idImage,  String DescItem) {
        this.nameItem = nameItem;
        this.idImage = idImage;
        this.DescItem = DescItem;

    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }
    public void setDescItem(String descItem) {
        DescItem = descItem;
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
}
