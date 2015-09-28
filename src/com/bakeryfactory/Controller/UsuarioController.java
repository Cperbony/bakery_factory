/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.Controller;

import com.bakeryfactory.Service.ConexaoBD;
import com.bakeryfactory.VO.UsuarioVO;
import com.bakeryfactory.view.UsuarioCadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com
 *
 */
public class UsuarioController {

    private Connection conn = null;
    private UsuarioVO usuarioVO;
   private ConexaoBD bd;

    public UsuarioVO validaUsuario() {
        bd.createConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            String sql = "select usuario.codigo,usuario.nome,usuario.login,"
                    + "usuario.senha,usuario.tipo from usuario "
                    + "where usuario.login=? and usuario.senha=?";
            
            stmt= conn.prepareStatement(sql);
            stmt.setString(1, usuarioVO.getLoginUsuario());
            stmt.setString(2, usuarioVO.getSenhaUsuario());
            rset = stmt.executeQuery();
            if (rset.next()) {
                usuarioVO.setCodUsuario(rset.getInt("codigo"));
                usuarioVO.setNomeUsuario(rset.getString("nome"));
                usuarioVO.setLoginUsuario(rset.getString("login"));
                usuarioVO.setSenhaUsuario(rset.getString("senha"));
                usuarioVO.setTipoUsuario(rset.getString("tipo"));
                return usuarioVO;
            } else {
                return new UsuarioVO();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new UsuarioVO();
        } finally {
            try {
                rset.close();
            } catch (Exception ex1) {
            }
            try {
                stmt.close();
            } catch (Exception ex1) {
            }
        }
    }
}
