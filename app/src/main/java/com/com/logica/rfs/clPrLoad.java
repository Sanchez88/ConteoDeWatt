package com.com.logica.rfs;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.com.entidades.rfs.clEnergia;

import java.util.List;

import adaptadores.clAdaptadorMes;

/**
 * Created by elite88 on 06/02/2015.
 */
public class clPrLoad extends AsyncTask<Void,Void,List<clEnergia>> {
    Context ctx;
    RecyclerView recyclerView;
    ProgressDialog pd;
    public clPrLoad(Context ctx, RecyclerView recyclerView){
        super();
        this.ctx = ctx;
        this.recyclerView = recyclerView;
    }

    @Override
    protected List<clEnergia> doInBackground(Void... params) {
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
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
        recyclerView.setAdapter(new clAdaptadorMes(ctx,clEnergias));
    }
}
