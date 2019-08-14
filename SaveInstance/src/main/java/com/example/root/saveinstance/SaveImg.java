package com.example.root.saveinstance;

import android.graphics.Bitmap;

import java.io.Serializable;

public class SaveImg implements Serializable {

    public Bitmap bitmap;
    public static String KEY = "img";

    public SaveImg(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
