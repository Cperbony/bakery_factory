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
public class SetorVO {

    private Integer idSetor;
    private Integer idDistribuicao;
    private Integer idCongelados;
    private Integer idUserJuridico;
    private Integer idUserFisico;
    private Integer idusuario;
    private Integer IdRequisicao;
    private Integer idProducaoFinal;
    private Date dataCadastroSetor;
    private String nomeSetor;
    private String ResponsavelSetor;

    /*
     CREATE TABLE setor (
     id_setor INT NOT NULL AUTO_INCREMENT,
     distribuicao_id_distribuicao INT NOT NULL,
     usuario_juridico_id_user_Juridico INT NOT NULL,
     usuario_fisica_id_user_fisica INT NOT NULL,
     usuario_id_usuario INT NOT NULL,
     congelados_id_congelados INT NOT NULL,
     requisicao_usuario_juridico_id_user_Juridico INT NOT NULL,
     requisicao_usuario_fisica_id_user_fisica INT NOT NULL,
     requisicao_usuario_id_usuario INT NOT NULL,
     requisicao_id_requisicao INT NOT NULL,
     producao_final_id_producao_final INT NOT NULL,
     datacadastro_setor DATE NULL,
     nome_setor VARCHAR(60) NULL,
     responsavel_setor VARCHAR(60) NULL,
     PRIMARY KEY(id_setor, distribuicao_id_distribuicao),
     INDEX setor_FKIndex1(producao_final_id_producao_final),
     INDEX setor_FKIndex2(requisicao_id_requisicao, requisicao_usuario_id_usuario, requisicao_usuario_fisica_id_user_fisica, requisicao_usuario_juridico_id_user_Juridico),
     INDEX setor_FKIndex3(congelados_id_congelados),
     INDEX setor_FKIndex4(distribuicao_id_distribuicao),
     INDEX setor_FKIndex5(usuario_id_usuario, usuario_fisica_id_user_fisica, usuario_juridico_id_user_Juridico),
     INDEX setor_FKIndex6(distribuicao_id_distribuicao)
     )
     TYPE=InnoDB;
     */
    public SetorVO() {
    }

}
