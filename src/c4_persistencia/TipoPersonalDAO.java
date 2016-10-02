/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.TipoPersonal; 
import c3_dominioFabrica.ITipoPersonalDAO;
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
public class TipoPersonalDAO implements ITipoPersonalDAO{
    GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<TipoPersonal> tipoPersonals;
    private String mysql;
    private TipoPersonal tipoPersonal;
    
    TipoPersonalDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public boolean ingresar(TipoPersonal dts) throws SQLException { 
        mysql= "{Call spUnidadInsertar (?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getUnidad());
        cst.setString(2, dts.getDescripcion());
        cst.setInt(3, dts.getEstado());   
        
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<TipoPersonal> Listar() throws SQLException { 
        tipoPersonals = new ArrayList();        
        mysql =  "{call spUnidadListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            tipoPersonal = new TipoPersonal();
            tipoPersonal.setIdunidad(rs.getInt("id"));
            tipoPersonal.setUnidad(rs.getString("nombre"));
            tipoPersonal.setDescripcion(rs.getString("descripcion"));
            tipoPersonal.setEstado(rs.getInt("estado"));            
            tipoPersonals.add(tipoPersonal);
        }
        rs.close();
        return tipoPersonals;
    }

    @Override
    public boolean editar(TipoPersonal dts) throws SQLException {  
       mysql ="{call spUnidadEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdunidad());
       cst.setString(2,dts.getUnidad());
       cst.setString(3, dts.getDescripcion());
       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(TipoPersonal dts) throws SQLException {
       mysql = "{call spUnidadEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdunidad());
       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<TipoPersonal> buscarNombre(TipoPersonal dts) throws Exception {
        tipoPersonals =new ArrayList();
      
        mysql ="{call spUnidadBuscarNombre('"+dts.getUnidad()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            tipoPersonal = new TipoPersonal();
            tipoPersonal.setIdunidad(rs.getInt("id"));
            tipoPersonal.setUnidad(rs.getString("nombre"));
            tipoPersonal.setDescripcion(rs.getString("descripcion"));
            tipoPersonal.setEstado(rs.getInt("estado"));            
            tipoPersonals.add(tipoPersonal);
        }
        rs.close(); 
        return tipoPersonals;
    }
    
    
}
