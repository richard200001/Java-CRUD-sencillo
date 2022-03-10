
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

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
