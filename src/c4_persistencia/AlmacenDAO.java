/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Almacen;  
import c3_dominioFabrica.IAlmacenDAO;
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
public class AlmacenDAO implements IAlmacenDAO{
    GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<Almacen> ubicacions;
    private String mysql;
    private Almacen ubicacion;
    
    AlmacenDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

     @Override
    public boolean ingresar(Almacen dts) throws SQLException { 
        mysql= "{Call spAlmacenInsertar (?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getAlmacen()); 
        cst.setInt(2, dts.getEstado());   
        
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<Almacen> Listar() throws SQLException { 
        ubicacions = new ArrayList();        
        mysql =  "{call spAlmacenListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            ubicacion = new Almacen();
            ubicacion.setIdalmacen(rs.getInt("id")); 
            ubicacion.setAlmacen(rs.getString("descripcion"));
            ubicacion.setEstado(rs.getInt("estado"));            
            ubicacions.add(ubicacion);
        }
        rs.close();
        return ubicacions;
    }

    @Override
    public boolean editar(Almacen dts) throws SQLException {  
       mysql ="{call spAlmacenEditar(?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdalmacen()); 
       cst.setString(2, dts.getAlmacen());
       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Almacen dts) throws SQLException {
       mysql = "{call spAlmacenEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdalmacen());
       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Almacen> buscarNombre(Almacen dts) throws Exception {
        ubicacions =new ArrayList();
      
        mysql ="{call spAlmacenBuscarNombre('"+dts.getAlmacen()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            ubicacion = new Almacen();
            ubicacion.setIdalmacen(rs.getInt("id")); 
            ubicacion.setAlmacen(rs.getString("descripcion"));
            ubicacion.setEstado(rs.getInt("estado"));            
            ubicacions.add(ubicacion);
        }
        rs.close(); 
        return ubicacions;
    }
    
    
}
