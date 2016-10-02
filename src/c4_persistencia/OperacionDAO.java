/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Operacion; 
import c3_dominioFabrica.IOperacionDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class OperacionDAO implements IOperacionDAO{
    GestorJDBC gestorJDBC;
     private CallableStatement cst;
    private ResultSet rs ;
    private List<Operacion> operacions;
    private String mysql;
    private Operacion operacion;
    
    OperacionDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

      @Override
    public boolean ingresar(Operacion dts) throws SQLException { 
        mysql= "{Call spUnidadInsertar (?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getUnidad());
        cst.setString(2, dts.getDescripcion());
        cst.setInt(3, dts.getEstado());   
        
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<Operacion> Listar() throws SQLException { 
        operacions = new ArrayList();        
        mysql =  "{call spUnidadListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            operacion = new Operacion();
            operacion.setIdunidad(rs.getInt("id"));
            operacion.setUnidad(rs.getString("nombre"));
            operacion.setDescripcion(rs.getString("descripcion"));
            operacion.setEstado(rs.getInt("estado"));            
            operacions.add(operacion);
        }
        rs.close();
        return operacions;
    }

    @Override
    public boolean editar(Operacion dts) throws SQLException {  
       mysql ="{call spUnidadEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdunidad());
       cst.setString(2,dts.getUnidad());
       cst.setString(3, dts.getDescripcion());
       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Operacion dts) throws SQLException {
       mysql = "{call spUnidadEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdunidad());
       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Operacion> buscarNombre(Operacion dts) throws Exception {
        operacions =new ArrayList();
      
        mysql ="{call spUnidadBuscarNombre('"+dts.getUnidad()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            operacion = new Operacion();
            operacion.setIdunidad(rs.getInt("id"));
            operacion.setUnidad(rs.getString("nombre"));
            operacion.setDescripcion(rs.getString("descripcion"));
            operacion.setEstado(rs.getInt("estado"));            
            operacions.add(operacion);
        }
        rs.close(); 
        return operacions;
    }
    
    
}
