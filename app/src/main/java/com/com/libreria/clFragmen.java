package com.com.libreria;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;

import com.elite.ronald.comluzcontego.R;

/**
 * Created by Ronald on 14/2/2015.
 */
public class clFragmen {
    public static void cargarReplaceFragmento(int contenedor, FragmentManager manager, Fragment fragment){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(contenedor, fragment);
        transaction.commit();
    }
}
