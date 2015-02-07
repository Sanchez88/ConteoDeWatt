package com.elite.ronald.comluzcontego;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.com.entidades.rfs.clEnergia;

import java.security.Principal;


public class principal extends ActionBarActivity {
    private ImageButton btn;
    private View v;
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        btn = (ImageButton) findViewById(R.id.imgB);

                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialogo = new AlertDialog.Builder(principal.this);
                dialogo.setTitle("Agregar información.");
                LayoutInflater inflater =  getLayoutInflater();
                v = inflater.inflate(R.layout.add_info, null);

                txt = (EditText) findViewById(R.id.txtConteoD);
                dialogo.setView(v)
                        .setPositiveButton(R.string.btnAddConteo, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                clEnergia cl = new clEnergia(principal.this);
                                int num = Integer.parseInt(txt.getText().toString());
                                cl.Guardar(num);
                                Toast.makeText(principal.this, "Guardado Correctamente.", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton(R.string.btnAddCancelar, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                dialogo.show();
            }
        });


        //new clPrLoad(getApplicationContext(), lista).execute();
       //lista =new clEnergia(this).lista();
        /*mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
       // mRecyclerView.setAdapter(new clAdaptadorMes(lista));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        new clPrLoad(this,mRecyclerView).execute();
        */
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                lista =new clEnergia(getApplicationContext()).lista();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mRecyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        mRecyclerView.setAdapter(new clAdaptadorMes(lista));
                    }
                });
            }
        }).start();*/

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

}
