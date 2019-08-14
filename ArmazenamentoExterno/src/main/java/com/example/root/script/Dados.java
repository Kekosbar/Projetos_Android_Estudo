package com.example.root.script;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import script.Pasta;

public class Dados {

    public static void exibir(Pasta pasta1){
        for(int i=0; i<pasta1.subPastas.size(); i++){
            Log.i("script", pasta1.subPastas.get(i).nome);
            exibirArquivo(pasta1.subPastas.get(i));
            if(pasta1.subPastas.get(i).subPastas.size() > 0)
                exibir(pasta1.subPastas.get(i));
        }
    }

    public static void exibirArquivo(Pasta pasta1){
        for(int i=0; i<pasta1.arquivos.size(); i++){
            Log.i("script", "Arquivo: "+pasta1.arquivos.get(i));
        }
    }

    public static void getVetSubPastas(Pasta pasta, ArrayList<String> array){
        for(int i=0; i<pasta.subPastas.size(); i++)
            array.add(pasta.subPastas.get(i).nome);
    }
}
