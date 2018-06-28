package com.example.mono.superkinoapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import databaseHandler.HttpHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by tfqo on 16.06.2017.
 */
public class MoviesActivity extends AppCompatActivity {

    ListView list;
    Button monday;
    Button tuesday;
    Button wednesday;
    Button thursday;
    Button friday;
    Button saturday;
    Button sunday;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        context = this;

        new ExecuteRequest().execute("http://156.17.228.98/php/getMovieDetails.php?dayOfTheWeek=4");

        final ArrayList<FilmDetails> monday_details = GetMondayResults();

        list = (ListView) findViewById(R.id.listView);
        // Domyślnie na początku wyświetla listę z poniedzialku
        list.setAdapter(new FilmAdapter(context, monday_details));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = list.getItemAtPosition(position);
                FilmDetails obj_filmDetails = (FilmDetails) o;
                Toast.makeText(MoviesActivity.this, "Wybrano : " + " " + obj_filmDetails.getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("Title", obj_filmDetails.getTitle());
                intent.putExtra("Genre", obj_filmDetails.getGenre());
                intent.putExtra("Image", obj_filmDetails.getImageNumber());
                intent.putExtra("Description", obj_filmDetails.getDescription());
                startActivity(intent);
            }
        });

        monday = (Button) findViewById(R.id.mondayButton);
        tuesday = (Button) findViewById(R.id.tuesdayButton);
        wednesday = (Button) findViewById(R.id.wednesdayButton);
        thursday = (Button) findViewById(R.id.thursdayButton);
        friday = (Button) findViewById(R.id.fridayButton);
        saturday = (Button) findViewById(R.id.saturdayButton);
        sunday = (Button) findViewById(R.id.sundayButton);


        //Obsluga przycisku PN(Poniedzialek) oraz obsluga listy, ktora sie wyswitla dla poniedzialku
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.setAdapter(new FilmAdapter(context, monday_details));
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                    }
                });
            }
        });
    }
        //Tutaj sa dodane przykladowane dane. Oczywiscie w rzeczywistosci
        // trzeba je wyciagnac z bazy i dodac do obiektow tak jak ponizej

        // find movies played in monday
        private ArrayList<FilmDetails> GetMondayResults () {
            ArrayList<FilmDetails> results = new ArrayList<FilmDetails>();

//            FilmDetails film_details = new FilmDetails();
//            film_details.setTitle("Tytuł 1");
//            film_details.setGenre("komedia, animowany");
//            film_details.setImageNumber(1); // od 1 jest odejmowane 1, co daje indeks 0 z tablicy z obrazkami
//            film_details.setDescription("Bardzo ładny opis"); // ktora znajduje sie w klasie FilmAdapter, a same obrazki w drawable
//            results.add(film_details);
//
//            film_details = new FilmDetails();
//            film_details.setTitle("Tytuł 2");
//            film_details.setGenre("akcja");
//            film_details.setImageNumber(1);
//            film_details.setDescription("Bardzo ładny opis");
//            results.add(film_details);
//
//            film_details = new FilmDetails();
//            film_details.setTitle("Tytuł 3");
//            film_details.setGenre("biograficzny");
//            film_details.setImageNumber(1);
//            film_details.setDescription("Bardzo ładny opis");
//            results.add(film_details);

            return results;
        }

        private void beginningOperations(){
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_WEEK);

            switch (day) {
                case Calendar.SUNDAY:
                    // Current day is Sunday

                case Calendar.MONDAY:
                    // Current day is Monday

                case Calendar.TUESDAY:
                    // etc.

                case Calendar.WEDNESDAY:

                case Calendar.THURSDAY:

                case Calendar.FRIDAY:

                case Calendar.SATURDAY:

            }
        }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    private class ExecuteRequest extends AsyncTask<String,Void, Void> {
        String resultQ = "";

        @Override
        protected Void doInBackground(String... strings) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(strings[0]);
            //System.out.println(jsonStr);
            //setResultQ(jsonStr);

            System.out.println(jsonStr);

//            if (jsonStr!=null){
//                try {
//                    //JSONObject jsonObject = new JSONObject(jsonStr);
//                    //JSONArray jsonArray = new JSONArray(jsonStr);
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
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
                //Intent intent = new Intent(getApplicationContext(), MoviesActivity.class);
               //startActivity(intent);
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
