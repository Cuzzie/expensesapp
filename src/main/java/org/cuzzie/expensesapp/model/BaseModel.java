package org.cuzzie.expensesapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Cuzzie on 6/15/2017.
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private int id;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createddt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;

    @Column(name = "updatedby")
    private String updatedBy;

    @Column(name = "updateddt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDt;

    public BaseModel() {
    }

    public BaseModel(int id) {
        this.id = id;
    }

    public BaseModel(int id, String createdBy, Date createdDt, String updatedBy, Date updatedDt) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdDt = createdDt;
        this.updatedBy = updatedBy;
        this.updatedDt = updatedDt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }
}
