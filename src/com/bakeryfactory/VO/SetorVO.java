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
    
    private long idSetor;
    private Date dataSetor;
    private String nomeSetor;
    private String RespSetor;

    public SetorVO() {
    }

    public long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(long idSetor) {
        this.idSetor = idSetor;
    }

    public Date getDataSetor() {
        return dataSetor;
    }

    public void setDataSetor(Date dataSetor) {
        this.dataSetor = dataSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getRespSetor() {
        return RespSetor;
    }

    public void setRespSetor(String RespSetor) {
        this.RespSetor = RespSetor;
    }

    

    @Override
    public String toString() {
        return "SetorVO{" 
                + "Id do Setor:" + idSetor
                + ", Data Cadastro Setor:" + dataSetor 
                + ", Nome do Setor:" + nomeSetor 
                + ", Responsável pelo Setor:" + RespSetor 
                + '}';
    }  

}
