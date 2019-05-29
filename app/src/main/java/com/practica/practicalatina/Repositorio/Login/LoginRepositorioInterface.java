package com.practica.practicalatina.Repositorio.Login;

import com.practica.practicalatina.Modelos.User;

public interface LoginRepositorioInterface {

    void login(String email, String pass);
    void getUser(String access_token);
    void saveUser(User user);

    void error(String data);

}
