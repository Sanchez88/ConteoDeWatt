package com.elite.ronald.comluzcontego;



import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.com.entidades.rfs.clEnergia;
import com.com.logica.rfs.clPrLoad;

import java.util.List;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragListaMes extends Fragment {
    private RecyclerView mRecyclerView;
    List<clEnergia> lista;

    public fragListaMes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_lista_mes, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // mRecyclerView.setAdapter(new clAdaptadorMes(lista));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        new clPrLoad(getActivity(),mRecyclerView).execute();

        return v;
    }


}
