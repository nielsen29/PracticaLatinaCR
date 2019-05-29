package com.practica.practicalatina.Productos.CinturaMod.Presenter;

import com.practica.practicalatina.Modelos.Cintura;

/**
 * Created by GITCE on 01/15/18.
 */

public interface InterfaceCinturaPresenter {

    // UI INTERFACE
    void OnGetAllResponse();
    void OnInsertResponse();
    void OnDeleteResponse();
    void OnUpdateResponse();
    void OnErrorResponse(String error);

    // SERVERs INTERFACE
    void RequestGetAll();
    void RequestInsert(Cintura cintura);
    void RequestUpdate(Cintura cintura);
    void RequestDelete(Cintura cintura);
}
