/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.VO;

import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com
 *
 */
public class UsuarioVO extends ValueObjectImpl {

    private Integer codUsuario;
    private String nomeUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String tipoUsuario;

  /*
    CREATE TABLE usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  usuario_fisica_id_user_fisica INT NOT NULL,
  usuario_juridico_id_user_Juridico INT NOT NULL,
  endereco_id_endereco INT NOT NULL,
  nome_usuario VARCHAR(60) NULL,
  fone_res_usuario VARCHAR(13) NULL,
  fone_com_usuario_2 VARCHAR(13) NULL,
  fone_celular1 VARCHAR(15) NULL,
  fone_celular2 VARCHAR(15) NULL,
  PRIMARY KEY(id_usuario, usuario_fisica_id_user_fisica, usuario_juridico_id_user_Juridico),
  INDEX usuario_FKIndex1(endereco_id_endereco),
  INDEX usuario_FKIndex2(usuario_fisica_id_user_fisica),
  INDEX usuario_FKIndex3(usuario_juridico_id_user_Juridico)
)
AUTO_INCREMENT = 1;
    */

}
