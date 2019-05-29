package com.practica.practicalatina.Productos.CinturaMod.Iteractor;

import com.practica.practicalatina.Modelos.Cintura;

/**
 * Created by GITCE on 01/15/18.
 */

public interface InterfaceCinturaIteractor {

    void RequestGetAll();
    void RequestInsert(Cintura cintura);
    void RequestUpdate(Cintura cintura);
    void RequestDelete(Cintura cintura);
}
