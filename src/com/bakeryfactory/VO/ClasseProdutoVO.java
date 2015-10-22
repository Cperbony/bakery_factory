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
public class ClasseProdutoVO extends ValueObjectImpl{
    
    private Integer codClasseProd;
    private Date dataCadastroClasseProd;
    private String nomeClasseProd;
    private String tipoClasseProd;
    private String descricaoClasseProd;
    
    /*
    CREATE TABLE classe_produto (
  id_classe_produto INT NOT NULL AUTO_INCREMENT,
  produto_quantificar_receitas_id_quantificar_receitas INT NOT NULL,
  produto_id_produto INT NOT NULL,
  datacadastro_classe_produto DATE NULL,
  nome_classe_produto VARCHAR(60) NULL,
  tipo_classe_produto VARCHAR(60) NULL,
  descricao_classe_produto VARCHAR(255) NULL,
  PRIMARY KEY(id_classe_produto),
  INDEX classe_produto_FKIndex1(produto_id_produto, produto_quantificar_receitas_id_quantificar_receitas)
)
TYPE=InnoDB;
    */

    public ClasseProdutoVO() {
    }

    /**
     * @return the codClasseProd
     */
    public Integer getCodClasseProd() {
        return codClasseProd;
    }

    /**
     * @param codClasseProd the codClasseProd to set
     */
    public void setCodClasseProd(Integer codClasseProd) {
        this.codClasseProd = codClasseProd;
    }

    /**
     * @return the dataCadastroClasseProd
     */
    public Date getDataCadastroClasseProd() {
        return dataCadastroClasseProd;
    }

    /**
     * @param dataCadastroClasseProd the dataCadastroClasseProd to set
     */
    public void setDataCadastroClasseProd(Date dataCadastroClasseProd) {
        this.dataCadastroClasseProd = dataCadastroClasseProd;
    }

    /**
     * @return the nomeClasseProd
     */
    public String getNomeClasseProd() {
        return nomeClasseProd;
    }

    /**
     * @param nomeClasseProd the nomeClasseProd to set
     */
    public void setNomeClasseProd(String nomeClasseProd) {
        this.nomeClasseProd = nomeClasseProd;
    }

    /**
     * @return the tipoClasseProd
     */
    public String getTipoClasseProd() {
        return tipoClasseProd;
    }

    /**
     * @param tipoClasseProd the tipoClasseProd to set
     */
    public void setTipoClasseProd(String tipoClasseProd) {
        this.tipoClasseProd = tipoClasseProd;
    }

    /**
     * @return the descricaoClasseProd
     */
    public String getDescricaoClasseProd() {
        return descricaoClasseProd;
    }

    /**
     * @param descricaoClasseProd the descricaoClasseProd to set
     */
    public void setDescricaoClasseProd(String descricaoClasseProd) {
        this.descricaoClasseProd = descricaoClasseProd;
    }
    
}