/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.main;

import com.bakeryfactory.Controller.IngredientesController;
import com.bakeryfactory.view.Ingredientes;
import java.sql.Connection;
import org.openswing.swing.mdi.client.ClientFacade;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.mdi.client.MDIFrame;

/**
 *
 * @author Claudinei Aparecido Perboni - codigo 805912 <cperbony@gmail.com>
 */

//Implementa um Pattern Facade
public class ClienteFachada implements ClientFacade{
    
   private Connection conn = null;
   
   public ClienteFachada(Connection conn) {
        this.conn = conn;
    }
   
   public void getIngredientes(){
       new IngredientesController(conn);
   }
   
   public void getF2(){
       InternalFrame f = new InternalFrame();
       f.setSize(300,200);
       f.setTitle("Function2");
       MDIFrame.add(f);
   }
    
}
