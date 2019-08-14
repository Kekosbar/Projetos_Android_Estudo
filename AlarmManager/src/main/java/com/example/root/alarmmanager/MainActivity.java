package com.example.root.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("ALARME_DISPARADO");
        PendingIntent p = PendingIntent.getBroadcast(this, 0, intent, 0);

        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(java.util.Calendar.SECOND, 3);

        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),5000, p);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Intent intent = new Intent("ALARME_DISPARADO");
        PendingIntent p = PendingIntent.getActivity(this, 0, intent, 0);
        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm.cancel(p);
    }
}
