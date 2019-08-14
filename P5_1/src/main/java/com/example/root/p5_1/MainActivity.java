package com.example.root.p5_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edNome, edSite, edEndereco, edCidade, edEstado, edPais, edCEP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNome = (EditText) findViewById(R.id.edNome);
        edSite = (EditText) findViewById(R.id.edSite);
        edEndereco = (EditText) findViewById(R.id.edEndereco);
        edCidade = (EditText) findViewById(R.id.edCidade);
        edEstado = (EditText) findViewById(R.id.edEstado);
        edPais = (EditText) findViewById(R.id.edPais);
        edCEP = (EditText) findViewById(R.id.edCEP);
    }

    public void enviar(View v){
        Bundle bundle = new Bundle();
        bundle.putString(KEY.nome, edNome.getText().toString());
        bundle.putString(KEY.site, edSite.getText().toString());
        bundle.putString(KEY.endereco, edEndereco.getText().toString());
        bundle.putString(KEY.cidade, edCidade.getText().toString());
        bundle.putString(KEY.estado, edEstado.getText().toString());
        bundle.putString(KEY.pais, edPais.getText().toString());
        bundle.putString(KEY.cep, edCEP.getText().toString());

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
