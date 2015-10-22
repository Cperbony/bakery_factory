/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.VO;

import java.sql.Date;
import java.util.ArrayList;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class LoggerVO extends ValueObjectImpl{
    
    private Integer idLogger;
    private Date dataTimeLogger;
    private String registroLogger;
    private String usuarioLogger;
    
    private ArrayList<String> registrosLoger = null;
    private ArrayList<String> usuariosLogger = null;
    
    /*
    CREATE TABLE logger (
  id_logger INT NOT NULL AUTO_INCREMENT,
  datetime_logger DATETIME NULL,
  registro_logger VARCHAR(255) NULL,
  PRIMARY KEY(id_logger)
    */

}
