package com.example.root.p4_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela_4 extends AppCompatActivity {

    private Data dados = new Data();
    private TextView txtName, txtEmail, txtCurso, txtPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_4);

        setTitle("Resultado");

        Intent intent = getIntent();
        dados = (Data) intent.getSerializableExtra(dados.KEY);

        txtName = (TextView) findViewById(R.id.txtNameResult);
        txtEmail = (TextView) findViewById(R.id.txtEmailResult);
        txtCurso = (TextView) findViewById(R.id.txtCursoResult);
        txtPagamento = (TextView) findViewById(R.id.txtPagamentoResult);

        txtName.setText("Nome: "+dados.getName());
        txtEmail.setText("Email: "+dados.getEmail());
        txtCurso.setText("Curso: "+dados.getCurso());
        txtPagamento.setText("Pagamento: "+dados.getPagamento());
    }
}
