/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.VO;


import java.sql.Date;
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
    private String tipoIngrediente;
    private String nomeIngrediente;
    private double peso;
    private int unidade;
    private double valor;
    
    
    /*
    CREATE TABLE Ingrediente (
  id_Ingrediente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  kit_producao_id_kit_producao INT NOT NULL,
  quantificar_receitas_id_quantificar_receitas INT NOT NULL,
  produto_quantificar_receitas_id_quantificar_receitas INT NOT NULL,
  receita_id_receita INT NOT NULL,
  produto_id_produto INT NOT NULL,
  data_Ingrediente DATE NULL,
  tipo_Ingrediente VARCHAR(60) NULL,
  nome_Ingrediente VARCHAR(60) NULL,
  peso_Ingrediente DECIMAL(5,2) NULL,
  unidade_Ingrediente INTEGER UNSIGNED NULL,
  Valor_Ingrediente DECIMAL(5,2) NULL,
  PRIMARY KEY(id_Ingrediente),
  INDEX Ingrediente_FKIndex1(produto_id_produto, produto_quantificar_receitas_id_quantificar_receitas),
  INDEX Ingrediente_FKIndex2(receita_id_receita),
  INDEX Ingrediente_FKIndex3(quantificar_receitas_id_quantificar_receitas),
  INDEX Ingrediente_FKIndex4(kit_producao_id_kit_producao)
)
TYPE=InnoDB
AUTO_INCREMENT = 1;
    */

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
