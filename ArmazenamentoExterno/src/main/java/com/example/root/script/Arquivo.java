package com.example.root.script;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    private static String diretorioApp;
    private final static String nomeDiretorio="Armazenamento externo";

    public String Ler() throws IOException {
        diretorioApp = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "";
        diretorioApp = diretorioApp.substring(0, diretorioApp.length() - 5);
        diretorioApp = diretorioApp + "/"+nomeDiretorio+"/";
        File dir = new File(diretorioApp);
        File arq = new File(dir.getParentFile()+"/"+nomeDiretorio+"/dados.txt");
        if (arq.exists()) {
            FileReader l = new FileReader(arq);
            BufferedReader ler = new BufferedReader(l);
            String s = ler.readLine();
            ler.close();
            return s;
        }
        return null;
    }

    public void escreve(String ip) throws IOException {
        File dir = new File(diretorioApp);
        if(!dir.exists())
            dir.mkdir();
        File arq = new File(dir.getParentFile()+"/"+nomeDiretorio+"/dados.txt");
        if(!arq.exists())
            arq.createNewFile();

        FileWriter fw = new FileWriter(arq, false);
        BufferedWriter escreve = new BufferedWriter(fw);

        escreve.write(ip);
        escreve.newLine();

        escreve.close();
    }
}
