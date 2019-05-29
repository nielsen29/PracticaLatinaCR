package com.practica.practicalatina.Presentadores.Login;

import android.content.Context;

import com.practica.practicalatina.Aplicacion.ServerAccess.TokenModel;
import com.practica.practicalatina.Interactor.Login.LoginInteractor;
import com.practica.practicalatina.Login.LoginViewInterface;
import com.practica.practicalatina.Modelos.User;

public class LoginPresentador implements LoginInterface{

    private LoginViewInterface view;
    private LoginInteractor interactor;
    private Context context;


    public LoginPresentador(LoginViewInterface view,Context context) {
        this.view = view;
        this.context = context;
        this.interactor = new LoginInteractor(this);
    }

    @Override
    public void login(String email, String pass) {
        interactor.login(email,pass);
    }

    @Override
    public void getuser(TokenModel tokenModel) {
        interactor.tokenSave(context,tokenModel);
    }

    @Override
    public void userSave(User user) {
        interactor.saveUser(context,user);
    }

    @Override
    public void isLogin(boolean login) {
        view.isLogin(login);
    }

    @Override
    public void error(String error) {
        view.error(error);
    }
}
