/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.Controller;

import com.bakeryfactory.VO.SetorVO;
import com.bakeryfactory.view.Setor;
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
public class SetorController extends GridController implements GridDataLocator {
    
    private final Setor gridControl_Setores;
    private final Connection conn;

    public SetorController(Connection conn) {
        this.conn = null;
        gridControl_Setores = new Setor(conn, this);
        MDIFrame.add(gridControl_Setores, true);
    }

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
            String sql = "select setor.ID_SETOR,"
                    + "setor.DATACADASTRO_SETOR,"
                    + "setor.NOME_SETOR_SETOR,"
                    + "setor.RESPONSAVEL_SETOR";
            

            Vector vals = new Vector();

            Map mapa = new HashMap();
            mapa.put("idSetor", "ID_SETOR");
            mapa.put("dataSetor", "DATACADASTRO_SETOR,");
            mapa.put("nomeSetor", "NOME_SETOR_SETOR");
            mapa.put("RespSetor", "RESPONSAVEL_SETOR");
       
            

            if (filteredColumns.size() > 0) {
                FilterWhereClause[] filtro = (FilterWhereClause[]) filteredColumns.get("nomeSetor");
                sql += " where setor.NOME_SETOR_SETOR" + filtro[0].getOperator() + "?";
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
            SetorVO vo = null;
            while (rset.next()) {
                System.out.println();
                vo = setarSetor(rset);

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

    public SetorVO setarSetor(ResultSet rset) throws SQLException {
        SetorVO vo;
        vo = new SetorVO();
        vo.setIdSetor(rset.getLong(1));
        vo.setDataSetor(rset.getDate(2));
        vo.setNomeSetor(rset.getString(3));
        vo.setRespSetor(rset.getString(4));
        return vo;
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
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM setor WHERE ID_SETOR=?");
            for (Object persistentObject : persistentObjects) {
                SetorVO vo = (SetorVO) persistentObject;
                stmt.setLong(1, vo.getIdSetor());
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
