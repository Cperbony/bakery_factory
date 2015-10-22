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
public class ProducaoVO extends ValueObjectImpl {

    private Integer idProducao;
    private Integer idDistribuicao;
    private Integer idQuantificarReceitas;
    private Integer idCalendarioProducao;
    private Integer idConsulta;
    private Integer idUsuario;
    private Integer idProduto;
    private Date dataInicialProducao;
    private Date dataFinalProducao;
    private String produtoProducao;
    private String itemProducao;
    private Integer unidadeProducao;
    private Double pesoProducao;
    private Double quantidadeProducao;
    private String descricaoProducao;
    private String responsavelProducao;
    
    private ArrayList<String> usuarios = null;
    

    /*
     CREATE TABLE producao (
     id_producao INT NOT NULL AUTO_INCREMENT,
     distribuicao_id_distribuicao INT NOT NULL,
     produto_quantificar_receitas_id_quantificar_receitas INT NOT NULL,
     calendario_producao_id_calendario_prod INT NOT NULL,
     consulta_id_consulta INT NOT NULL,
     requisicao_usuario_juridico_id_user_Juridico INT NOT NULL,
     requisicao_usuario_fisica_id_user_fisica INT NOT NULL,
     requisicao_usuario_id_usuario INT NOT NULL,
     requisicao_id_requisicao INT NOT NULL,
     produto_id_produto INT NOT NULL,
     data_inicial_producao DATE NULL,
     data_final_producao DATETIME NULL,
     produto_producao VARCHAR(120) NULL,
     item_producao VARCHAR(60) NULL,
     unidade_producao INT NULL,
     peso_producao DECIMAL(5,2) NULL,
     quantidade_producao DECIMAL(5,2) NULL,
     descricao_producao VARCHAR(255) NULL,
     responsavel_producao VARCHAR(60) NULL,
     PRIMARY KEY(id_producao, produto_quantificar_receitas_id_quantificar_receitas, calendario_producao_id_calendario_prod, requisicao_usuario_juridico_id_user_Juridico, requisicao_usuario_fisica_id_user_fisica, requisicao_usuario_id_usuario, requisicao_id_requisicao, produto_id_produto),
     INDEX producao_FKIndex1(produto_id_produto, produto_quantificar_receitas_id_quantificar_receitas),
     INDEX producao_FKIndex2(requisicao_id_requisicao, requisicao_usuario_id_usuario, requisicao_usuario_fisica_id_user_fisica, requisicao_usuario_juridico_id_user_Juridico),
     INDEX producao_FKIndex3(consulta_id_consulta),
     INDEX producao_FKIndex4(calendario_producao_id_calendario_prod),
     INDEX producao_FKIndex5(distribuicao_id_distribuicao)
     )
     TYPE=InnoDB;
     */
}
