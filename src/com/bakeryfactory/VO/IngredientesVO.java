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
public class IngredientesVO extends ValueObjectImpl{
    
    private Integer codIngredientes;
    private Date dataCadastroIngred;
    private String nomeIngrediente;
    private String tipoIngrediente;
    private double peso;
    private int unidade;
    private double valor;

    public IngredientesVO() {
    }

    /**
     * @return the codIngredientes
     */
    public Integer getCodIngredientes() {
        return codIngredientes;
    }

    /**
     * @param codIngredientes the codIngredientes to set
     */
    public void setCodIngredientes(Integer codIngredientes) {
        this.codIngredientes = codIngredientes;
    }

    /**
     * @return the dataCadastroIngred
     */
    public Date getDataCadastroIngred() {
        return dataCadastroIngred;
    }

    /**
     * @param dataCadastroIngred the dataCadastroIngred to set
     */
    public void setDataCadastroIngred(Date dataCadastroIngred) {
        this.dataCadastroIngred = dataCadastroIngred;
    }

    /**
     * @return the nomeIngrediente
     */
    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    /**
     * @param nomeIngrediente the nomeIngrediente to set
     */
    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    /**
     * @return the tipoIngrediente
     */
    public String getTipoIngrediente() {
        return tipoIngrediente;
    }

    /**
     * @param tipoIngrediente the tipoIngrediente to set
     */
    public void setTipoIngrediente(String tipoIngrediente) {
        this.tipoIngrediente = tipoIngrediente;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the unidade
     */
    public int getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    

}
