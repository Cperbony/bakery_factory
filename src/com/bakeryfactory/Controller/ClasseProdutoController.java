/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakeryfactory.Controller;

import com.bakeryfactory.VO.ClasseProdutoVO;
import com.bakeryfactory.view.ClasseProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
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
public class ClasseProdutoController extends GridController implements GridDataLocator {

    private ClasseProduto gridClasseProduto = null;
    private Connection conn = null;

    public ClasseProdutoController(Connection conn) {
        this.conn = conn;
        gridClasseProduto = new ClasseProduto(conn, this);
        MDIFrame.add(gridClasseProduto, true);
    }

    /**
     * Callback method invoked when the user has double clicked on the selected
     * row of the gridIngredientes.
     *
     * @param rowNumber selected row index
     * @param persistentObject v.o. related to the selected row
     */
    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        ClasseProdutoVO vo = (ClasseProdutoVO) persistentObject;
        new ClasseProdutoDetalheController(gridClasseProduto, vo.getCodClasseProd().toString(), conn);
    }

    /**
     * Callback method invoked to load data on the gridIngredientes.
     *
     * @param action fetching versus: PREVIOUS_BLOCK_ACTION, NEXT_BLOCK_ACTION
     * or LAST_BLOCK_ACTION
     * @param startPos start position of data fetching in result set
     * @param filteredColumns filtered columns
     * @param currentSortedColumns sorted columns
     * @param currentSortedVersusColumns ordering versus of sorted columns
     * @param valueObjectType v.o. type
     * @param otherGridParams other gridIngredientes parameters
     * @return response from the server: an object of type VOListResponse if
     * data loading was successfully completed, or an ErrorResponse onject if
     * some error occours
     */
    @Override
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
            String sql = "select "
                    + "classe_produto.ID_CLASSE_PROD,"
                    + "classe_produto.DATA_CLASSE_PROD,"
                    + "classe_produto.NOME_CLASSE_PROD,"
                    + "classe_produto.TIPO_CLASSE_PROD,"
                    + "classe_produto.DESCRICAO_CLASSE_PROD from classe_produto";

            Vector vals = new Vector();

            Map mapa = new HashMap();
            mapa.put("codClasseProd", "classe_produto.ID_CLASSE_PROD");
            mapa.put("dataCadastroClasseProd", "classe_produto.DATA_CLASSE_PROD");
            mapa.put("nomeClasseProd", "classe_produto.NOME_CLASSE_PROD");
            mapa.put("tipoClasseProd", "classe_produto.TIPO_CLASSE_PROD");
            mapa.put("descricaoClasseProd", "classe_produto.DESCRICAO_CLASSE_PROD");

            if (filteredColumns.size() > 0) {
                FilterWhereClause[] filtro = (FilterWhereClause[]) filteredColumns.get("nomeClasseProd");
                sql += " where classe_produto.NOME_CLASSE_PROD" + filtro[0].getOperator() + "?";
                vals.add(filtro[0].getValue());
            }

            if (currentSortedColumns.size() > 0) {
                sql += " order by " + mapa.get(
                        currentSortedColumns.get(0).toString()) + " "
                        + currentSortedVersusColumns.get(0);
            }

            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < vals.size(); i++) {
                stmt.setObject(i + 1, vals.get(i));
            }

            ResultSet rset = stmt.executeQuery();

            ArrayList list = new ArrayList();
            ClasseProdutoVO vo = null;
            while (rset.next()) {
                System.out.println();
                vo = new ClasseProdutoVO();
                vo.setCodClasseProd(rset.getInt(1));
                vo.setDataCadastroClasseProd(rset.getDate(2));
                vo.setNomeClasseProd(rset.getString(3));
                vo.setTipoClasseProd(rset.getString(4));
                vo.setDescricaoClasseProd(rset.getString(5));

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
     * Method invoked when the user has clicked on delete button and the
     * gridIngredientes is in READONLY mode.
     *
     * @param persistentObjects value objects to delete (related to the
     * currently selected rows)
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM classe_produto WHERE ID_CLASSE_PROD = ?");
            for (Object persistentObject : persistentObjects) {
                ClasseProdutoVO vo = (ClasseProdutoVO) persistentObject;
                stmt.setString(1, vo.getCodClasseProd().toString());
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
