/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.Controller;

import com.bakeryfactory.VO.IngredientesVO;
import com.bakeryfactory.VO.SetorVO;
import com.bakeryfactory.view.IngredienteDetalhe;
import com.bakeryfactory.view.Ingredientes;
import com.bakeryfactory.view.Setor;
import com.bakeryfactory.view.SetorDetalhe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class SetorDetalheController extends FormController {

    private SetorDetalhe setorDetFrame = null;
    private final Connection conn = null;
    private String pk = null;
    private final Setor setorFrame = null;
    private String sql = "select setor.ID_SETOR,"
            + "setor.DATACADASTRO_SETOR,"
            + "setor.NOME_SETOR_SETOR,"
            + "setor.RESPONSAVEL_SETOR"
            + "from setor";

    public SetorDetalheController(SetorDetalheControllerBuilder setorDetalheContollerBuilder) {
        setorDetalheContollerBuilder.createSetorDetalhe();
        setorDetFrame = new SetorDetalhe(conn, this);
        MDIFrame.add(setorDetFrame);

        if (pk != null) {
            setorDetFrame.getForm1().setMode(Consts.READONLY);
            setorDetFrame.getForm1().reload();
        } else {
            setorDetFrame.getForm1().setMode(Consts.INSERT);
        }

    }

    public Response loadData(Class valueObjectClass) {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(sql + pk);
            if (rset.next()) {
                
                SetorController vo = new SetorController(conn);
                vo.setarSetor(rset);
                
                return new VOResponse(vo);

            } else {
                return new ErrorResponse(" Nenhum Registro Encontrado");
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
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into setor ("
                    + "ID_SETOR,"
                    + "DATACADASTRO_SETOR, "
                    + "NOME_SETOR_SETOR,"
                    + "RESPONSAVEL_SETOR"
                    + " values(?, ?, ?, ?)");
            
            SetorVO vo = (SetorVO) newPersistentObject;
            stmt.setLong(1, vo.getIdSetor());
            stmt.setString(2, vo.getDataSetor().toString());
            stmt.setString(3, vo.getNomeSetor());
            stmt.setString(4, vo.getRespSetor());

            stmt.execute();

           
            setorFrame.reloadData();
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

    /**
     * Method called by the Form panel to update existing data.
     *
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(""
                    + "update setor "
                    + "set ID_SETOR=?,"
                    + "DATACADASTRO_SETOR=?,"
                    + "NOME_SETOR_SETOR=?, "
                    + "RESPONSAVEL_SETOR=?"
                    + "where ID_SETOR=?");
            

            SetorVO vo = (SetorVO) persistentObject;
            
            stmt.setLong(1, vo.getIdSetor());
            stmt.setString(2, vo.getDataSetor().toString());
            stmt.setString(3, vo.getNomeSetor());
            stmt.setString(4, vo.getRespSetor());

            stmt.execute();
            setorFrame.reloadData();
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

    /**
     * Method called by the Form panel to delete existing data.
     *
     * @param persistentObject value object to delete
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from setor where ID_SETOR=?");
            SetorVO vo = (SetorVO) persistentObject;
            stmt.setLong(1, vo.getIdSetor());
            stmt.execute();
            setorFrame.reloadData();
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
}
