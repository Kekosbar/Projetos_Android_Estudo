package com.example.root.aula7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {

    private ListView listView;
    private static ArrayAdapter<String> adapter;
    private Toolbar toolbar;

    private DADCurso dc;
    public static final String KEY_POS = "POSITION";
    public static final String KEY_CURSO = "CURSO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        dc = DADCurso.getInstance(this);
        dc.listar();
        Curso.carregaListNomes();
        listView = (ListView) findViewById(R.id.listView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(TelaInicial.this, TelaIncluir.class);
                startActivity(intent);
                return false;
            }
        });
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Curso.lista_nomes);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Curso curso = Curso.getCurso(position);
                Bundle bundle = new Bundle();
                //bundle.putInt(KEY, (int) curso.getIdCurso());
                bundle.putSerializable(KEY_CURSO, curso);
                bundle.putInt(KEY_POS, position);
                Intent intent = new Intent(TelaInicial.this, TelaAlterar.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public static void atualizar(){
        adapter.notifyDataSetChanged();
    }

}
