/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.DAO.ProductDAO;
import com.model.Manufacturer;
import com.model.Product;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nguyen Xuan Hung
 */
@ManagedBean
@SessionScoped
public class ProductBean {

    /**
     * Creates a new instance of ProductBean
     */
    private List<Product> listProduct;
    private List<Manufacturer> listManu;
    private Product product;
    private String manuID;
    private ProductDAO dao;

    public ProductBean() {
        dao = new ProductDAO();
        listManu = dao.loadAllManu();
        listProduct = dao.loadAllProduct();
    }

    public void getProductByManu(String id) {
        if (id.equals("")) {
            listProduct = dao.loadAllProduct();
        } else {
            listProduct = dao.loadAllProductByManuID(id);
        }
    }

    public String prepareAddNew(){
        product = new Product();
        return "new";
    }
    
    public String addNew(){
        Manufacturer m = null;
        for (Manufacturer manu : listManu) {
            if(manu.getManuID().equals(manuID)){
                m = manu;
                break;
            }
        }
        product.setManu(m);
        dao.addNew(product);
        listProduct = dao.loadAllProduct();
        return "index";
    }
    
    public String prepareUpdate(String id){
        product = dao.loadAllProductID(id);
        return "edit";
    }
    
    public String update(){
        dao.update(product);
        listProduct = dao.loadAllProduct();
        return "index";
    }

    public void remove(String id){
        dao.deleteProduct(id);
        listProduct = dao.loadAllProduct();
    }
    
    public String goBack(){
        return "index";
    }
    
    public List<Product> getListProduct() {
        return listProduct;
    }

    public List<Manufacturer> getListManu() {
        return listManu;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getManuID() {
        return manuID;
    }

    public void setManuID(String manuID) {
        this.manuID = manuID;
    }
    
    

}
