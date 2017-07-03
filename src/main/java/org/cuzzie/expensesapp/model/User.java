package org.cuzzie.expensesapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Cuzzie on 6/15/2017.
 */
@Entity
@Table(name = "users")
public class User extends BaseModel{

    @Column(name = "username")
    @Basic(optional = false)
    @NotNull
    private String username;

    @Column(name = "password")
    @Basic(optional = false)
    @NotNull
    private String password;

    @Column(name = "firstname")
    @Basic(optional = false)
    @NotNull
    private String firstName;

    @Column(name = "lastname")
    @Basic(optional = false)
    @NotNull
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "dob")
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Column(name = "isadmin")
    @Basic(optional = false)
    private Boolean isAdmin;

    public User() {
    }

    public User(int id, String username, String password, String firstName, String lastName, String address, String country, Date dob, Boolean isAdmin) {
        super(id);
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.dob = dob;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
