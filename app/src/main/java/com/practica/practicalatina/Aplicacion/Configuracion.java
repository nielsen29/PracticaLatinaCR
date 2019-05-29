package com.practica.practicalatina.Aplicacion;

/**
 * Created by amihealthmel on 07/26/17.
 */

public class Configuracion {

    public static final String ROOT_SERVER = "http://10.0.2.2:8000/";

    public static final String SERVER = ROOT_SERVER + "api/";
    public static final String URL_LOGIN = "oauth/token";
    public static final String USER = SERVER + "user";
    public static final String URL_GET_PRODUCTOS = "productos";

    public static final  String URL_GET_CINTURA = SERVER + "cintura";
    public static final  String URL_INSERT_CINTURA = "add_cintura";
    public static final  String URL_EDIT_CINTURA = "editar_cintura";
    public static final  String URL_DELETE_CINTURA = "borrar_cintura";
    public static final  String URL_STATUS_CINTURA = "status_cintura";
}
