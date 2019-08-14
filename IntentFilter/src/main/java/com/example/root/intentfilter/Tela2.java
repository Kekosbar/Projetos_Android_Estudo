package com.example.root.intentfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tela2 extends AppCompatActivity {

    private final int codigoTela = 2;

    private EditText edValor1, edValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        edValor1 = (EditText) findViewById(R.id.editText);
        edValor2 = (EditText) findViewById(R.id.editText2);
    }

    public void somar(View v){
        double dx = Double.parseDouble(edValor1.getText().toString());
        double dy = Double.parseDouble(edValor2.getText().toString());
        double dres = dx + dy;

        String x = String.valueOf(dx);
        String y = String.valueOf(dy);
        String res = String.valueOf(dres);
        Intent intent = new Intent();
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        intent.putExtra("res", res);
        setResult(codigoTela, intent);
        finish();
    }

    public void voltar(View v){
        finish();
    }
}
