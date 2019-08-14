package com.example.root.testelist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Main extends Activity {

    ArrayList<Item> items;
    ImageView imgLixeira, imgOk, imgCancel;
    Adapter adapter;
    AdapterDelete adapterDelete;
    ListView list;
    boolean deletando = false;

    public Main(){
        items = new ArrayList<>();
        for(int i=0; i<20; i++)
            items.add(new Item("Item "+i));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        imgLixeira = (ImageView) findViewById(R.id.imgLixeira);
        imgOk = (ImageView) findViewById(R.id.imgOk);
        imgCancel = (ImageView) findViewById(R.id.imgCancel);
        list = (ListView) findViewById(R.id.list);

        adapter = new Adapter(this, items);
        adapterDelete = new AdapterDelete(this, items);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(deletando){
                    items.get(position).setCheck(!items.get(position).isCheck());
                    adapterDelete.notifyDataSetChanged();
                }
            }
        });
    }

    public void clickDelete(View v){
        if(!deletando){
            imgCancel.setVisibility(View.VISIBLE);
            imgCancel.setClickable(true);
            imgOk.setVisibility(View.VISIBLE);
            imgOk.setClickable(true);
            deletando = true;
            list.setAdapter(adapterDelete);
        }
    }

    public void clickOk(View v){
        deletar();
    }

    public void clickCancel(View v){
        if(deletando){
            imgCancel.setVisibility(View.INVISIBLE);
            imgCancel.setClickable(false);
            imgOk.setVisibility(View.INVISIBLE);
            imgOk.setClickable(false);
            deletando = false;
            for(int i=0; i<items.size(); i++)
                items.get(i).setCheck(false);
            list.setAdapter(adapter);
        }
    }

    public void deletar(){
        int i=0;
        while(i < items.size()){
            if(items.get(i).isCheck()){
                items.remove(i);
                continue;
            }
            i++;
        }
        adapterDelete.notifyDataSetChanged();
    }
}
