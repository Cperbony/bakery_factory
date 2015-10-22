/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.Controller;

import com.bakeryfactory.VO.ClasseProdutoVO;
import com.bakeryfactory.view.ClasseProduto;
import com.bakeryfactory.view.ClasseProdutoDetalhe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com
 *
 */
public class ClasseProdutoDetalheController extends FormController {

    private ClasseProdutoDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private ClasseProduto classeProdutoFrame = null;

    public ClasseProdutoDetalheController(ClasseProduto classeProdutoFrame, String pk, Connection conn) {
        this.classeProdutoFrame = classeProdutoFrame;
        this.pk = pk;
        this.conn = conn;
        frame = new ClasseProdutoDetalhe(conn, this);
        MDIFrame.add(frame, true);

        if (pk != null) {
            frame.getForm1().setMode(Consts.READONLY);
            frame.getForm1().reload();
        } else {
            frame.getForm1().setMode(Consts.INSERT);
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            ResultSet rset = stmt.executeQuery("select " 
                    + "classe_produto.ID_CLASSE_PROD,"
                    + "classe_produto.DATA_CLASSE_PROD,"
                    + "classe_produto.NOME_CLASSE_PROD,"
                    + "classe_produto.TIPO_CLASSE_PROD,"
                    + "classe_produto.DESCRICAO_CLASSE_PROD "
                    + "from classe_produto where ID_CLASSE_PROD = " + pk);

            // JOptionPane.showMessageDialog(null,"Comando LoadData");
            if (rset.next()) {

                ClasseProdutoVO vo = new ClasseProdutoVO();

                vo.setCodClasseProd(rset.getInt(1));
                vo.setDataCadastroClasseProd(rset.getDate(2));
                vo.setNomeClasseProd(rset.getString(3));
                vo.setTipoClasseProd(rset.getString(4));
                vo.setDescricaoClasseProd(rset.getString(5));

                return new VOResponse(vo);

            } else {
                return new ErrorResponse("Nenhum Registro Encontrado");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {

                stmt.close();

            } catch (SQLException ex1) {

            }
        }
    }

    /**
     * Method called by the Form panel to insert new data.
     *
     * @param newValueObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(insertClasseProdutos());

            ClasseProdutoVO vo = (ClasseProdutoVO) newPersistentObject;

            //stmt.setInt(1, vo.getCodClasseProd());
            stmt.setDate(1, vo.getDataCadastroClasseProd());
            stmt.setString(2, vo.getNomeClasseProd());
            stmt.setString(3, vo.getTipoClasseProd());
            stmt.setString(4, vo.getDescricaoClasseProd());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");

            classeProdutoFrame.reloadData();
            return new VOResponse(vo);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                stmt.close();
                conn.commit();
            } catch (SQLException ex1) {
            }
        }

    }

    public static String insertClasseProdutos() {
        return "insert into classe_produto("
                + "DATA_CLASSE_PROD,"
                + "NOME_CLASSE_PROD,"
                + "TIPO_CLASSE_PROD,"
                + "DESCRICAO_CLASSE_PROD)"
                + "values(?, ?, ?, ?)";

    }

    /**
     * Method called by the Form panel to update existing data.
     *
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(updateClasseProduto());

            ClasseProdutoVO vo = (ClasseProdutoVO) persistentObject;

            stmt.setDate(1, vo.getDataCadastroClasseProd());
            stmt.setString(2, vo.getNomeClasseProd());
            stmt.setString(3, vo.getTipoClasseProd());
            stmt.setString(4, vo.getDescricaoClasseProd());
            stmt.setInt(5, vo.getCodClasseProd());

            stmt.execute();

            classeProdutoFrame.reloadData();

            return new VOResponse(vo);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                stmt.close();
                conn.commit();
            } catch (SQLException ex1) {
            }
        }
    }

    public static String updateClasseProduto() {
        return "update classe_produto set "
                + "DATA_CLASSE_PROD = ?,"
                + "NOME_CLASSE_PROD = ?,"
                + "TIPO_CLASSE_PROD = ?,"
                + "DESCRICAO_CLASSE_PROD = ?"
                + "where ID_CLASSE_PROD = ?";

    }

    /**
     * Method called by the Form panel to delete existing data.
     *
     * @param persistentObject value object to delete
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    @Override
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(deleteClasseProduto());
            ClasseProdutoVO vo = (ClasseProdutoVO) persistentObject;
            stmt.setInt(1, vo.getCodClasseProd());
            stmt.execute();
            classeProdutoFrame.reloadData();
            return new VOResponse(vo);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                stmt.close();
                conn.commit();
                JOptionPane.showMessageDialog(null, "Registro Deletado com Sucesso");
            } catch (SQLException ex1) {
            }
        }
    }

    public static String deleteClasseProduto() {
        return "delete from classe_produto where ID_CLASSE_PROD = ?";
    }
}
