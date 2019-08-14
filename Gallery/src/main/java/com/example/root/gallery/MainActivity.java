package com.example.root.gallery;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int[] imgINT = {R.drawable.img1, R.drawable.img2, R.drawable.img4,
                            R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8};

    private ViewPager viewPager;
    private AdapterImage adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPage);
        adapter = new AdapterImage(this, imgINT);
        viewPager.setAdapter(adapter);
    }
}
