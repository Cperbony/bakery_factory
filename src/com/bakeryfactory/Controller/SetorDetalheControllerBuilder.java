/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.Controller;

import com.bakeryfactory.view.Setor;
import java.sql.Connection;


public class SetorDetalheControllerBuilder {
    private Setor setor;
    private String pk;
    private Connection conn;

    public SetorDetalheControllerBuilder() {
    }

    public SetorDetalheControllerBuilder setSetor(Setor setor) {
        this.setor = setor;
        return this;
    }

    public SetorDetalheControllerBuilder setPk(String pk) {
        this.pk = pk;
        return this;
    }

    public SetorDetalheControllerBuilder setConn(Connection conn) {
        this.conn = conn;
        return this;
    }

    public SetorDetalheController createSetorDetalhe() {
        return new SetorDetalheController(this);
    }

   

}
