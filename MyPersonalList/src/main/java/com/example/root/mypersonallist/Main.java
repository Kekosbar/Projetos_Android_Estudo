package com.example.root.mypersonallist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity {

    private Item item;

    private ListView list;
    private EditText edtxt;
    private Button botao;
    private AlertDialog.Builder mensagem;
    private ContentList adapter;

    public Main(){
        item = new Item();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        edtxt = (EditText) findViewById(R.id.editText);
        botao = (Button) findViewById(R.id.button);

        mensagem = new AlertDialog.Builder(this);

        adapter = new ContentList(this, item);

        list = (ListView) findViewById(R.id.myList);
        list.setAdapter(adapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
                mensagem.setTitle("Atenção");
                mensagem.setMessage("Apagar mensagem ?");
                mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        removeItem(position);
                    }
                });
                mensagem.setNegativeButton("Não", null);
                mensagem.show();
                return false;
            }
        });

        botao.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });
    }

    public void clickEdtxt(View v){
        if(edtxt.getText().toString().equals("Enviar mensagem")) edtxt.setText("");
    }

    public void clickDelete(View c){

        Toast.makeText(getApplicationContext(), "Tamanho da lista: "+item.checkBox.size(), Toast.LENGTH_SHORT).show();

        for(int i=0; i<item.checkBox.size(); i++)
            item.checkBox.get(i).setVisibility(View.VISIBLE);

    }

    public void addItem(){
        String msm = edtxt.getText().toString();
        item.addItem("Caique", "1212", msm);
        adapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), "Tamanho da lista: "+item.name.size(), Toast.LENGTH_SHORT).show();
    }

    public void removeItem(int position){
        item.removeItem(position);
        adapter.notifyDataSetChanged();
    }
}
