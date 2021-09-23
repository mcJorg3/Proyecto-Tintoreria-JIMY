
/*
 * Copyright (c) 2019, 2021, CALE SOFTWARE. All rights reserved.
 * SisVenPro version 2.0.0.0
 * This program is trial software.
 * This software is distributed in the hope that it will be useful
 * and is provided by the Copyright authors
 * -Illegal copying and use of the software is prohibited.
 * 
 */
package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controller.DB;
import java.sql.Statement;

public class Session {

    private static Session session;
    private static String name;
    private static int id;
    private static String profile;


    private Session() {
    }

    /**
     * Create only one instance of Session
     *
     * @return Session
     */
    public static Session getSession() {
        if (session == null) {
            session = new Session();
        }
        return session;
    }

    /**
     *
     * @param usr
     * @param pass
     * @return
     */
    public static boolean validate(String usr, String pass) {
        Connection con = DB.getConnection();
      
        
        boolean rpta = false;
        Statement stm;
        ResultSet rs;
    
        try {
            String sql = "";
            sql+="SELECT IDEMP,USR,PROFILE FROM EMPLOYEE WHERE USR = '"+usr+"'  AND  PWD = '"+pass+"'";
            stm=con.createStatement();
            rs= stm.executeQuery(sql);
         
            while (rs.next()) {
                id = rs.getInt("IDEMP");
                name = rs.getString("USR");
                profile=rs.getString("PROFILE");
                System.out.println("nombre usuario base:"+name);
                if (!name.isEmpty()) {
                    rpta = true;
                }
            }
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "Message:Unexpected error: " + ex,"Runtime Exception",JOptionPane.ERROR_MESSAGE);
        }
        return rpta;
    }

    public static String getName() {
        return name;
    }

    public static int getId() {
        return id;
    }

    public static String getProfile() {
        return profile;
    }
}
