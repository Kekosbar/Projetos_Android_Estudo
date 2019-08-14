package com.example.root.hnadler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void baixar(View v){
        new Thread(){
            public void run(){
                try {
                    URL url = new URL("https://lh3.googleusercontent.com/YGqr3CRLm45jMF8eM8eQxc1VSERDTyzkv1CIng0qjcenJZxqV5DBgH5xlRTawnqNPcOp=w300");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    final Bitmap imagem = BitmapFactory.decodeStream(input);

                    Log.i("Livro", "Baixou imagem");

                    final ImageView img = (ImageView) findViewById(R.id.imageView);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            img.setImageBitmap(imagem);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
