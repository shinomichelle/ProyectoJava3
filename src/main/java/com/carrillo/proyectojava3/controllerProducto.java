/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrillo.proyectojava3;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author shinomichelle
 */
@Controller
@RequestMapping("/")
public class controllerProducto {

    @RequestMapping(value = "/producto", method = RequestMethod.GET, headers = {"Accept = Application/json"})

    public @ResponseBody
    String metodoBuscarProducto() throws Exception {

        ObjectMapper maper = new ObjectMapper();
        DAOProducto prod = new DAOProducto();
        return maper.writeValueAsString(prod.buscarProducto());

    }
    
    @RequestMapping(value = "/buscarProdId/{id_producto}", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody
    String metodoActualizarProducto(@PathVariable int id_producto) {
        String msg;
        
        try {
            DAOProducto p = new DAOProducto();
            p.buscarPorId(id_producto);
            msg = "Producto encontrado con exito";
        } catch (Exception e) {
            msg = "Error al actualizar prodcuto...";
        }
        return msg;
        
    }

    @RequestMapping(value = "/agregarProducto/{id_categoria}/{descripcion}", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody
    String metodoInsertarCategoria(@PathVariable int id_categoria, @PathVariable String descripcion) {

        String msg;
        try {
            DAOProducto p = new DAOProducto();
            p.agregarProducto(new Producto(new Categoria(id_categoria), descripcion));
            msg = "Producto Insertado con exito";
        } catch (Exception e) {
            msg = "Error al insertar producto..." + e;
        }
        return msg;

    }

    @RequestMapping(value = "/borrarProd/{id_producto}", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody
    String metodoBorrarProducto(@PathVariable int id_producto) {
        String msg;

        try {
            DAOProducto p = new DAOProducto();
            p.borrarProducto(new Producto(id_producto));
            msg = "Producto eliminado con exito !!";
        } catch (Exception e) {
            msg = "Error al eliminar producto..." + e;
        }
        return msg;
    }

    @RequestMapping(value = "/actualizarProd/{id_producto}/{descripcion}", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody
    String metodoActualizarProducto(@PathVariable int id_producto, @PathVariable String descripcion) {
        String msg;
        
        try {
            DAOProducto p = new DAOProducto();
            p.actualizarProducto(new Producto(id_producto,descripcion));
            msg = "Producto actualizado con exito";
        } catch (Exception e) {
            msg = "Error al actualizar prodcuto..." + e;
        }
        return msg;
        
    }
}
