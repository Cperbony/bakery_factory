/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.VO;

import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class QuantificarReceita extends ValueObjectImpl {
    
    private Integer idQuantificarReceitas;
    private Integer idCalendarioProd;
    private String resultadoQuantificarReceita;
    private Integer unidadesQuantificarReceitas;
    private Double pesosQuantificarReceitas;
    private Double quantidadesQuantificarReceitas;
    
    
    /*
    CREATE TABLE quantificar_receitas (
  id_quantificar_receitas INT NOT NULL AUTO_INCREMENT,
  calendario_producao_id_calendario_prod INT NOT NULL,
  resultado_quantificar_receitas VARCHAR(120) NULL,
  unidade_total_quantificar_receitas INT NULL,
  peso_total_quantificar_receitas DECIMAL(5,2) NULL,
  quantidade_total_quantificar_receitas DECIMAL(5,2) NULL,
  PRIMARY KEY(id_quantificar_receitas),
  INDEX quantificar_receitas_FKIndex1(calendario_producao_id_calendario_prod)
)
TYPE=InnoDB;
    */

}
