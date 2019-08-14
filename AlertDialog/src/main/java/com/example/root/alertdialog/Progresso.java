package com.example.root.alertdialog;

import android.util.Log;
import android.widget.ProgressBar;

public class Progresso extends Thread {

    private int progresso = 0;
    private ProgressBar bar;

    public Progresso(ProgressBar bar) {
        this.bar = bar;
    }

    @Override
    public void run() {
        Log.i("script", "INICIOU A THREAD");
        while(progresso < 100){
            progresso++;
            bar.setProgress(progresso);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.i("script", "FIM DA THREAD");
    }
}
