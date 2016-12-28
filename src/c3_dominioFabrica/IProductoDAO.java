/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Producto;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IProductoDAO {
    public boolean ingresar(Producto producto) throws SQLException;
    public List<Producto> Listar() throws SQLException; 
    public boolean editar(Producto producto) throws SQLException;
    public boolean eliminar(Producto producto) throws SQLException;
    public List<Producto> buscarNombre(Producto producto) throws Exception;   
    public List<Producto> buscarArticuloCodigo(String location , String value) throws Exception ;
    public List<Producto> buscarArticuloNombre(String location , String value) throws Exception ;
    public boolean portafolio(Timestamp fecha, int  personal_id,int producto_id,String operacion,String descripcion)throws Exception ;
    public int obtenetIdProducto(String codigo)throws Exception ;
}
