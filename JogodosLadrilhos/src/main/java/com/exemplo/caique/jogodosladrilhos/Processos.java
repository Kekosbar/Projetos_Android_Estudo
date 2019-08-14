package com.exemplo.caique.jogodosladrilhos;

import android.view.View;

import java.util.Random;

public class Processos {

    private static int quadro[][] = new int[3][3], ni=3, nj=3, pos0i, pos0j;

    public static void sorteiQuadroInicio(){

        Random gerador = new Random();
        int v[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int x, p=0;
        boolean b;

        while (p != 9){
            x = gerador.nextInt(9);
            b = true;
            for (int i=0; i<9; i++){
                if(v[i] == x){
                    b = false;
                    break;
                }
            }
            if (b == true){
                v[p] = x;
                p++;
            }
        }
        p = 0;
        for (int i=0; i<ni; i++) {
            for (int j = 0; j < nj; j++) {
                quadro[i][j] = v[p];
                p++;
            }
        }
    }

    public static void posicaoInicial0(){

        for (int i=0; i<ni; i++){
            for (int j=0; j<nj; j++){
                if(quadro[i][j] == 0){
                    pos0i = i;
                    pos0j = j;
                }
            }
        }
    }

    public static void atualizaQuadro(){

        int p = 0;
        for (int i=0; i<ni; i++){
            for (int j=0; j<nj; j++){
                if(quadro[i][j] == 0)
                    Main.bt[p].setText(" ");
                else
                    Main.bt[p].setText(""+quadro[i][j]);
                p++;
            }
        }
    }

    public static boolean verifValidaJogada(int posbti, int posbtj){

        if ((posbti-1 == pos0i) && (posbtj == pos0j)) //para cima
            return true;
        if ((posbti == pos0i) && (posbtj+1 == pos0j)) //para direita
            return true;
        if ((posbti == pos0i) && (posbtj-1 == pos0j)) //para esquerda
            return true;
        if ((posbti+1 == pos0i) && (posbtj == pos0j)) //para baixo
            return true;
        return false;
    }

    public static void processaJogada(int posbti, int posbtj){

        int salva;
        salva = quadro[posbti][posbtj];
        quadro[posbti][posbtj] = 0;
        quadro[pos0i][pos0j] = salva;
        pos0i = posbti;
        pos0j = posbtj;
        atualizaQuadro();
        boolean b = verifFim();
        if(b)
            fimDeJogo();
    }

    public static boolean verifFim(){

        if (quadro[0][0] == 1) {
            int p = 0;
            int[] v = new int[ni * nj];
            for (int i = 0; i < ni; i++) {
                for (int j = 0; j < nj; j++) {
                    v[p] = quadro[i][j];
                    p++;
                }
            }
            for (int i = 0; i < (ni * nj) - 1; i++) {
                if (i > 0) {
                    if (v[i] < v[i - 1]) {
                        return false;
                    }
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public static void fimDeJogo(){

        for (int i=0; i<9; i++){
            Main.bt[i].setEnabled(false);
        }
        Main.txt.setText("Parabéns, fim de jogo");
        Main.btReinicio.setVisibility(View.VISIBLE);
    }
}
