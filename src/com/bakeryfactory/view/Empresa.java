/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.view;

import com.bakeryfactory.Controller.IngredientesController;
import java.sql.Connection;
import javax.swing.ListSelectionModel;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni
 */
public class Empresa extends InternalFrame {

    private Connection conn = null;

    /**
     * Creates new form Ingredientes Panificadora
     */
    public Empresa(Connection conn, IngredientesController ingredController) {
        this.conn = conn;
        try {
            initComponents();
            setSize(750, 300);
            gridControl_Temp.setController(ingredController);
            gridControl_Temp.setGridDataLocator(ingredController);
            //gridControlIngred.enableDrag("Grid1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void reloadData(){
        gridControl_Temp.reloadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lbl_Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        insertButton_ = new org.openswing.swing.client.InsertButton();
        editButton_ = new org.openswing.swing.client.EditButton();
        deleteButton_ = new org.openswing.swing.client.DeleteButton();
        reloadButton_ = new org.openswing.swing.client.ReloadButton();
        exportButton_ = new org.openswing.swing.client.ExportButton();
        importButton_ = new org.openswing.swing.client.ImportButton();
        navigatorBar_ = new org.openswing.swing.client.NavigatorBar();
        gridControl_Temp = new org.openswing.swing.client.GridControl();
        dateData = new org.openswing.swing.table.columns.client.DateColumn();
        integerCod = new org.openswing.swing.table.columns.client.IntegerColumn();
        textNome_ = new org.openswing.swing.table.columns.client.TextColumn();
        textTipo_ = new org.openswing.swing.table.columns.client.TextColumn();
        decimalPeso = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalUnidade = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalValor_Ingred = new org.openswing.swing.table.columns.client.DecimalColumn();

        setTitle("Cadastro de Ingredientes");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        lbl_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bakery_Factory_logo_127x50.png"))); // NOI18N
        lbl_Logo.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel1.add(lbl_Logo);

        jLabel1.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastros");
        jPanel1.add(jLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.add(insertButton_);
        jPanel2.add(editButton_);
        jPanel2.add(deleteButton_);
        jPanel2.add(reloadButton_);
        jPanel2.add(exportButton_);
        jPanel2.add(importButton_);
        jPanel2.add(navigatorBar_);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        gridControl_Temp.setDeleteButton(deleteButton_);
        gridControl_Temp.setEditButton(editButton_);
        gridControl_Temp.setExportButton(exportButton_);
        gridControl_Temp.setFunctionId("ingredientes");
        gridControl_Temp.setImportButton(importButton_);
        gridControl_Temp.setInsertButton(insertButton_);
        gridControl_Temp.setNavBar(navigatorBar_);
        gridControl_Temp.setReloadButton(reloadButton_);
        gridControl_Temp.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gridControl_Temp.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        dateData.setColumnSortable(true);
        dateData.setHeaderColumnName("Data");
        dateData.setSortVersus(org.openswing.swing.util.java.Consts.ASC_SORTED);
        gridControl_Temp.getColumnContainer().add(dateData);

        integerCod.setHeaderColumnName("Código");
        gridControl_Temp.getColumnContainer().add(integerCod);

        textNome_.setAdditionalHeaderColumnName("Nome temp");
        textNome_.setColumnSortable(true);
        textNome_.setHeaderColumnName("Nome temp");
        textNome_.setPreferredWidth(300);
        gridControl_Temp.getColumnContainer().add(textNome_);

        textTipo_.setColumnFilterable(true);
        textTipo_.setColumnSortable(true);
        textTipo_.setHeaderColumnName("Tipo");
        textTipo_.setPreferredWidth(200);
        gridControl_Temp.getColumnContainer().add(textTipo_);

        decimalPeso.setHeaderColumnName("Peso");
        gridControl_Temp.getColumnContainer().add(decimalPeso);

        decimalUnidade.setHeaderColumnName("Unidades");
        gridControl_Temp.getColumnContainer().add(decimalUnidade);

        decimalValor_Ingred.setHeaderColumnName("Valor R$");
        gridControl_Temp.getColumnContainer().add(decimalValor_Ingred);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControl_Temp, gridBagConstraints);
        gridControl_Temp.getAccessibleContext().setAccessibleName("Cadastro Ingredientes");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.DateColumn dateData;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalPeso;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalUnidade;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalValor_Ingred;
    private org.openswing.swing.client.DeleteButton deleteButton_;
    private org.openswing.swing.client.EditButton editButton_;
    private org.openswing.swing.client.ExportButton exportButton_;
    private org.openswing.swing.client.GridControl gridControl_Temp;
    private org.openswing.swing.client.ImportButton importButton_;
    private org.openswing.swing.client.InsertButton insertButton_;
    private org.openswing.swing.table.columns.client.IntegerColumn integerCod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_Logo;
    private org.openswing.swing.client.NavigatorBar navigatorBar_;
    private org.openswing.swing.client.ReloadButton reloadButton_;
    private org.openswing.swing.table.columns.client.TextColumn textNome_;
    private org.openswing.swing.table.columns.client.TextColumn textTipo_;
    // End of variables declaration//GEN-END:variables
}
