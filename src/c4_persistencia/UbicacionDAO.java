/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Ubicacion;  
import c3_dominioFabrica.IUbicacionDAO;
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
public class UbicacionDAO implements IUbicacionDAO{
    GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<Ubicacion> ubicacions;
    private String mysql;
    private Ubicacion ubicacion;
    
    UbicacionDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

     @Override
    public boolean ingresar(Ubicacion dts) throws SQLException { 
        mysql= "{Call spUnidadInsertar (?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getUnidad());
        cst.setString(2, dts.getDescripcion());
        cst.setInt(3, dts.getEstado());   
        
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<Ubicacion> Listar() throws SQLException { 
        ubicacions = new ArrayList();        
        mysql =  "{call spUnidadListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            ubicacion = new Ubicacion();
            ubicacion.setIdunidad(rs.getInt("id"));
            ubicacion.setUnidad(rs.getString("nombre"));
            ubicacion.setDescripcion(rs.getString("descripcion"));
            ubicacion.setEstado(rs.getInt("estado"));            
            ubicacions.add(ubicacion);
        }
        rs.close();
        return ubicacions;
    }

    @Override
    public boolean editar(Ubicacion dts) throws SQLException {  
       mysql ="{call spUnidadEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdunidad());
       cst.setString(2,dts.getUnidad());
       cst.setString(3, dts.getDescripcion());
       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Ubicacion dts) throws SQLException {
       mysql = "{call spUnidadEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdunidad());
       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Ubicacion> buscarNombre(Ubicacion dts) throws Exception {
        ubicacions =new ArrayList();
      
        mysql ="{call spUnidadBuscarNombre('"+dts.getUnidad()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            ubicacion = new Ubicacion();
            ubicacion.setIdunidad(rs.getInt("id"));
            ubicacion.setUnidad(rs.getString("nombre"));
            ubicacion.setDescripcion(rs.getString("descripcion"));
            ubicacion.setEstado(rs.getInt("estado"));            
            ubicacions.add(ubicacion);
        }
        rs.close(); 
        return ubicacions;
    }
    
    
}
