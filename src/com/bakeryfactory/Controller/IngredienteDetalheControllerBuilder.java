/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.Controller;

import com.bakeryfactory.view.Ingredientes;
import java.sql.Connection;


public class IngredienteDetalheControllerBuilder {
    private Ingredientes ingredienteFrame;
    private String pk;
    private Connection conn;

    public IngredienteDetalheControllerBuilder() {
    }

    public IngredienteDetalheControllerBuilder setIngredienteFrame(Ingredientes ingredienteFrame) {
        this.ingredienteFrame = ingredienteFrame;
        return this;
    }

    public IngredienteDetalheControllerBuilder setPk(String pk) {
        this.pk = pk;
        return this;
    }

    public IngredienteDetalheControllerBuilder setConn(Connection conn) {
        this.conn = conn;
        return this;
    }

    public IngredienteDetalheController createIngredienteDetalheController() {
        return new IngredienteDetalheController(this);
    }

    @Override
    public String toString() {
        return '}' 
                + "IngredienteDetalheControllerBuilder{" 
                + "ingredienteFrame=" + ingredienteFrame
                + ", pk=" + pk
                + ", conn=" + conn;
    }
}
