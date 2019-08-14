package com.example.root.simuladownload;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.TextView;

public class Main extends Activity implements Runnable{

    ProgressBar progress;
    Thread th;
    Handler h;
    TextView txtp;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        progress = (ProgressBar) findViewById(R.id.progressBar4);
        txtp = (TextView) findViewById(R.id.txtPorcentagem);
    }

    public void download(View view){
        h = new Handler();
        th = new Thread(Main.this);
        th.start();
    }

    @Override
    public void run() {
        i=1;
        try {
            while(i<=100) {
                Thread.sleep(100);
                h.post(new Runnable(){
                    public void run() {
                        progress.setProgress(i++);
                        if(i < 101) txtp.setText(i+" %");
                    }
                });
            }
        }catch(Exception e) {}
    }
}
