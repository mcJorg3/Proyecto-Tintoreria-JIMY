 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author Ing.Jorge Carlos Mancera Méndez
 * 
 */
public interface SchemaDAO {
    
    public void show(javax.swing.JTable table);
    public void search(javax.swing.JTable table,int id);
    public void search(javax.swing.JTable table,String param);
    public boolean delete(int id);
    public boolean delete(String param);
    public boolean save(ArrayList<Object> data);
    public int edit(ArrayList<Object>data);
    public ArrayList all();
   
}
