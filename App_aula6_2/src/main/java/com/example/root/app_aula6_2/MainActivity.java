package com.example.root.app_aula6_2;

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

    private MeuService meuService;
    private boolean vinculado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MeuService.class);
        bindService(intent, serviceConn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConn);
        vinculado = false;
    }

    public void click(View v){
        if(vinculado){
            int linhas = meuService.lerArquivo();
            Toast.makeText(this, "Numero de linhas: "+linhas, Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Deu merda", Toast.LENGTH_SHORT).show();
    }

    private ServiceConnection serviceConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MeuService.ServiceVinculado serVinculado = (MeuService.ServiceVinculado) iBinder;
            meuService = serVinculado.getService();
            vinculado = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            vinculado = false;
        }
    };
}
