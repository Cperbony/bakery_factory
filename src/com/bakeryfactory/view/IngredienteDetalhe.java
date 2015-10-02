/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.view;

import com.bakeryfactory.Controller.IngredienteDetalheController;
import com.bakeryfactory.view.Ingredientes;
import java.sql.Connection;
import org.openswing.swing.client.DeleteButton;
import org.openswing.swing.client.EditButton;
import org.openswing.swing.client.SaveButton;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 *
 * @author Claudinei Aparecido Perboni
 */
public class IngredienteDetalhe extends InternalFrame {
    
    private Connection conn = null;

    public IngredienteDetalhe(Connection conn, FormController dataController) {
        try {
            this.conn = conn;
             initComponents();
             formIngredientes.setFormController(dataController);
             setSize(800,600);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public Form getForm1(){
        return formIngredientes;
        
    }
    
    public SaveButton getSaveButton() {
        return saveButton1;
    }

    public DeleteButton getDeleteButton() {
        return deleteButton1;
    }

    public EditButton getEditButton() {
        return editButton1;
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        copyButtonIngrediente = new org.openswing.swing.client.CopyButton();
        editButton1 = new org.openswing.swing.client.EditButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        saveButton1 = new org.openswing.swing.client.SaveButton();
        formIngredientes = new org.openswing.swing.form.client.Form();
        textTipoIngred = new org.openswing.swing.client.TextControl();
        textCodIngred = new org.openswing.swing.client.TextControl();
        numericUnidadeIngred = new org.openswing.swing.client.NumericControl();
        txtData_Ingred = new org.openswing.swing.client.LabelControl();
        txtNome_Ingred = new org.openswing.swing.client.LabelControl();
        txtUnidade_Ingred = new org.openswing.swing.client.LabelControl();
        numericPesoIngred = new org.openswing.swing.client.NumericControl();
        txtPeso_Ingred1 = new org.openswing.swing.client.LabelControl();
        txtValor_ingred = new org.openswing.swing.client.LabelControl();
        dateControlIngred = new org.openswing.swing.client.DateControl();
        txtCod_Ingred1 = new org.openswing.swing.client.LabelControl();
        currencyControl1 = new org.openswing.swing.client.CurrencyControl();
        textTipoIngred1 = new org.openswing.swing.client.TextControl();
        txtNome_Ingred1 = new org.openswing.swing.client.LabelControl();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Ingredientes (Inserir/Alterar)");
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bakery_Factory_logo_127x50.png"))); // NOI18N
        lblLogo.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel1.add(lblLogo);
        jPanel1.add(insertButton1);
        jPanel1.add(copyButtonIngrediente);
        jPanel1.add(editButton1);
        jPanel1.add(deleteButton1);
        jPanel1.add(reloadButton1);
        jPanel1.add(saveButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        formIngredientes.setVOClassName("com.bakeryfactory.VO.IngredienteVO");
        formIngredientes.setCopyButton(copyButtonIngrediente);
        formIngredientes.setDeleteButton(deleteButton1);
        formIngredientes.setEditButton(editButton1);
        formIngredientes.setInsertButton(insertButton1);
        formIngredientes.setReloadButton(reloadButton1);
        formIngredientes.setSaveButton(saveButton1);
        formIngredientes.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        formIngredientes.add(textTipoIngred, gridBagConstraints);

        textCodIngred.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 250);
        formIngredientes.add(textCodIngred, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        formIngredientes.add(numericUnidadeIngred, gridBagConstraints);

        txtData_Ingred.setText("Data de Cadastro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        formIngredientes.add(txtData_Ingred, gridBagConstraints);

        txtNome_Ingred.setText("Tipo Ingrediente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        formIngredientes.add(txtNome_Ingred, gridBagConstraints);

        txtUnidade_Ingred.setText("Unidade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        formIngredientes.add(txtUnidade_Ingred, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        formIngredientes.add(numericPesoIngred, gridBagConstraints);

        txtPeso_Ingred1.setText("Peso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        formIngredientes.add(txtPeso_Ingred1, gridBagConstraints);

        txtValor_ingred.setText("Valor R$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        formIngredientes.add(txtValor_ingred, gridBagConstraints);

        dateControlIngred.setCanCopy(false);
        dateControlIngred.setRequired(true);
        dateControlIngred.setToolTipText("Inserir Data de Cadastro do Ingrediente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        formIngredientes.add(dateControlIngred, gridBagConstraints);

        txtCod_Ingred1.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        formIngredientes.add(txtCod_Ingred1, gridBagConstraints);

        currencyControl1.setCurrencySymbol("R$");
        currencyControl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyControl1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        formIngredientes.add(currencyControl1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        formIngredientes.add(textTipoIngred1, gridBagConstraints);

        txtNome_Ingred1.setText("Nome do Ingrediente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        formIngredientes.add(txtNome_Ingred1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        getContentPane().add(formIngredientes, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void currencyControl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currencyControl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currencyControl1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.CopyButton copyButtonIngrediente;
    private org.openswing.swing.client.CurrencyControl currencyControl1;
    private org.openswing.swing.client.DateControl dateControlIngred;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.form.client.Form formIngredientes;
    private org.openswing.swing.client.InsertButton insertButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogo;
    private org.openswing.swing.client.NumericControl numericPesoIngred;
    private org.openswing.swing.client.NumericControl numericUnidadeIngred;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.TextControl textCodIngred;
    private org.openswing.swing.client.TextControl textTipoIngred;
    private org.openswing.swing.client.TextControl textTipoIngred1;
    private org.openswing.swing.client.LabelControl txtCod_Ingred1;
    private org.openswing.swing.client.LabelControl txtData_Ingred;
    private org.openswing.swing.client.LabelControl txtNome_Ingred;
    private org.openswing.swing.client.LabelControl txtNome_Ingred1;
    private org.openswing.swing.client.LabelControl txtPeso_Ingred1;
    private org.openswing.swing.client.LabelControl txtUnidade_Ingred;
    private org.openswing.swing.client.LabelControl txtValor_ingred;
    // End of variables declaration//GEN-END:variables
}
