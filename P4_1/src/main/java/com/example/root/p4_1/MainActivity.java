package com.example.root.p4_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edName, edEmail;
    private Data dados = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Android Studio - Wincomp");
        edName = (EditText) findViewById(R.id.edName);
        edEmail = (EditText) findViewById(R.id.edEmail);
    }

    public void selecionaCurso(View v){
        String name = edName.getText().toString();
        String email = edEmail.getText().toString();
        if(!name.equals("") && !email.equals("")){
            // salvar dados dados
            dados.setName(name);
            dados.setEmail(email);

            Intent intent = new Intent(this, Tela_2.class);
            Bundle parametro = new Bundle();
            parametro.putSerializable(dados.KEY, dados);
            intent.putExtras(parametro);
            startActivity(intent);
        }else
            Toast.makeText(getApplicationContext(), "Há campos em branco", Toast.LENGTH_LONG).show();
    }
}
