package com.example.root.aula7;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Curso implements Serializable{

    private long idCurso;
    private String nomeCurso;
    private Date dataInicio;
    private float precoCurso;
    private float cargaHoraria;

    public static ArrayList<Curso> lista_curso = new ArrayList<>();
    public static ArrayList<String> lista_nomes = new ArrayList<>();

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public float getPrecoCurso() {
        return precoCurso;
    }

    public void setPrecoCurso(float precoCurso) {
        this.precoCurso = precoCurso;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public static void carregaListNomes(){
        for(int i=lista_nomes.size(); i<lista_curso.size(); i++){
            lista_nomes.add(lista_curso.get(i).nomeCurso);
        }
    }

    public static void atualizarListas(int id, Curso curso, int position){
        for(int i=0; i<lista_curso.size(); i++) {
            if (lista_curso.get(i).getIdCurso() == id) {
                Curso.lista_curso.remove(position);
                Curso.lista_curso.add(position, curso);
                Curso.lista_nomes.remove(position);
                Curso.lista_nomes.add(position, curso.getNomeCurso());
                return;
            }
        }
    }

    public static void excluirNaLista(int id){
        for(int i=0; i<lista_curso.size(); i++){
            if(lista_curso.get(i).getIdCurso() == id){
                lista_curso.remove(i);
                lista_nomes.remove(i);
                return;
            }
        }
    }

    public static Curso getCurso(int position){
        return lista_curso.get(position);
    }
}
