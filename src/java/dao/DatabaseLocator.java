/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fernanda
 */
public class DatabaseLocator {
    
    public static DatabaseLocator instance = null;
    
    private DatabaseLocator(){}
    
    public static DatabaseLocator getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null)
            instance = new DatabaseLocator();
        return instance;
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
       
        String serverName = "localhost";
        String mydatabase = "testesoftware";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(url, "root", "");
        return conn;
    }
    
    public static void fecharConexao(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {

        }
    }   
}
