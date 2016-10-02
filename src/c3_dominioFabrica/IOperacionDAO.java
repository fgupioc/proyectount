/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Operacion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IOperacionDAO {
    public boolean ingresar(Operacion operacion) throws SQLException;
    public List<Operacion> Listar() throws SQLException; 
    public boolean editar(Operacion operacion) throws SQLException;
    public boolean eliminar(Operacion operacion) throws SQLException;
    public List<Operacion> buscarNombre(Operacion operacion) throws Exception;    
}
