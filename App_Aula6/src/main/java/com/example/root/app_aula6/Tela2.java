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

public class Tela2 extends AppCompatActivity {

    private MeuServico3 meuServico3;
    private boolean vinculado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConn);
        vinculado = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MeuServico3.class);
        bindService(intent, serviceConn, Context.BIND_AUTO_CREATE);
    }

    public void clickBt(View v){
        if(vinculado){
            int num = meuServico3.obterNumeroRdomico();
            Toast.makeText(this, "Valor: "+num, Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Deu merda", Toast.LENGTH_SHORT).show();
    }

    private ServiceConnection serviceConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MeuServico3.ServicoVinculado serVinculado = (MeuServico3.ServicoVinculado) iBinder;
            meuServico3 = serVinculado.getService();
            vinculado = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            vinculado = false;
        }
    };
}
