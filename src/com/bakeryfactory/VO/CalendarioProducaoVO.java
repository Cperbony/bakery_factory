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
public class CalendarioProducaoVO extends ValueObjectImpl{
    
    private Integer idCalendarioProducao;
    private Date dataCalendarioProducao;
    private String nomeCalendarioProducao;
    private String classeCalendarioProducao;
    private Date dataInicioCalendarioProducao;
    private Date dataFimCalendarioProducao;
    
    /*
    CREATE TABLE calendario_producao (
  id_calendario_prod INT NOT NULL AUTO_INCREMENT,
  requisicao_usuario_juridico_id_user_Juridico INT NOT NULL,
  requisicao_usuario_fisica_id_user_fisica INT NOT NULL,
  requisicao_usuario_id_usuario INT NOT NULL,
  requisicao_id_requisicao INT NOT NULL,
  data_calendario_prod DATE NULL,
  nome_calendario_prod VARCHAR(60) NULL,
  tipo_calendario_prod VARCHAR(60) NULL,
  classe_calendario_prod VARCHAR(60) NULL,
  data_inicio_calendario_prod DATETIME NULL,
  data_fim_calendario_prod DATETIME NULL,
  PRIMARY KEY(id_calendario_prod),
  INDEX calendario_producao_FKIndex1(requisicao_id_requisicao, requisicao_usuario_id_usuario, requisicao_usuario_fisica_id_user_fisica, requisicao_usuario_juridico_id_user_Juridico)
)
TYPE=InnoDB
AUTO_INCREMENT = 1;
    */

}
