package com.exemplo.caique.serverthreads;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class Main extends AppCompatActivity {

    static String x;

    private TextView txt;
    private EditText edit;
    static boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.txt);
        edit = (EditText)findViewById(R.id.editText);

        Servidor i = new Servidor();
        i.execute();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(b)
            txt.setText("Conectado");
        else
            txt.setText("Nao conectado");
    }

    public class Teste extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                Servidor.saida.println("1");
                x = Servidor.entrada.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void enviar(View v){

        Servidor.saida.println("0");
        x = (edit.getText().toString());
        Servidor.saida.println(x);
    }

    public void recebe(View v){

        Teste i = new Teste();
        i.execute();
        txt.setText(x);
    }
}
