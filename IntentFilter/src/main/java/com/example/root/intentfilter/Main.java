package com.example.root.intentfilter;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Main extends AppCompatActivity {

    private final int constanteTela = 11;
    private TextView txtSoma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtSoma = (TextView) findViewById(R.id.txtSoma);
    }

    public void abrirTela1(View v){
        Intent intent = new Intent("TELA_1");
        startActivityForResult(intent, constanteTela);
    }

    public void abrirTela2(View v){
        Intent intent = new Intent(this, Tela2.class);
        startActivityForResult(intent, constanteTela);
    }

    public void abrirBrowser(View v){
        Uri uri = Uri.parse("https://www.youtube.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        // abaixo verifica se há um aplicativo capaz de executar a ação solicitada
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        // se houver execute
        if(isIntentSafe)
            startActivity(intent);
    }

    @Override
    protected void onActivityResult(int Tela_Q_Chamou, int Tela_Q_Respondeu, Intent intent){
        // Tela q chamou e'esta tela atual q chamou uma activity
        // Tela q respondeu é a tela q esta enviando uma respota
        if(Tela_Q_Respondeu == 1)
            Toast.makeText(getApplicationContext(), "Veio da tela "+Tela_Q_Respondeu, Toast.LENGTH_LONG).show();
        else if(Tela_Q_Respondeu == 2){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                String x = bundle.getString("x");
                String y = bundle.getString("y");
                String res = bundle.getString("res");
                txtSoma.setText(x+" + "+y+" = "+res);
                Toast.makeText(getApplicationContext(), "Veio da tela "+Tela_Q_Respondeu, Toast.LENGTH_LONG).show();
            }
        }
    }
}
