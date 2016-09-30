/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistenciaConexion;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FrAnzZ
 */
public abstract class GestorJDBC {
   protected Connection conexion;
   
   public abstract void abrirConexion() throws Exception;
   
   public void cerrarConexion() throws Exception{
   conexion.close();
   }
   
   public void iniciarTransaccion() throws Exception{
   conexion.setAutoCommit(false);
   }
   
   public void terminarTransaccion() throws Exception{
   conexion.commit();
   conexion.setAutoCommit(true);
   conexion.close();
   } 
    
    public void cancelarTransaccion() throws SQLException{
        conexion.rollback();
        conexion.setAutoCommit(true);
        conexion.close();
    }
   public PreparedStatement prepareSentencia(String psql)throws SQLException{
       return conexion.prepareStatement(psql);
   }
    public ResultSet ejecutarConsulta(String psql) throws SQLException{
        Statement sentencia;
        ResultSet resultado;
        sentencia =  conexion.createStatement();
        resultado = sentencia.executeQuery(psql); 
        return resultado;
    }
    
    public CallableStatement procedimientoAlmacenado(String psql) throws SQLException{ 
       CallableStatement cst ;
       cst = conexion.prepareCall(psql);  
       return cst; 
    }
    public ResultSet ejecutarProcedimiento(String psql) throws SQLException{ 
        CallableStatement cst = conexion.prepareCall(psql);
        ResultSet rs = cst.executeQuery();        
        return rs;
    }
    public Connection cn(){
        return conexion;
    }
}
