/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.VO;

import java.sql.Date;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class RelatorioVO {
    
    private Integer idRelatorio;
    private Date dataRelatorio;
    private String tipoRelatorio;
    private String produtosRelatorio;
    private Double somaProducao;
    private Integer quantidade;
    private String descricaoRelatorio;
    private String solicitanteRelatorio;
    
    /*
    CREATE TABLE relatorio (
  id_relatorio INT NOT NULL AUTO_INCREMENT,
  data_relatorio DATE NULL,
  tipo_relatorio VARCHAR(120) NULL,
  produtos_relatorio VARCHAR(120) NULL,
  soma_producao DECIMAL(5,2) NULL,
  quantidade_relatorio INT NULL,
  peso_total_relatorio DECIMAL(5,2) NULL,
  descricao_relatorio VARCHAR(255) NULL,
  solitcitante_relatorio VARCHAR(120) NULL,
  PRIMARY KEY(id_relatorio)
)
TYPE=InnoDB;
    */

}
