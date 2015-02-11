package com.elite.ronald.comluzcontego;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.com.entidades.rfs.clEnergia;


public class agregar_conteo extends ActionBarActivity {
    Button btn;
    EditText txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_conteo);

        btn = (Button) findViewById(R.id.btnAgregarConteo);
        txt = (EditText) findViewById(R.id.txtConteo);

        if(getIntent().getStringArrayExtra("codigo") != null){
            final String [] con = getIntent().getStringArrayExtra("codigo");
            txt.setText(con[1]);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clEnergia cl = new clEnergia(getApplicationContext());

                    cl.Actualizar(Integer.parseInt(con[0]),Integer.parseInt(txt.getText().toString()));

                    Toast.makeText(getApplicationContext(), "Actualizado Correctamente.", Toast.LENGTH_SHORT).show();
                    txt.setText("");
                    startActivity(new Intent(getApplicationContext(), actListDias.class).putExtra("fecha",con[2]));

                }
            });
        }else {


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clEnergia cl = new clEnergia(getApplicationContext());

                    cl.Guardar(Integer.parseInt(txt.getText().toString()));

                    Toast.makeText(getApplicationContext(), "Guardado Correctamente.", Toast.LENGTH_SHORT).show();
                    txt.setText("");
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agregar_conteo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_listConteo) {
            Intent i = new Intent(this, principal.class);
            startActivity(i);
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
