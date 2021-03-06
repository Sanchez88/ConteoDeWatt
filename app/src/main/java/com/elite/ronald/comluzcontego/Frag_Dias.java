package com.elite.ronald.comluzcontego;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.com.entidades.rfs.clEnergia;
import com.com.logica.rfs.clPrDias;

import java.util.List;

public class Frag_Dias extends Fragment {
    private RecyclerView mRecyclerView;
    private List<clEnergia> lista;


    public Frag_Dias() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frag_lista_mes, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // mRecyclerView.setAdapter(new clAdaptadorMes(lista));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        Intent i = getActivity().getIntent();
        String fecha = i.getStringExtra("fecha");
        new clPrDias(getActivity(),mRecyclerView, fecha).execute();

        return v;
    }
}
