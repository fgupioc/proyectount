/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Marca; 
import c3_dominioFabrica.IMarcaDAO;
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
public class MarcaDAO implements IMarcaDAO{
    GestorJDBC gestorJDBC;
     private CallableStatement cst;
    private ResultSet rs ;
    private List<Marca> marcas;
    private String mysql;
    private Marca marca;
    MarcaDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

      @Override
    public boolean ingresar(Marca dts) throws SQLException { 
        mysql= "{Call spMarcaInsertar (?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getMarca()); 
        cst.setInt(2, dts.getEstado());   
        
        return (cst.executeUpdate()==1)?true:false; 
 
    }

    @Override
    public List<Marca> Listar() throws SQLException { 
        marcas = new ArrayList();        
        mysql =  "{call spMarcaListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            marca = new Marca();
            marca.setIdmarca(rs.getInt("id")); 
            marca.setMarca(rs.getString("descripcion"));
            marca.setEstado(rs.getInt("estado"));            
            marcas.add(marca);
        }
        rs.close();
        return marcas;
    }

    @Override
    public boolean editar(Marca dts) throws SQLException {  
       mysql ="{call spMarcaEditar(?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdmarca());
       cst.setString(2,dts.getMarca()); 
       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Marca dts) throws SQLException {
       mysql = "{call spMarcaEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);
       
       cst.setInt(1,dts.getIdmarca());
       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Marca> buscarNombre(Marca dts) throws Exception {
        marcas =new ArrayList();
      
        mysql ="{call spMarcaBuscarNombre('"+dts.getMarca()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            marca = new Marca();
            marca.setIdmarca(rs.getInt("id"));
            marca.setMarca(rs.getString("descripcion")); 
            marca.setEstado(rs.getInt("estado"));            
            marcas.add(marca);
        }
        rs.close(); 
        return marcas;
    }
    
    
}
