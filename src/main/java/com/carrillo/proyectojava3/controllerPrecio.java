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
public class controllerPrecio {

    @RequestMapping(value = "/precio", method = RequestMethod.GET, headers = {"Accept = Application/json"})

    public @ResponseBody
    String metodoBuscarProducto() throws Exception {

        ObjectMapper maper = new ObjectMapper();
        DAOPrecio prec = new DAOPrecio();
        return maper.writeValueAsString(prec.buscarPrecio());

    }
    
     @RequestMapping (value ="/agregarPrecio/{descripcion}",method = RequestMethod.GET, headers = {"Accept=Application/json"})
     public @ResponseBody
     String metodoInsertarCategoria(@PathVariable int id_prod, @PathVariable float precio) {

     String msg;
     try {
     DAOPrecio p = new DAOPrecio();
     p.agregarPrecio(new Precio(id_prod, precio));
     msg = "Precio Insertado con exito";
     } catch (Exception e) {
     msg = "Error al insertar precio..." + e;
     }
     return msg;

     }
     
     @RequestMapping (value = "actulizarPrecio/{id_precio}/{precio}", method = RequestMethod.GET, headers = {"Accept = Application/json"})
     public @ResponseBody
     String metodoActualizarPrecio(@PathVariable int id_precio, @PathVariable float precio){
         
         String msg;
         try {
             DAOPrecio p = new DAOPrecio();
             p.actualizarPrecio(new Precio(id_precio,precio));
             msg= "Precio actualizado con exito";
         } catch (Exception e) {
             msg = "Error al actualizar precio...";
             
         }
         return msg;
                
     }
     
    @RequestMapping (value = "eliminarPrecio/{id_precio}",method = RequestMethod.GET,headers = {"Accept = Application/json"})
    public @ResponseBody
    String metodoEliminarPrecio(@PathVariable int id_precio){
        
        String msg;
        
        try {
            DAOPrecio p = new DAOPrecio();
            p.borrarPrecio(new Precio(id_precio));
            msg = "Precio eliminado correctamente";
        } catch (Exception e) {
            msg = "Error al eliminar precio..." + e ;
        }
        return msg;
        
    }
     
}
