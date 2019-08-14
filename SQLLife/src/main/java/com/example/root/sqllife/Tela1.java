package com.example.root.sqllife;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class Tela1 extends Activity implements View.OnClickListener{

    private DADCategoria dc;

    private Button alterar;
    private Button excluir;
    private Button incluir;
    private Button sair;
    private EditText cxIdCategoria;
    private EditText cxCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        dc = DADCategoria.getInstance(this);

        alterar = (Button) findViewById(R.id.btAlterar);
        alterar.setOnClickListener(new AlterarButton());

        excluir = (Button) findViewById(R.id.btExcluir);
        excluir.setOnClickListener(new ExcluirButton());

        incluir = (Button) findViewById(R.id.btIncluir);
        incluir.setOnClickListener(new IncluirButton());

        sair = (Button) findViewById(R.id.btSair);
        sair.setOnClickListener(this);

        cxIdCategoria = (EditText) findViewById(R.id.edIdCategoria);
        cxCategoria = (EditText) findViewById(R.id.edCategoria);
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    public void listar(){
        List<Categoria> lista = dc.listar();
        int linha = 0;

        Iterator<Categoria> i = lista.iterator();
        while(i.hasNext()){
            Categoria c = (Categoria) i.next();
            int id = c.getIdCategoria();
            String categoria = c.getCategoria();
            String msg = "Id: " + id + ", Categoria: " + categoria;
            linha = linha + 1;
            Log.i("RESULTADO", "Linha " + linha + ": " + msg);
        }
    }

    public class AlterarButton implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            int idCategoria = Integer.parseInt(cxIdCategoria.getText().toString());
            String categoria = cxCategoria.getText().toString();
            Categoria c = new Categoria();
            c.setIdCategoria(idCategoria);
            c.setCategoria(categoria);
            dc.alterar(c);
            Toast.makeText(Tela1.this, "Registro alterado com sucesso", Toast.LENGTH_LONG).show();
            cxIdCategoria.setText("");
            cxCategoria.setText("");
        }
    }

    public class IncluirButton implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String categoria = cxCategoria.getText().toString();
            Categoria c = new Categoria();
            c.setCategoria(categoria);
            dc.incluit(c);
            Toast.makeText(Tela1.this, "Registro incluido com sucesso", Toast.LENGTH_LONG).show();
            cxIdCategoria.setText("");
            cxCategoria.setText("");
            listar();
        }
    }

    public class ExcluirButton implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            int idCategoria = Integer.parseInt(cxIdCategoria.getText().toString());
            dc.excluit(idCategoria);
            Toast.makeText(Tela1.this, "Registro excluido com sucesso", Toast.LENGTH_LONG).show();
            cxIdCategoria.setText("");
            cxCategoria.setText("");
            listar();
        }
    }
}
