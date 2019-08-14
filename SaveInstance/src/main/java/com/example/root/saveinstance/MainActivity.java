package com.example.root.saveinstance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private ImageView imageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        if(savedInstanceState != null){
            Log.i("script", "Pegando imagem ja baixada");
            SaveImg saveImg = (SaveImg) savedInstanceState.getSerializable(SaveImg.KEY);
            bitmap = saveImg.bitmap;
            setImageView();
        }else
            baixaImg();
    }

    public void baixaImg() {
        new Thread() {
            public void run() {
                try {
                    Log.i("script", "Inicia download");
                    URL url = new URL("http://cdn.1001freedownloads.com/icon/thumb/394849/Mario-icon.png");
                    HttpURLConnection conection = (HttpURLConnection) url.openConnection();
                    conection.setDoInput(true);
                    conection.connect();
                    InputStream input = conection.getInputStream();
                    Log.i("script", "Finaliza download");
                    bitmap = BitmapFactory.decodeStream(input);
                    setImageView();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "ERROR, ao fazer o download", Toast.LENGTH_LONG).show();
                }
            }
        }.start();
    }

    public void setImageView(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);

        saveInstanceState.putSerializable(SaveImg.KEY, new SaveImg(bitmap));
    }
}
