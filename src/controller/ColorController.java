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
public class ColorController implements SchemaDAO {
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int edit(ArrayList<Object> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList all() {
         ArrayList<String> listColours = new ArrayList<>();
        try {
            con = DB.getConnection();
            String sql = "SELECT NAME_COLOR FROM COLOURS ORDER BY COLOR_ID  ASC";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String name = rs.getString("NAME_COLOR");
                listColours.add(name);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex, "Exception", JOptionPane.ERROR_MESSAGE);
        }
        return listColours;
    }
    
    
    
}
