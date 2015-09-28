/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.Service;

import com.bakeryfactory.Controller.UsuarioController;
import com.bakeryfactory.VO.UsuarioVO;
import com.bakeryfactory.main.ClienteFachada;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class AutenticaUsuario {
    
  private UsuarioVO usuario = new UsuarioVO();
    private ClienteFachada clienteFachada;
    
    private ConexaoBD bd;
    
    public boolean authenticateUser(Map loginInfo) throws Exception {
        String username = loginInfo.get("username").toString().toUpperCase();
        String encpassword = new String((byte[]) loginInfo.get("password"));

        usuario.setLoginUsuario(username);
        usuario.setSenhaUsuario(encpassword);

        ConexaoBD bd = new ConexaoBD();
        UsuarioController uc = new UsuarioController();
        uc.validaUsuario();
        

        usuario = uc.validaUsuario();

        if (usuario.getLoginUsuario() != null) {
            clienteFachada.setUsuario(usuario);
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Login ou senha inválidos.");
            return false;
        }
    }

}
