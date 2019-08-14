package com.example.root.p5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textNome, textSite, textEndereco, textCidade, textEstado, textPais, textCEP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textNome = (TextView) findViewById(R.id.textNome);
        textSite = (TextView) findViewById(R.id.textSite);
        textEndereco = (TextView) findViewById(R.id.textEndereco);
        textCidade = (TextView) findViewById(R.id.textCidade);
        textEstado = (TextView) findViewById(R.id.textEstado);
        textPais = (TextView) findViewById(R.id.textPais);
        textCEP = (TextView) findViewById(R.id.textCEP);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            textNome.setText(bundle.getString(KEY.nome));
            textSite.setText(bundle.getString(KEY.site));
            textEndereco.setText(bundle.getString(KEY.endereco));
            textCidade.setText(bundle.getString(KEY.cidade));
            textEstado.setText(bundle.getString(KEY.estado));
            textPais.setText(bundle.getString(KEY.pais));
            textCEP.setText(bundle.getString(KEY.cep));
        }
    }

    public void voltar(View v){
        this.finish();
    }
}
