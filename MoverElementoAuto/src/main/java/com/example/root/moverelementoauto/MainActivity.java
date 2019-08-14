package com.example.root.moverelementoauto;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView img;
    public static boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imageView);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(flag) {
            new Mover(img, event.getX(), event.getY()).start();
            flag = false;
        }
        return true;
    }

}
