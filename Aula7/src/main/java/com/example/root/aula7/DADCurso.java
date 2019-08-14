package com.example.root.aula7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.Date;

public class DADCurso {

    private static final String[] COLUMNS = {"idCurso", "nomeCurso", "dataInicio", "precoCurso", "cargaHoraria"};
    public SQLiteDatabase db;
    private static final DADCurso instance = new DADCurso();

    public static DADCurso getInstance(Context context){
        if(instance.db == null || !instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return instance;
    }

    public long incluir(Curso curso){
        long id = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues(4);
            cv.put(COLUMNS[1], curso.getNomeCurso());
            cv.put(COLUMNS[2], String.valueOf(curso.getDataInicio()));
            cv.put(COLUMNS[3], curso.getPrecoCurso());
            cv.put(COLUMNS[4], curso.getCargaHoraria());
            id = db.insert(DB.CURSO, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
        return id;
    }

    public boolean alterar(Curso curso){
        boolean b = false;
        db.beginTransaction();
        try{
            long id = curso.getIdCurso();
            ContentValues cv = new ContentValues(4);
            cv.put(COLUMNS[1], curso.getNomeCurso());
            cv.put(COLUMNS[2], String.valueOf(curso.getDataInicio()));
            cv.put(COLUMNS[3], curso.getPrecoCurso());
            cv.put(COLUMNS[4], curso.getCargaHoraria());
            db.update(DB.CURSO, cv, COLUMNS[0]+"="+id, null);
            db.setTransactionSuccessful();
            b = true;
        }finally {
            db.endTransaction();
        }
        return b;
    }

    public boolean excluir(int id){
        boolean b = false;
        db.beginTransaction();
        try{
            db.delete(DB.CURSO, COLUMNS[0]+"="+id, null);
            db.setTransactionSuccessful();
            b = true;
        }finally {
            db.endTransaction();
        }
        return b;
    }

    private Curso carregaCurso(Cursor c){
        Curso curso = new Curso();
        curso.setIdCurso(c.getInt(c.getColumnIndex(COLUMNS[0])));
        curso.setNomeCurso(c.getString(c.getColumnIndex(COLUMNS[1])));
        curso.setDataInicio(Date.valueOf(c.getString(c.getColumnIndex(COLUMNS[2]))));
        curso.setPrecoCurso(c.getFloat(c.getColumnIndex(COLUMNS[3])));
        curso.setCargaHoraria(c.getFloat(c.getColumnIndex(COLUMNS[4])));
        return curso;
    }

    public void listar(){
        Cursor c = db.query(DB.CURSO, null, null, null, null, null, null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Curso curso = carregaCurso(c);
            Curso.lista_curso.add(curso);
            c.moveToNext();
        }
    }
}
