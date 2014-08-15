/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carrillo.proyectojava3;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shinomichelle
 */
@Entity
@Table(name = "precio")

public class Precio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_precio")
    private Integer idPrecio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    @JoinColumn(name = "id_prod", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProd;

    public Precio() {
    }

    public Precio(Integer idPrecio, Float precio, Producto idProd) {
        this.idPrecio = idPrecio;
        this.precio = precio;
        this.idProd = idProd;
    }

    public Precio(Producto idProd, Float precio) {
        this.precio = precio;
        this.idProd = idProd;
    }

    public Precio(Integer idPrecio, Float precio) {
        this.idPrecio = idPrecio;
        this.precio = precio;
    }
    
       
    public Precio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Producto getIdProd() {
        return idProd;
    }

    public void setIdProd(Producto idProd) {
        this.idProd = idProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecio != null ? idPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precio)) {
            return false;
        }
        Precio other = (Precio) object;
        if ((this.idPrecio == null && other.idPrecio != null) || (this.idPrecio != null && !this.idPrecio.equals(other.idPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carrillo.proyectojava3.Precio[ idPrecio=" + idPrecio + " ]";
    }
    
}
