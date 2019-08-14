package com.exemplo.caique.jogodosladrilhos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    static Button[] bt;
    static Button btReinicio;
    static TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bt = new Button[9];
        bt[0] = (Button)findViewById(R.id.bt1);
        bt[1] = (Button)findViewById(R.id.bt2);
        bt[2] = (Button)findViewById(R.id.bt3);
        bt[3] = (Button)findViewById(R.id.bt4);
        bt[4] = (Button)findViewById(R.id.bt5);
        bt[5] = (Button)findViewById(R.id.bt6);
        bt[6] = (Button)findViewById(R.id.bt7);
        bt[7] = (Button)findViewById(R.id.bt8);
        bt[8] = (Button)findViewById(R.id.bt9);
        btReinicio = (Button)findViewById(R.id.btReinicio);

        txt = (TextView)findViewById(R.id.txt);

        Processos.sorteiQuadroInicio();
        Processos.posicaoInicial0();
        Processos.atualizaQuadro();
    }

    public void cliqueBt1(View v){

        int posbti = 0;
        int posbtj = 0;
        boolean b = Processos.verifValidaJogada(posbti, posbtj);
        if (b)
            Processos.processaJogada(posbti, posbtj);
    }

    public void cliqueBt2(View v){

        int posbti = 0;
        int posbtj = 1;
        boolean b = Processos.verifValidaJogada(posbti, posbtj);
        if (b)
            Processos.processaJogada(posbti, posbtj);
    }

    public void cliqueBt3(View v){

        int posbti = 0;
        int posbtj = 2;
        boolean b = Processos.verifValidaJogada(posbti, posbtj);
        if (b)
            Processos.processaJogada(posbti, posbtj);
    }

    public void cliqueBt4(View v){

        int posbti = 1;
        int posbtj = 0;
        boolean b = Processos.verifValidaJogada(posbti, posbtj);
        if (b)
            Processos.processaJogada(posbti, posbtj);
    }

    public void cliqueBt5(View v){

        int posbti = 1;
        int posbtj = 1;
        boolean b = Processos.verifValidaJogada(posbti, posbtj);
        if (b)
            Processos.processaJogada(posbti, posbtj);
    }

    public void cliqueBt6(View v){

        int posbti = 1;
        int posbtj = 2;
        boolean b = Processos.verifValidaJogada(posbti, posbtj);
        if (b)
            Processos.processaJogada(posbti, posbtj);
    }

    public void cliqueBt7(View v){

        int posbti = 2;
        int posbtj = 0;
        boolean b = Processos.verifValidaJogada(posbti, posbtj);
        if (b)
            Processos.processaJogada(posbti, posbtj);
    }

    public void cliqueBt8(View v){

        int posbti = 2;
        int posbtj = 1;
        boolean b = Processos.verifValidaJogada(posbti, posbtj);
        if (b)
            Processos.processaJogada(posbti, posbtj);
    }

    public void cliqueBt9(View v){

        int posbti = 2;
        int posbtj = 2;
        boolean b = Processos.verifValidaJogada(posbti, posbtj);
        if (b)
            Processos.processaJogada(posbti, posbtj);
    }

    public void cliqueReinicio(View v){


        for (int i=0; i<9; i++){
            bt[i].setEnabled(true);
        }
        txt.setText("");
        btReinicio.setVisibility(View.INVISIBLE);
        Processos.sorteiQuadroInicio();
        Processos.posicaoInicial0();
        Processos.atualizaQuadro();
    }
}
