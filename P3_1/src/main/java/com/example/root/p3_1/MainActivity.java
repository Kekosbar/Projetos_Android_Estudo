package com.example.root.p3_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button[] bt = new Button[10];
    private Button btSoma, btSubtracao, btMulti, btDivisao, btPonto, btigual, btClear;
    private Calculadora calculo = new Calculadora();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit);

        conectaButtonsNumbersXML();
        conectaButtonsXML();

        actionButtonsNumbers();
        actionButtonsOthers();

    }

    public void conectaButtonsNumbersXML(){
        bt[0] = (Button) findViewById(R.id.bt0);
        bt[1] = (Button) findViewById(R.id.bt1);
        bt[2] = (Button) findViewById(R.id.bt2);
        bt[3] = (Button) findViewById(R.id.bt3);
        bt[4] = (Button) findViewById(R.id.bt4);
        bt[5] = (Button) findViewById(R.id.bt5);
        bt[6] = (Button) findViewById(R.id.bt6);
        bt[7] = (Button) findViewById(R.id.bt7);
        bt[8] = (Button) findViewById(R.id.bt8);
        bt[9] = (Button) findViewById(R.id.bt9);
    }

    public void conectaButtonsXML(){
        btSoma = (Button) findViewById(R.id.btSoma);
        btSubtracao = (Button) findViewById(R.id.btSubtracao);
        btMulti = (Button) findViewById(R.id.btMulti);
        btDivisao = (Button) findViewById(R.id.btDivisao);
        btigual = (Button) findViewById(R.id.btIgual);
        btPonto = (Button) findViewById(R.id.btPonto);
        btClear = (Button) findViewById(R.id.btClear);
    }

    public void actionButtonsNumbers(){
        bt[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"0");
            }
        });
        bt[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"1");
            }
        });
        bt[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"2");
            }
        });
        bt[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"3");
            }
        });
        bt[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"4");
            }
        });
        bt[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"5");
            }
        });
        bt[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"6");
            }
        });
        bt[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"7");
            }
        });
        bt[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"8");
            }
        });
        bt[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+"9");
            }
        });
    }

    public void actionButtonsOthers(){
        btSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+" + ");
            }
        });
        btSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+" - ");
            }
        });
        btMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+" x ");
            }
        });
        btDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+" / ");
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                calculo.setResultado(0);
            }
        });
        btPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+".");
            }
        });
        btigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invocaCalculo();
            }
        });
    }

    public void invocaCalculo(){
        calculo.setResultado(0); // zera a variavel res antes de fazer qualquer novo calculo
        String myString = editText.getText().toString();
        String[] str = myString.split(Pattern.quote(" ")); // separa as strings de numeros das de operações
        for (int i=0; i<str.length-2; i+=2){ // ate efetuar todos os calculos requisitados
            double x;
            double y;
            try{ // tenta converter string para double
                if(i < 1) // se estiver na primeira operção pegue o primeiro valor
                    x = Double.parseDouble(str[i]);
                else { // senão, pegue o valor do resultado para seguir as operações
                    x = calculo.getResultado();
                    calculo.setResultado(0); // as operações são de incremento, logo é preciso zerar o valor da variavel res, pois seu valor
                                            // ja foi pego pela variavel x
                }
                y = Double.parseDouble(str[i+2]);
            }catch (Exception e){ // caso o usuario digite errado faça
                Toast.makeText(getApplicationContext(), "Operação inválida", Toast.LENGTH_SHORT).show();
                return; // abandone a operação falha
            }
            switch (str[i+1]){
                case "+":
                    calculo.somar(x, y);
                    break;
                case "-":
                    calculo.subtracao(x, y);
                    break;
                case "x":
                    calculo.multiplicacao(x, y);
                    break;
                case "/":
                    calculo.divisao(x, y);
                    break;
            }
        }
        editText.setText(""+calculo.getResultado());
    }

}
