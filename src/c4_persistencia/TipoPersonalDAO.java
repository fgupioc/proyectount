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
    private List<TipoPersonal> tipoPersonales;
    private String mysql;
    private TipoPersonal tipoPersonal;
    
    TipoPersonalDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public boolean ingresar(TipoPersonal dts) throws SQLException { 
        mysql= "{Call spTipo_PersonalInsertar(?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getTipoPersonal()); 
        cst.setInt(2, dts.getEstado());   
        
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<TipoPersonal> Listar() throws SQLException { 
        tipoPersonales = new ArrayList();        
        mysql =  "{call spTipo_PersonalListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            tipoPersonal = new TipoPersonal();
            tipoPersonal.setIdtipoPersonal(rs.getInt("id")); 
            tipoPersonal.setTipoPersonal(rs.getString("descripcion"));
            tipoPersonal.setEstado(rs.getInt("estado"));            
            tipoPersonales.add(tipoPersonal);
        }
        rs.close();
        return tipoPersonales;
    }

    @Override
    public boolean editar(TipoPersonal dts) throws SQLException {  
       mysql ="{call spTipo_PersonalEditar(?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdtipoPersonal());
       cst.setString(2,dts.getTipoPersonal()); 
       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(TipoPersonal dts) throws SQLException {
       mysql = "{call spTipo_PersonalEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdtipoPersonal());
       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<TipoPersonal> buscarNombre(TipoPersonal dts) throws Exception {
        tipoPersonales =new ArrayList();
      
        mysql ="{call spUnidadBuscarNombre('"+dts.getTipoPersonal()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            tipoPersonal = new TipoPersonal();
            tipoPersonal.setIdtipoPersonal(rs.getInt("id")); 
            tipoPersonal.setTipoPersonal(rs.getString("descripcion"));
            tipoPersonal.setEstado(rs.getInt("estado"));            
            tipoPersonales.add(tipoPersonal);
        }
        rs.close(); 
        return tipoPersonales;
    }
    
    
}
