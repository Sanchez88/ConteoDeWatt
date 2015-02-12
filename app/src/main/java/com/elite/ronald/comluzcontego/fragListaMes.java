package com.elite.ronald.comluzcontego;



import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.com.entidades.rfs.clEnergia;
import com.com.logica.rfs.clPrMes;


import java.util.List;



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
        View v = inflater.inflate(R.layout.fragment_frag_mes, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view_Mes);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // mRecyclerView.setAdapter(new clAdaptadorMes(lista));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Toast.makeText(getActivity(),"Llego evento Drag", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        new clPrMes(getActivity(),mRecyclerView).execute();

        return v;
    }


}
