package com.example.root.app_aula6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MeuServico mServico;
    private boolean vinculado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MeuServico.class);
        bindService(intent, mServiceConn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mServiceConn);
        vinculado = false;
    }

    public void click(View view){
        if(vinculado){
            int n = mServico.numeroRandomico();
            Toast.makeText(this, "Numero: "+n, Toast.LENGTH_SHORT).show();
        }
    }

    private ServiceConnection mServiceConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MeuServico.ServicoVinculado mServiceVinc = (MeuServico.ServicoVinculado) iBinder;
            mServico = mServiceVinc.getService();
            vinculado = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            vinculado = false;
        }
    };
}
