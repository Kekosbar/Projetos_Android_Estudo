package com.example.root.mensagem;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import script.Cadastro;
import script.ConnectServer;

public class CadastrarActivity extends AppCompatActivity {

    private EditText edNome, edEmail, edSenha, edConfSenha,
                    edDia, edMes, edAno;
    private RadioGroup radSexo;
    private TextView txtInfo;
    private Button btEnviar;
    private ProgressBar progressBar;
    private Handler handler = new Handler(); // Para acessar de dentro de uma thread

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        edNome = (EditText) findViewById(R.id.edNome);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edSenha = (EditText) findViewById(R.id.edSenha);
        edConfSenha = (EditText) findViewById(R.id.edConfSenha);
        edDia = (EditText) findViewById(R.id.edDia);
        edMes = (EditText) findViewById(R.id.edMes);
        edAno = (EditText) findViewById(R.id.edAno);
        radSexo = (RadioGroup) findViewById(R.id.radSexo);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        progressBar = (ProgressBar) findViewById(R.id.progressBarCadastro);
        btEnviar = (Button) findViewById(R.id.btEnviarCadastro);
    }

    public void clickEnviarCadastro(View view){
        // Pega e verifica campos vazios
        String nome = edNome.getText().toString();
        if (nome.equals("")) {mostraToasr("Campo nome vazio"); return;}
        String email = edEmail.getText().toString();
        if (email.equals("")) {mostraToasr("Campo Email vazio"); return;}
        String senha = edSenha.getText().toString();
        if (senha.equals("")) {mostraToasr("Campo senha vazio"); return;}
        String confSenha = edConfSenha.getText().toString();
        if (confSenha.equals("")) {mostraToasr("Campo confirmar senha vazio"); return;}
        // Senha e confirmaSenha iguais
        if (!senha.equals(confSenha)) {mostraToasr("Senhas diferentes"); return;}
        // Configura a data
        if (edDia.getText().toString().equals("")) {mostraToasr("Campo dia vazio"); return;}
        if (edMes.getText().toString().equals("")) {mostraToasr("Campo mes vazio"); return;}
        if (edAno.getText().toString().equals("")) {mostraToasr("Campo ano vazio"); return;}
        int dia = Integer.parseInt(edDia.getText().toString());
        int mes = Integer.parseInt(edMes.getText().toString());
        int ano = Integer.parseInt(edAno.getText().toString());
        String data = ano+"-"+mes+"-"+dia;
        SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date dataNasc;
        try {
            dataNasc = textFormat.parse(data);
        } catch (ParseException e) {
            mostraToasr("Data invalida");
            return;
        }
        // Botão de radio sexo
        int btid = radSexo.getCheckedRadioButtonId();
        if (btid == -1) {mostraToasr("Marque o sexo"); return;}
        RadioButton rdbt = (RadioButton) findViewById(btid);
        String x = rdbt.getText().toString();
        char sexo = x.equals("Masculino")? 'm' : 'f';

        Cadastro cadastro = new Cadastro(nome, senha, email, sexo, dataNasc);
        enviarCadastro(cadastro);
    }

    public void clickCancelar(View view){
        finish();
    }

    private void mostraToasr(String msm){
        Toast.makeText(this, msm, Toast.LENGTH_LONG).show();
    }

    private void enviarCadastro(final Cadastro cadastro){
        txtInfo.setText("Enviando...");
        progressBar.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                ConnectServer connect = ConnectServer.getInstance();
                boolean aux = false;
                try {
                    aux = connect.enviarCadastro(cadastro);
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                final boolean result = aux;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (result){
                            txtInfo.setText("Cadastrado com sucesso");
                            btEnviar.setEnabled(false);
                        }else
                            txtInfo.setText("FALHA ao cadastrar");
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }.start();
    }
}
