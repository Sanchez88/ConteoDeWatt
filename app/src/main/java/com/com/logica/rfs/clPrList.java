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

/**
 * Created by elite88 on 06/02/2015.
 */
public class clPrList extends AsyncTask<Void,Void,JSONArray> {
    Context ctx;
    JSONArray json;

    public clPrList(Context ctx) {
        super();
        this.ctx = ctx;
    }

    @Override
    protected JSONArray doInBackground(Void... params) {
        List<clEnergia> ener = new clEnergia(ctx).listaArray();
        JSONArray js = new JSONArray();
        JSONObject obj;
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

        return js;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        Log.e("JsonOject:",jsonArray.toString());

    }


}