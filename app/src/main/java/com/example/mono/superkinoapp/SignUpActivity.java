package com.example.mono.superkinoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ForeignCollection;
import databaseHandler.HttpHandler;
import databaseTools.DBHelper;
import databaseTools.DBManager;
import ormLiteModel.Ticket;
import ormLiteModel.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tfqo on 17.06.2017.
 */
public class SignUpActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword,editTextName,editTextSurname;
    ImageButton imageButtonRegister;
    CheckBox rememberMeCheckBox2;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //final DBHelper dbHelper = new DBHelper(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editTextEmail = (EditText) findViewById(R.id.emailText2);
        editTextPassword = (EditText) findViewById(R.id.passwordText2);
        editTextName = (EditText) findViewById(R.id.nameText);
        editTextSurname = (EditText) findViewById(R.id.surnameText);
        imageButtonRegister = (ImageButton) findViewById(R.id.signupButton2);
        rememberMeCheckBox2 = (CheckBox) findViewById(R.id.rememberCheckBox2);

        imageButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String name = editTextName.getText().toString();
                String surname = editTextSurname.getText().toString();
                if (rememberMeCheckBox2.isChecked()) {
                    sharedPreferences.edit().putString("rememberedEmail", email).apply();
                }
                if (!email.isEmpty() && !password.isEmpty() && !name.isEmpty() && !surname.isEmpty()){
                   //adding to the database
                    final User user = new User(email, password, name, surname);
                    if (user.isExisting(DBManager.getInstance().getAllUsers())) {
                        DBManager.getInstance().addUser(user);
                        Intent intent = new Intent(getApplicationContext(), MoviesActivity.class);
                        startActivity(intent);
                    } else Snackbar.make(v,"Dany użytkownik już istnieje", Snackbar.LENGTH_SHORT).show();


                }else {
                    Snackbar.make(v,"Wypełnij wszystkie pola", Snackbar.LENGTH_SHORT).show();
                }

            }
        });
    }



}

