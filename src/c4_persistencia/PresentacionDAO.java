/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Presentacion; 
import c3_dominioFabrica.IPresentacionDAO;
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
public class PresentacionDAO implements IPresentacionDAO{    
    GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<Presentacion> presentacions;
    private String mysql;
    private Presentacion presentacion;
    
    PresentacionDAO(GestorJDBC gestorJDBC){
        this.gestorJDBC = gestorJDBC;
    }

      @Override
    public boolean ingresar(Presentacion dts) throws SQLException { 
        mysql= "{Call spUnidadInsertar (?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getUnidad());
        cst.setString(2, dts.getDescripcion());
        cst.setInt(3, dts.getEstado());   
        
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<Presentacion> Listar() throws SQLException { 
        presentacions = new ArrayList();        
        mysql =  "{call spUnidadListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            presentacion = new Presentacion();
            presentacion.setIdunidad(rs.getInt("id"));
            presentacion.setUnidad(rs.getString("nombre"));
            presentacion.setDescripcion(rs.getString("descripcion"));
            presentacion.setEstado(rs.getInt("estado"));            
            presentacions.add(presentacion);
        }
        rs.close();
        return presentacions;
    }

    @Override
    public boolean editar(Presentacion dts) throws SQLException {  
       mysql ="{call spUnidadEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdunidad());
       cst.setString(2,dts.getUnidad());
       cst.setString(3, dts.getDescripcion());
       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Presentacion dts) throws SQLException {
       mysql = "{call spUnidadEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdunidad());
       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Presentacion> buscarNombre(Presentacion dts) throws Exception {
        presentacions =new ArrayList();
      
        mysql ="{call spUnidadBuscarNombre('"+dts.getUnidad()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            presentacion = new Presentacion();
            presentacion.setIdunidad(rs.getInt("id"));
            presentacion.setUnidad(rs.getString("nombre"));
            presentacion.setDescripcion(rs.getString("descripcion"));
            presentacion.setEstado(rs.getInt("estado"));            
            presentacions.add(presentacion);
        }
        rs.close(); 
        return presentacions;
    }
    
}
