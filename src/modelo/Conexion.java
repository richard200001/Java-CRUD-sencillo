/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author Usuario
 */
public class Conexion {
    
    public static Connection obtenerConexion(){
        String dbURL = "jdbc:mysql://localhost:3306/DB";
        String username = "root";
        String password = "password";
        Connection conn = null;
        // conectar
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn!=null) {
                System.out.println("Conectado");
                return conn;
            }
        } catch (SQLException exc) {
            System.out.println("No se pudo establecer la conexión"+ exc.getMessage());
        }
        return conn;
    }
}
