package com.example.root.script;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        tiraFoto();
    }

    public void tiraFoto(){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            startActivityForResult(intent, 0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data != null){
            Bundle bundle = data.getExtras();
            if(bundle != null){
                bitmap = (Bitmap) bundle.get("data");

                ImageView imageView = (ImageView) findViewById(R.id.imgFoto);
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public void clickEnviaFoto(View v){

    }
}
