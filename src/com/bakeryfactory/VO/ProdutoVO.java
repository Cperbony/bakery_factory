/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.VO;

import java.sql.Date;
import java.util.ArrayList;
import org.openswing.swing.message.receive.java.ValueObjectException;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class ProdutoVO extends ValueObjectException{
    private Integer idProduto;
    private Integer idQuantificarReceitas;
    private Integer idCongelado;
    private Integer idKitProducao;
    private Integer idRequisicao;
    private Integer idUsuario;
    private String nomeProduto;
    private Date dataCadastroProduto;
    private String observacaoProduto;
    
    //private Integer idUsuarioFisica;
    //private Integer idUsuarioJuridico;

    
    private ArrayList<String> usuarios = null;
        
    
    /*
    CREATE TABLE produto (
  id_produto INT NOT NULL AUTO_INCREMENT,
  quantificar_receitas_id_quantificar_receitas INT NOT NULL,
  congelados_id_congelados INT NOT NULL,
  kit_producao_id_kit_producao INT NOT NULL,
  requisicao_usuario_juridico_id_user_Juridico INT NOT NULL,
  requisicao_usuario_fisica_id_user_fisica INT NOT NULL,
  requisicao_usuario_id_usuario INT NOT NULL,
  requisicao_id_requisicao INT NOT NULL,
  nome_produto VARCHAR(120) NULL,
  data_cadastro_produto DATE NULL,
  observacao_produto VARCHAR(255) NULL,
  PRIMARY KEY(id_produto, quantificar_receitas_id_quantificar_receitas),
  INDEX produto_FKIndex1(requisicao_id_requisicao, requisicao_usuario_id_usuario, requisicao_usuario_fisica_id_user_fisica, requisicao_usuario_juridico_id_user_Juridico),
  INDEX produto_FKIndex2(kit_producao_id_kit_producao),
  INDEX produto_FKIndex3(quantificar_receitas_id_quantificar_receitas),
  INDEX produto_FKIndex4(congelados_id_congelados)
)
TYPE=InnoDB
AUTO_INCREMENT = 1;
    */

}
