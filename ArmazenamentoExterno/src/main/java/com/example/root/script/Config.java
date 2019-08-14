package com.example.root.script;

import java.io.IOException;

public class Config {

    public String ip;
    public final int port = 2525;

    public Config() {
        Arquivo arquivo = new Arquivo();
        try {
            ip = arquivo.Ler();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
