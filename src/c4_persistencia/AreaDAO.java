/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Area; 
import c3_dominioFabrica.IAreaDAO;
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
public class AreaDAO implements IAreaDAO{
    GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<Area> areas;
    private String mysql;
    private Area area;
    
    AreaDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

      @Override
    public boolean ingresar(Area dts) throws SQLException { 
        mysql= "{Call spAreaInsertar (?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getArea()); 
        cst.setInt(2, dts.getEstado());   
        
        return (cst.executeUpdate()==1)?true:false;  
    }

    @Override
    public List<Area> Listar() throws SQLException { 
        areas = new ArrayList();        
        mysql =  "{call spAreaListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            area = new Area();
            area.setIdarea(rs.getInt("id")); 
            area.setArea(rs.getString("descripcion"));
            area.setEstado(rs.getInt("estado"));            
            areas.add(area);
        }
        rs.close();
        return areas;
    }

    @Override
    public boolean editar(Area dts) throws SQLException {  
       mysql ="{call spAreaEditar(?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdarea());
       cst.setString(2,dts.getArea()); 
       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Area dts) throws SQLException {
       mysql = "{call spAreaEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdarea());
       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Area> buscarNombre(Area dts) throws Exception {
        areas =new ArrayList(); 
        mysql ="{call spAreaBuscarNombre('"+dts.getArea()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            area = new Area();
            area.setIdarea(rs.getInt("id")); 
            area.setArea(rs.getString("descripcion"));
            area.setEstado(rs.getInt("estado"));            
            areas.add(area);
        }
        rs.close(); 
        return areas;
    }
    
}
