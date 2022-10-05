package vn.plusplus.springboot.utils;

public class Account {
    private String username;
    private String email;

    public Account(String username) {
        this.username = username;
    }

    public Account() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void printUsername(){
        System.out.println(username);
    }
}
