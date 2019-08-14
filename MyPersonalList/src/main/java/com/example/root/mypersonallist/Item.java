package com.example.root.mypersonallist;

import android.widget.CheckBox;

import java.util.ArrayList;

public class Item {

    ArrayList<String> name;
    ArrayList<String> number;
    ArrayList<String> msm;
    ArrayList<CheckBox> checkBox;

    public Item(){
        this.name = new ArrayList<>();
        this.number = new ArrayList<>();
        this.msm = new ArrayList<>();
        this.checkBox = new ArrayList<>();

        name.add("Ana"); name.add("Barbara"); name.add("Carlos"); name.add("Lucas"); name.add("João");
        number.add("0123"); number.add("1234"); number.add("2345"); number.add("3456"); number.add("3210");
        msm.add("Ola"); msm.add("tudo bem "); msm.add("ok galera"); msm.add("ate mais"); msm.add("não da não");
    }

    public void addItem(String name, String number, String msm){
        this.name.add(name);
        this.number.add(number);
        this.msm.add(msm);
    }

    public void removeItem(int position){
        this.name.remove(position);
        this.number.remove(position);
        this.msm.remove(position);
    }
}
