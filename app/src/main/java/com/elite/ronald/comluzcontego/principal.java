package com.elite.ronald.comluzcontego;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.content.Intent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class principal extends ActionBarActivity{
    private ImageButton btn;

    private Frag_Dias frdias;
  //  private View v;
   // EditText txt;
    //AlertDialog.Builder dialogo;

    private void inicializar(){
        if(frdias != null)
            frdias = new Frag_Dias();

    }

    private void cargarFragmento(Fragment fragment){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.contenedor, fragment);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        frdias = new Frag_Dias();

        cargarFragmento(frdias);

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
    protected void onRestart() {
        super.onRestart();
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
