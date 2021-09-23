/*
 * Copyright (c) 2019, 2021, CALE SOFTWARE. All rights reserved.
 * SisVenPro version 2.0.0.0
 * This program is trial software.
 * This software is distributed in the hope that it will be useful
 * and is provided by the Copyright authors
 * -Illegal copying and use of the software is prohibited.
 * 
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ing.Jorge Carlos Mancera Méndez
 */
public class DB {

    private static Connection con;



    public static Connection getConnection() {
       try {

            if (con == null) {
                Runtime.getRuntime().addShutdownHook(new stdh());
                String usr = "yimi";
                String pwd = "yimi";
                String server = "localhost";
                String driver = "oracle.jdbc.OracleDriver";//JAR ojdbc7 
                String url = "jdbc:oracle:thin:@" + server + ":1521:XE";
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se pudo estebecer comunicacion,Error al crear la conexion" + ex, "Error " + ex, JOptionPane.ERROR_MESSAGE);

            throw new RuntimeException("Error al crear la conexion", ex);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error con la ruta o el driver,Error al crear la conexion" + ex, "Error " + ex, JOptionPane.ERROR_MESSAGE);
        }
       

        return con;
    }

    static class stdh extends Thread {

        @Override
        public void run() {

            try {
                Connection con = DB.getConnection();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error close connection..." + ex, "Error" + ex, JOptionPane.ERROR_MESSAGE);

            }

        }

    }
}
