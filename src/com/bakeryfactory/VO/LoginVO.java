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
public class LoginVO extends ValueObjectImpl {
    
    private Integer idLogin;
    private String usuario;
    private String nomeLogin;
    private String password;
    private Date dataTimeLogin;
    
    private ArrayList<String> usuarios = null;
    
    /*
    CREATE TABLE login (
  id_login INT NOT NULL AUTO_INCREMENT,
  usuario_juridico_id_user_Juridico INT NOT NULL,
  usuario_fisica_id_user_fisica INT NOT NULL,
  usuario_id_usuario INT NOT NULL,
  nome_login VARCHAR(30) NULL,
  senha_login VARCHAR(20) NULL,
  datatime_login DATETIME NULL,
  PRIMARY KEY(id_login),
  INDEX login_FKIndex1(usuario_id_usuario, usuario_fisica_id_user_fisica, usuario_juridico_id_user_Juridico)
);
    */

}
