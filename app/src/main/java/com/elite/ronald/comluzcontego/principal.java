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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.com.entidades.rfs.clEnergia;

import java.security.Principal;


public class principal extends ActionBarActivity{
    private ImageButton btn;
    private Button btnAdd, btnCancelar;
    private View v;
    EditText txt;
    AlertDialog.Builder dialogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        btn = (ImageButton) findViewById(R.id.imgB);

                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogo = new AlertDialog.Builder(principal.this);
                dialogo.setTitle("Agregar información.");
                LayoutInflater inflater =  getLayoutInflater();
                v = inflater.inflate(R.layout.add_info, null);
                btnAdd = (Button) v.findViewById(R.id.btnAgregarConteoD);
                txt = (EditText) v.findViewById(R.id.txtConteoD);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clEnergia cl = new clEnergia(getApplicationContext());

                        cl.Guardar(Integer.parseInt(txt.getText().toString()));

                        Toast.makeText(getApplicationContext(),"Guardado Correctamente.", Toast.LENGTH_SHORT).show();
                        txt.setText("");
                    }
                });


                dialogo.setView(v)
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
