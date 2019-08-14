package com.example.root.pa_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btConf = (Button) findViewById(R.id.btConf);
        btConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edEmail = (EditText) findViewById(R.id.edEmail);
                EditText edSenha = (EditText) findViewById(R.id.edSenha);
                Arquivo arquivo = new Arquivo(MainActivity.this);
                arquivo.gravar(edEmail.getText().toString(), edSenha.getText().toString());
                Intent intent = new Intent(MainActivity.this, Tela2.class);
                startActivity(intent);
            }
        });
    }
}
