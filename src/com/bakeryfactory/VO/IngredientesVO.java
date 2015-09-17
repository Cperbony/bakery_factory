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
    
    private int codIngredientes;
    private Date dataCadastroIngred;
    private String nomeIngrediente;
    private String tipoIngrediente;
    private double peso;
    private int unidade;
    private double valor;

    public IngredientesVO() {
    }

    public int getCodigoIngred() {
        return codIngredientes;
    }

    public void setCodigo(int codigo) {
        this.codIngredientes = codigo;
    }

    public Date getDataCadastroIngred() {
        return dataCadastroIngred;
    }

    public void setDataCadastroIngred(Date dataCadastroIngred) {
        this.dataCadastroIngred = dataCadastroIngred;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public String getTipoIngrediente() {
        return tipoIngrediente;
    }

    public void setTipoIngrediente(String tipoIngrediente) {
        this.tipoIngrediente = tipoIngrediente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "IngredientesVO{" + "codIngredientes=" + codIngredientes 
                + ", dataCadastroIngred=" + dataCadastroIngred 
                + ", nomeIngrediente=" + nomeIngrediente 
                + ", tipoIngrediente=" + tipoIngrediente
                + ", peso=" + peso
                + ", unidade=" + unidade
                + ", valor=" + valor
                + '}';
    }
    
    
    
    

}
