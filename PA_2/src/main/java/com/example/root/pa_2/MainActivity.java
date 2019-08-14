package com.example.root.pa_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btConf = (Button) findViewById(R.id.btConf);

        btConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edEmail = (EditText) findViewById(R.id.edEmail);
                EditText edSenha = (EditText) findViewById(R.id.edSenha);

                SharedPreferences preferences = getSharedPreferences(KEY.nameShared, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(KEY.email, edEmail.getText().toString());
                editor.putString(KEY.senha, edSenha.getText().toString());
                editor.commit();
                Intent intent = new Intent(MainActivity.this, Tela2.class);
                startActivity(intent);
            }
        });
    }
}
