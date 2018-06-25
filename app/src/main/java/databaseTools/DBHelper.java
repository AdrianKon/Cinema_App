package databaseTools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import ormLiteModel.Movie;
import ormLiteModel.Screening;
import ormLiteModel.Ticket;
import ormLiteModel.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "cinemaDB.sqlite";
    private static final int DATABASE_VERSION = 1;

    private Dao<User, Integer> userDao = null;
    private Dao<Ticket, Integer> ticketDao = null;
    private Dao<Screening, Integer> screeningDao = null;
    private Dao<Movie, Integer> movieDao = null;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource){
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Ticket.class);
            TableUtils.createTable(connectionSource, Screening.class);
            TableUtils.createTable(connectionSource, Movie.class);
        } catch (SQLException e) {
            Log.e(DBHelper.class.getName(), "Can not open the database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion){
//        try {
            List<String> allSql = new ArrayList<String>();
            switch (oldVersion){
                case 1:
                    //dunno why empty
            }
            for (String sql: allSql) database.execSQL(sql);
//        }catch (SQLException e){
//            Log.e(DBHelper.class.getName(), "Exception during onUpdate", e);
//            throw new RuntimeException(e);
//        }
    }

    public Dao<User, Integer> getUserDao() {
        if (userDao == null){
            try {
                userDao = getDao(User.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userDao;
    }

    public Dao<Ticket, Integer> getTicketDao() {

        if (ticketDao == null){
            try {
                ticketDao = getDao(Ticket.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ticketDao;
    }

    public Dao<Screening, Integer> getScreeningDao() {
        if (screeningDao == null) {
            try {
                screeningDao = getDao(Screening.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return screeningDao;
    }

    public Dao<Movie, Integer> getMovieDao() {
        if (movieDao == null) {
            try {
                movieDao = getDao(Movie.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movieDao;
    }
}
