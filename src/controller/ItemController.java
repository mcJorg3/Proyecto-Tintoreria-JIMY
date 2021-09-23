/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JORGE MANCERA
 */
public class ItemController implements SchemaDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;
    private ResultSetMetaData rsmt;

    @Override
    public void show(JTable table) {
        try {
            con = DB.getConnection();
            String sql = "";
            sql += "SELECT CODART AS CODIGO,DESCRIPTION AS DESCRIPCION,PRICE AS PRECIO,"
                    + "STOCK AS INVENTARIO FROM "
                    + "ITEM ORDER BY CODART ASC";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            rsmt = rs.getMetaData();
            int numColumnas = rsmt.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            table.setModel(modelo);

            for (int i = 1; i <= numColumnas; i++) {
                modelo.addColumn(rsmt.getColumnLabel(i));
            }
            Object obj[] = new Object[numColumnas];

            while (rs.next()) {
                for (int j = 0; j < numColumnas; j++) {
                    obj[j] = rs.getObject(j + 1);
                }
                modelo.addRow(obj);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void search(JTable table, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void search(JTable table, String item) {

        try {
            con = DB.getConnection();
            String sql = "";
            sql += "SELECT * FROM ITEM " + " WHERE UPPER(ITEM.CODART) LIKE UPPER('%" + item
                    + "%')OR LOWER(ITEM.CODART) LIKE LOWER('%" + item + "%')" + " OR UPPER(ITEM.DESCRIPTION) LIKE UPPER('%"
                    + item + "%') OR LOWER(ITEM.DESCRIPTION) LIKE LOWER('%" + item + "%')";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            rsmt = rs.getMetaData();
            int numColumnas = rsmt.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            table.setModel(modelo);

            for (int i = 1; i <= numColumnas; i++) {
                modelo.addColumn(rsmt.getColumnLabel(i));
            }
            Object obj[] = new Object[numColumnas];

            while (rs.next()) {
                for (int j = 0; j < numColumnas; j++) {
                    obj[j] = rs.getObject(j + 1);
                }
                modelo.addRow(obj);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(ArrayList<Object> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int edit(ArrayList<Object> data) {
        int rtdo = 0;
        try {
            String sql = "";
            sql += "UPDATE ITEM SET DESCRIPTION = ?,PRICE = ?,STOCK=?  WHERE CODART = ?";
            con = DB.getConnection();
            pstm = con.prepareStatement(sql);
            int i = 1;
            for (Object o : data) {
                pstm.setObject(i, o);
                i++;
            }
            rtdo = pstm.executeUpdate();
            if (rtdo == 1) {
                JOptionPane.showMessageDialog(null, "Item updated successfully ");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Exception", JOptionPane.ERROR_MESSAGE);
        }
        return rtdo;
    }

    @Override
    public ArrayList all() {
        ArrayList<String> list = new ArrayList<>();
        try {
            con = DB.getConnection();
            String sql = "SELECT CODART,DESCRIPTION FROM ITEM ORDER BY CODART  ASC";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String s = rs.getString("CODART") + "|" + rs.getString("DESCRIPTION");
                list.add(s);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Exception", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    public double getPrice(String descrip) {
        double price = 0;
        try {
            String sql = "SELECT PRICE FROM ITEM WHERE DESCRIPTION=? ";
            con = DB.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, descrip);
            rs = pstm.executeQuery();
            while (rs.next()) {
                price = rs.getDouble("PRICE");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
        return price;
    }

    public String getItem(String descrip) {
        String s = "";
        try {
            String sql = "SELECT CODART FROM ITEM WHERE DESCRIPTION=? ";
            con = DB.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, descrip);
            rs = pstm.executeQuery();
            while (rs.next()) {
                s = rs.getString("CODART");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }

        return s;

    }

}
