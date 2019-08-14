package com.example.root.testelist;

public class Item {

    private String item;
    private boolean check;

    public Item(String item){
        this.item = item;
        check = false;
    }

    public String getItem(){
        return item;
    }

    public void setItem(String item){
        this.item = item;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

}
