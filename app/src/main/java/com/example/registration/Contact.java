package com.example.registration;

public class Contact {

    String namec, emailc, unamec, passc;

    public String getEmail() {
        return this.emailc;
    }

    public void setEmail(String email) {
        this.emailc = email;
    }

    public String getName() {
        return this.namec;
    }

    public void setName(String name) {
        this.namec = name;
    }


    public String getPass() {
        return this.passc;
    }

    public void setPass(String pass) {
        this.passc = pass;
    }

    public void setUname(String uname) {
        this.unamec = uname;
    }

    public String getUname() {
        return unamec;
    }
}
