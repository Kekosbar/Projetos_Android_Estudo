package com.example.root.app_aula6_2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.io.IOException;

public class MeuService extends Service {

    public class ServiceVinculado extends Binder{
        MeuService getService(){
            return MeuService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        ServiceVinculado ibinder = new ServiceVinculado();
        return ibinder;
    }

    public int lerArquivo(){
        Arquivo arquivo = new Arquivo();
        try {
            return arquivo.Ler();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
