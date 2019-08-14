package com.example.root.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mensagem de alerta");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("Alerta");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();
    }

    public void click2(View view){
        String[] items = new String[] {"Item 1", "Item 2", "Item 3", "Item 4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alerta com Lista");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Posição: "+i, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();
    }

    public void click3(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alerta com Progresso");

        LayoutInflater inflater = this.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.inflater,null,true);
        ProgressBar bar = (ProgressBar) rowview.findViewById(R.id.progressBar);
        Progresso progresso = new Progresso(bar);
        progresso.start();
        builder.setView(rowview).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }

}
