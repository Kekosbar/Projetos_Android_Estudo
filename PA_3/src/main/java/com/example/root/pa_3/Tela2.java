package com.example.root.pa_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class Tela2 extends AppCompatActivity {

    private String email;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        String[] s;
        try {
            s = ler();
            email = s[0];
            senha = s[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edEmail = (EditText) findViewById(R.id.edEmail);
                EditText edSenha = (EditText) findViewById(R.id.edSenha);
                if (email.equals(edEmail.getText().toString()) && senha.equals(edSenha.getText().toString()))
                    Toast.makeText(Tela2.this, "Logado com sucesso", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Tela2.this, "ERRO! Email ou senha incorretos", Toast.LENGTH_LONG).show();
            }
        });
    }

    private String[] ler() throws IOException {
        return new Arquivo(this).ler();
    }
}
