package com.example.root.script;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import script.Pasta;

public class MainActivity extends AppCompatActivity {

    private Server server;
    private Config config;
    private Pasta pasta;

    private ListView listView;
    private Toolbar toolbar;
    private Handler handler = new Handler();
    private static ProgressBar progressBar;
    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        progressBar = (ProgressBar) findViewById(R.id.progressBarMain);
        textView = (TextView) findViewById(R.id.textMainConnect);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setTitle("Teste");

        config = new Config();
        server = new Server(this, config);
        final Activity activity = this;
        if(config.ip != null)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    server.conecta();
                    if (server.isConnect()) {
                        try {
                            pasta = server.recebeDadosIniciais();
                            iniciaListView(activity);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        else{
            solicitaIp("Digite o IP do PC com o programa para armazenamento externo", this);
        }
    }

    public void iniciaListView(final Activity activity){
        handler.post(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> array = new ArrayList<>();
                Dados.getVetSubPastas(pasta, array);
                CustomAdapter adapter = new CustomAdapter(activity, array);
                listView.setAdapter(adapter);
            }
        });
    }

    public void solicitaIp(String msm, final Activity activity){
        final EditText editText = new EditText(activity);
        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle("Informe IP");
        alert.setMessage(msm);
        alert.setView(editText, 10, 0, 10, 0);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                server.setIp(editText.getText().toString());
                progressBar.setVisibility(View.VISIBLE);
                iniciaServer(activity);
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        handler.post(new Runnable() {
            @Override
            public void run() {
                alert.show();
            }
        });
    }

    public void iniciaServer(final Activity activity){
        new Thread(new Runnable() {
            @Override
            public void run() {
                server.conecta();
                Log.i("script", "Teste 1");
                if(server.isConnect()){
                    try {
                        pasta = server.recebeDadosIniciais();
                        iniciaListView(activity);
                    } catch (IOException e) {e.printStackTrace();}
                }else{
                    Log.i("script", "Não conectado");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            solicitaIp("ERRO: IP invalido\nPC ou software de armazenamento pode estar desligado", activity);
                        }
                    }).start();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                        textView.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();
    }

    public void clickCamera(View v){
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
}
