package com.mycompany.java_gui;
import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fullName;
    private String email;

    public Person(String fullName, String email) {
        this.fullName = fullName;
        this.email = email ;
    }

    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
}
