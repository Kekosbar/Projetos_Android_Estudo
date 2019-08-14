package com.example.root.pa_3;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

    private Context context;
    private final String arquivo = "learning.txt";

    public Arquivo(Context context) {
        this.context = context;
    }

    public boolean gravar(String email, String senha){
        try {
            File f = new File(context.getExternalFilesDir(null), arquivo);
            FileOutputStream o = new FileOutputStream(f, true);
            o.write(email.getBytes());
            o.write("\n".getBytes());
            o.write(senha.getBytes());
            o.write("\n".getBytes());
            o.flush();
            o.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String[] ler() throws FileNotFoundException, IOException {
        String[] s = null;
        File f = new File(context.getExternalFilesDir(null), arquivo);
        if (f.exists()) {
            FileReader r = new FileReader(f);
            BufferedReader ler = new BufferedReader(r);
            s = new String[2];
            s[0] = ler.readLine();
            s[1] = ler.readLine();
            ler.close();
        }
        return s;
    }
}
