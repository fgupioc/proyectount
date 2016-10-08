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
        mysql= "{Call spAreaInsertar(?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getCodigo());
        cst.setString(2, dts.getDescripcion()); 
        cst.setInt(3, dts.getEstado());           
        return (cst.executeUpdate()==1)?true:false;  
    }

    @Override
    public List<Area> Listar() throws SQLException { 
        areas = new ArrayList();        
        mysql =  "{call spAreaListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            area = new Area();
            area.setId(rs.getInt("id")); 
            area.setCodigo(rs.getString("codigo"));
            area.setDescripcion(rs.getString("descripcion"));
            area.setEstado(rs.getInt("estado"));            
            areas.add(area);
        }
        rs.close();
        return areas;
    }

    @Override
    public boolean editar(Area dts) throws SQLException {  
       mysql ="{call spAreaEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);       
       cst.setInt(1,dts.getId());
       cst.setString(2, dts.getCodigo());
       cst.setString(3,dts.getDescripcion());        
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Area dts) throws SQLException {
       mysql = "{call spAreaEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql); 
       cst.setInt(1,dts.getId()); 
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Area> buscarNombre(Area dts) throws Exception {
        areas =new ArrayList(); 
        mysql ="{call spAreaBuscarNombre('"+dts.getDescripcion()+"')}"; 
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            area = new Area();
            area.setId(rs.getInt("id")); 
            area.setCodigo(rs.getString("codigo"));             
            area.setDescripcion(rs.getString("descripcion"));
            area.setEstado(rs.getInt("estado"));            
            areas.add(area);
        }
        rs.close(); 
        return areas;
    } 
}
