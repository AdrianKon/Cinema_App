package ormLiteModel;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.joda.time.DateTime;

import java.util.Date;

@DatabaseTable
public class Screening {

    @DatabaseField(dataType = DataType.DATE)
    private Date date;
    @DatabaseField(dataType = DataType.DATE_TIME)
    private DateTime time;
    @DatabaseField
    private int roomNumber;
    @DatabaseField
    private Movie movie;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public DateTime getTime() {
        return time;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
