package com.example.root.app_aula6;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MeuServico extends Service {

    public MeuServico() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        incrementar();
        stopSelf();
        Log.i("MeuServico", "Encerrando");
        return START_STICKY_COMPATIBILITY;
    }

    public void incrementar(){
        Log.i("MeuServico", "Iniciando");
        for(int i=0; i<5; i++){
            Log.i("MeuServico", "Valor "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.i("MeuServico", "Erro");
            }
        }
    }
}
