    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.Controller;

import com.bakeryfactory.VO.IngredientesVO;
import com.bakeryfactory.view.IngredienteDetalhe;
import com.bakeryfactory.view.Ingredientes;
import com.bakeryfactory.view.ReceitaProducao;
import com.bakeryfactory.view.ReceitaProducaoDetalhe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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
public class ReceitaProducaoDetalheController extends FormController {

    private ReceitaProducaoDetalhe frame = null;
    private Connection conn = null;
    private String pk = null;
    private ReceitaProducao receitaProducaoFrame = null;

    public ReceitaProducaoDetalheController(ReceitaProducao receitaProducaoFrame, String pk, Connection conn) {
        this.receitaProducaoFrame = receitaProducaoFrame;
        this.pk = pk;
        this.conn = conn;
        frame = new ReceitaProducaoDetalhe(conn, this);
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

            ResultSet rset = stmt.executeQuery("SELECT "
                    + "ingredientes.ID_INGRED,"
                    + "ingredientes.DATA_INGRED,"
                    + "ingredientes.TIPO_INGRED,"
                    + "ingredientes.NOME_INGRED,"
                    + "ingredientes.PESO_INGRED,"
                    + "ingredientes.UNIDADE_INGRED,"
                    + "ingredientes.VALOR_INGRED"
                    + " from ingredientes where ID_INGRED = " + pk);

            // JOptionPane.showMessageDialog(null, "Comando LoadData");
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
    //Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(insertIngredientes());

            IngredientesVO vo = (IngredientesVO) newPersistentObject;
            //stmt.setInt(1, vo.getCodIngredientes());
            //Date dataCadastro = new Date();

            stmt.setDate(1, vo.getDataCadastroIngred());
            stmt.setString(2, vo.getTipoIngrediente());
            stmt.setString(3, vo.getNomeIngrediente());
            stmt.setDouble(4, vo.getPeso());
            stmt.setInt(5, vo.getUnidade());
            stmt.setDouble(6, vo.getValor());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");

            //pk = vo.getCodigoIngred().toString();
            receitaProducaoFrame.reloadData();
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

    public static String insertIngredientes() {
        return "insert into ingredientes ("
                + "DATA_INGRED, "
                + "TIPO_INGRED, "
                + "NOME_INGRED, "
                + "PESO_INGRED, "
                + "UNIDADE_INGRED, "
                + "VALOR_INGRED) "
                + "values(?, ?, ?, ?, ?, ?)";
    }

    /**
     * Method called by the Form panel to update existing data.
     *
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    //@Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(updateIngredientes());

            IngredientesVO vo = (IngredientesVO) persistentObject;

            stmt.setDate(1, vo.getDataCadastroIngred());
            stmt.setString(2, vo.getTipoIngrediente());
            stmt.setString(3, vo.getNomeIngrediente());
            stmt.setDouble(4, vo.getPeso());
            stmt.setInt(5, vo.getUnidade());
            stmt.setDouble(6, vo.getValor());
            stmt.setInt(7, vo.getCodIngredientes());

            stmt.execute();

            receitaProducaoFrame.reloadData();

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

    public static String updateIngredientes() {
        return "update ingredientes set "
                + "DATA_INGRED = ?,"
                + "TIPO_INGRED = ?,"
                + "NOME_INGRED = ?,"
                + "PESO_INGRED = ?,"
                + "UNIDADE_INGRED = ?,"
                + "VALOR_INGRED = ?"
                + "where ID_INGRED =?";
    }

    /**
     * Method called by the Form panel to delete existing data.
     *
     * @param persistentObject value object to delete
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    //@Override
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(deleteIngredientes());
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
                JOptionPane.showMessageDialog(null, "Registro Deletado com Sucesso");
            } catch (SQLException ex1) {
            }
        }
    }

    public static String deleteIngredientes() {
        return "delete from ingredientes where ID_INGRED = ?";
    }
}
