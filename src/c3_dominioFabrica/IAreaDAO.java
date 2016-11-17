/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Area;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IAreaDAO {
    public boolean ingresar(Area area) throws SQLException;
    public List<Area> Listar() throws SQLException; 
    public boolean editar(Area area) throws SQLException;
    public boolean eliminar(Area area) throws SQLException;
    public List<Area> buscarNombre(Area area) throws Exception;    
}
