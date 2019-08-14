package com.example.root.app_aula6_2;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

    private String diretorioApp;

    public int Ler() throws IOException {
        diretorioApp = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "";
        File arq = new File(diretorioApp+"//log.txt");

        FileReader l = new FileReader(arq);
        BufferedReader ler = new BufferedReader(l);

        String linha = ler.readLine();
        int nLinhas = 0;
        while(linha != null){
            Log.i("script", linha);
            linha = ler.readLine();
            nLinhas++;
        }
        return nLinhas;
    }
}
