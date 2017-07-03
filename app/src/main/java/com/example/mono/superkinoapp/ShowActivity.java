package com.example.mono.superkinoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by tfqo on 16.06.2017.
 */
public class ShowActivity extends AppCompatActivity {
    TextView title;
    TextView genre;
    ImageView image;
    TextView description;
    RadioButton timeB;
    RadioButton timeB2;
    RadioButton timeB3;
    RadioButton timeB4;
    ImageButton nextB;
    Context context;

    boolean time1, time2,  time3, time4;

    private Integer[] imgId = {
            R.drawable.dudi,
            R.drawable.ghost,
            R.drawable.gwiazdy,
            R.drawable.obcy,
            R.drawable.straznicy,
            R.drawable.szybcy,
            R.drawable.uciekaj
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        context = this;
        title = (TextView) findViewById(R.id.showTitle);
        genre = (TextView) findViewById(R.id.showGenre);
        image = (ImageView) findViewById(R.id.show_filmImage);
        description = (TextView) findViewById(R.id.descriptionView);
        timeB = (RadioButton) findViewById(R.id.timeButton);
        timeB2 = (RadioButton) findViewById(R.id.timeButton2);
        timeB3 = (RadioButton) findViewById(R.id.timeButton3);
        timeB4 = (RadioButton) findViewById(R.id.timeButton4);
        nextB = (ImageButton) findViewById(R.id.nextButton);

        //Pobieranie danych z poprzedniego ekranu
        title.setText(getIntent().getStringExtra("Title"));
        genre.setText(getIntent().getStringExtra("Genre"));
        image.setImageResource(imgId[getIntent().getIntExtra("Image", 0) - 1]);
        description.setText(getIntent().getStringExtra("Description"));

        //Obsluga przycisku dalej i zczytanie wyboru godziny
        nextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timeB.isChecked()) {
                    time1 = true;
                    time2 = false;
                    time3 = false;
                    time4 = false;
                } else if(timeB2.isChecked()) {
                    time1 = false;
                    time2 = true;
                    time3 = false;
                    time4 = false;
                } else if(timeB3.isChecked()) {
                    time1 = false;
                    time2 = false;
                    time3 = true;
                    time4 = false;
                } else if(timeB4.isChecked()) {
                    time1 = false;
                    time2 = false;
                    time3 = true;
                    time4 = false;
                }

                //Wybor z bazy na podstawie wybranej godziny

                //Przejscie do ekranu wyboru miejsca
                Intent intent = new Intent(context, SeatsActivity.class);
                intent.putExtra("time1", time1);
                intent.putExtra("time2", time2);
                intent.putExtra("time3", time3);
                intent.putExtra("time4", time4);
                startActivity(intent);
            }
        });

    }
}
