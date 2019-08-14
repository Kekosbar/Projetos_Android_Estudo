package com.example.root.alarmmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class Broadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("script", "acessa broadcast");
        notificacao(context, new Intent(context, MainActivity.class), "Notificação", "Titulo", "Notificação recebida", "funcionando perfeitamente");
    }

    public void notificacao(Context context, Intent intent, String ticker, String title, String text, String subText){
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent p = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setTicker(ticker);
        builder.setContentTitle(title);
        builder.setContentText(text);
        builder.setSubText(subText);
        builder.setSmallIcon(R.drawable.unnamed);
        builder.setContentIntent(p);

        Notification notification = builder.build();
        nm.notify(0, notification);

        try {
            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone toque = RingtoneManager.getRingtone(context, som);
            toque.play();
        } catch (Exception e) {
            Log.i("script", "falha na reprodução do audio");
        }
    }
}
