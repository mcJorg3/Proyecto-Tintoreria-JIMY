/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author JORGE MANCERA
 */
public class CustomerController implements SchemaDAO {
    
      private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;

    @Override
    public void show(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void search(JTable table, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            sql += "INSERT INTO CUSTOMER(CUSTID,NAME) VALUES(?,?)";
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
        ArrayList<String> listCustomer = new ArrayList<>();
        try {
            con = DB.getConnection();
            String sql = "SELECT NAME FROM CUSTOMER";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String name = rs.getString("NAME");
                listCustomer.add(name);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Exception", JOptionPane.ERROR_MESSAGE);
        }
        return listCustomer;
    }
    
    public int getCountCustomers(){
           int number = 0;
        try {
            String sql = "SELECT MAX(CUSTID) AS NUMCLI FROM CUSTOMER ";
            con = DB.getConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                number = rs.getInt("NUMCLI");
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
    
}
