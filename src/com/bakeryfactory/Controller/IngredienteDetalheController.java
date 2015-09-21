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
    private String sql = "select ingredientes.id_ingred,"
            + "ingredientes.data_ingred, "
            + "ingredientes.nome_ingred,"
            + "ingredientes.tipo_ingred"
            + "ingredientes.peso_ingred"
            + "ingredientes.unidade_ingred"
            + "ingredientes.valor_ingred"
            + "from ingredientes";

    public IngredienteDetalheController(IngredienteDetalheControllerBuilder ingredientesBuilder) {
        ingredientesBuilder.createIngredienteDetalheController();
        frame = new IngredienteDetalhe(conn, this);
        MDIFrame.add(frame);

        if (pk != null) {
            frame.getForm1().setMode(Consts.READONLY);
            frame.getForm1().reload();
        } else {
            frame.getForm1().setMode(Consts.INSERT);
        }

    }

    public Response loadData(Class valueObjectClass) {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(sql + pk);
            if (rset.next()) {
                IngredientesVO vo = new IngredientesVO();
                vo.setCodigo(rset.getInt(1));
                vo.setDataCadastroIngred(rset.getDate(2));
                vo.setNomeIngrediente(rset.getString(3));
                vo.setTipoIngrediente(rset.getString(4));
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
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into ingredientes ("
                    + "id_ingred,"
                    + "data_ingred, "
                    + "nome_ingred,"
                    + "tipo_ingred"
                    + "peso_ingred"
                    + "unidade_ingred"
                    + "valor_ingred"
                    + " values(?, ?, ?, ?, ?, ?, ?)");
            IngredientesVO vo = (IngredientesVO) newPersistentObject;
            stmt.setInt(1, vo.getCodigoIngred());
            stmt.setString(2, vo.getDataCadastroIngred().toString());
            stmt.setString(3, vo.getNomeIngrediente());
            stmt.setString(4, vo.getTipoIngrediente());
            stmt.setString(5, vo.getTipoIngrediente());
            stmt.setDouble(6, vo.getPeso());
            stmt.setInt(7, vo.getUnidade());
            stmt.setDouble(8, vo.getValor());

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
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(""
                    + "update ingredientes "
                    + "set id_ingred=?,"
                    + "data_ingred=?,"
                    + "nome_ingred=?, "
                    + "tipo_ingred=?,"
                    + "peso_ingred=?,"
                    + "unidade_ingred=?,"
                    + "valor_ingred=?"
                    + "where id_ingred=?");
            
            IngredientesVO vo = (IngredientesVO) persistentObject;
            
            stmt.setInt(1, vo.getCodigoIngred());
            stmt.setString(2, vo.getDataCadastroIngred().toString());
            stmt.setString(3, vo.getNomeIngrediente());
            stmt.setString(4, vo.getTipoIngrediente());
            stmt.setString(5, vo.getTipoIngrediente());
            stmt.setDouble(6, vo.getPeso());
            stmt.setInt(7, vo.getUnidade());
            stmt.setDouble(8, vo.getValor());

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
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from ingredientes where id_ingred=?");
            IngredientesVO vo = (IngredientesVO) persistentObject;
            stmt.setInt(1, vo.getCodigoIngred());
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