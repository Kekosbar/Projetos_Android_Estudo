package com.example.root.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends FragmentActivity {

    private FragmentManager fm = getSupportFragmentManager();
    private Fragment1 frag1 = new Fragment1();
    private Fragment2 frag2 = new Fragment2();
    private EditText edit;
    private Button btProximo;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        edit = (EditText) findViewById(R.id.editText);
        btProximo = (Button) findViewById(R.id.button2);
        //frag1 = (Fragment1) fm.findFragmentById(R.id.fragment1);

        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0 || position == 2) {
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frame_layout, frag1, "frag1");
                    ft.commit();
                    position = 1;
                }else{
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frame_layout, frag2, "frag2");
                    ft.commit();
                    position = 2;
                }
            }
        });
    }

    public void click(View v){
        if(position == 1){
            Fragment1 frag = (Fragment1) fm.findFragmentByTag("frag1");
            frag.alteraTxt(edit.getText().toString());
        }else{
            Fragment2 frag = (Fragment2) fm.findFragmentByTag("frag2");
            frag.alteraTxt(edit.getText().toString());
        }
        edit.setText("");
    }
}
