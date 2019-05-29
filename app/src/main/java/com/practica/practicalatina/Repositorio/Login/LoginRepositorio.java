package com.practica.practicalatina.Repositorio.Login;

import com.practica.practicalatina.Aplicacion.ServerAccess.ApiModelToken;
import com.practica.practicalatina.Aplicacion.ServerAccess.RetrofitAdapter;
import com.practica.practicalatina.Aplicacion.ServerAccess.TokenModel;
import com.practica.practicalatina.Modelos.User;
import com.practica.practicalatina.Presentadores.Login.LoginPresentador;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepositorio implements LoginRepositorioInterface{

    private LoginPresentador presentador;

    public LoginRepositorio(LoginPresentador loginPresentador) {

        this.presentador = loginPresentador;

    }


    @Override
    public void login(String email, String pass) {

        RetrofitAdapter retrofitAdapter = new RetrofitAdapter();
        Call<TokenModel> call = retrofitAdapter.getClienteLogin().login(new ApiModelToken(email,pass));
        call.enqueue(new Callback<TokenModel>() {
            @Override
            public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                if (response.isSuccessful()){
                    presentador.getuser(response.body());
                }else{

                    //Toast.makeText(context,"Error CREDENCIAL",Toast.LENGTH_LONG).show();
                    presentador.error("Error CREDENCIAL");
                }
            }

            @Override
            public void onFailure(Call<TokenModel> call, Throwable t) {
                //Toast.makeText(context,"Error CREDENCIAL",Toast.LENGTH_LONG).show();
                presentador.error("Error CREDENCIAL");
            }
        });

    }

    @Override
    public void getUser(String access_token) {

        RetrofitAdapter retrofitAdapter = new RetrofitAdapter();

        Call<User> call = retrofitAdapter.getService(access_token).user();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()){
                    presentador.error("GETUSER");
                    presentador.userSave(response.body());
                }else
                {
                    presentador.error(String.valueOf(response.code()));
                }
                //Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                presentador.error(String.valueOf(t.getMessage()));
            }
        });

    }

    @Override
    public void saveUser(final User user) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(user);
            }
        });
        realm.close();
        presentador.isLogin(true);
    }

    @Override
    public void error(String data) {

    }
}
