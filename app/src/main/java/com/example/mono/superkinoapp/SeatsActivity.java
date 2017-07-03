package com.example.mono.superkinoapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

/**
 * Created by tfqo on 16.06.2017.
 */
public class SeatsActivity extends AppCompatActivity {
    private static final String TAG = SeatsActivity.class.getSimpleName();
    ImageButton bookB;
    ImageButton payB;
    CheckBox discount;
    boolean[][] isTaken; //Ktore miejsca sa zajete
    boolean[][] isChosen; //Ktore miejsca zostaly wybrane
    TableLayout buttonTable;
    Context context;

    private final int numOfRows = 4;
    private final int numOfCols = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        context = this;

        isTaken = whichSeatsTaken();
        isChosen = new boolean[numOfRows][numOfCols];

        buttonTable = (TableLayout) findViewById(R.id.seatsButtons);
        bookB = (ImageButton) findViewById(R.id.bookButton);
        discount = (CheckBox) findViewById(R.id.discCheckBox);
        payB = (ImageButton) findViewById(R.id.payButton);

        //Obsluga przyciskow wyboru miejsc
        for(int i = 1; i < (numOfRows + 1); i++) //+1 poniewaz w layoucie w pierwszym wierszu i kolumnie sa TextView
        {
            TableRow row = (TableRow)buttonTable.getChildAt(i);
            for(int j = 1; j < (numOfCols + 1); j++){
                final ToggleButton button = (ToggleButton) row.getChildAt(j); // get child index on particular row

                if(isTaken[i - 1][j - 1]) { //jesli miejsce zajete to zablokuj i zmien kolor na ciemny szary
                    button.setEnabled(false);
                    button.setBackgroundColor(Color.parseColor("#565656"));
                } else { //jesli miejsce wolne to zmien kolor na jasny szary i "nasluchuj" zmian na ToggleButtonach
                    button.setBackgroundColor(Color.parseColor("#D6D6D6"));
                    button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked) { // zaznaczenie przycisku, tag=1 (zaznaczony)
                                buttonView.setBackgroundColor(Color.parseColor("#9453D3")); // Fioletowy kolor uzywany w aplikacji
                                buttonView.setTag("1");
                            } else { // odznaczenie przycisku, tag=0 (odznaczony)
                                buttonView.setBackgroundColor(Color.parseColor("#D6D6D6"));
                                buttonView.setTag("0");
                            }
                        }
                    });
                }
            }
        }

        bookB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Sprawdza wszystkie przyciski(na podstawie tagow) czy zostaly wybrane
                for(int i = 1; i < (numOfRows + 1); i++)
                {
                    TableRow row = (TableRow)buttonTable.getChildAt(i);
                    for(int j = 1; j < (numOfCols + 1); j++){
                        final ToggleButton button = (ToggleButton) row.getChildAt(j); // get child index on particular row

                        if(button.isEnabled()) {
                            if(button.getTag() == "1") {
                                isChosen[i - 1][j - 1] = true;
                            } else {
                                isChosen[i - 1][j - 1] = false;
                            }

                        }
                    }
                }

                /*
                //Wyswietlanie miejsc, ktore wybrano
                for(int i = 0; i < numOfRows; i++) {
                    for(int j = 0; j < numOfCols; j++) {
                        if(isChoosen[i][j]) {
                            Log.w(TAG, "Wybrano: [" + i + "][" + j + "]");
                        }

                    }
                }
                */

                //Dokonaj rezerwacji w bazie
                if(discount.isChecked()) {
                    //cos tam
                }

                //powrot do reperturaru
                Intent intent = new Intent(context, MoviesActivity.class);
                startActivity(intent);

            }
        });


        payB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Sprawdza wszystkie przyciski(na podstawie tagow) czy zostaly wybrane
                for(int i = 1; i < (numOfRows + 1); i++)
                {
                    TableRow row = (TableRow)buttonTable.getChildAt(i);
                    for(int j = 1; j < (numOfCols + 1); j++){
                        final ToggleButton button = (ToggleButton) row.getChildAt(j); // get child index on particular row

                        if(button.isEnabled()) {
                            if(button.getTag() == "1") {
                                isChosen[i - 1][j - 1] = true;
                            } else {
                                isChosen[i - 1][j - 1] = false;
                            }

                        }
                    }
                }

                /*
                //Wyswietlanie miejsc, ktore wybrano
                for(int i = 0; i < numOfRows; i++) {
                    for(int j = 0; j < numOfCols; j++) {
                        if(isChoosen[i][j]) {
                            Log.w(TAG, "Wybrano: [" + i + "][" + j + "]");
                        }

                    }
                }
                */

                //Dokonaj zaplaty w bazie
                if(discount.isChecked()) {
                    //cos tam
                }

                //powrot do reperturaru
                Intent intent = new Intent(context, MoviesActivity.class);
                startActivity(intent);

            }
        });
    }

    // Sprawdz w bazie ktore miejsca sa zajete
    // i ustaw wartosc true w tablicy seats dla tych zajetych
    boolean[][] whichSeatsTaken () {
        boolean[][] seats = new boolean[numOfRows][numOfCols];
        for(int i = 0; i < numOfRows; i++) {
            for(int j = 0; j < numOfCols; j++) {
                // Warunek potrzebny do przetestowania dzialania
                if(j % 2 == 0) {
                    seats[i][j] = true;
                }
            }
        }
        return seats;
    }
}
