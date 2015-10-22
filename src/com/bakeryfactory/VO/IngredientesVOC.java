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
public class IngredientesVOC extends ValueObjectImpl {

    private Integer idKitProducao;
    private Integer idQuantificarReceita;
    private Integer idReceita;
    private Integer idProduto;

    private ArrayList<String> kitsProducao = null;
    private ArrayList<String> receitas = null;
    private ArrayList<String> produtos = null;

    /*
    
     private Integer codIngredientes;
     private Date dataCadastroIngred;
     private String tipoIngrediente;
     private String nomeIngrediente;
     private double peso;
     private int unidade;
     private double valor;
     */
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
    public IngredientesVOC() {
    }

}
