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
    "HORA TIME DEFAULT CURRENT_TIME NOT NULL," +
    "FECHA DATE DEFAULT CURRENT_DATE NOT NULL" +
    ")";

    public clBase(Context context){
        super(context,dbName,null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ENERGY_CONTEO");
        onCreate(db);
    }

}
