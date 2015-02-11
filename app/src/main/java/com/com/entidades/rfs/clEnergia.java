package com.com.entidades.rfs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.datos.rfs.clBase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by elite88 on 06/02/2015.
 */
public class clEnergia {
    private Context context;

    public clEnergia(Context ctx) {
        this.context = ctx;

    }

    public clEnergia(int CON_ID, int ENERGY_CONTEO, String HORA, String FECHA) {
        this.CON_ID = CON_ID;
        this.ENERGY_CONTEO = ENERGY_CONTEO;
        this.FECHA = FECHA;
        this.HORA = HORA;
    }

    public int getCON_ID() {
        return CON_ID;
    }

    public void setCON_ID(int CON_ID) {
        this.CON_ID = CON_ID;
    }

    public int getENERGY_CONTEO() {
        return ENERGY_CONTEO;
    }

    public void setENERGY_CONTEO(int ENERGY_CONTEO) {
        this.ENERGY_CONTEO = ENERGY_CONTEO;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getHORA() {
        return HORA;
    }

    public void setHORA(String HORA) {
        this.HORA = HORA;
    }

    private int CON_ID;
    private int ENERGY_CONTEO;
    private String FECHA;
    private String HORA;

    public void Guardar(int actual){
        clBase db = new clBase(context);
        SQLiteDatabase base = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        Date d = new Date();

        Calendar c = Calendar.getInstance();

        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       // String formattedDate = df.format(c.getTime());

        String year = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        String time = new SimpleDateFormat("HH:mm:ss").format(c.getTime());
        values.put("ACTUAL", actual);
        values.put("HORA", time);
        values.put("FECHA",year);

        base.insert("ENERGY_CONTEO", null, values);

        base.close();
    }

    public void Actualizar(int codigo, int actual){
        clBase db = new clBase(context);
        SQLiteDatabase base = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        Date d = new Date();

        Calendar c = Calendar.getInstance();

        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String formattedDate = df.format(c.getTime());

        String year = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        String time = new SimpleDateFormat("HH:mm:ss").format(c.getTime());
        values.put("ACTUAL", actual);
        values.put("CON_ID", codigo);


        base.update(tabla,values,"CON_ID = ?", new String[]{""+codigo});

        base.close();
    }

    final String tabla = "ENERGY_CONTEO";
    final String [] select = {"CON_ID", "ACTUAL", "HORA", "FECHA"};

    public List<clEnergia> lista(){
        clBase db = new clBase(context);
        SQLiteDatabase base = db.getReadableDatabase();
        Cursor c =  base.query(tabla,select,null,null,null,null,null);
        List<clEnergia> lista = new ArrayList<clEnergia>();
        if(c.moveToFirst()){
            do
            {
                lista.add(new clEnergia(c.getInt(0),c.getInt(1), c.getString(2), c.getString(3)));

            }while(c.moveToNext());
        }

        c.close();
        //base.close();
        return lista;
    }

    public List<clDias> listaDias(){
        clBase db = new clBase(context);
        SQLiteDatabase base = db.getReadableDatabase();
        Cursor c =  base.query(tabla,new String[]{"COUNT(CON_ID) AS CON_ID","(MAX(ACTUAL) - MIN(ACTUAL)) AS CONSUMO", "FECHA"},null,null,"FECHA",null, "FECHA DESC");
        List<clDias> lista = new ArrayList<clDias>();
        if(c.moveToFirst()){
            do
            {
                lista.add(new clDias(c.getInt(0),c.getInt(1), c.getString(2)));

            }while(c.moveToNext());
        }

        c.close();
        //base.close();
        return lista;
    }

    public List<clEnergia> listaDiasHora(String fecha){
        clBase db = new clBase(context);
        SQLiteDatabase base = db.getReadableDatabase();
        Cursor c =  base.query(tabla,select,"FECHA = ?",new String[]{fecha},null,null, "HORA DESC");
        List<clEnergia> lista = new ArrayList<clEnergia>();
        if(c.moveToFirst()){
            do
            {
                lista.add(new clEnergia(c.getInt(0),c.getInt(1), c.getString(2), c.getString(3)));

            }while(c.moveToNext());
        }

        c.close();
        //base.close();
        return lista;
    }

    public List<clMes> listaMes(){
        clBase db = new clBase(context);
        SQLiteDatabase base = db.getReadableDatabase();
        Cursor c =  base.query(tabla,new String[]{"strftime('%Y-%m', FECHA) AS MES","(MAX(ACTUAL) - MIN(ACTUAL)) AS CONSUMO"},null,null,"strftime('%Y-%m', FECHA)",null, "FECHA DESC");
        List<clMes> lista = new ArrayList<clMes>();
        if(c.moveToFirst()){
            do
            {
                lista.add(new clMes(c.getString(0),c.getInt(1)));

            }while(c.moveToNext());
        }

        c.close();
        //base.close();
        return lista;
    }
}
