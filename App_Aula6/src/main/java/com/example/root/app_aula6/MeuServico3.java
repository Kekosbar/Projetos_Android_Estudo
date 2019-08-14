package com.example.root.app_aula6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MeuServico3 extends Service {
    public class ServicoVinculado extends Binder{
        MeuServico3 getService(){
            return MeuServico3.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        IBinder iBinder = new ServicoVinculado();
        return iBinder;
    }

    public int obterNumeroRdomico(){
        Random random = new Random();
        try{ return random.nextInt(100);}
        catch(Exception e){e.getMessage();}
        return 0;
    }
}
