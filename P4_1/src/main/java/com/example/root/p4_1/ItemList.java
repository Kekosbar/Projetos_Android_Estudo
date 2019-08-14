package com.example.root.p4_1;

public class ItemList {

    private String nameItem;
    private boolean check;

    public ItemList(String nameItem) {

        this.nameItem = nameItem;
        check = false;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
