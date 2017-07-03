package com.example.mono.superkinoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import databaseHandler.HttpHandler;

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
                    String url = "http://"+getString(R.string.ip_address)+"/php/newUser.php?email="+ email + "&password=" + password + "&name=" + name + "&surname=" + surname;
                    new ExecuteRequest().execute(url);
                }
            }
        });
    }


    private class ExecuteRequest extends AsyncTask<String,Void, Void> {
        String resultQ = "";

        @Override
        protected Void doInBackground(String... strings) {
            HttpHandler sh = new HttpHandler();
            String result = sh.makeServiceCall(strings[0]);
            setResultQ(result);
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (resultQ.contains("true")){
                Intent intent = new Intent(getApplicationContext(), MoviesActivity.class);
                startActivity(intent);
            }
        }
        public void setResultQ(String resultQ) {
            this.resultQ = resultQ;
        }

        public String getResultQ() {
            return resultQ;
        }
    }
}

