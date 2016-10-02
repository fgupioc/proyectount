/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.TipoProducto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface ITipoProductoDAO {
    public boolean ingresar(TipoProducto tipoProducto) throws SQLException;
    public List<TipoProducto> Listar() throws SQLException; 
    public boolean editar(TipoProducto tipoProducto) throws SQLException;
    public boolean eliminar(TipoProducto tipoProducto) throws SQLException;
    public List<TipoProducto> buscarNombre(TipoProducto tipoProducto) throws Exception;
}
