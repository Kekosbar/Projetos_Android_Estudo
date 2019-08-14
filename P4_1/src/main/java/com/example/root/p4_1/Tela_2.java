package com.example.root.p4_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tela_2 extends Activity {

    private Data dados = new Data();
    private ArrayList<ItemList> lista;
    private ListView listView;
    private Button bt;
    private TextView txtSelPag;
    private Button btComfirm;
    private PersonalListAdapter adapter;
    private int checkedPositionTrue = -1; // no inicio todos os checkbox estão desativados

    public Tela_2(){
        lista = new ArrayList<>();
        lista.add(new ItemList("C#"));
        lista.add(new ItemList("Java"));
        lista.add(new ItemList("Android Studio"));
        lista.add(new ItemList("Xamarin"));
        lista.add(new ItemList("Java Script"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_2);

        Intent intent = getIntent();
        dados = (Data) intent.getSerializableExtra(dados.KEY);

        txtSelPag = (TextView) findViewById(R.id.text_activity2);
        btComfirm = (Button) findViewById(R.id.button2);
        listView = (ListView) findViewById(R.id.listView);

        txtSelPag.setText(getString(R.string.sel_curso));
        btComfirm.setText(getString(R.string.sel_pagamento));

        adapter = new PersonalListAdapter(this, lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(checkedPositionTrue > -1)
                    lista.get(checkedPositionTrue).setCheck(false);
                checkedPositionTrue = position;
                lista.get(position).setCheck(true);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void clickComfirm(View v){
        if(checkedPositionTrue == -1)
            Toast.makeText(getApplicationContext(), "Você deve selecionar um curso antes de prosseguir", Toast.LENGTH_LONG).show();
        else{
            dados.setCurso(lista.get(checkedPositionTrue).getNameItem());
            Intent intent = new Intent(this, Tela_3.class);
            Bundle parametro = new Bundle();
            parametro.putSerializable(dados.KEY, dados);
            intent.putExtras(parametro);
            startActivity(intent);
        }
    }
}
