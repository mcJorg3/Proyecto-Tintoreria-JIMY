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
public class TicketController  implements SchemaDAO{
    
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ResultSetMetaData rsmt;

    @Override
    public void show(JTable table) {
          try {
            con = DB.getConnection();
            String sql = "";
            sql += "SELECT FOLIO AS FOLIO,FDATE AS F_ENTRADA,EDATE AS F_ENTREGA,NAME AS CLIENTE, QUANTITY AS CANTIDAD,CODART AS ARTICULO,"
                     +"NAME_COLOR AS  COLOR,DESCRIP AS DESCRIP,PRICE AS PRECIO,AMOUNT AS IMPORTE,STATUS AS ESTATUS,NOTES AS NOTAS "
                     + " FROM VW_SALES ORDER BY FOLIO ASC ";
             
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
         try {
            con = DB.getConnection();
            String sql = "";
            sql += "SELECT FOLIO AS FOLIO,FDATE AS F_ENTRADA,EDATE AS F_ENTREGA,NAME AS CLIENTE, QUANTITY AS CANTIDAD,CODART AS ARTICULO,"
                     +"NAME_COLOR AS  COLOR,DESCRIP AS DESCRIP,PRICE AS PRECIO,AMOUNT AS IMPORTE,STATUS AS ESTATUS,NOTES AS NOTAS "
                     + " FROM  VW_SALES WHERE FOLIO=? ORDER  BY FOLIO ASC ";
             
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
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
    public void search(JTable table, String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                 int rtdo = 0;

        try {
            String sql = "";
            sql += "INSERT INTO TICKET(FOLIO,FDATE,EDATE,TOTAL,CUSTID) VALUES(?,?,?,?,?)";
            con = DB.getConnection();
            pstm = con.prepareStatement(sql);
            int i = 1;
            for (Object o : data) {
                pstm.setObject(i, o);
                i++;
            }
            rtdo = pstm.executeUpdate();
            if (rtdo == 1) {
                JOptionPane.showMessageDialog(null, "Message:Record modified successfully...");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Exception", JOptionPane.ERROR_MESSAGE);
        }
        return rtdo == 1;
    }

    @Override
    public int edit(ArrayList<Object> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getFolio(){
     int number = 0;
        try {
            String sql = "SELECT MAX(FOLIO) AS NUMTIC FROM TICKET ";
            con = DB.getConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                number = rs.getInt("NUMTIC");
            }
            if (number == 0) {
                number = 1;
            } else {
                number = number + 1;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
        return number;
    }
    
       public void insertDetail(int numTicket, int quantity, String item,int color, String descrip, double price, double amount,
            int status, String notes) {
        try {
            con = DB.getConnection();
            String sql = "";
            sql += "INSERT INTO DETASALE(FOLIO,QUANTITY,CODART,COLOR_ID,DESCRIP,PRICE,AMOUNT,STATUS,NOTES) VALUES (?,?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, numTicket);
            pstm.setInt(2, quantity);
            pstm.setString(3, item);
             pstm.setInt(4, color);
            pstm.setString(5, descrip);
            pstm.setDouble(6, price);
            pstm.setDouble(7, amount);
            pstm.setInt(8, status);
            pstm.setString(9, notes);
            int rtdo = pstm.executeUpdate();
            if (rtdo == 1) {
               // JOptionPane.showMessageDialog(null, "Message:Ticket detail Registered successful...");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
}
