package com.example.root.aula7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;

public class TelaIncluir extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText edNome, edDia, edMes, edAno, edCargaHoraria, edPreco;
    private DADCurso dc = DADCurso.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_incluir);

        edNome = (EditText) findViewById(R.id.edNome);
        edDia = (EditText) findViewById(R.id.editDataDia);
        edMes = (EditText) findViewById(R.id.editDataMes);
        edAno = (EditText) findViewById(R.id.editDataAno);
        edCargaHoraria = (EditText) findViewById(R.id.edCargHoraria);
        edPreco = (EditText) findViewById(R.id.edPreco);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Adicionando");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelaIncluir.this.finish();
            }
        });
    }

    public void clickSalvar(View v){
        Curso curso = new Curso();
        curso.setNomeCurso(edNome.getText().toString());
        curso.setCargaHoraria(Float.parseFloat(edCargaHoraria.getText().toString()));
        curso.setPrecoCurso(Float.parseFloat(edPreco.getText().toString()));
        String dia = edDia.getText().toString();
        String mes = edMes.getText().toString();
        String ano = edAno.getText().toString();
        String data = ano+"-"+mes+"-"+dia;
        Date date = java.sql.Date.valueOf(data);
        curso.setDataInicio(date);
        long id = dc.incluir(curso);
        if(id != -1) {
            curso.setIdCurso(id);
            Curso.lista_curso.add(curso);
            Toast.makeText(this, "Adicionado com sucesso", Toast.LENGTH_LONG).show();
            Curso.carregaListNomes();
            TelaInicial.atualizar();
        }
        Log.i("script", "Id "+id);
    }
}
