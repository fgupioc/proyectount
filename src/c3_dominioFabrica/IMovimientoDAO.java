/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Movimiento;
import c3_dominio.Producto;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franz
 */
public interface IMovimientoDAO {
    public boolean ingreso(Movimiento movimiento) throws SQLException;
    public boolean salida(Movimiento movimiento) throws SQLException;    
    public boolean addCantidaProducto(Movimiento movimiento) throws SQLException;
    public boolean removeCantidaProducto(Movimiento movimiento) throws SQLException;   
    public DefaultTableModel consultaArea(String value) throws Exception ;
    public DefaultTableModel consultaProductoMovimiento(String codigo) throws Exception ;
}
