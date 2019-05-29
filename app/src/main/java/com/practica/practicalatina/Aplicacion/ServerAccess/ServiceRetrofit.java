package com.practica.practicalatina.Aplicacion.ServerAccess;

import com.google.gson.JsonObject;
import com.practica.practicalatina.Aplicacion.Configuracion;
import com.practica.practicalatina.Modelos.Cintura;
import com.practica.practicalatina.Modelos.Producto;
import com.practica.practicalatina.Modelos.User;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by amihealthmel on 11/27/17.
 */

public interface ServiceRetrofit {

    @POST(Configuracion.URL_LOGIN)
    Call<TokenModel> login(@Body ApiModelToken apiModelToken);
    // ANALIZAR EL BODY PARA SOLICITAR TOKENNNN

    @GET(Configuracion.USER)
    Call<User> user();

    @GET(Configuracion.URL_GET_PRODUCTOS)
    Call<ArrayList<Producto>> productos();

    @GET("https://saludmovil.utp.ac.pa/api/cintura")
    Observable<Response<ArrayList<Cintura>>> getMedidas_cintura();

    @POST(Configuracion.URL_INSERT_CINTURA)
    Observable<Response<Cintura>> insert_Cintura(@Body Cintura cintura);

    @POST(Configuracion.URL_EDIT_CINTURA)
    Observable<Response<Cintura>> edit_Cintura(@Body Cintura cintura);

    @POST(Configuracion.URL_DELETE_CINTURA)
    Observable<Response<Cintura>> delete_Cintura(@Body Cintura cintura);






}
