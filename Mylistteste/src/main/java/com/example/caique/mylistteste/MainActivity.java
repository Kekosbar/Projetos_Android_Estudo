package com.example.caique.mylistteste;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/*
* ListView com icones iguais
*/

public class MainActivity extends ListActivity {

    String[] itemname = {"bola","lua","casa","rua"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setListAdapter(new ArrayAdapter<String>(
                this, R.layout.mylist,
                R.id.itemname, itemname
        ));
    }
}
