package com.practica.practicalatina.Productos.CinturaMod.Presenter;

import android.content.Context;
import com.practica.practicalatina.Modelos.Cintura;
import com.practica.practicalatina.Productos.CinturaMod.Fragments.InterfaceCinturaView;
import com.practica.practicalatina.Productos.CinturaMod.Iteractor.CinturaIteractorIMP;
import com.practica.practicalatina.Productos.CinturaMod.Iteractor.InterfaceCinturaIteractor;

/**
 * Created by GITCE on 01/15/18.
 */

public class CinturaPresenterIMP implements InterfaceCinturaPresenter {


    private InterfaceCinturaView cinturaView;
    private InterfaceCinturaIteractor cinturaIteractor;
    private Context context;

    public CinturaPresenterIMP(InterfaceCinturaView cinturaView, Context context) {
        this.cinturaView = cinturaView;
        this.context = context;
        this.cinturaIteractor = new CinturaIteractorIMP(context,this);
    }

    @Override
    public void OnGetAllResponse() {
        cinturaView.OnGetAllResponse();
    }

    @Override
    public void OnInsertResponse() {

    }

    @Override
    public void OnDeleteResponse() {
        cinturaView.OnDeleteResponse();
    }

    @Override
    public void OnUpdateResponse() {

    }

    @Override
    public void OnErrorResponse(String error) {
        cinturaView.OnErrorResponse(error);
    }

    @Override
    public void RequestGetAll() {
        cinturaIteractor.RequestGetAll();
    }

    @Override
    public void RequestInsert(Cintura cintura) {
        cinturaIteractor.RequestInsert(cintura);
    }

    @Override
    public void RequestUpdate(Cintura cintura) {
        cinturaIteractor.RequestUpdate(cintura);
    }

    @Override
    public void RequestDelete(Cintura cintura) {
        cinturaIteractor.RequestDelete(cintura);
    }
}
