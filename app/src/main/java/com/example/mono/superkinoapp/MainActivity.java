package com.example.mono.superkinoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import databaseHandler.HttpHandler;
import databaseTools.DBManager;
import ormLiteModel.User;

import java.util.List;

/**
 * Created by tfqo on 15.06.2017.
 */
public class MainActivity extends AppCompatActivity {

    ImageButton buttonLogin, buttonRegister;
    EditText editTextEmail, editTextPassword;
    CheckBox rememberMeCheckBox;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        DBManager.init(this);
        setContentView(R.layout.activity_main);
        buttonLogin = (ImageButton) findViewById(R.id.loginButton);
        buttonRegister = (ImageButton) findViewById(R.id.signupButton);
        editTextEmail = (EditText) findViewById(R.id.emailText);
        if (!sharedPreferences.getString("rememberedEmail","").equalsIgnoreCase("")) {
            editTextEmail.setText(sharedPreferences.getString("rememberedEmail",""));
        }else editTextEmail.setHint("email");
        editTextPassword = (EditText) findViewById(R.id.passwordText);
        rememberMeCheckBox = (CheckBox) findViewById(R.id.rememberCheckBox);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rememberMeCheckBox.isChecked()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("rememberedEmail", editTextEmail.getText().toString());
                    editor.apply();
                }
                List<User> userList = DBManager.getInstance().getAllUsers();
                User loggingUser = new User();
                loggingUser.setEmail(editTextEmail.getText().toString());
                loggingUser.setPassword(editTextPassword.getText().toString());
                if (loggingUser.isExisting(userList)){
                    Intent intent = new Intent(getApplicationContext(), MoviesActivity.class);
                    finish();
                    startActivity(intent);
                }else {
                    Snackbar.make(v,"Dany użytkownik nie istnieje", Snackbar.LENGTH_SHORT).show();
                }

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
