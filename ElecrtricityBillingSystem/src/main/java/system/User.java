package system;

import java.util.Date;
import java.io.*;


public class User {

    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected Date date;

    User() {
    }

    User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
      //added
    public void saveUserToFile() {
        try {
            FileWriter writer = new FileWriter("Users_Log.txt", true); 
            writer.write("ID: " + id + " | Name: " + name + " | Email: " + email + " | Role: User\n");
            writer.write("--------------------------------------------------\n");
            writer.close();
            System.out.println("User saved to Users_Log.txt ");
        } catch (IOException e) {
            System.out.println("Error saving user");
        }
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate() {
        return date;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}