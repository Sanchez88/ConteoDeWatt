package com.elite.ronald.comluzcontego;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.content.Intent;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.com.libreria.clFragmen;


public class principal extends ActionBarActivity{
    private ImageButton btn;
    SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_containerListDiasMes);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clFragmen.cargarReplaceFragmento(R.id.contenedorListDiasMes, getFragmentManager(), new Frag_Dias());
                        swipeLayout.setRefreshing(false);
                    }
                },1000);
            }
        });
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        clFragmen.cargarReplaceFragmento(R.id.contenedorListDiasMes, getFragmentManager(), new Frag_Dias());

        btn = (ImageButton) findViewById(R.id.imgB);

                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), agregar_conteo.class);
                startActivity(i);

            }
        });

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
        switch (id){
            case R.id.action_listMes:{
                Intent i = new Intent(this, act_mes.class);
                startActivity(i);
            }break;
            case R.id.action_addConteo:{
                Intent i = new Intent(this, agregar_conteo.class);
                startActivity(i);
            }break;
        }



        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

}
