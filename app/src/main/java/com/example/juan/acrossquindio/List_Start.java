package com.example.juan.acrossquindio;

public class List_Start {
    private int idImage;
    private String nameItem;
    private String DescItem;

   public List_Start(int idImage, String nameItem, String DescItem) {
        this.idImage = idImage;
        this.nameItem = nameItem;
        this.DescItem = DescItem;
    }


    public int getIdImage() {
            return idImage;
        }
    public String getNameItem() {
        return nameItem;
    }
    public String getDescItem() {
        return DescItem;
    }

}
