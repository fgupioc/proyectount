/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Ubicacion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IUbicacionDAO {
    public boolean ingresar(Ubicacion ubicacion) throws SQLException;
    public List<Ubicacion> Listar() throws SQLException; 
    public boolean editar(Ubicacion ubicacion) throws SQLException;
    public boolean eliminar(Ubicacion ubicacion) throws SQLException;
    public List<Ubicacion> buscarNombre(Ubicacion ubicacion) throws Exception;    
}
