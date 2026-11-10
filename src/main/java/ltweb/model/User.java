package ltweb.model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String heardFrom;
    private String contactvia;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        dateOfBirth = "";
        heardFrom = "";
        contactvia = "";
    }

    public User(String firstName, String lastName, String email, String dateOfBirth, String heardFrom, String contactvia) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.heardFrom = heardFrom;
        this.contactvia = contactvia;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getHeardFrom() { return heardFrom; }

    public void setHeardFrom(String heardFrom) { this.heardFrom = heardFrom; }

    public String getContactvia() { return contactvia; }

    public void setContactvia(String contactvia) { this.contactvia = contactvia; }
}

