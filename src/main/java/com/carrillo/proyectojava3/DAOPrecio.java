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
public class DAOPrecio extends DAO{
    
    public void agregarPrecio(Precio prec) {
        begin();
        getSession().save(prec);
        commit();
        close();

    }
    
    public  void actualizarPrecio(Precio prec){
        begin();
        getSession().update(prec);
        commit();
        close();
    }

    public ArrayList<Precio> buscarPrecio() {
        begin();
        Criteria c = getSession().createCriteria(Precio.class);
        ArrayList<Precio> prec = (ArrayList<Precio>) c.list();
        commit();
        close();

        return prec;

    }

    public void borrarPrecio(Precio p) {
        begin();
        getSession().delete(p);
        commit();
        close();
    }

    public Producto buscarPorId(int id) {
        begin();
        Query q = getSession().createQuery("from precio where id_precio = :id");
        q.setInteger("id_precio", id);
        Producto p = (Producto) q.uniqueResult();
        commit();
        close();
        return p;

    }
    
}
