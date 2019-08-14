package com.example.root.aula7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.util.regex.Pattern;

public class TelaAlterar extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView txtId;
    private EditText edNome, edDia, edMes, edAno, edCargaHoraria, edPreco;
    private DADCurso dc = DADCurso.getInstance(this);
    private int id;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_alterar);

        edNome = (EditText) findViewById(R.id.edNome);
        edDia = (EditText) findViewById(R.id.editDataDia);
        edMes = (EditText) findViewById(R.id.editDataMes);
        edAno = (EditText) findViewById(R.id.editDataAno);
        edCargaHoraria = (EditText) findViewById(R.id.edCargHoraria);
        edPreco = (EditText) findViewById(R.id.edPreco);
        txtId = (TextView) findViewById(R.id.txtId);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Editando");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelaAlterar.this.finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            Curso curso = (Curso) bundle.getSerializable(TelaInicial.KEY_CURSO);
            position = bundle.getInt(TelaInicial.KEY_POS);
            id = (int) curso.getIdCurso();
            setDados(curso);
        }else
            Toast.makeText(this, "Falha, um erro ocorreu", Toast.LENGTH_LONG).show();
    }

    public void setDados(Curso curso){
        txtId.setText("ID: "+String.valueOf(curso.getIdCurso()));
        edNome.setText(curso.getNomeCurso());
        Date date = curso.getDataInicio();
        String data = String.valueOf(date);
        String[] s = data.split(Pattern.quote("-"));
        edDia.setText(""+s[2]);
        edMes.setText(""+s[1]);
        edAno.setText(""+s[0]);
        edCargaHoraria.setText(""+curso.getCargaHoraria());
        edPreco.setText(""+curso.getPrecoCurso());
    }

    public void clickAlter(View v){
        Curso curso = new Curso();
        curso.setIdCurso(id);
        curso.setNomeCurso(edNome.getText().toString());
        curso.setCargaHoraria(Float.parseFloat(edCargaHoraria.getText().toString()));
        curso.setPrecoCurso(Float.parseFloat(edPreco.getText().toString()));
        String dia = edDia.getText().toString();
        String mes = edMes.getText().toString();
        String ano = edAno.getText().toString();
        String data = ano+"-"+mes+"-"+dia;
        Date date = java.sql.Date.valueOf(data);
        curso.setDataInicio(date);
        if(dc.alterar(curso)) {
            Curso.atualizarListas(id, curso, position);
            TelaInicial.atualizar();
            Toast.makeText(this, "Alterado com sucesso", Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this, "Falha, um erro ocorreu", Toast.LENGTH_LONG).show();
    }

    public void clickExcluir(View v){
        if(dc.excluir(id)){
            Curso.excluirNaLista(id);
            Toast.makeText(this, "Excluido com sucesso", Toast.LENGTH_LONG).show();
            TelaInicial.atualizar();
            finish();
        }else
            Toast.makeText(this, "Falha em excluir o elemento", Toast.LENGTH_LONG).show();
    }
}
