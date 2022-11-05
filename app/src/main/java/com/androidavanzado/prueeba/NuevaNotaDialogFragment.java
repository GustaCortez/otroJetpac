package com.androidavanzado.prueeba;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.androidavanzado.prueeba.db.entity.NotaEntity;

public class NuevaNotaDialogFragment extends DialogFragment {



    public static NuevaNotaDialogFragment newInstance() {
        return new NuevaNotaDialogFragment();
    }
private  View view;

    private EditText etTitulo,etContenido;
    private RadioGroup rgColor;
    private Switch swNotaFavorita;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nueva_nota_dialog_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NuevaNotaDialogViewModel.class);
        // TODO: Use the ViewModel
    }

    // Use the Builder class for convenient dialog construction
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("nueva nota");
        builder.setMessage("introduzca los datos de la nueva nota")
            .setPositiveButton("guardar la nota", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {

         String titulo = etTitulo.getText().toString();
         String contenido = etContenido.getText().toString();
         String scontenido = etContenido.getText().toString();
         String Color = "azul";
           switch (rgColor.getCheckedRadioButtonId()){
               case R.id. radioButtonColorRojo:
                   color = "rojo"; break;

               case R.id. radioButtonColorVerde:
                   color = "verde"; break;

               case R.id. radioButtonColorRojo:
                   color = "rojo"; break;



           }
           boolean esFavorita = swNotaFavorita.isChecked();
            NuevaNotaDialogViewModel mViewModel =getDefaultViewModelProvider.of(getActivity()).get(NuevaNotaDialogViewModel.class);
        mViewModel.insertNota(new NotaEntity(titulo,contenido, esFavorita,color));
        getDialog().dismiss();
        }
    })
            .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
        getDialog().dismiss();

    });
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View.inflater.inflate(R.layout.nueva_nota_dialog_fragment, null);
        etTitulo =view.findViewById(R.id.editTextTitulo);
    etcontenido =view.findViewById(R.id.editTextContenido);
    rgColor= view.findViewById(R.id.radioGroupColor);
    swNotaFavoritaview.findViewById(R.id.switchNotaFavorita);
        builder.setView(view);
    // Create the AlertDialog object and return it
        return builder.create();
}
}