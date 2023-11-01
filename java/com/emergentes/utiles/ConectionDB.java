package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {
    static String driver="com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
    static String usuario = "root";
    static String password="";    
    protected Connection conn = null;
    public ConectionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null){
                System.out.println("Conexion OK " + conn);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR EN ESPECIFICACION DE DRIVER " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conectar " + ex.getMessage());
        }        
    }
    // CLASE CONECTAR
     public Connection conectar()
     {
         return conn;
     }        
     // CLASE DESCONECTAR
     public void desconectar()
     {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar" + ex.getMessage());
        }
     }        
    
}
