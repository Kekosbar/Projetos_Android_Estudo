package com.example.root.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("script", "Funcionando");
    }
}
