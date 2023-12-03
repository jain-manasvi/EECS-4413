package com.example.project.repository.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String fName;
    private String lName;
    private String email;
    private String password;

    public User(String fName, String lName, String email, String password) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public String getfName() {
        return this.fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return this.lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{Id=" + this.id + ", fName='" + this.fName + "', lName='" + this.lName + "', email='" + this.email + "', password='" + this.password + "'}";
    }
}
