package com.exemplo.caique.serverthreads;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor extends AsyncTask<Void, Void, Void> {

    static BufferedReader entrada;
    static PrintWriter saida;
    static Socket socket = null;

    @Override
    protected Void doInBackground(Void... arg0) {

        try {
            socket = new Socket("192.168.1.20", 2121);

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            Main.b = socket.isConnected();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void recc(){

        Servidor.saida.println("1");
        try {
            Main.x = entrada.readLine();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
