package com.practica.practicalatina.Aplicacion;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CoreAplicacion extends Application {

    public static AtomicInteger MedidasHTA_ID       = new AtomicInteger();
    public static AtomicInteger CATHTA_ID       = new AtomicInteger();
    public static AtomicInteger COLORHTA_ID       = new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();

        //Configuracion Inicial de la base de datos realm
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("amihealth")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }


}
