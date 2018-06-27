package ormLiteModel;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

@DatabaseTable
public class Ticket {
    @DatabaseField(generatedId = true)
    private int ticketId;
    @DatabaseField
    private int screeningId;
    @DatabaseField
    private int seatsAvailable;
    @ForeignCollectionField
    private ForeignCollection<Integer> seats;

    public void setScreening(int screening) {
        this.screeningId = screening;
    }

    public int getScreening() {
        return screeningId;
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

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
