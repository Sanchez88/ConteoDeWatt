package com.com.logica.rfs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.com.entidades.rfs.clDias;
import com.com.entidades.rfs.clEnergia;

import java.util.List;

import adaptadores.clAdaptadorDias;
import adaptadores.clAdaptadorMes;

/**
 * Created by elite88 on 06/02/2015.
 */
public class clPrDias extends AsyncTask<Void,Void,List<clDias>> {
    Context ctx;
    RecyclerView recyclerView;
    ProgressDialog pd;
    String fecha;
    public clPrDias(Context ctx, RecyclerView recyclerView, String fecha){
        super();
        this.ctx = ctx;
        this.recyclerView = recyclerView;
        this.fecha =  fecha;
    }

    @Override
    protected List<clDias> doInBackground(Void... params) {
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return new clEnergia(ctx).listaDias(this.fecha);
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
    protected void onPostExecute(List<clDias> clDias) {
        if(pd != null){
            pd.dismiss();
        }
        recyclerView.setAdapter(new clAdaptadorDias(ctx,clDias));
    }
}
