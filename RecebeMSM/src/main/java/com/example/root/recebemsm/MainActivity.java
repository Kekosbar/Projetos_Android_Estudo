package com.example.root.recebemsm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String log = "script";
    private final String key = "string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if(Intent.ACTION_SEND.equals(action) && type != null){
            Log.i(log, "Recebido");
            if(type.equals("text/plain")){
                TextView txt = (TextView) findViewById(R.id.textView);
                String texto = intent.getStringExtra(Intent.EXTRA_TEXT);
                txt.setText(texto);
            }
        }
    }
}
