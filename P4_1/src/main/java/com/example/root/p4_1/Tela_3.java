package com.example.root.p4_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tela_3 extends Activity {

    private Data dados = new Data();
    private ArrayList<ItemList> lista;
    private TextView txtSelPag;
    private Button btComfirm;
    private ListView listView;
    private PersonalListAdapter adapter;
    private int checkedPositionTrue = -1;

    public Tela_3(){
        lista = new ArrayList<>();
        lista.add(new ItemList("Transferencia"));
        lista.add(new ItemList("DDC"));
        lista.add(new ItemList("Deposito"));
        lista.add(new ItemList("Cartão de credito"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_2);

        Intent intent = getIntent();
        dados = (Data) intent.getSerializableExtra(dados.KEY);;

        txtSelPag = (TextView) findViewById(R.id.text_activity2);
        btComfirm = (Button) findViewById(R.id.button2);
        listView = (ListView) findViewById(R.id.listView);

        txtSelPag.setText(getString(R.string.sel_pagamento));
        btComfirm.setText(getString(R.string.bt_confirmar));

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
            Toast.makeText(getApplicationContext(), "Selecione uma forma de pagamento antes de continuar", Toast.LENGTH_LONG).show();
        else{
            Intent intent =new Intent(this, Tela_4.class);
            Bundle parametro = new Bundle();
            dados.setPagamento(lista.get(checkedPositionTrue).getNameItem());
            parametro.putSerializable(dados.KEY, dados);
            intent.putExtras(parametro);
            startActivity(intent);
        }
    }
}
