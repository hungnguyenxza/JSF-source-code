/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.model.Manufacturer;
import com.model.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Nguyen Xuan Hung
 */
public class ProductDAO {
    public List<Product> loadAllProduct(){
        EntityManager em = Persistence.createEntityManagerFactory("JSF_ReviewPU").createEntityManager();
        String hql = String.format("select a from %s a", Product.class.getName());
        return em.createQuery(hql).getResultList();
    }
    public List<Product> loadAllProductByManuID(String id){
        EntityManager em = Persistence.createEntityManagerFactory("JSF_ReviewPU").createEntityManager();
        String hql = String.format("select a from %s a where a.manu.manuID = :id", Product.class.getName());
        return em.createQuery(hql)
                .setParameter("id", id)
                .getResultList();
    }
    public Product loadAllProductID(String id){
        EntityManager em = Persistence.createEntityManagerFactory("JSF_ReviewPU").createEntityManager();
        return em.find(Product.class, id);
    }
    public List<Manufacturer> loadAllManu(){
        EntityManager em = Persistence.createEntityManagerFactory("JSF_ReviewPU").createEntityManager();
        String hql = String.format("select a from %s a", Manufacturer.class.getName());
        return em.createQuery(hql).getResultList();
    }
    public void addNew(Product p){
        EntityManager em = Persistence.createEntityManagerFactory("JSF_ReviewPU").createEntityManager();
        Product find = em.find(Product.class, p.getPID());
        em.getTransaction().begin();
        if(find==null){
            em.persist(p);
        }
        em.getTransaction().commit();
    }
    
    public void update(Product p){
        EntityManager em = Persistence.createEntityManagerFactory("JSF_ReviewPU").createEntityManager();
        Product find = em.find(Product.class, p.getPID());
        em.getTransaction().begin();
        if(find!=null){
            find.setPName(p.getPName());
            find.setCreatedDate(p.getCreatedDate());
            find.setManu(p.getManu());
        }
        em.getTransaction().commit();
    }
    public void deleteProduct(String id){
        EntityManager em = Persistence.createEntityManagerFactory("JSF_ReviewPU").createEntityManager();
        Product find = em.find(Product.class, id);
        em.getTransaction().begin();
        if(find!=null){
            em.remove(find);
        }
        em.getTransaction().commit();
        
    }
    
}
