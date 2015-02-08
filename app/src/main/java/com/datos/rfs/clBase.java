package com.datos.rfs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elite88 on 06/02/2015.
 */
public class clBase extends SQLiteOpenHelper {
    private static String dbName = "DBLUZ";
    private String tb = "CREATE TABLE ENERGY_CONTEO(" +
    "CON_ID INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL," +
    "ACTUAL INTEGER  NOT NULL," +
    "HORA TIME NOT NULL," +
    "FECHA DATE NOT NULL" +
    ")";
    /*
    private String tb2 = "CREATE TABLE MESES ( " +
            "MES_ID INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "NOMBRE VARCHAR(10)  NOT NULL " +
            ")";

    private String tb3 = "CREATE TABLE SEMANA (" +
            "SE_ID INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "NOMBRE VARCHAR(20)  NOT NULL" +
            ")";
            */

    public clBase(Context context){
        super(context,dbName,null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tb);
        /*
        db.execSQL(tb2);
        db.execSQL(tb3);

        SQLiteDatabase b2 = getWritableDatabase();
        b2.execSQL("insert into semana(nombre)VALUES('LUNES')");
        b2.execSQL("insert into semana(nombre) VALUES('MARTES')");
        b2.execSQL("insert into semana(nombre) VALUES('MIERCOLES')");
        b2.execSQL("insert into semana(nombre) VALUES('JUEVEZ')");
        b2.execSQL("insert into semana(nombre) VALUES('VIERNES')");
        b2.execSQL("insert into semana(nombre) VALUES('SABADO')");
        b2.execSQL("insert into semana(nombre) VALUES('DOMINGO')");
        b2.close();*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ENERGY_CONTEO");
        db.execSQL("DROP TABLE IF EXISTS SEMANA");
        db.execSQL("DROP TABLE IF EXISTS MESES");
        onCreate(db);
    }

}
