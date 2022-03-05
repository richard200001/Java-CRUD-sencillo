package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD {
    Connection coneBD;
    
    public ClienteCRUD(){
        coneBD = Conexion.obtenerConexion();
    }
        
    public String ingresarRegistro(Cliente unCliente){
        String salida="";
        String sql ="INSERT INTO cliente VALUES(?,?)";
        try{
                PreparedStatement sentencia = coneBD.prepareStatement(sql);

                sentencia.setLong(1,unCliente.getId());
                sentencia.setString(2,unCliente.getNombre());
                int rowsInserted = sentencia.executeUpdate();
                if ( rowsInserted > 0) {
                    salida="Se ingró el cliente: "+unCliente.getNombre()+" con exito";
                }
        }catch(SQLException ex){
            salida= "No se puedo ingresar el cliente: "+unCliente.getNombre()+ ex.getMessage();
        }
        return salida;
    }
    
    public List<Cliente> mostrarRegistros(){
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try{
            Statement sentencia = coneBD.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()){
                long id = resultado.getLong(1);
                String nombre = resultado.getString(2);
                lista.add(new Cliente(id,nombre));
            }
        }catch(SQLException ex)
        {
            System.out.println("No se pudo traer datos: ");
        }
        return lista;
    }
    
    public String actualizarRegistro(Cliente unCliente){
        String salida="";
        String sql ="UPDATE cliente SET nombre=? WHERE cc=?";
        try{
                PreparedStatement sentencia = coneBD.prepareStatement(sql);
                sentencia.setString(1,unCliente.getNombre());
                sentencia.setLong(2,unCliente.getId());
                int rowsInserted = sentencia.executeUpdate();
                if ( rowsInserted > 0) {
                    salida="Actualización exitosa!";
                }
        }catch(SQLException ex){
            salida="No se puedo actualizar: "+ ex.getMessage();
        }
        return salida;
    }
    
    public String borrarRegistro(long id){
        String salida ="";
        String sql ="DELETE FROM cliente WHERE cc=?";
        try{
                PreparedStatement sentencia = coneBD.prepareStatement(sql);
                sentencia.setLong(1,id);
                int rowsInserted = sentencia.executeUpdate();
                if ( rowsInserted > 0) {
                    salida ="Borrado exitoso!";
                }
        }catch(SQLException ex){
            salida="No se pudo borrar: "+ ex.getMessage();
        }
        return salida;
    }
}

