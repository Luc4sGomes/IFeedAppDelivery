package com.example.ifeed.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ifeed.Activity.Domain.FoodDomain;
import com.example.ifeed.Activity.sql.Conexacao;

public class FoodDAO {

    private Conexacao con;
    private SQLiteDatabase db;


    public void comidaDAO(Context context) {
        con = new Conexacao(context);
        db = con.getWritableDatabase();
    }

    public long inserir(FoodDomain comida) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", comida.getTitle());
        contentValues.put("pic", comida.getPic());
        contentValues.put("description", comida.getDescription());
        contentValues.put("value", comida.getFee());

        return db.insert("pedidos", null, contentValues);
    }
}
