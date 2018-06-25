package com.example.mono.superkinoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import databaseHandler.HttpHandler;
import databaseTools.DBManager;

/**
 * Created by tfqo on 17.06.2017.
 */
public class SignUpActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword,editTextName,editTextSurname;
    ImageButton imageButtonRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //final CalendarContract.Instances

        editTextEmail = (EditText) findViewById(R.id.emailText2);
        editTextPassword = (EditText) findViewById(R.id.passwordText2);
        editTextName = (EditText) findViewById(R.id.nameText);
        editTextSurname = (EditText) findViewById(R.id.surnameText);
        imageButtonRegister = (ImageButton) findViewById(R.id.signupButton2);

        imageButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String name = editTextName.getText().toString();
                String surname = editTextSurname.getText().toString();
                if (!email.isEmpty() && !password.isEmpty() && !name.isEmpty() && !surname.isEmpty()){
                   //adding to the database
                    DBManager.getInstance().
                }
            }
        });
    }



}

