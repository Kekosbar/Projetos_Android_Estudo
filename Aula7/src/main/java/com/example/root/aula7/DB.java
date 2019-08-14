package com.example.root.aula7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    public static final String BANCO = "BancoCurso";
    public static final String CURSO = "Cursos";
    public static final String SCRIPT_TABLE_CURSO = "create table Cursos(" +
                                                    "idCurso integer not null primary key autoincrement," +
                                                    "nomeCurso text not null," +
                                                    "dataInicio date not null," +
                                                    "precoCurso decimal not null," +
                                                    "cargaHoraria decimal not null" +
                                                    ");";

    public DB(Context context){
        super(context, BANCO, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_TABLE_CURSO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
