/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Solicitante; 
import c3_dominioFabrica.ISolicitanteDAO;
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
public class SolicitanteDAO implements ISolicitanteDAO{
    GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<Solicitante> solicitantes;
    private String mysql;
    private Solicitante solicitante;
    
    SolicitanteDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public boolean ingresar(Solicitante dts) throws SQLException { 
        mysql= "{Call spUnidadInsertar (?,?,?)}";
//        cst = gestorJDBC.procedimientoAlmacenado(mysql);
//        cst.setString(1, dts.getUnidad());
//        cst.setString(2, dts.getDescripcion());
//        cst.setInt(3, dts.getEstado());   
        
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<Solicitante> Listar() throws SQLException { 
        solicitantes = new ArrayList();        
        mysql =  "{call spUnidadListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
//            solicitante = new Solicitante();
//            solicitante.setIdunidad(rs.getInt("id"));
//            solicitante.setUnidad(rs.getString("nombre"));
//            solicitante.setDescripcion(rs.getString("descripcion"));
//            solicitante.setEstado(rs.getInt("estado"));            
            solicitantes.add(solicitante);
        }
        rs.close();
        return solicitantes;
    }

    @Override
    public boolean editar(Solicitante dts) throws SQLException {  
       mysql ="{call spUnidadEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
//       cst.setInt(1,dts.getIdunidad());
//       cst.setString(2,dts.getUnidad());
//       cst.setString(3, dts.getDescripcion());
       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Solicitante dts) throws SQLException {
       mysql = "{call spUnidadEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
//       
//       cst.setInt(1,dts.getIdunidad());
       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Solicitante> buscarNombre(Solicitante dts) throws Exception {
        solicitantes =new ArrayList();
      
//        mysql ="{call spUnidadBuscarNombre('"+dts.getUnidad()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            solicitante = new Solicitante();
//            solicitante.setIdunidad(rs.getInt("id"));
//            solicitante.setUnidad(rs.getString("nombre"));
//            solicitante.setDescripcion(rs.getString("descripcion"));
//            solicitante.setEstado(rs.getInt("estado"));            
            solicitantes.add(solicitante);
        }
        rs.close(); 
        return solicitantes;
    }
    
    
}
