package com.example.root.livroexemplo1;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        Cursor c = getContentResolver().query(uri, null, null, null, null);
        startManagingCursor(c);
        String[] colunas = new String[] {ContactsContract.Contacts.DISPLAY_NAME};
        int[] campos = new int[] {R.id.nome};
        adapter = new SimpleCursorAdapter(this, R.layout.activity_main, c, colunas, campos);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Cursor c = (Cursor) adapter.getItem(position);
        String nameColuna = ContactsContract.Contacts.DISPLAY_NAME;
        String nome = c.getString(c.getColumnIndexOrThrow(nameColuna));
        Toast.makeText(this, "Contato: "+nome, Toast.LENGTH_SHORT).show();
    }

}
