package com.example.root.p3_1;

public class Calculadora {

    private double res = 0;

    public void setResultado(double res) {
        this.res = res;
    }

    public double getResultado() {
        return res;
    }

    public void somar(double x, double y){
        res += x + y;
    }

    public void subtracao(double x, double y){
        res += x - y;
    }

    public void multiplicacao(double x, double y){
        res += x * y;
    }

    public void divisao(double x, double y){
        res += x / y;
    }
}
