package com.example.root.contatos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int KEY_CONTATO = 1;
    private static final String CATEGORIA_CONTATO = "livro";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
    }

    // onClick do XML
    public void click(View view){
        Uri uri = Uri.parse("content://com.android.contacts/contacts/");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(intent, KEY_CONTATO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data == null)
            textView.setText("Falha no contato");
        else{
            Uri contato = data.getData();
            Intent intent = new Intent(Intent.ACTION_VIEW, contato);
            startActivity(intent);
        }
    }
}
