package org.cuzzie.expensesapp.model;

import java.util.Date;

public class UserBuilder {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private Date dob;
    private Boolean isAdmin;

    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public UserBuilder setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    public User createUser() {
        return new User(id, firstName, lastName, age, address, dob, isAdmin);
    }
}