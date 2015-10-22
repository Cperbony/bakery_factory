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
public class ModoPreparoVO extends ValueObjectImpl{
    
    private Integer idModoPreparo;
    private Integer idReceita;
    private Date dataCadastroModoPreparo;
    private String preparoModo;
    private String tempoModoPreparo;
    private String observacaoModoPreparo;
    
    private ArrayList<String> receitas = null;
    
    /*
    CREATE TABLE modo_preparo (
  id_modo_preparo INT NOT NULL AUTO_INCREMENT,
  receita_id_receita INT NOT NULL,
  datacadastro_modo_preparo DATE NULL,
  preparo_modo_preparo VARCHAR(255) NULL,
  tempo_modo_preparo VARCHAR(50) NULL,
  observacao__modo_preparo VARCHAR(255) NULL,
  PRIMARY KEY(id_modo_preparo),
  INDEX modo_preparo_FKIndex1(receita_id_receita)
)
TYPE=InnoDB;
    */
    
    

}
