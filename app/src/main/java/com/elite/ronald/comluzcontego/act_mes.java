package com.elite.ronald.comluzcontego;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.com.libreria.clFragmen;


public class act_mes extends ActionBarActivity{

    SwipeRefreshLayout swipeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_mes);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clFragmen.cargarReplaceFragmento(R.id.contenedorMes,getFragmentManager(),new fragListaMes());
                        swipeLayout.setRefreshing(false);
                    }
                },1000);
            }
        });
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        clFragmen.cargarReplaceFragmento(R.id.contenedorMes, getFragmentManager(), new fragListaMes());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_mes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.action_addConteo:{
                startActivity(new Intent(getApplicationContext(), agregar_conteo.class));
                break;
            }
            case R.id.action_sinc:{
                startActivity(new Intent(getApplicationContext(), act_sincronizar.class));
                break;
            }
           /* case R.id.action_navegacion:{
                startActivity(new Intent(getApplicationContext(), act_navegacion.class));
                break;
            }*/

        }

        return super.onOptionsItemSelected(item);
    }

}
