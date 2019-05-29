package com.practica.practicalatina.Aplicacion.ServerAccess;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amihealthmel on 12/03/17.
 */

public class TokenModel {
    @SerializedName("token_type")
    private String token_type;

    @SerializedName("expires_in")
    private String expires_in;

    @SerializedName("access_token")
    private String access_token;

    @SerializedName("refresh_token")
    private String refresh_token;

    public TokenModel() {
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}