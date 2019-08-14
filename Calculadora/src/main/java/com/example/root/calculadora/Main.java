package com.example.root.calculadora;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Main extends Activity {

    AlertDialog.Builder mensagem;
    EditText edVal1, edVal2;
    Button btSoma, btSub, btMul, btDiv;
    Spinner spinner;
    double val1, val2, res;
    private final String[] opcao = {"Selecione","Soma","Subtração","Multiplicação","Divisão"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edVal1 = (EditText) findViewById(R.id.edit1);
        edVal2 = (EditText) findViewById(R.id.edit2);

        btSoma = (Button) findViewById(R.id.btSoma);
        btSub = (Button) findViewById(R.id.btSubtracao);
        btMul = (Button) findViewById(R.id.btMultiplicacao);
        btDiv = (Button) findViewById(R.id.btDivisao);

        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcao));

        mensagem = new AlertDialog.Builder(this);
        mensagem.setTitle("Calculado");
        mensagem.setMessage("Resultado: "+res);
        mensagem.setNeutralButton("Ok", null);
    }

    public void getValue(){
        val1 = Double.parseDouble(edVal1.getText().toString());
        val2 = Double.parseDouble(edVal2.getText().toString());
    }

    public void exibeMSM(double res){
        mensagem.setMessage("Resultado: "+res);
        mensagem.show();
    }

    public void soma(View view){
        getValue();
        res = val1 + val2;
        exibeMSM(res);
    }

    public void subtracao(View view){
        getValue();
        res = val1 - val2;
        exibeMSM(res);
    }

    public void multiplicacao(View view){
        getValue();
        res = val1 * val2;
        exibeMSM(res);
    }

    public void divisao(View view){
        getValue();
        res = val1 / val2;
        exibeMSM(res);
    }

    public void Resultado(View view){
        switch (spinner.getSelectedItemPosition()){
            case 0: Toast.makeText(this, "Selecione uma operação", Toast.LENGTH_LONG).show(); break;
            case 1: soma(null); break;
            case 2: subtracao(null); break;
            case 3: multiplicacao(null); break;
            case 4: divisao(null);
        }

    }
}
