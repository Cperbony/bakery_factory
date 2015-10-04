/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.Controller;

import com.bakeryfactory.VO.IngredientesVO;
import com.bakeryfactory.view.Ingredientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.openswing.swing.mdi.client.MDIController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.FilterWhereClause;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

/**
 *
 * @author Claudinei Aparecido Perboni
 * @codigo author 805912
 * @email cperbony@gmail.com
 *
 */
public class IngredientesController extends GridController implements GridDataLocator {

    private Ingredientes gridIngredientes;
    private Connection conn = null;
   
    
    public IngredientesController(Connection conn) {
        this.gridIngredientes = null;
        this.conn = conn;
        gridIngredientes = new Ingredientes(conn, this);
        MDIFrame.add(gridIngredientes, true);
    }

    /**
     * Callback method invoked when the user has double clicked on the selected
     * row of the grid.
     *
     * @param rowNumber selected row index
     * @param persistentObject v.o. related to the selected row
     */
   // @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        IngredientesVO vo = (IngredientesVO) persistentObject;
        new IngredienteDetalheController(gridIngredientes, vo.getCodIngredientes().toString(), conn);
    }

    /**
     * Callback method invoked to load data on the grid.
     *
     * @param action fetching versus: PREVIOUS_BLOCK_ACTION, NEXT_BLOCK_ACTION
     * or LAST_BLOCK_ACTION
     * @param startPos start position of data fetching in result set
     * @param filteredColumns filtered columns
     * @param currentSortedColumns sorted columns
     * @param currentSortedVersusColumns ordering versus of sorted columns
     * @param valueObjectType v.o. type
     * @param otherGridParams other grid parameters
     * @return response from the server: an object of type VOListResponse if
     * data loading was successfully completed, or an ErrorResponse onject if
     * some error occours
     */
    //@Override
    public Response loadData(
            int action,
            int startIndex,
            Map filteredColumns,
            ArrayList currentSortedColumns,
            ArrayList currentSortedVersusColumns,
            Class valueObjectType,
            Map otherGridParams) {
        PreparedStatement stmt = null;
        try {
            String sql = "select ingredientes.ID_INGRED,ingredientes.DATA_INGRED,ingredientes.TIPO_INGRED,ingredientes.NOME_INGRED,ingredientes.PESO_INGRED,ingredientes.UNIDADE_INGRED,ingredientes.VALOR_INGRED from ingredientes";

            Vector vals = new Vector();

            Map mapa = new HashMap();
            mapa.put("codIngredientes", "ingredientes.ID_INGRED");
            mapa.put("dataCadastroIngred", "ingredientes.DATA_INGRED");
            mapa.put("tipoIngrediente", "ingredientes.TIPO_INGRED");
            mapa.put("nomeIngrediente", "ingredientes.NOME_INGRED");
            mapa.put("peso", "ingredientes.PESO_INGRED");
            mapa.put("unidade", "ingredientes.UNIDADE_INGRED");
            mapa.put("valor", "ingredientes.VALOR_INGRED");

//verificar se tem colunas a serem filtradas
            if (filteredColumns.size() > 0) {
                FilterWhereClause[] filtro = (FilterWhereClause[]) filteredColumns.get("nomeIngrediente");
                sql += " where ingredientes.NOME_INGRED " + filtro[0].getOperator() + "?";
                vals.add(filtro[0].getValue());
            }

            if (currentSortedColumns.size() > 0) {
                sql += " order by " + mapa.get(currentSortedColumns.get(0).toString()) + " " + currentSortedVersusColumns.get(0);
            }

            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < vals.size(); i++) {
                stmt.setObject(i + 1, vals.get(i));
            }

            ResultSet rset = stmt.executeQuery();

            ArrayList list = new ArrayList();
            IngredientesVO vo = null;
            while (rset.next()) {
                System.out.println();
                vo = new IngredientesVO();
                vo.setCodIngredientes(rset.getInt(1));
                vo.setDataCadastroIngred(rset.getDate(2));
                vo.setTipoIngrediente(rset.getString(3));
                vo.setNomeIngrediente(rset.getString(4));
                vo.setPeso(rset.getDouble(5));
                vo.setUnidade(rset.getInt(6));
                vo.setValor(rset.getDouble(7));

                list.add(vo);
            }
            return new VOListResponse(list, false, list.size());
        } catch (SQLException ex) {
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex1) {
            }
        }

    }

    /**
     * Method invoked when the user has clicked on delete button and the grid is
     * in READONLY mode.
     *
     * @param persistentObjects value objects to delete (related to the
     * currently selected rows)
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM ingredientes WHERE ID_INGRED = ?");
            for (Object persistentObject : persistentObjects) {
                IngredientesVO vo = (IngredientesVO) persistentObject;
                stmt.setString(1, vo.getCodIngredientes().toString());
                stmt.execute();
            }
            return new VOResponse(new Boolean(true));
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
