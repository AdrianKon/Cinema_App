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

/**
 * Created by tfqo on 15.06.2017.
 */
public class MainActivity extends AppCompatActivity {

    ImageButton buttonLogin, buttonRegister;
    EditText editTextEmail, editTextPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogin = (ImageButton) findViewById(R.id.loginButton);
        buttonRegister = (ImageButton) findViewById(R.id.signupButton);
        editTextEmail = (EditText) findViewById(R.id.emailText);
        editTextPassword = (EditText) findViewById(R.id.passwordText);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://"+getString(R.string.ip_address)+"/php/loginCheck.php?email="+ editTextEmail.getText().toString() + "&password=" + editTextPassword.getText().toString();
                System.out.println(url);
                new ExecuteRequest().execute(url);
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



    private class ExecuteRequest extends AsyncTask<String,Void, Void> {
        String resultQ = "";

        @Override
        protected Void doInBackground(String... strings) {
            HttpHandler sh = new HttpHandler();
            String result = sh.makeServiceCall(strings[0]);
            //System.out.println(result);
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
