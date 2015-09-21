/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.VO;

import java.util.Date;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class ClasseProdutoVO extends ValueObjectImpl{
    
    private int codClasseProd;
    private Date dataCadastroClasseProd;
    private String nomeClasseProd;
    private String tipoClasseProd;
    private String descricaoClasseProd;

    public ClasseProdutoVO() {
    }

    public int getCodClasseProd() {
        return codClasseProd;
    }

    public void setCodClasseProd(int codClasseProd) {
        this.codClasseProd = codClasseProd;
    }

    public Date getDataCadastroClasseProd() {
        return dataCadastroClasseProd;
    }

    public void setDataCadastroClasseProd(Date dataCadastroClasseProd) {
        this.dataCadastroClasseProd = dataCadastroClasseProd;
    }

    public String getNomeClasseProd() {
        return nomeClasseProd;
    }

    public void setNomeClasseProd(String nomeClasseProd) {
        this.nomeClasseProd = nomeClasseProd;
    }

    public String getTipoClasseProd() {
        return tipoClasseProd;
    }

    public void setTipoClasseProd(String tipoClasseProd) {
        this.tipoClasseProd = tipoClasseProd;
    }

    public String getDescricaoClasseProd() {
        return descricaoClasseProd;
    }

    public void setDescricaoClasseProd(String descricaoClasseProd) {
        this.descricaoClasseProd = descricaoClasseProd;
    }

    @Override
    public String toString() {
        return + '}' +
                "ClasseProdutoVO{"
                + "codClasseProd=" + codClasseProd + ","
                + " dataCadastroClasseProd=" + dataCadastroClasseProd + ","
                + " nomeClasseProd=" + nomeClasseProd + ","
                + " tipoClasseProd=" + tipoClasseProd + ","
                + " descricaoClasseProd=" + descricaoClasseProd;
    }

    

    
    
    
    
    

}
