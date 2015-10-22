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
public class ProducaoFinal extends ValueObjectImpl{
    private Integer idProducaoFinal;
    private Integer idProduto;
    private Integer idRequisicao;
    private Integer idUsuario;
    private Integer idCalendarioProducao;
    private Integer idConsulta;
    private Integer idProducao;
    private Date dataCadastroProdFinal;
    private String produto;
    private Integer unidadeProdFinal;
    private Double quantidadeProdFinal;
    private Double pesoProdFinal;
    

    public ProducaoFinal() {
    }

    
    /*
    CREATE TABLE producao_final (
  id_producao_final INT NOT NULL AUTO_INCREMENT,
  producao_produto_id_produto INT NOT NULL,
  producao_produto_quantificar_receitas_id_quantificar_receitas INT NOT NULL,
  producao_requisicao_id_requisicao INT NOT NULL,
  producao_requisicao_usuario_id_usuario INT NOT NULL,
  producao_requisicao_usuario_fisica_id_user_fisica INT NOT NULL,
  producao_requisicao_usuario_juridico_id_user_Juridico INT NOT NULL,
  producao_calendario_producao_id_calendario_prod INT NOT NULL,
  consulta_id_consulta INT NOT NULL,
  producao_id_producao INT NOT NULL,
  datacadastro_producao_final DATE NULL,
  produto_producao_final VARCHAR(120) NULL,
  unidade_producao_final INT NULL,
  quantidade_producao_final DECIMAL(5,2) NULL,
  peso_producao_final DECIMAL(5,2) NULL,
  PRIMARY KEY(id_producao_final),
  INDEX producao_final_FKIndex1(producao_id_producao, producao_calendario_producao_id_calendario_prod, producao_requisicao_usuario_juridico_id_user_Juridico, producao_requisicao_usuario_fisica_id_user_fisica, producao_requisicao_usuario_id_usuario, producao_requisicao_id_requisicao, producao_produto_quantificar_receitas_id_quantificar_receitas, producao_produto_id_produto),
  INDEX producao_final_FKIndex2(consulta_id_consulta)
)
TYPE=InnoDB;
    */

}
