package com.example.root.sqllife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DADCategoria {

    private static final String[] COLUNNS_TBL_CATEGORIA = {"idCategoria", "categoria"};
    public SQLiteDatabase db;
    private static DADCategoria instance = new DADCategoria();

    public static DADCategoria getInstance(Context context){
        if(instance.db == null || !instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return instance;
    }

    public long incluit(Categoria c){
        long idCategoria = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues(1);
            cv.put(COLUNNS_TBL_CATEGORIA[1], c.getCategoria());
            idCategoria = db.insert(DB.CATEGORIA, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
        return idCategoria;
    }

    public void excluit(int id){
        db.beginTransaction();
        try{
            db.delete(DB.CATEGORIA, COLUNNS_TBL_CATEGORIA[0] + "=?", new String[]{String.valueOf(id)});
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    public void alterar(Categoria c){
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put(COLUNNS_TBL_CATEGORIA[1], c.getCategoria());
            db.update(DB.CATEGORIA, cv, COLUNNS_TBL_CATEGORIA[0] + "=?", new String[]{String.valueOf(c.getIdCategoria())});
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    public Categoria buscar(int id){
        Cursor c = db.query(DB.CATEGORIA, null, COLUNNS_TBL_CATEGORIA[0]+"="+id, null, null, null, null);
        if(c.getCount() > 0){
            c.moveToFirst();
            return carregaCategoria(c);
        }
        return null;
    }

    public Categoria carregaCategoria(Cursor c){
        int idCat = c.getInt(c.getColumnIndex(COLUNNS_TBL_CATEGORIA[0]));
        String cat = c.getString(c.getColumnIndex(COLUNNS_TBL_CATEGORIA[1]));
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCat);
        categoria.setCategoria(cat);
        return categoria;
    }

    public List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<>();
        Cursor c = db.query(DB.CATEGORIA, null, null, null, null, null, null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Categoria categoria = carregaCategoria(c);
            lista.add(categoria);
            c.moveToNext();
        }
        return lista;
    }
}
