/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Unidad;
import c3_dominioFabrica.IUnidadDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Franz
 */
public class UnidadDAO implements IUnidadDAO {

    private GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs ;
    private List<Unidad> unidades;
    private String mysql;
    private Unidad unidad;

    UnidadDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public boolean ingresar(Unidad dts) throws SQLException { 
        mysql= "{Call spUnidadInsertar (?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getCodigo()); 
        cst.setString(2, dts.getDescripcion()); 
        cst.setInt(3, dts.getEstado());           
        return (cst.executeUpdate()==1)?true:false; 

      //procedimientro prar traer todo una tabla
        /*ResultSet rs;
         String consultaSQL;
         consultaSQL = "{call spUnidadListado}";
         rs = gestorJDBC.ejecutarProcedimiento(consultaSQL);
         while (rs.next()) {             
         JOptionPane.showMessageDialog(null, rs.getString("estado"));
         }
         rs.close();        */
        //procedimiento para consultar por un campo
       /* ResultSet rs;
         String consultaSQL;
         int codigo =1;
         consultaSQL = "{call spUnidadNombre ("+codigo+")}";
         rs = gestorJDBC.ejecutarProcedimiento(consultaSQL);
         while (rs.next()) {             
         JOptionPane.showMessageDialog(null, rs.getString("descripcion"));
         }
         rs.close();
        
         */
         
         /*   CallableStatement cst = gestorJDBC.cn().prepareCall("{call spUnidadId(?,?,?,?)}"); 
            
                cst.setInt(1,1);  
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);
                cst.registerOutParameter(4, java.sql.Types.VARCHAR);  
                cst.execute();   
                System.out.println("Nombre: " + cst.getString(2)); 
        
        return 1;*/
    }

    @Override
    public List<Unidad> Listar() throws SQLException { 
        unidades = new ArrayList();        
        mysql =  "{call spUnidadListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            unidad = new Unidad();
            unidad.setId(rs.getInt("id"));
            unidad.setCodigo(rs.getString("codigo")); 
            unidad.setDescripcion(rs.getString("descripcion")); 
            unidad.setEstado(rs.getInt("estado"));            
            unidades.add(unidad);
        }
        rs.close();
        return unidades;
    }

    @Override
    public boolean editar(Unidad dts) throws SQLException {  
       mysql ="{call spUnidadEditar(?,?,?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);       
       cst.setInt(1,dts.getId());
       cst.setString(2,dts.getCodigo()); 
       cst.setString(3,dts.getDescripcion());        
       return (cst.executeUpdate()==1)?true:false;        
    } 

    @Override
    public boolean eliminar(Unidad dts) throws SQLException {
       mysql = "{call spUnidadEliminar(?)}";
       cst = gestorJDBC.procedimientoAlmacenado(mysql);       
       cst.setInt(1,dts.getId());       
       return (cst.executeUpdate()==1)?true:false;
    }

    @Override
    public List<Unidad> buscarNombre(Unidad dts) throws Exception {
        unidades =new ArrayList();
      
        mysql ="{call spUnidadBuscarNombre('"+dts.getDescripcion()+"')}";
        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            unidad = new Unidad();
            unidad.setId(rs.getInt("id"));
            unidad.setCodigo(rs.getString("Codigo")); 
            unidad.setDescripcion(rs.getString("descripcion")); 
            unidad.setEstado(rs.getInt("estado"));            
            unidades.add(unidad);
        }
        rs.close(); 
        return unidades;
    }

}
