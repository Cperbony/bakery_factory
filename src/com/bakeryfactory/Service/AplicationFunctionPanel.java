/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.Service;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.openswing.swing.mdi.java.ApplicationFunction;
import org.openswing.swing.tree.java.OpenSwingTreeNode;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com  
 * 
 */
public class AplicationFunctionPanel {
    
    private final DefaultMutableTreeNode root = new OpenSwingTreeNode();
    private final DefaultTreeModel model = new DefaultTreeModel(root);

    public AplicationFunctionPanel() {
    }
    
    
    public DefaultTreeModel getApplicationFunctions() {

        ApplicationFunction n1 = new ApplicationFunction("Cadastro", null);
        ApplicationFunction n2 = new ApplicationFunction("Movimento", null);

        ApplicationFunction n11 = new ApplicationFunction("Ingredientes", "ingredientes", null, "getIngredientes");
        ApplicationFunction n12 = new ApplicationFunction("Inquilinos", "inquilino", null, "getInquilino");
        ApplicationFunction n13 = new ApplicationFunction("Bancos", "banco", null, "getBanco");
        ApplicationFunction n14 = new ApplicationFunction("Fornecedores", "fornecedor", null, "getFornecedor");
        ApplicationFunction n15 = new ApplicationFunction(true);
        ApplicationFunction n16 = new ApplicationFunction("Centro de Custo", "centro_custo", null, "getCentroCusto");
        ApplicationFunction n17 = new ApplicationFunction("Contratos", "contrato", null, "getContrato");

        ApplicationFunction n21 = new ApplicationFunction("Contas a Receber", null);
        ApplicationFunction n211 = new ApplicationFunction("Emissao de Boletos", "boleto", null, "getBoleto");
        ApplicationFunction n212 = new ApplicationFunction("Confirma Recebimentos", "receber", null, "getReceber");
        ApplicationFunction n22 = new ApplicationFunction("Contas a Pagar", "pagar", null, "getPagar");
        ApplicationFunction n23 = new ApplicationFunction("Controle do Gás", "gas", null, "getGas");
        ApplicationFunction n24 = new ApplicationFunction("Conciliação de Cheques", "cheque", null, "getCheque");
        ApplicationFunction n25 = new ApplicationFunction("Movimento Bancário", "bancario", null, "getBancario");
        ApplicationFunction n26 = new ApplicationFunction(true);
        ApplicationFunction n27 = new ApplicationFunction("Controle de Atas", "ata", null, "getAta");
        ApplicationFunction n28 = new ApplicationFunction("Cartas de Cobrança", "cobranca", null, "getCobranca");

        n1.add(n11);
        n1.add(n12);
        n1.add(n13);
        n1.add(n14);
        n1.add(n15);
        n1.add(n16);
        n1.add(n17);

        n2.add(n21);
        n21.add(n211);
        n21.add(n212);
        n2.add(n22);
        n2.add(n23);
        n2.add(n24);
        n2.add(n25);
        n2.add(n26);
        n2.add(n27);
        n2.add(n28);

        root.add(n1);
        root.add(n2);

        return model;
    }

}
