package databaseTools;

import android.content.Context;
import ormLiteModel.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void addUser(User user){
        try {
            getHelper().getUserDao().create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
        List<User> userList = null;
        try {
            userList = getHelper().getUserDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void deleteUser(String email){
        List<User> userList = new ArrayList<>();
        try {
             userList = getHelper().getUserDao().queryForEq("email",email);
            for (User user: userList) {
                getHelper().getUserDao().delete(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
