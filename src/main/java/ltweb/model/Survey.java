package ltweb.model;

import java.io.Serializable;

public class Survey implements Serializable {
    private User user;
    private String heardFrom;
    private String contactvia;

    public Survey() {
        user = null;
        heardFrom = "";
        contactvia = "";
    }

    public Survey(User user, String heardFrom, String contactVia) {
        this.user = user;
        this.heardFrom = heardFrom;
        this.contactvia = contactVia;
    }

    public void  setUser(User user) {this.user = user;}
    public void setHeardFrom(String heardFrom) {this.heardFrom = heardFrom;}
    public void setContactVia(String contactVia) {this.contactvia = contactVia;}
    public User getUser() {return user;}
    public String getContactVia() {return contactvia;}
    public String getHeardFrom() {return heardFrom;}
}
