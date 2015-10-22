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
public class ControleComprasVO extends ValueObjectImpl{
    
    private Integer idControleCompras;
    private Date dataControleCompras;
    private Integer numeroNotaFiscal;
    private Date dataNotaFiscalCompra;
    private String produtoControleCompras;
    private Double quantidadeControleCompras;
    private Double pesoControleCompras;
    private Integer unidadeControleCompras;
    
    private ArrayList<String> produtos = null;
    
    
    
    /*
    CREATE TABLE controle_compras (
  id_controle_compras INT NOT NULL AUTO_INCREMENT,
  consulta_id_consulta INT NOT NULL,
  data_controle_compras DATE NULL,
  numero_nf__controle_compras INT NULL,
  data_nf_controle_compras DATE NULL,
  produto_controle_compras VARCHAR(120) NULL,
  quantidade_controle_compras DECIMAL(5,2) NULL,
  peso_controle_compras DECIMAL(5,2) NULL,
  unidade_controle_compras INT NULL,
  PRIMARY KEY(id_controle_compras),
  INDEX controle_compras_FKIndex1(consulta_id_consulta)
)
TYPE=InnoDB;
    */

}
