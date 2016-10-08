/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Categoria;
import c3_dominioFabrica.ICategoriaDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Franz
 */
public class CategoriaDAO implements ICategoriaDAO{
    GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<Categoria> categorias;
    private String mysql;
    private Categoria categoria;
    
    CategoriaDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

       @Override
    public boolean ingresar(Categoria dts) throws SQLException { 
        mysql= "{Call spCategoriaInsertar (?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getCodigo()); 
        cst.setString(2, dts.getDescripcion()); 
        cst.setInt(3, dts.getEstado());           
        return (cst.executeUpdate()==1)?true:false;  
    }

    @Override
    public List<Categoria> Listar() throws SQLException { 
        categorias = new ArrayList();        
        mysql =  "{call spCategoriaListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setCodigo(rs.getString("codigo"));
            categoria.setDescripcion(rs.getString("descripcion")); 
            categoria.setEstado(rs.getInt("estado"));            
            categorias.add(categoria);
        }
        rs.close();
        return categorias;
    }

    @Override
    public boolean editar(Categoria dts) throws SQLException {  
       mysql ="{call spCategoriaEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql); 
       cst.setInt(1,dts.getId()); 
       cst.setString(2,dts.getCodigo()); 
       cst.setString(3, dts.getDescripcion());       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Categoria dts) throws SQLException {
       mysql = "{call spCategoriaEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);       
       cst.setInt(1,dts.getId());       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Categoria> buscarNombre(Categoria dts) throws Exception {
        categorias =new ArrayList();
      
        mysql ="{call spCategoriaBuscarNombre('"+dts.getDescripcion()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setDescripcion(rs.getString("descripcion")); 
            categoria.setEstado(rs.getInt("estado"));            
            categorias.add(categoria);
        }
        rs.close(); 
        return categorias;
    }
    
}
