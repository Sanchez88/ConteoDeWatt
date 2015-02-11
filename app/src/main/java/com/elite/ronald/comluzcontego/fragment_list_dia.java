package com.elite.ronald.comluzcontego;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.com.entidades.rfs.clEnergia;
import com.com.logica.rfs.clPrLoad;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_list_dia extends Fragment {
    private RecyclerView mRecyclerView;
    List<clEnergia> lista;

    public fragment_list_dia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_list_dia, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view_List_dia);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // mRecyclerView.setAdapter(new clAdaptadorMes(lista));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        Intent i = getActivity().getIntent();
        String fecha = i.getStringExtra("fecha");
        new clPrLoad(getActivity(),mRecyclerView, fecha).execute();

        return v;
    }


}
