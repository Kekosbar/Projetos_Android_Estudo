package com.example.root.pa_1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btIncluir = (Button) findViewById(R.id.btIncluir);
        Button btBuscar = (Button) findViewById(R.id.btBuscar);
        Button btGrava = (Button) findViewById(R.id.btGrava);
        ler(this);

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chave = "codigo";
                SharedPreferences preferencia = getSharedPreferences("wincomp", MODE_PRIVATE);
                String valor = preferencia.getString(chave, "999");
                String msg = "Valor: "+valor;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
        btIncluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chave = "codigo";
                EditText edValor = (EditText) findViewById(R.id.edCodigo);
                String valor = edValor.getText().toString();
                SharedPreferences preferencia = getSharedPreferences("wincomp", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencia.edit();
                editor.putString(chave, valor);
                editor.commit();
                String msg = valor+" incluido";
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
        btGrava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edSite = (EditText) findViewById(R.id.edSite);
                String site = edSite.getText().toString();
                String arquivo = "wincomp";
                try{
                    FileOutputStream esc = openFileOutput(arquivo, MODE_PRIVATE);
                    esc.write(site.getBytes());
                    esc.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

    public void ler(Context context){
        EditText edSite = (EditText) findViewById(R.id.edSite);
        String arquivo = "wincomp";
        try{
            byte[] dados = new byte[20];
            FileInputStream file = openFileInput(arquivo);
            file.read(dados);
            String site = new String(dados).trim();
            edSite.setText(site);
            file.close();
        }catch (Exception e){
            Toast.makeText(context, "Falhou ao ler o arquivo ou ele ainda não existe", Toast.LENGTH_LONG);
        }
    }
}
