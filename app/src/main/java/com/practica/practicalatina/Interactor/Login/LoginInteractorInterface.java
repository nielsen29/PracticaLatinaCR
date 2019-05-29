package com.practica.practicalatina.Interactor.Login;

import android.content.Context;

import com.practica.practicalatina.Aplicacion.ServerAccess.TokenModel;
import com.practica.practicalatina.Modelos.User;

public interface LoginInteractorInterface {

    void login(String email, String pass);

    void tokenSave(Context context, TokenModel token);

    void saveUser(Context context, User user);

}
