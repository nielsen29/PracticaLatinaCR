package com.practica.practicalatina.Login;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.practica.practicalatina.MainActivity;
import com.practica.practicalatina.Presentadores.Login.LoginPresentador;

import com.practica.practicalatina.Productos.CinturaMod.CinturaActivity;
import com.practica.practicalatina.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity  implements LoginViewInterface{

    private LoginPresentador presentador;
    private FloatingActionButton btn_login;
    private EditText email, pass;


    final private String PATRON_EMAIL = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@"+"[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*(\\.[a-z]{2,})$";
    final private String PATRON_NUMBER = "^[_0-9]";
    final private String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{4,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.presentador = new LoginPresentador(this,getApplicationContext());



        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        btn_login = (FloatingActionButton) findViewById(R.id.login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               login(view);
            }
        });


    }

    private void login(View view){
        email.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        pass.setTransformationMethod(PasswordTransformationMethod.getInstance());

        if(!verificarPatronesText(email) && !verificarPatronesText(pass)){
            String mEmail   = email.getText().toString();
            String mPass    = pass.getText().toString();
            blockInputs();
            showProgressbar();
            this.presentador.login(email.getText().toString(),pass.getText().toString());
        }else{
            hideProgressbar();
            unblockInputs();
        }


    }

    private void showProgressbar() {
    }

    private void blockInputs() {
    }

    private void unblockInputs() {
    }

    private void hideProgressbar() {
    }

    public boolean verificarPatronesText(EditText editText){
        if(editText.getText().length()>0 ){
            switch (editText.getInputType()){

                case InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS:
                {
                    hideProgressbar();
                    unblockInputs();
                    Pattern pattern = Pattern.compile(PATRON_EMAIL);
                    Matcher matcher = pattern.matcher(editText.getText().toString());
                    if(matcher.matches()){
                        return false;
                    }else{
                        editText.setError(getResources().getString(R.string.error_email));
                        return true;
                    }
                }
                case InputType.TYPE_TEXT_VARIATION_PASSWORD:
                {
                    hideProgressbar();
                    unblockInputs();
                    Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
                    Matcher matcher = pattern.matcher(editText.getText().toString());
                    if(matcher.matches()){
                        return false;
                    }else{
                        editText.setError(getResources().getString(R.string.error_pass));
                        return true;
                    }
                }
                default:
                    return false;
            }
        }else{
            editText.setError("Este Campo no puede estar vacio");
            hideProgressbar();
            unblockInputs();
            return true;
        }
    }


    @Override
    public void isLogin(boolean islogin) {
        if(islogin){
            hideProgressbar();
            //Toast.makeText(getApplicationContext(),"PASO X EL USER: "+String.valueOf(user.getId()),Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), CinturaActivity.class);
            //intent.putExtra(Configuracion.ID_PACIENTE,String.valueOf(user.getId()));
            startActivity(intent);
            finish();

        }else{
            Toast.makeText(getApplicationContext(),"Error al Iniciar",Toast.LENGTH_LONG).show();
            hideProgressbar();
            unblockInputs();
        }
    }

    @Override
    public void error(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAffinity();
    }
}
