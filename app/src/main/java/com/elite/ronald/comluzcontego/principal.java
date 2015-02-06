package com.elite.ronald.comluzcontego;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.com.entidades.rfs.clEnergia;
import com.com.logica.rfs.clPrLoad;

import java.util.ArrayList;
import java.util.List;

import adaptadores.clAdaptadorMes;


public class principal extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    List<clEnergia> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
         new Cargar(this).execute();
        //new clPrLoad(getApplicationContext(), lista).execute();
       //lista =new clEnergia(this).lista();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_addConteo) {
            Intent i = new Intent(this, agregar_conteo.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class Cargar extends AsyncTask<Void,Void,Void>{
        ProgressDialog pd = null;
        List<clEnergia> datos;
        Context context;

        public Cargar(Context context){
            this.context = context;
        }

        @Override
        protected Void doInBackground(Void... params) {
           datos = new clEnergia(getApplicationContext()).lista();
            return null;
        }

        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(getApplicationContext());
            pd.setTitle("Buscando Informacion");
            pd.setMessage("Espere un momento...");
            pd.setCancelable(false);
            pd.setIndeterminate(true);
            pd.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(pd != null)
                pd.dismiss();
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

            mRecyclerView.setHasFixedSize(true);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            mRecyclerView.setAdapter(new clAdaptadorMes(datos));
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        }
    }
}
