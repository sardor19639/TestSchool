package com.online.school.model;


public class Student {

    private Long id;

    private String name;

    private String surname;

    private boolean active;

    public Student() {
        super();
    }

    public Student(Long id, String name, String surname) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Student(String name, String passportNumber) {
        super();
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + name + '\'' +
                ", password='" + surname + '\'' +
                '}';
    }



}
