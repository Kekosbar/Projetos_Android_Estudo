package com.example.root.moverelementoauto;

import android.util.Log;
import android.view.View;

public class Mover extends Thread {
    private float x, y;
    private int altura;
    private int largura;
    private final int pulo = 10;
    private final int timer = 10;
    private View view;

    public Mover(View view, float x, float y) {
        this.x = x;
        this.view = view;
        this.y = y;
        this.altura = view.getHeight();
        this.largura = view.getWidth()/2;
    }

    @Override
    public void run() {
        String s = String.format("Y: %,.2f Img Y: %,.2f", y, view.getY());
        Log.d("script", s);
        try {
            if (view.getY() > y)
                subir();
            else if (view.getX() < y)
                descer();
            if(view.getX() > x)
                direita();
            else if(view.getX() < x)
                esquerda();
        } catch (InterruptedException e) {
            Log.e("script", "ERRO EM THREAD SLEEP");
        }
        //Log.i("script", "TERMINOU THREAD");
        MainActivity.flag = true;
    }

    public void subir() throws InterruptedException {
        Log.i("script", "Subir");
        while(view.getY()+altura > y){
            view.setY(view.getY() - pulo);
            Thread.sleep(timer);
        }
    }

    public void descer() throws InterruptedException {
        Log.i("script", "Descer");
        while(view.getY()+altura < y){
            view.setY(view.getY() + pulo);
            Thread.sleep(timer);
        }
    }

    public void direita() throws InterruptedException {
        while(view.getX() + largura > x){
            view.setX(view.getX() - pulo);
            Thread.sleep(timer);
        }
    }

    public void esquerda() throws InterruptedException {
        while(view.getX() + largura < x){
            view.setX(view.getX() + pulo);
            Thread.sleep(timer);
        }
    }
}
