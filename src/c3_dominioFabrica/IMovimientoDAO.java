/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

 
import c3_dominio.DetalleMovimiento;
import c3_dominio.Movimiento;
import c3_dominio.Producto;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franz
 */
public interface IMovimientoDAO {
    public boolean ingreso(Movimiento movimiento) throws SQLException;
    public boolean salida(Movimiento movimiento) throws SQLException;    
    public boolean addCantidaProducto(int id,String codigo,int cantidad) throws SQLException;
    public boolean removeCantidaProducto(int id,String codigo,int cantidad) throws SQLException;   
    public DefaultTableModel consultaArea(String value) throws Exception ;
    public DefaultTableModel consultaProductoMovimiento(String codigo) throws Exception ;
 
    public String consultaCodigo()throws Exception;
    public int obtenerIdIngreso(String codigo,int Personal_id)throws Exception;
    public int obtenerIdSalida(String codigo,int Personal_id)throws Exception;
    public boolean detalleIngreso(DetalleMovimiento detalle, int id)throws Exception;
    public boolean detalleSalida(DetalleMovimiento detalle, int id)throws Exception;
    public boolean portafolio(Timestamp fecha, int personal_id, int movimiento_id,String operacion,String detalle)throws Exception;
}
