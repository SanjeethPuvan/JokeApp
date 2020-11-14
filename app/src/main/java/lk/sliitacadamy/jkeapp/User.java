package lk.sliitacadamy.jkeapp;

public class User {
    private String Name;
    private  String Email;
    private int Password;

    public User(String name, String email, int password) {
        Name = name;
        Email = email;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }
}
