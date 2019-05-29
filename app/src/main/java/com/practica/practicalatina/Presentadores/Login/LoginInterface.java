package com.practica.practicalatina.Presentadores.Login;

import android.content.Context;

import com.practica.practicalatina.Aplicacion.ServerAccess.TokenModel;
import com.practica.practicalatina.Modelos.User;

public interface LoginInterface {

    void login(String email, String pass);
    void getuser(TokenModel tokenModel);

    void userSave(User user);

    void error(String error);
    void isLogin(boolean login);

}
