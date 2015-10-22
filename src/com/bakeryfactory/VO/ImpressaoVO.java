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
public class ImpressaoVO extends ValueObjectImpl{
    
    private Integer idImpressao;
    private Date dataImpressao;
    private String requeridoImpressao;
    
    
    
   /*  id_impressao INT NOT NULL AUTO_INCREMENT,
  relatorio_id_relatorio INT NOT NULL,
  data_impressao DATE NULL,
  requerido_impressao VARCHAR(60) NULL,
  PRIMARY KEY(id_impressao),
  INDEX impressao_FKIndex1(relatorio_id_relatorio)
)
*/

}
