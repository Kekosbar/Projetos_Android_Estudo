package com.example.root.script;

import android.app.Activity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import script.Pasta;


public class Server {

    private Socket socket = new Socket();
    private PrintWriter saida;
    private BufferedReader entrada;
    private ObjectInputStream objectInput;

    private Activity activity;
    private Config config;

    private String ip;
    private int port;

    public Server(Activity activity, Config config){
        this.ip = config.ip;
        this.port = config.port;
        this.activity = activity;
        this.config = config;
    }

    public void conecta(){
        if (!socket.isConnected()) {
            try {
                socket = new Socket(ip, port);
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                saida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                objectInput = new ObjectInputStream(socket.getInputStream());
                if(socket.isConnected() && config.ip == null)
                    new Arquivo().escreve(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Pasta recebeDadosIniciais() throws IOException {
        try {
            Pasta pasta = (Pasta) objectInput.readObject();
            return pasta;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isConnect(){
        return this.socket.isConnected();
    }

}

