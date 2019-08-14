package com.example.root.aula2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class Main extends AppCompatActivity {

    Button botaoOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        botaoOk = (Button) findViewById(R.id.button);

        botaoOk.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText) findViewById(R.id.editText);
                TextView status = (TextView) findViewById(R.id.textView);
                TextView email = (TextView) findViewById(R.id.textView2);
                String[] divide = nome.getText().toString().split(Pattern.quote("@"));
                status.setText(divide[0]);
                email.setText(divide[1]);
            }
        });
    }
}
