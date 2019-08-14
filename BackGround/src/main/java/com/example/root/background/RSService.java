package com.example.root.background;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class RSService extends IntentService{
    /*
    * O intentService para e fecha sua execução
    * ao finalizar todas as suas tarefas, não sendo preciso usar o stopService
    */
    private static boolean b_filter_msm = false;
    private static boolean b_filter_number = false;

    public RSService() {
        super(RSService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("script", "Inicia service");
        Bundle bundle = intent.getExtras();
        Intent localIntent = null;
        switch (bundle.getString(MainActivity.KEY)){
            case "number":
                Log.i("script", "Service number iniciado");
                localIntent = new Intent (Constant.ACTION_1).putExtra (Constant.STATUS_1_INT, bundle.getInt(Constant.STATUS_1_INT));
                if(!b_filter_number) {
                    IntentFilter intentFilter = new IntentFilter(Constant.ACTION_1);
                    LocalBroadcastManager.getInstance(this).registerReceiver(new ResponseReceiver(), intentFilter);
                    b_filter_number = true;
                }
                break;
            case "msm":
                Log.i("script", "Service mensager iniciado");
                localIntent = new Intent (Constant.ACTION_2).putExtra (Constant.STATUS_2_STRING, bundle.getString(Constant.STATUS_2_STRING));
                if(!b_filter_msm) {
                    IntentFilter intentFilter = new IntentFilter(Constant.ACTION_2);
                    LocalBroadcastManager.getInstance(this).registerReceiver(new ResponseReceiver(), intentFilter);
                    b_filter_msm = true;
                }
                break;
        }
        // Transmite a intenção de receber nesta aplicação.
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);

        Log.i("script", "Finaliza service");
    }
}
