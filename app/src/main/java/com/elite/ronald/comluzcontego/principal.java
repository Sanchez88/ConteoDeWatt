package com.elite.ronald.comluzcontego;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import adaptadores.clAdaptadorMes;
import entidades.clLista;


public class principal extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    List<clLista> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lista = new ArrayList<clLista>();

        lista.add(new clLista(1200,"ENERO"));
        lista.add(new clLista(1300,"FEBRERO"));
        lista.add(new clLista(1400,"MARZO"));
        lista.add(new clLista(1500,"ABRIL"));
        lista.add(new clLista(1600,"MAYO"));
        lista.add(new clLista(1700,"JUNI"));
        lista.add(new clLista(1800,"JULIO"));
        lista.add(new clLista(1900,"AGOSTO"));
        lista.add(new clLista(2000,"SEPTIEMBRE"));
        lista.add(new clLista(2100,"OCTUBRE"));
        lista.add(new clLista(2200,"NOVIEMBRE"));
        lista.add(new clLista(2300,"DICIEMBRE"));

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(new clAdaptadorMes(lista));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
