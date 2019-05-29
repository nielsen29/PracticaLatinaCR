package com.practica.practicalatina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.practica.practicalatina.Aplicacion.SessionManager;
import com.practica.practicalatina.Modelos.User;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;

    private TextView msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msj = (TextView) findViewById(R.id.msj);

        sessionManager = new SessionManager(getApplicationContext());

        sessionManager.checkLogin();

        if(sessionManager.isLoggedIn()){

            msj.setText(sessionManager.getUserLogin().get(SessionManager.KEY_NAME));

        }
    }
}
