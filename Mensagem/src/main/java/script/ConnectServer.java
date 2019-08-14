package script;

import android.util.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectServer {

    private Socket socket;
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;

    private static ConnectServer instance = null;

    private ConnectServer(){
        try {
            Log.i("script", "Inicia conexão");
            socket = new Socket("192.168.1.114", 2727);
            saida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());

            instance = this;
            Log.i("script", "Conexão concluida");
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.i("script", ex.toString());
            Log.i("script", "FALHA na conexão");
        }
    }

    public static synchronized ConnectServer getInstance(){
        //if ((instance == null || instance.socket == null) || (!instance.socket.isConnected()))
            instance = new ConnectServer();
        return instance;
    }

    public boolean enviarCadastro(Cadastro cadastro) throws IOException, ClassNotFoundException {
        if(socket == null) return false;
        saida.writeObject("Cadastro");
        saida.writeObject(cadastro);
        String resultado = (String) entrada.readObject();
        if(resultado.equals("s"))
            return true;
        else
            return false;
        //objectOut.flush();
    }
}
