package com.practica.practicalatina.Interactor.Login;

import android.content.Context;

import com.practica.practicalatina.Aplicacion.ServerAccess.TokenModel;
import com.practica.practicalatina.Aplicacion.SessionManager;
import com.practica.practicalatina.Modelos.User;
import com.practica.practicalatina.Presentadores.Login.LoginPresentador;
import com.practica.practicalatina.Repositorio.Login.LoginRepositorio;

import io.realm.Realm;

public class LoginInteractor implements LoginInteractorInterface {

    private LoginRepositorio repositorio;

    public LoginInteractor(LoginPresentador loginPresentador) {

        this.repositorio = new LoginRepositorio(loginPresentador);

    }

    @Override
    public void login(String email, String pass) {
        this.repositorio.login(email,pass);
    }

    @Override
    public void tokenSave(Context context, TokenModel token) {
        SessionManager sessionManager = new SessionManager(context);
        if(!token.getAccess_token().equals("")){
            sessionManager.setAuth(token.getAccess_token());
            repositorio.getUser(token.getAccess_token());
        }
    }

    @Override
    public void saveUser(Context context, final User user) {

        SessionManager sessionManager = new SessionManager(context);
        sessionManager.crearSessionLogin(String.valueOf(user.getId()),user.getNombre(),user.getEmail());
        repositorio.saveUser(user);

    }
}
