package com.mycompany.java_gui;
import java.io.Serializable;

public class User extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private Role role;

    public User(String fullName, String email, String username, String password, Role role) {
        super(fullName, email);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }

    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) { this.password = password; }
    public void setRole(Role role) { this.role = role; }
}
