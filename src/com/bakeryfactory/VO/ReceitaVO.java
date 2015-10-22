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
public class ReceitaVO extends ValueObjectImpl{
    
    private Integer idReceita;
            private Date dataCadastroReceita;
            private String nomeReceita;
            private String tipoReceita;
            private String descricaoReceita;
            private ArrayList receitas = null;
            
                /*
    CREATE TABLE receita (
  id_receita INT NOT NULL AUTO_INCREMENT,
  quantificar_receitas_id_quantificar_receitas INT NOT NULL,
  datacadastro_receita DATE NULL,
  nome_receita VARCHAR(120) NULL,
  tipo_receita VARCHAR(60) NULL,
  descricao_receita VARCHAR(255) NULL,
  PRIMARY KEY(id_receita),
  INDEX receita_FKIndex1(quantificar_receitas_id_quantificar_receitas)
)
TYPE=InnoDB;
    */
    
  

}
