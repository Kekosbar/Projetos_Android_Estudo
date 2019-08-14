package com.example.root.sqllife;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    public static final String BANCO = "teste";
    public static final String CATEGORIA = "Categorias";
    public static final String SCRIPT_TABLE_CREATE = "create table Categorias(idCategoria integer not null "
                                                   + " primary key autoincrement, categoria text not null);";

    public DB(Context context) {
        // Cria o BANCO DE DADOS
        super(context, BANCO, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Cria as tabelas do BANCO DE DADOS
        db.execSQL(SCRIPT_TABLE_CREATE); // Executa um comando em SQL
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
