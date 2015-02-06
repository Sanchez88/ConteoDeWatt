package com.com.logica.rfs;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;

import com.com.entidades.rfs.clEnergia;

import java.util.List;

/**
 * Created by elite88 on 06/02/2015.
 */
public class clPrLoad extends AsyncTask<Void,Void,List<clEnergia>> {
    Context ctx;
    List<clEnergia> datos;
    ProgressDialog pd;
    public clPrLoad(Context ctx, List<clEnergia> datos){
        super();
        this.ctx = ctx;
        this.datos = datos;
    }

    @Override
    protected List<clEnergia> doInBackground(Void... params) {
        return new clEnergia(ctx).lista();
    }

    @Override
    protected void onPreExecute() {
        pd = new ProgressDialog(ctx);
        pd.setTitle("Buscando Informacion");
        pd.setMessage("Espere un momento...");
        pd.setCancelable(false);
        pd.setIndeterminate(true);
        pd.show();
    }

    @Override
    protected void onPostExecute(List<clEnergia> clEnergias) {
        if(pd != null){
            pd.dismiss();
        }
        datos = clEnergias;
    }
}
