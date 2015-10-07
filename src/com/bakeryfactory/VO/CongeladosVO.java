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
public class CongeladosVO extends ValueObjectImpl{
    private Integer codCongelado;
    private Date dataCongelados;
    private Integer codRequisicao;
    private String produto;
    private String descricao;
    private String classeProduto;
    private String setorSolicitante;
    private String responsavel;
    private int quantidade;
    private Double pesoUnitario;
    private Double pesoTotal;
    

}
