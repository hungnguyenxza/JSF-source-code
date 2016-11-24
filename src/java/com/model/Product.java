/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nguyen Xuan Hung
 */
@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @Column(name = "pID")
    private String pID;
    
    @Column(name = "pName")
    private String pName;
    
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @JoinColumn(name = "manuID", referencedColumnName = "manuID")
    @ManyToOne(optional = false)
    private Manufacturer manu;

    public Product() {
    }

    public Product(String pID) {
        this.pID = pID;
    }

    public String getPID() {
        return pID;
    }

    public void setPID(String pID) {
        this.pID = pID;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Manufacturer getManu() {
        return manu;
    }

    public void setManu(Manufacturer manuID) {
        this.manu = manuID;
    }
    
}
