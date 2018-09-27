package ro.jademy.carrental;

public class Salesman extends Person{



    String username;
    String password;

    public Salesman(String user, String password) {
        this.username = user;
        this.password = password;
    }

    // Q: how can we avoid duplicate code in the salesman and the customer classes?


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
