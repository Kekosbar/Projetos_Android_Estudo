package com.example.root.background;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    public static final String KEY = "string";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
    }

    public void enviaMsm(View v){
        Intent intent = new Intent(this, RSService.class).putExtra(KEY, "msm")
                                                         .putExtra(Constant.STATUS_2_STRING, editText.getText().toString());
        startService(intent);
    }

    public void enviaNumero(View v){
        Intent intent = new Intent(this, RSService.class).putExtra(KEY, "number")
                                                         .putExtra(Constant.STATUS_1_INT, Integer.parseInt(editText.getText().toString()));
        startService(intent);
    }
}