package com.in28minutes.rest.webservices.restfull_web_services.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {
    private int id;

    @Size(min = 2,message = "Name 2 character!")
    private String name;

    @Past(message = "Birtdatay error!")
    private LocalDate birthDate;

    public User( int id, String name,LocalDate birthDate ) {
        this.birthDate = birthDate;
        this.name = name;
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
