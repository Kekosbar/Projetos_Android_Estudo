package com.example.root.testetoolbar;

public class FeedItem {

    private String item;
    private String subItem;

    public FeedItem(String item, String subItem) {
        this.item = item;
        this.subItem = subItem;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSubItem() {
        return subItem;
    }

    public void setSubItem(String subItem) {
        this.subItem = subItem;
    }
}
