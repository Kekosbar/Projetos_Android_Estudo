package com.example.root.testetoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<FeedItem> feedItemList = new ArrayList<>();
    private ArrayList<String> myString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addItems(25);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, feedItemList);
        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //recyclerView.setAdapter(adapter);

        iniciaString(25);
        ListView list = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myString);

        list.setAdapter(adapter1);

    }

    public void addItems(int tam){
        for (int i=1; i<=tam; i++){
            feedItemList.add(new FeedItem("Item "+i, "SubItem "+i));
        }
    }

    public void iniciaString(int tam){
        for (int i=1; i<=tam; i++){
            myString.add("Item "+i);
        }
    }
}
