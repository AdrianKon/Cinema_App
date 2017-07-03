package com.example.mono.superkinoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button buttonLogin, buttonRegister;
    EditText editTextEmail, editTextPassword;

    int permittedLoginTries = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("  === button clicked ===");
                if (editTextEmail.getText().toString().equals("admin@pl.pl") && editTextPassword.getText().toString().equals("55555")){
                    //Intent intent = new Intent(getApplicationContext(), Repertuar.class);
                    //startActivity(intent);
                }else {
                    System.out.println(" +++ not equal +++");
                }
            }
        });
    }
}
