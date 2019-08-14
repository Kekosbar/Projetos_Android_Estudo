package com.example.root.app_aula6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.textView);
    }

    public void click(View v){
        txt.setText("Iniciando serviço");
        Intent intent = new Intent(this, MeuServico.class);
        startService(intent);
    }
}
