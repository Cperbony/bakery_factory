/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.main;

import com.bakeryfactory.Controller.ClasseProdutoController;
import com.bakeryfactory.Controller.IngredientesController;
import com.bakeryfactory.VO.UsuarioVO;
import java.sql.Connection;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.ClientFacade;

/**
 *
 * @author Claudinei Aparecido Perboni - codigo 805912 <cperbony@gmail.com>
 */
//Implementa um Pattern Facade
public class ClienteFachada implements ClientFacade {

    private Connection conn = null;
    private UsuarioVO usuario;

    public ClienteFachada(Connection conn) {
        this.conn = conn;
    }

    public void getIngredientes() {
        IngredientesController ingredientesController = new IngredientesController(conn);
        //JOptionPane.showMessageDialog(null, "Ingredientes");
    }

    public void getClasseProdutos() {
        new ClasseProdutoController(conn);
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;

    }
}
