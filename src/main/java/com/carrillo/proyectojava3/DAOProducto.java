/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrillo.proyectojava3;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author shinomichelle
 */
public class DAOProducto extends DAO {

    public void agregarProducto(Producto prod) {
        begin();
        getSession().save(prod);
        commit();
        close();

    }
    
      public void actualizarProducto(Producto prod) {
        begin();
        getSession().update(prod);
        commit();
        close();

    }
    

    public ArrayList<Producto> buscarProducto() {
        begin();
        Criteria c = getSession().createCriteria(Producto.class);
        ArrayList<Producto> producto = (ArrayList<Producto>) c.list();
        commit();
        close();

        return producto;

    }

    public void borrarProducto(Producto p) {
        begin();
        getSession().delete(p);
        commit();
        close();
    }

    public Producto buscarPorId(int id) {
        begin();
        Query q = getSession().createQuery("select from producto where id_producto = :id");
        q.setInteger("id_producto", id);
        Producto p = (Producto) q.uniqueResult();
        commit();
        close();
        return p;

    }

}
