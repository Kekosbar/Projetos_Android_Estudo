package com.example.root.mensagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class TrocaMsmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trocamsm);

        ListView list = (ListView) findViewById(R.id.listmsm);
        //ListAdaptador adaptador = new ListAdaptador(this, mensagens);
        //list.setAdapter(adaptador);
    }
}
