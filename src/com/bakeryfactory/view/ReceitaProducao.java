/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.view;

import com.bakeryfactory.Controller.IngredienteDetalheController;
import com.bakeryfactory.Controller.IngredientesController;
import com.bakeryfactory.Controller.ReceitaProducaoController;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ListSelectionModel;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni
 */
public class ReceitaProducao extends InternalFrame implements ActionListener{

    private Connection conn = null;
   
    /**
     * Creates new form Ingredientes Panificadora
     */
    public ReceitaProducao(Connection conn, ReceitaProducaoController receitaProdController) {
        this.conn = conn;
        try {
            initComponents();
            setSize(750, 300);
            gridReceitaProducao.setController(receitaProdController);
            gridReceitaProducao.setGridDataLocator(receitaProdController);
            
            //gridControlIngred.enableDrag("Grid1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void reloadData(){
        gridReceitaProducao.reloadData();
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

        jPanelHeader = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelButtons = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        editButton1 = new org.openswing.swing.client.EditButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        exportButton1 = new org.openswing.swing.client.ExportButton();
        importButton1 = new org.openswing.swing.client.ImportButton();
        navigatorBarIngred = new org.openswing.swing.client.NavigatorBar();
        gridReceitaProducao = new org.openswing.swing.client.GridControl();
        integerColumn1 = new org.openswing.swing.table.columns.client.IntegerColumn();
        dateColumn1 = new org.openswing.swing.table.columns.client.DateColumn();
        textColumn2 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn1 = new org.openswing.swing.table.columns.client.TextColumn();
        decimalColumn1 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn2 = new org.openswing.swing.table.columns.client.DecimalColumn();
        currencyColumn1 = new org.openswing.swing.table.columns.client.CurrencyColumn();

        setTitle("Cadastro de Ingredientes");
        setPreferredSize(new java.awt.Dimension(900, 200));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelHeader.setBackground(new java.awt.Color(153, 0, 0));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bakery_Factory_logo_127x50.png"))); // NOI18N
        jLabelLogo.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanelHeader.add(jLabelLogo);

        jLabelTitulo.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Ingredientes");
        jPanelHeader.add(jLabelTitulo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanelHeader, gridBagConstraints);

        jPanelButtons.setBackground(new java.awt.Color(153, 0, 0));

        insertButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButton1ActionPerformed(evt);
            }
        });
        jPanelButtons.add(insertButton1);
        jPanelButtons.add(editButton1);
        jPanelButtons.add(deleteButton1);
        jPanelButtons.add(reloadButton1);
        jPanelButtons.add(exportButton1);
        jPanelButtons.add(importButton1);
        jPanelButtons.add(navigatorBarIngred);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanelButtons, gridBagConstraints);

        gridReceitaProducao.setAllowInsertInEdit(true);
        gridReceitaProducao.setDeleteButton(deleteButton1);
        gridReceitaProducao.setEditButton(editButton1);
        gridReceitaProducao.setExportButton(exportButton1);
        gridReceitaProducao.setFunctionId("ingredientes");
        gridReceitaProducao.setImportButton(importButton1);
        gridReceitaProducao.setInsertButton(insertButton1);
        gridReceitaProducao.setNavBar(navigatorBarIngred);
        gridReceitaProducao.setReloadButton(reloadButton1);
        gridReceitaProducao.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gridReceitaProducao.setShowFilterPanelOnGrid(true);
        gridReceitaProducao.setValueObjectClassName("com.bakeryfactory.VO.IngredientesVO");
        gridReceitaProducao.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        integerColumn1.setColumnFilterable(true);
        integerColumn1.setColumnName("codIngredientes");
        integerColumn1.setColumnSortable(true);
        integerColumn1.setHeaderColumnName("Código");
        gridReceitaProducao.getColumnContainer().add(integerColumn1);

        dateColumn1.setColumnName("dataCadastroIngred");
        dateColumn1.setColumnSortable(true);
        dateColumn1.setEditableOnEdit(true);
        dateColumn1.setEditableOnInsert(true);
        dateColumn1.setHeaderColumnName("Data Cadastro");
        gridReceitaProducao.getColumnContainer().add(dateColumn1);

        textColumn2.setColumnFilterable(true);
        textColumn2.setColumnName("tipoIngrediente");
        textColumn2.setColumnRequired(false);
        textColumn2.setColumnSortable(true);
        textColumn2.setEditableOnEdit(true);
        textColumn2.setEditableOnInsert(true);
        textColumn2.setHeaderColumnName("Tipo Ingredientes");
        textColumn2.setPreferredWidth(255);
        gridReceitaProducao.getColumnContainer().add(textColumn2);

        textColumn1.setAutoFitColumn(true);
        textColumn1.setColumnFilterable(true);
        textColumn1.setColumnName("nomeIngrediente");
        textColumn1.setColumnSortable(true);
        textColumn1.setEditableOnEdit(true);
        textColumn1.setEditableOnInsert(true);
        textColumn1.setHeaderColumnName("Nome Ingredientes");
        textColumn1.setPreferredWidth(255);
        gridReceitaProducao.getColumnContainer().add(textColumn1);

        decimalColumn1.setColumnFilterable(true);
        decimalColumn1.setColumnName("peso");
        decimalColumn1.setDecimals(2);
        decimalColumn1.setEditableOnEdit(true);
        decimalColumn1.setEditableOnInsert(true);
        decimalColumn1.setHeaderColumnName("Peso");
        gridReceitaProducao.getColumnContainer().add(decimalColumn1);

        decimalColumn2.setColumnName("unidade");
        decimalColumn2.setColumnSortable(true);
        decimalColumn2.setEditableOnEdit(true);
        decimalColumn2.setEditableOnInsert(true);
        decimalColumn2.setHeaderColumnName("Unidades");
        gridReceitaProducao.getColumnContainer().add(decimalColumn2);

        currencyColumn1.setColumnName("valor");
        currencyColumn1.setCurrencySymbol("");
        currencyColumn1.setDecimals(4);
        currencyColumn1.setEditableOnEdit(true);
        currencyColumn1.setEditableOnInsert(true);
        currencyColumn1.setHeaderColumnName("Valor R$");
        gridReceitaProducao.getColumnContainer().add(currencyColumn1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridReceitaProducao, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButton1ActionPerformed
        new ReceitaProducaoController(this, null, conn);
    }//GEN-LAST:event_insertButton1ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.CurrencyColumn currencyColumn1;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn1;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn1;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn2;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.client.ExportButton exportButton1;
    private org.openswing.swing.client.GridControl gridReceitaProducao;
    private org.openswing.swing.client.ImportButton importButton1;
    private org.openswing.swing.client.InsertButton insertButton1;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn1;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelHeader;
    private org.openswing.swing.client.NavigatorBar navigatorBarIngred;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       if(evt.getSource() == insertButton1){
           ReceitaProducao.this.insertButton1ActionPerformed(evt);
       }
    }
}