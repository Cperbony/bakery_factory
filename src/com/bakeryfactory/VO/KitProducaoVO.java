/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.VO;

import java.sql.Date;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class KitProducaoVO extends ValueObjectImpl {
    
    private Integer idKitProducao;
    
    private Integer idQuantificarReceitas;
    private Integer idUserJuridico;
    private Integer idUserFisica;
    private Integer idUsuario;
    
    private Date dataKitProducao;
    private Date horarioKitProducao;
    private String produtoKitProducao;
    private Integer unidadeKitProducao;
    private Double quantidadeKitProducao;
    private Double pesoKitProducao;
    private String descricaoKitProducao;
    
    private ArrayList<String> usuarios=null;
    private ArrayList<String> requisicoes=null;
    private ArrayList<String> produtos=null;
    
    
    
    
    
    /*
    CREATE TABLE kit_producao (
  id_kit_producao INT NOT NULL AUTO_INCREMENT,
  quantificar_receitas_id_quantificar_receitas INT NOT NULL,
  requisicao_usuario_juridico_id_user_Juridico INT NOT NULL,
  requisicao_usuario_fisica_id_user_fisica INT NOT NULL,
  requisicao_usuario_id_usuario INT NOT NULL,
  requisicao_id_requisicao INT NOT NULL,
  data_kit_producao DATE NULL,
  horario_kit_producao TIME NULL,
  produto_kit_producao VARCHAR(120) NULL,
  peso_kit_producao DECIMAL(5,2) NULL,
  unidade_kit_producao INT NULL,
  descricao_kit_producao VARCHAR(255) NULL,
  PRIMARY KEY(id_kit_producao),
  INDEX kit_producao_FKIndex1(requisicao_id_requisicao, requisicao_usuario_id_usuario, requisicao_usuario_fisica_id_user_fisica, requisicao_usuario_juridico_id_user_Juridico),
  INDEX kit_producao_FKIndex2(quantificar_receitas_id_quantificar_receitas)
)
TYPE=InnoDB
AUTO_INCREMENT = 1;
    */

}
