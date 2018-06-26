package ormLiteModel;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

@DatabaseTable
public class Movie {
    @DatabaseField(generatedId = true)
    private int movieId;
    @DatabaseField
    private String title;
    @DatabaseField
    private String synopis;
    @ForeignCollectionField
    private ForeignCollection<Screening> screenings;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSynopis(String synopis) {
        this.synopis = synopis;
    }

    public String getSynopis() {
        return synopis;
    }

    public void setScreenings(ForeignCollection<Screening> screenings) {
        this.screenings = screenings;
    }

    public ArrayList<Screening> getScreenings() {
        ArrayList<Screening> screeningsList = new ArrayList<Screening>();
        for (Screening screening : screenings) {
            screeningsList.add(screening);
        }
        return screeningsList;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
