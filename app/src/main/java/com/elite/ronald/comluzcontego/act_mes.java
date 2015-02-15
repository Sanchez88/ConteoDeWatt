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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.com.libreria.clFragmen;

import java.lang.reflect.Method;


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
        /*RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.0.254/app1/ServiciosWeb/ServicioDemo.asmx/Multiplicar";

        StringRequest jsObjRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


                // TODO Auto-generated method stub
                String json = "";
                boolean inicio=false, fin= false;

                for(char c : response.toCharArray()){
                    if(c == '<'){
                        inicio = true;

                    }
                    if(c=='>'){
                        fin = true;
                    }

                    if(inicio == true & fin == true){
                        json += ""+c;
                    }
                }


                    Toast.makeText(getApplicationContext(),json, Toast.LENGTH_LONG).show();


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),"Msj error: "+error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }

        });

        // Add the request to the RequestQueue.
        queue.add(jsObjRequest);*/
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
        if (id == R.id.action_navegacion) {
            Intent i = new Intent(getApplicationContext(), act_navegacion.class);
            startActivity(i);
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
