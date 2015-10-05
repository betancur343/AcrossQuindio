package com.example.juan.acrossquindio;

/**
 * Created by Juan on 04/10/2015.
 */
public class List_Bars {
    private String nameItem;
    private int idImage;
    private String DescItem;


    public List_Bars(String nameItem, int idImage,  String DescItem) {
        this.nameItem = nameItem;
        this.idImage = idImage;
        this.DescItem = DescItem;

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
