package ormLiteModel;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

@DatabaseTable
public class Ticket {
    @DatabaseField
    private Screening screening;
    @DatabaseField
    private int seatsAvailable;
    @ForeignCollectionField
    private ForeignCollection<Integer> seats;

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeats(ForeignCollection<Integer> seats) {
        this.seats = seats;
    }

    public ArrayList<Integer> getSeats() {
        ArrayList<Integer> seatsList = new ArrayList<Integer>();
        for (Integer seat : seats) {
            seatsList.add(seat);
        }
        return seatsList;
    }
}
