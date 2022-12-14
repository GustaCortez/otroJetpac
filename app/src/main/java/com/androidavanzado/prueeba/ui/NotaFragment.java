package com.androidavanzado.prueeba.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidavanzado.prueeba.R;
import com.androidavanzado.prueeba.db.entity.NotaEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class NotaFragment extends Fragment {






    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;

    private List<NotaEntity>notaList;
    private MyNotaRecyclerViewAdapter adapterNotas;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nota_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (view.getId() == R.id.listPortrait) {

                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                float dpWidth = displayMetrics.widthPixels/ displayMetrics.density;
                int numeroColumnas =(int)(dpWidth / 180 );
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas,StaggeredGridLayoutManager.VERTICAL));
            }
            notaList = new ArrayList<>();
            notaList.add(new NotaEntity("lista de la compra", "Comprar pan tostado", true, android.R.color.holo_blue_light));
            notaList.add(new NotaEntity("Recordar", "He estacionado mi bicicleta en la calle las maquilas y necesito pasar a recogerla", false, android.R.color.holo_green_light));
            notaList.add(new NotaEntity("Cumplea??os (fiesta)", "no hay que olvida por nada las velas", false, android.R.color.holo_orange_light));
            notaList.add(new NotaEntity("lista de la compra", "Comprar pan tostado", true, android.R.color.holo_blue_light));
            notaList.add(new NotaEntity("Recordar", "He estacionado mi bicicleta en la calle las maquilas y necesito pasar a recogerla", false, android.R.color.holo_green_light));
            notaList.add(new NotaEntity("Cumplea??os (fiesta)", "no hay que olvida por nada las velas", false, android.R.color.holo_orange_light));

            adapterNotas =new MyNotaRecyclerViewAdapter(notaList.getClass());
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }
}