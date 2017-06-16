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

    @Column(name = "firstname")
    @Basic(optional = false)
    @NotNull
    private String firstName;

    @Column(name = "lastname")
    @Basic(optional = false)
    @NotNull
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

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

    public User(int id, String firstName, String lastName, int age, String address, Date dob, Boolean isAdmin) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.dob = dob;
        this.isAdmin = isAdmin;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
