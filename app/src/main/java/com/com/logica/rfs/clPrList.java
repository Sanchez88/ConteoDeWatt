package com.com.logica.rfs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.com.entidades.rfs.clEnergia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import adaptadores.clAdaptadorListDias;
import servicios.url.ConexionWS;

/**
 * Created by elite88 on 06/02/2015.
 */
public class clPrList extends AsyncTask<Void,Void,String> {
    Context ctx;
    JSONArray json;

    public clPrList(Context ctx) {
        super();
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(Void... params) {
        List<clEnergia> ener = new clEnergia(ctx).listaArray();
        JSONArray js = new JSONArray();
        JSONObject obj;
        String res= "";
        for (clEnergia item : ener) {
            try {
                obj = new JSONObject();
                obj.put("CON_ID", item.getCON_ID());
                obj.put("ENERGY_CONTEO", item.getENERGY_CONTEO());
                obj.put("HORA", item.getHORA());
                obj.put("FECHA", item.getFECHA());
                js.put(obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    try{
        ConexionWS cx = new ConexionWS("http://tempuri.org/"
                                       ,"http://192.168.0.254/app1/serviciosWeb/serviciodemo.asmx"
                                       ,"sincronizarDatos","http://tempuri.org/sincronizarDatos");
        cx.addParametro("cadenaJson",js.toString());

         res = cx.EjecutarWS();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        return res;
    }

    @Override
    protected void onPostExecute(String jsonArray) {
        Toast.makeText(ctx,jsonArray,Toast.LENGTH_SHORT).show();
    }


}