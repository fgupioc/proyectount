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
        mysql= "{Call spSolicitanteInsertar (?,?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getNombre());
        cst.setString(2, dts.getPaterno());
        cst.setString(3, dts.getMaterno()); 
        cst.setInt(4, dts.getEstado());
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<Solicitante> Listar() throws SQLException { 
        solicitantes = new ArrayList();        
        mysql =  "{call spSolicitanteListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            solicitante = new Solicitante();
            solicitante.setIdsolicitante(rs.getInt("id"));
            solicitante.setNombre(rs.getString("nombre"));
            solicitante.setPaterno(rs.getString("apellidoPaterno"));
            solicitante.setMaterno(rs.getString("apellidoMaterno"));
            solicitante.setEstado(rs.getInt("estado"));            
            solicitantes.add(solicitante);
        }
        rs.close();
        return solicitantes;
    }

    @Override
    public boolean editar(Solicitante dts) throws SQLException {  
       mysql ="{call spSolicitanteEditar(?,?,?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdsolicitante());
       cst.setString(2,dts.getNombre());
       cst.setString(3, dts.getPaterno());
       cst.setString(4, dts.getMaterno());
       cst.setInt(5, dts.getEstado());

       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Solicitante dts) throws SQLException {
       mysql = "{call spSolicitanteEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);       
       cst.setInt(1,dts.getIdsolicitante());       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Solicitante> buscarNombre(Solicitante dts) throws Exception {
        solicitantes =new ArrayList();
      
        mysql ="{call spSolicitanteBuscarNombre('"+dts.getNombre()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            solicitante = new Solicitante();
            solicitante.setIdsolicitante(rs.getInt("id"));
            solicitante.setNombre(rs.getString("nombre"));
            solicitante.setPaterno(rs.getString("apellidoPaterno"));
            solicitante.setMaterno(rs.getString("apellidoMaterno"));
            solicitante.setEstado(rs.getInt("estado"));            
            solicitantes.add(solicitante);
        }
        rs.close(); 
        return solicitantes;
    }
    
    
}
