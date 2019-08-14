package com.example.root.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

class ResponseReceiver extends BroadcastReceiver{

    private String LOG = "script";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(LOG, "Inicia broadcast");
        Log.i(LOG, "Intent: "+intent.getAction());
        Bundle bundle = intent.getExtras();
        switch (intent.getAction()){
            case Constant.ACTION_1:
                timer(bundle.getInt(Constant.STATUS_1_INT));
                break;
            case Constant.ACTION_2:
                msm(bundle.getString(Constant.STATUS_2_STRING));
                break;
        }
        Log.i(LOG, "Finaliza broadcast");
    }

    private void timer(int x){
        Log.i(LOG, "Valor: "+x);
    }

    private void msm(String msm){
        Log.i(LOG, "Mensagem recebida: "+msm);
    }
}