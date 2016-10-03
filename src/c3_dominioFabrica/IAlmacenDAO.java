/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Almacen;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IAlmacenDAO {
    public boolean ingresar(Almacen almacen) throws SQLException;
    public List<Almacen> Listar() throws SQLException; 
    public boolean editar(Almacen almacen) throws SQLException;
    public boolean eliminar(Almacen almacen) throws SQLException;
    public List<Almacen> buscarNombre(Almacen almacen) throws Exception;    
}
