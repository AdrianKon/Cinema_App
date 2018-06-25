package databaseTools;

import android.content.Context;

public class DBManager {
    private static DBManager instance;
    public static void init(Context context){
        if (instance == null) {
            instance = new DBManager(context);
        }
    }

    public static DBManager getInstance() {
        return instance;
    }

    private DBHelper helper;
    private DBManager(Context context){
        helper = new DBHelper(context);
    }

    public DBHelper getHelper() {
        return helper;
    }

    // add there getters for Dao as lists of lines in tables

}
