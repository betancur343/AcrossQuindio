package com.example.juan.acrossquindio;

public class List_Tourism {
    private String nameItem;
    private int idImage;
    private String Desc1Item;
    private String Desc2Item;

    public List_Tourism(String nameItem, int idImage, String Desc1Item, String Desc2Item) {
        this.idImage = idImage;
        this.nameItem = nameItem;
        this.Desc1Item = Desc1Item;
        this.Desc2Item = Desc2Item;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }
    public void setDesc1Item(String desc1Item) {
        Desc1Item = desc1Item;
    }
    public void setDesc2Item(String desc2Item) {
        Desc2Item = desc2Item;
    }

    public String getNameItem() {
        return nameItem;
    }
    public int getIdImage() {
        return idImage;
    }
    public String getDesc1Item() {
        return Desc1Item;
    }
    public String getDesc2Item() {
        return Desc2Item;
    }
}
