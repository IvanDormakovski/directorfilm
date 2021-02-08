package com.library.models;

import java.util.Date;

public class Director {
    private int id;
    private String firsName;
    private String lastName;
    private Date birthDate;

    public Director() {
    }

    public Director(String firsName, String lastName, Date birthDate) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Director(int id, String firsName, String lastName, Date birthDate) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
