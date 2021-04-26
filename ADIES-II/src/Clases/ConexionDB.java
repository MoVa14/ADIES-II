/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB {
    
    public String url="jdbc:sqlite:C://Repositorio//ADIES-II//BD//ADIES.db";
    Connection connect;
    ResultSet result = null;
    
    public void conectar(){
        try {
            connect = DriverManager.getConnection(url);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Conectado el Error es: " + e.toString());
            //System.out.println(e.toString());
        }   
    }
    
    public void insertar(String sql){
        try {
            PreparedStatement st = connect.prepareStatement(sql);
            st.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Conectado el Error es: " + e.toString());
            //System.out.println(e.toString());
        }
    }
    
    public ResultSet seleccionar (String sql){
        try {
            PreparedStatement st = connect.prepareStatement(sql);
            result = st.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Conectado el Error es: " + e.toString());
            //System.out.println(e.toString());
        }
        return result;
    }
    
    public void cerrar(){
        try {
            connect.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Conectado el Error es: " + e.toString());
           // System.out.println(e.toString());
        }
    }
    
}
