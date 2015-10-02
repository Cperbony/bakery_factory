/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.Controller;

import com.bakeryfactory.VO.IngredientesVO;
import com.bakeryfactory.view.IngredienteDetalhe;
import com.bakeryfactory.view.Ingredientes;
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
public class IngredienteDetalheController extends FormController {

    private IngredienteDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private Ingredientes ingredienteFrame = null;

    public IngredienteDetalheController(Ingredientes ingredienteFrame, String pk, Connection conn) {
        this.ingredienteFrame = ingredienteFrame;
        this.pk = pk;
        this.conn = conn;
        frame = new IngredienteDetalhe(conn, this);
        MDIFrame.add(frame);

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

            ResultSet rset = stmt.executeQuery(
                    "SELECT"
                    + "ingredientes.ID_INGRED,"
                    + "ingredientes.DATA_INGRED,"
                    + "ingredientes.TIPO_INGRED,"
                    + "ingredientes.NOME_INGRED,"
                    + "ingredientes.PESO_INGRED,"
                    + "ingredientes.UNIDADE_INGRED,"
                    + "ingredientes.VALOR_INGRED"
                    + "from ingredientes WHERE ID_INGRED =" + pk);

            if (rset.next()) {
                IngredientesVO vo = new IngredientesVO();
                vo.setCodIngredientes(rset.getInt(1));
                vo.setDataCadastroIngred(rset.getDate(2));
                vo.setTipoIngrediente(rset.getString(3));
                vo.setNomeIngrediente(rset.getString(4));
                vo.setPeso(rset.getDouble(5));
                vo.setUnidade(rset.getInt(6));
                vo.setValor(rset.getDouble(7));
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
    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into ingredientes ("
                    + "DATA_INGRED,"
                    + "TIPO_INGRED,"
                    + "NOME_INGRED,"
                    + "PESO_INGRED,"
                    + "UNIDADE_INGRED,"
                    + "VALOR_INGRED)"
                    + " values(?, ?, ?, ?, ?, ?)");
            
            IngredientesVO vo = (IngredientesVO) newPersistentObject;
            stmt.setInt(1, vo.getCodIngredientes());
            stmt.setString(2, vo.getDataCadastroIngred().toString());
            stmt.setString(3, vo.getTipoIngrediente());
            stmt.setString(4, vo.getNomeIngrediente());
            stmt.setDouble(5, vo.getPeso());
            stmt.setInt(6, vo.getUnidade());
            stmt.setDouble(7, vo.getValor());

            stmt.execute();

            //pk = vo.getCodigoIngred().toString();
            ingredienteFrame.reloadData();
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
    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(""
                    + "update ingredientes set "
                    //+ "set id_ingred=?,"
                    + "DATA_INGRED = ?,"
                    + "TIPO_INGRED = ?,"
                    + "NOME_INGRED = ?,"
                    + "PESO_INGRED = ?,"
                    + "UNIDADE_INGRED = ?,"
                    + "VALOR_INGRED = ?"
                    + "where ID_INGRED =?");

            IngredientesVO vo = (IngredientesVO) persistentObject;

            // stmt.setInt(1, vo.getCodIngredientes());
            stmt.setString(1, vo.getDataCadastroIngred().toString());
            stmt.setString(2, vo.getTipoIngrediente());
            stmt.setString(3, vo.getNomeIngrediente());
            stmt.setDouble(4, vo.getPeso());
            stmt.setInt(5, vo.getUnidade());
            stmt.setDouble(6, vo.getValor());

            stmt.execute();

            ingredienteFrame.reloadData();

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
    @Override
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from ingredientes where ID_INGRED = ?");
            IngredientesVO vo = (IngredientesVO) persistentObject;
            stmt.setInt(1, vo.getCodIngredientes());
            stmt.execute();
            ingredienteFrame.reloadData();
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
