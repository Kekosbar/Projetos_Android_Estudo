package com.example.root.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, Activity2.class), 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("ticker");
        builder.setContentTitle("title");
        builder.setContentText("Descrição");
        builder.setSubText("Sub descrição");
        builder.setSmallIcon(R.drawable.jet);
        builder.setContentIntent(p);

        Notification notification = builder.build();
        nm.notify(0, notification);

        try {
            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone toque = RingtoneManager.getRingtone(this, som);
            toque.play();
        } catch (Exception e) {
            Log.i("script", "falha na reprodução do audio");
        }
    }

    public void act(View v){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
