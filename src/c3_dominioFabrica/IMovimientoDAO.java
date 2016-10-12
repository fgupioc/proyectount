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

/**
 *
 * @author Franz
 */
public interface IMovimientoDAO {
    public boolean ingreso(Movimiento movimiento) throws SQLException;
    public boolean salida(Movimiento movimiento) throws SQLException;    
    public boolean addCantidaProducto(Movimiento movimiento) throws SQLException;
    public boolean removeCantidaProducto(Movimiento movimiento) throws SQLException;
    public List<Movimiento> Listar() throws SQLException; 
    public boolean editar(Movimiento movimiento) throws SQLException;
    public boolean eliminar(Movimiento movimiento) throws SQLException;
    public List<Movimiento> buscarNombre(Movimiento movimiento) throws Exception;  
}
