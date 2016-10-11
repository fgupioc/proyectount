/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Movimiento;
import c3_dominioFabrica.IMovimientoDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public class MovimientoDAO implements IMovimientoDAO{
    public GestorJDBC gestorJDBC;
     private CallableStatement cst;
    private ResultSet rs ;
    private List<Movimiento> movimientos;
    private String mysql;
    private Movimiento movimiento;
    
    public MovimientoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC=gestorJDBC;
    } 
    
    @Override
    public boolean ingresar(Movimiento dts) throws SQLException {
        mysql ="{call spIngresoArticulo(?,?,?,?,?,?,?,?,?,?,?)}";
        cst= gestorJDBC.procedimientoAlmacenado(mysql);
         cst.setString(1, dts.getOperacion());
         cst.setTimestamp(2, dts.getFechaRegistro());
         cst.setString(3, dts.getNumIngreso());
         cst.setString(4, dts.getReferencia());
         cst.setInt(5,dts.getCantidad());
         cst.setString(6, dts.getUnidad());
         cst.setString(7, dts.getMedida());
         cst.setString(8, dts.getColor());
         cst.setString(9, dts.getObservacion());
         cst.setInt(10, dts.getPersonal().getIdpersonal());
         cst.setInt(11, dts.getProducto().getId());
        return (cst.executeUpdate()==1)?true:false;  
//        System.out.println("__________________________________________");;
//        System.out.println("operacion : "+dts.getOperacion());;
//        System.out.println("fehca : "+dts.getFechaRegistro());;
//        System.out.println("num ingreso : "+dts.getNumIngreso());;
//        System.out.println("referencia : "+dts.getReferencia());;
//        System.out.println("cantidad : "+dts.getCantidad());;
//        System.out.println("unidad : "+dts.getUnidad());;
//        System.out.println("medida : "+dts.getMedida());;
//        System.out.println("color : "+dts.getColor());;
//        System.out.println("observacion : "+dts.getObservacion());;
//        System.out.println("personal_id : "+dts.getPersonal().getIdpersonal());;
//        System.out.println("producto_id : "+dts.getProducto().getId());;    
    }

    @Override
    public List<Movimiento> Listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Movimiento movimiento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Movimiento movimiento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimiento> buscarNombre(Movimiento movimiento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
