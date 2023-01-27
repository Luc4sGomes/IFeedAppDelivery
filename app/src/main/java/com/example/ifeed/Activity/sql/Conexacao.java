package com.example.ifeed.Activity.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Conexacao extends SQLiteOpenHelper {

    private static final String nome = "banco_pedidos.db";
    private static final int versao = 1;

    public Conexacao(@Nullable Context context) {
        super(context, nome,null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pedidos (id INTEGER primary key autoincrement, nome VARCHAR(30), description VARCHAR(50), valor DOUBLE(4))");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
