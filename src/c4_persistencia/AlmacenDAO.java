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
        mysql= "{Call spAlmacenInsertar (?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getCodigo());
        cst.setString(2, dts.getDescripcion()); 
        cst.setInt(3, dts.getEstado());           
        return (cst.executeUpdate()==1)?true:false;  
    }

    @Override
    public List<Almacen> Listar() throws SQLException { 
        ubicacions = new ArrayList();        
        mysql =  "{call spAlmacenListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            ubicacion = new Almacen();
            ubicacion.setId(rs.getInt("id")); 
            ubicacion.setCodigo(rs.getString("codigo"));
            ubicacion.setDescripcion(rs.getString("descripcion"));
            ubicacion.setEstado(rs.getInt("estado"));            
            ubicacions.add(ubicacion);
        }
        rs.close();
        return ubicacions;
    }

    @Override
    public boolean editar(Almacen dts) throws SQLException {  
       mysql ="{call spAlmacenEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);       
       cst.setInt(1,dts.getId()); 
       cst.setString(2, dts.getCodigo());
       cst.setString(3, dts.getDescripcion());        
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Almacen dts) throws SQLException {
       mysql = "{call spAlmacenEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);       
       cst.setInt(1,dts.getId());       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Almacen> buscarNombre(Almacen dts) throws Exception {
        ubicacions =new ArrayList();      
        mysql ="{call spAlmacenBuscarNombre('"+dts.getDescripcion()+"')}";        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            ubicacion = new Almacen();
            ubicacion.setId(rs.getInt("id")); 
            ubicacion.setCodigo(rs.getString("codigo"));
            ubicacion.setDescripcion(rs.getString("descripcion"));
            ubicacion.setEstado(rs.getInt("estado"));            
            ubicacions.add(ubicacion);
        }
        rs.close(); 
        return ubicacions;
    } 
}
