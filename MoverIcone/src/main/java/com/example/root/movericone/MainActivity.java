package com.example.root.movericone;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX() - 150;
        float y = event.getY() - 150;

        img.setX(x);
        img.setY(y);
        return false;
    }
}
