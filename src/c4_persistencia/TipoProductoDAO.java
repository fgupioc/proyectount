/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.TipoProducto;
import c3_dominioFabrica.ITipoProductoDAO;
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
public class TipoProductoDAO implements ITipoProductoDAO{    
    GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<TipoProducto> tipoProductos;
    private String mysql;
    private TipoProducto tipoProducto;
    
    public TipoProductoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

      @Override
    public boolean ingresar(TipoProducto dts) throws SQLException { 
        mysql= "{Call spTipo_ProductoInsertar (?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql); 
        cst.setString(1, dts.getDescripcion());
        cst.setInt(2, dts.getEstado());           
        return (cst.executeUpdate()==1)?true:false;  
    }

    @Override
    public List<TipoProducto> Listar() throws SQLException { 
        tipoProductos = new ArrayList();        
        mysql =  "{call spTipo_ProductoListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            tipoProducto = new TipoProducto();
            tipoProducto.setIdtipoproducto(rs.getInt("id")); 
            tipoProducto.setDescripcion(rs.getString("descripcion"));
            tipoProducto.setEstado(rs.getInt("estado"));            
            tipoProductos.add(tipoProducto);
        }
        rs.close();
        return tipoProductos;
    }

    @Override
    public boolean editar(TipoProducto dts) throws SQLException {  
       mysql ="{call spTipo_ProductoEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);       
       cst.setInt(1,dts.getIdtipoproducto()); 
       cst.setString(2, dts.getDescripcion());
       cst.setInt(3,dts.getEstado());       
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(TipoProducto dts) throws SQLException {
       mysql = "{call spTipo_ProductoEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);       
       cst.setInt(1,dts.getIdtipoproducto());       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<TipoProducto> buscarNombre(TipoProducto dts) throws Exception {
        tipoProductos =new ArrayList();
      
        mysql ="{call spTipo_ProductoBuscarNombre('"+dts.getDescripcion()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            tipoProducto = new TipoProducto();
            tipoProducto.setIdtipoproducto(rs.getInt("id")); 
            tipoProducto.setDescripcion(rs.getString("descripcion"));
            tipoProducto.setEstado(rs.getInt("estado"));            
            tipoProductos.add(tipoProducto);
        }
        rs.close(); 
        return tipoProductos;
    }
    
    
    
    
}
