package com.example.mono.superkinoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import databaseHandler.HttpHandler;
import databaseTools.DBManager;

/**
 * Created by tfqo on 15.06.2017.
 */
public class MainActivity extends AppCompatActivity {

    ImageButton buttonLogin, buttonRegister;
    EditText editTextEmail, editTextPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBManager.init(this);
        setContentView(R.layout.activity_main);
        buttonLogin = (ImageButton) findViewById(R.id.loginButton);
        buttonRegister = (ImageButton) findViewById(R.id.signupButton);
        editTextEmail = (EditText) findViewById(R.id.emailText);
        editTextPassword = (EditText) findViewById(R.id.passwordText);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }




}
