package org.cuzzie.expensesapp.model;

import java.util.Date;

public class UserBuilder {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String country;
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

    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder setCountry(String country) {
        this.country = country;
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
        return new User(id, firstName, lastName, address, country, dob, isAdmin);
    }
}