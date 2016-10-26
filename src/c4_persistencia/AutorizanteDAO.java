/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Autorizante; 
import c3_dominioFabrica.IAutorizanteDAO;
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
public class AutorizanteDAO implements IAutorizanteDAO{
    GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<Autorizante> autorizantes;
    private String mysql;
    private Autorizante autorizante;
    
    AutorizanteDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public boolean ingresar(Autorizante dts) throws SQLException { 
        mysql= "{Call spAutorizanteInsertar (?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getDescripcion());
        cst.setString(2, dts.getEspecialidad()); 
        cst.setString(3, dts.getCargo());
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<Autorizante> Listar() throws SQLException { 
        autorizantes = new ArrayList();        
        mysql =  "{call spAutorizanteListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            autorizante = new Autorizante();
            autorizante.setId(rs.getInt("id"));
            autorizante.setDescripcion(rs.getString("nombre"));
            autorizante.setEspecialidad(rs.getString("especialidad"));
            autorizante.setCargo(rs.getString("cargo"));
            autorizante.setEstado(rs.getInt("estado"));            
            autorizantes.add(autorizante);
        }
        rs.close();
        return autorizantes;
    }

    @Override
    public boolean editar(Autorizante dts) throws SQLException {  
       mysql ="{call spAutorizanteEditar(?,?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getId());
       cst.setString(2,dts.getDescripcion());
       cst.setString(3, dts.getEspecialidad());
       cst.setString(4, dts.getCargo()); 

       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Autorizante dts) throws SQLException {
       mysql = "{call spAutorizanteEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);  
       System.out.println(dts.getId());
       cst.setInt(1,dts.getId());       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Autorizante> buscarNombre(Autorizante dts) throws Exception {
        autorizantes =new ArrayList();
      
        mysql ="{call spAutorizanteBuscarNombre('"+dts.getDescripcion()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            autorizante = new Autorizante();
            autorizante.setId(rs.getInt("id"));
            autorizante.setDescripcion(rs.getString("nombre"));
            autorizante.setEspecialidad(rs.getString("especialidad"));
            autorizante.setCargo(rs.getString("cargo"));
            autorizante.setEstado(rs.getInt("estado"));            
            autorizantes.add(autorizante);
        }
        rs.close(); 
        return autorizantes;
    }
    
    
}
