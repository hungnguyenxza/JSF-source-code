/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Nguyen Xuan Hung
 */
@Entity
@Table(name = "Manufacturer")
public class Manufacturer implements Serializable {

    @Id
    @Column(name = "manuID")
    private String manuID;
    
    @Column(name = "manuName")
    private String manuName;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manu")
    private List<Product> listProduct;

    public Manufacturer() {
    }

    public Manufacturer(String manuID, String manuName) {
        this.manuID = manuID;
        this.manuName = manuName;
    }

    public String getManuID() {
        return manuID;
    }

    public void setManuID(String manuID) {
        this.manuID = manuID;
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public Collection<Product> getProductCollection() {
        return listProduct;
    }

    public void setProductCollection(List<Product> productCollection) {
        this.listProduct = productCollection;
    }
}
