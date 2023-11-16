package com.example.semana12_sqllite.Controlador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionHelper extends SQLiteOpenHelper {

    public ConexionHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utility.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){
        // Define la lógica para actualizar la base de datos cuando sea necesario
        // En este ejemplo, eliminamos la tabla existente y la volvemos a crear
        db.execSQL("DROP TABLE IF EXISTS "+ Utility.CREAR_TABLA_USUARIO);
        onCreate(db);
    }
}