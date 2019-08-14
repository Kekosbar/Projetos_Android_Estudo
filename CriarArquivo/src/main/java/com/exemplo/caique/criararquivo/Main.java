package com.exemplo.caique.criararquivo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends AppCompatActivity {

    static TextView txtM;
    static EditText edM;
    File arq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtM = (TextView)findViewById(R.id.textView2);

        edM = (EditText)findViewById(R.id.editText);

    }

    public void cliqueEscreve(View v) throws IOException {

        try{
            String s, diretorioApp, nomeDiretorio="teste";
            diretorioApp = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    + "/"+nomeDiretorio+"/";
            File dir = new File(diretorioApp);

            if(!dir.exists())
                dir.mkdir();
            arq = new File(dir.getParentFile()+"/"+nomeDiretorio+"/dados.txt");
            if(!arq.exists())
                arq.createNewFile();
            FileWriter fw = new FileWriter(arq, true);
            BufferedWriter escreve = new BufferedWriter(fw);

            String cont = edM.getText().toString();
            escreve.write(cont);
            escreve.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void cliqueMostre(View v){

        try {
            FileReader l = new FileReader(arq);
            BufferedReader ler = new BufferedReader(l);

            String txt = ler.readLine();
            while(txt != null){
                txtM.setText(txt);
                txt = ler.readLine();
            }
            ler.close();
            l.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
