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
public class DAOcategoria extends DAO {

    public void agregarCategoria(Categoria categ) {
        begin();
        getSession().save(categ);
        commit();
        close();

    }
    
    public  void actualizarCategoria(Categoria cat){
        begin();
        getSession().update(cat);
        commit();
        close();             
    }

    public ArrayList<Categoria> buscarCategoria() {
        begin();
        Criteria c = getSession().createCriteria(Categoria.class);
        ArrayList<Categoria> categoria = (ArrayList<Categoria>) c.list();
        commit();
        close();

        return categoria;

    }

     public void borrarCategoria(Categoria c){
            begin();
             getSession().delete(c);
            commit();
            close();
 }   
    
     public Categoria buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from categoria where id = :id");
        q.setInteger("id",id);
        Categoria c = (Categoria)q.uniqueResult();
        commit();
        close();
return c;  
   
  } 
     
}
