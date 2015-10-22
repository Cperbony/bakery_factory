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
public class RequisicaoVO extends ValueObjectImpl {
    
    private Integer idRequisicao;
    private Integer idUsuario;
    private Date dataRequisicao;
    private String produtoRequisicao;
    private Integer quantidadeRequisicao;
    private Double pesoRequisicao;
    private String descricaoRequisicao;
    
    /*
    CREATE TABLE requisicao (
  id_requisicao INT NOT NULL AUTO_INCREMENT,
  usuario_id_usuario INT NOT NULL,
  usuario_fisica_id_user_fisica INT NOT NULL,
  usuario_juridico_id_user_Juridico INT NOT NULL,
  data_requisicao DATE NULL,
  produto_requisicao VARCHAR(120) NULL,
  quantidade_requisicao INT NULL,
  peso_requisicao DECIMAL(5,2) NULL,
  descricao_requisicao VARCHAR(255) NULL,
  PRIMARY KEY(id_requisicao, usuario_id_usuario, usuario_fisica_id_user_fisica, usuario_juridico_id_user_Juridico),
  INDEX requisicao_FKIndex1(usuario_id_usuario, usuario_fisica_id_user_fisica, usuario_juridico_id_user_Juridico)
);

    */

}
