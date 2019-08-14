package com.example.root.app_aula6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

public class MeuServico extends Service {

    public class ServicoVinculado extends Binder{
        MeuServico getService(){
            return MeuServico.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        IBinder mBinder = new ServicoVinculado();
        return mBinder;
    }

    public int numeroRandomico(){
        Random r = new Random();
        try{ return r.nextInt(100);}
        catch(Exception e){ Log.i("script", e.getMessage());}
        return 0;
    }
}
