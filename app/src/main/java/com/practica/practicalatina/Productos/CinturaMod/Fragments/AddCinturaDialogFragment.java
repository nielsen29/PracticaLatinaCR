package com.practica.practicalatina.Productos.CinturaMod.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.practica.practicalatina.Modelos.Peso;
import com.practica.practicalatina.R;

import io.realm.Realm;

/**
 * Created by GITCE on 01/12/18.
 */

public class AddCinturaDialogFragment extends DialogFragment {


    private EditText peso;
    private TextView mensaje;
    private Spinner sp_kg;


    public AddCinturaDialogFragment() {
        super();
    }




    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       super.onCreateDialog(savedInstanceState);

           return crearDialogo();


    }

    public AlertDialog crearDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.nuevo_peso_dialogo,null);

        peso = (EditText) v.findViewById(R.id.nuevo_peso_txt);
        peso.setHint("Cintura (cm)");
        mensaje = (TextView)  v.findViewById(R.id.add_mensaje);
        mensaje.setText("Esta medición se debería tomar:\n" +
                "• al final de una espiración normal,\n" +
                "• con los brazos relajados a cada lado,\n" +
                "• a la altura de la mitad de la axila, en el punto que se encuentra entre la parte\n" +
                "inferior de la última costilla y la parte más alta de la cadera.");
        sp_kg = (Spinner) v.findViewById(R.id.sp_kg);
        String[] s = {"Kg","Lb"};
        sp_kg.setAdapter(new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,s));
        sp_kg.setEnabled(false);
        sp_kg.setVisibility(View.INVISIBLE);
        builder.setView(v);

        peso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               /* if(!(s < 0)){
                    if(!peso.getText().equals("") && peso != null){
                        if(sp_kg.getSelectedItemId() != 0){
                            if(Double.valueOf(peso.getText().toString()) > 0 ){
                                double a = Double.valueOf(peso.getText().toString())/2.20462;
                                peso.setError(String.valueOf(a) + "|| Kg");
                            }
                        }else{
                            if(Double.valueOf(peso.getText().toString()) > 0 ){
                                double a = Double.valueOf(peso.getText().toString())/0.453592;
                                peso.setError(String.valueOf(a) + "|| Lb");
                            }
                        }
                    }
                }
                */
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        peso.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(peso.getText().length() <= 0){
                    peso.setError("Este campo no puede estar vacio");

                }
            }
        });


        builder.setPositiveButton(getContext().getString(R.string.btn_guardar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(peso.getText().length() <= 0){
                    peso.setError("Este campo no puede estar vacio");
                    peso.setText("0");
                    mListener.onDialogPositiveClick(AddCinturaDialogFragment.this, Double.valueOf(peso.getText().toString()));
                    dialogInterface.cancel();

                }else{
                    mListener.onDialogPositiveClick(AddCinturaDialogFragment.this, Double.valueOf(peso.getText().toString()));
                    dismiss();

                }

            }
        });
        builder.setNegativeButton(getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setTitle(getString(R.string.nuevo_ICA_titulo));
        builder.setMessage(getString(R.string.info_nueva_medida_cintura));

        return builder.create();

    }
    public AlertDialog crearDialogo(String id){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.nuevo_peso_dialogo,null);
        Realm realm = Realm.getDefaultInstance();
        Peso pes = realm.where(Peso.class).equalTo("id",id).findFirst();
        peso = (EditText) v.findViewById(R.id.nuevo_peso_txt);
        peso.setText(String.valueOf(pes.getPeso()));
        builder.setView(v);
        builder.setPositiveButton(getContext().getString(R.string.update), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(peso.getText().length() <= 0){
                    peso.setError("Este campo no puede estar vacio");
                }else{
                    mListener.onDialogPositiveEdit(id, Double.valueOf(peso.getText().toString()));
                }
            }
        });
        builder.setNegativeButton(getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setTitle(getString(R.string.editar_peso_title));

        return builder.create();

    }


    public interface AddPesoDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, double value);
        public void onDialogPositiveEdit(String id, double value);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    AddPesoDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (AddPesoDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

}
