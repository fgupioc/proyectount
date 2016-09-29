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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Franz
 */
public class UnidadDAO implements IUnidadDAO {

    GestorJDBC gestorJDBC;

    UnidadDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Unidad dts) throws SQLException {

        String consultaSQL = "{Call spUnidadInsertar (?,?,?)}";
        CallableStatement cst = gestorJDBC.procedimientoAlmacenado(consultaSQL);
        cst.setString(1, dts.getUnidad());
        cst.setString(2, dts.getDescripcion());
        cst.setInt(3, dts.getEstado());
        return cst.executeUpdate();

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
    }

}
