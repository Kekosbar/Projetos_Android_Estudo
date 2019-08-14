package com.example.root.barradeaplicativo;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        int tam = 25;
        String[] myString = criaString(tam);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myString);
        listView.setAdapter(adapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg));
        // Display icon in the toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(android.R.drawable.ic_lock_idle_alarm); // Se for para colocar um icone
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        // Abaixo coloca a seta de retorno
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // Abaixo click de um item do toolbar
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        // Abaixo click na seta de retorno
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Voltar", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if(i != 0)
                    getSupportActionBar().hide();
                else
                    getSupportActionBar().show();
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        SearchView ss = new SearchView(this);
        ss.setOnQueryTextListener(new SearchFiltro()); // Esta classe foi implementada logo abaixo

        MenuItem item = menu.add(0, 0, 0, "Item 1");
        item.setIcon(android.R.drawable.ic_menu_search);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item.setActionView(ss); // Executa a ação do view loho acima

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public String[] criaString(int tam){
        String[] myString = new String[tam];
        for (int i=1; i<=tam; i++){
            myString[i-1] = "Item "+i;
        }
        return myString;
    }

    private class SearchFiltro implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextChange(String s) {
            // Mudança na digitação
            Log.i("script", s);
            return false;
        }

        @Override
        public boolean onQueryTextSubmit(String s) {
            //Pega o resultado final
            Log.i("script", "String enviada: "+s);
            return false;
        }
    }

}
