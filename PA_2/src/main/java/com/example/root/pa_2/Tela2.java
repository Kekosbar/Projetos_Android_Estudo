package com.example.root.pa_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edEmail = (EditText) findViewById(R.id.edEmail);
                EditText edSenha = (EditText) findViewById(R.id.edSenha);
                SharedPreferences preferences = getSharedPreferences(KEY.nameShared, MODE_PRIVATE);
                String email = preferences.getString(KEY.email, "xx");
                String senha = preferences.getString(KEY.senha, "xx");
                if(email.equals(edEmail.getText().toString()) && senha.equals(edSenha.getText().toString()))
                    Toast.makeText(Tela2.this, "Logado com sucesso", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Tela2.this, "ERRO! Email ou senha incorretos", Toast.LENGTH_LONG).show();
            }
        });
    }
}
