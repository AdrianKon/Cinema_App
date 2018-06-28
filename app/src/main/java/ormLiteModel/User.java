package ormLiteModel;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

@DatabaseTable
public class User {
    @DatabaseField(generatedId = true)
    private int userId;
    @DatabaseField
    private String email;
    @DatabaseField
    private String password;
    @DatabaseField
    private String name;
    @DatabaseField
    private String surname;
    //@ForeignCollectionField()
    //private ForeignCollection<Ticket> tickets;

    public User(){}

    public User(final String email, final String password, final String name, final String surname/*, final List<Ticket> tickets*/){
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        //this.tickets = (ForeignCollection<Ticket>) tickets;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

//    public void setTickets(ForeignCollection<Ticket> tickets) {
//        this.tickets = tickets;
//    }
//
//    public ArrayList<Ticket> getTickets() {
//        ArrayList<Ticket> ticketsList = new ArrayList<Ticket>();
//        for (Ticket ticket : tickets) {
//            ticketsList.add(ticket);
//        }
//        return ticketsList;
//    }


    public boolean isExisting(List<User> users) {
        for (User forUser : users) {
            if (this.email.equals(forUser.email) && this.password.equals(forUser.password)) return true;
        }
        return false;
    }
}
