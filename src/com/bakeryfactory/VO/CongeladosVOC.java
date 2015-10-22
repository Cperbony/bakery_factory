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
public class CongeladosVOC extends ValueObjectImpl{
    private Integer codCongelado;
    
    private Integer idDistribuicao;
    private Integer idProducao;
    private Integer idProducaoFinal;
    private ArrayList<String> produtos = null;
    
    
   
    
    /*
    CREATE TABLE congelados (
  id_congelados INT NOT NULL AUTO_INCREMENT,
  distribuicao_id_distribuicao INT NOT NULL,
  producao_final_id_producao_final INT NOT NULL,
  data_congelados DATE NULL,
  validade_congelados DATE NULL,
  nome_responsavel_congelados VARCHAR(60) NULL,
  produto_congelados VARCHAR(120) NULL,
  producao__congelados VARCHAR(120) NULL,
  unidade_congelados INT NULL,
  peso_congelados DECIMAL(5,2) NULL,
  quantidade_congelados DECIMAL(5,2) NULL,
  PRIMARY KEY(id_congelados),
  INDEX congelados_FKIndex1(producao_final_id_producao_final),
  INDEX congelados_FKIndex2(distribuicao_id_distribuicao)
)
TYPE=InnoDB;
    */
    

}
