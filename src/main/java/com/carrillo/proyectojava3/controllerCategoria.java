/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrillo.proyectojava3;

import com.sun.org.apache.bcel.internal.generic.RETURN;
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

public class controllerCategoria {

    @RequestMapping(value = "/categoria", method = RequestMethod.GET, headers = {"Accept = Application/json"})

    public @ResponseBody
    String metodoBuscarCategorias() throws Exception {

        ObjectMapper maper = new ObjectMapper();
        DAOcategoria cat = new DAOcategoria();
        return maper.writeValueAsString(cat.buscarCategoria());

    }

    @RequestMapping(value = "/agregarCategoria/{descripcion}", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody
    String metodoInsertarCategoria(@PathVariable String descripcion) {

        String msg;
        try {
            DAOcategoria c = new DAOcategoria();
            c.agregarCategoria(new Categoria(descripcion));
            msg = "Categoria Insertada con exito";
        } catch (Exception e) {
            msg = "Error al insertar categoria...";
        }
        return msg;

    }

    @RequestMapping(value = "/actualizarCategoria/{id}/{descripcion}", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody
    String metodoActualizarCategoria(@PathVariable int id, @PathVariable String descripcion) {

        String msg;

        try {
            DAOcategoria c = new DAOcategoria();
            c.actualizarCategoria(new Categoria(id, descripcion));
            msg = "Categoria actulizada correctamente";
        } catch (Exception e) {
            msg = "Error al actualizar categoria..." + e;
        }
        return msg;

    }

    @RequestMapping(value = "eliminarCategoria/{id}", method = RequestMethod.GET, headers = {"Accept=Applicatio/json"})
    public @ResponseBody
    String metodoEliminarCategoria(@PathVariable int id) {
        String msg;
        try {
            DAOcategoria c = new DAOcategoria();
            c.borrarCategoria(new Categoria(id));
            msg = "Categoria eliminada con exito";
        } catch (Exception e) {
            msg = "Error al eliminar categoria..." + e;
        }
        return msg;
    }

}
