package com.example.root.telas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;

public class MainActivity extends Activity {

    private CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario);

}
