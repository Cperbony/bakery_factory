/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.VO;

import java.sql.Date;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class ConsultaVO extends ValueObjectImpl{
    
    private Integer idConsulta;
    private Date dataConsulta;
    private String nomeConsulta;
    private String descricaoConsulta;
    private String requeridoConsulta;
    
    /*
    CREATE TABLE consulta (
  id_consulta INT NOT NULL AUTO_INCREMENT,
  relatorio_id_relatorio INT NOT NULL,
  data_consulta DATE NULL,
  nome_consulta VARCHAR(60) NULL,
  descricao_consulta VARCHAR(255) NULL,
  requerido_consulta VARCHAR(60) NULL,
  PRIMARY KEY(id_consulta),
  INDEX consulta_FKIndex1(relatorio_id_relatorio)
)
TYPE=InnoDB;
    */

}
