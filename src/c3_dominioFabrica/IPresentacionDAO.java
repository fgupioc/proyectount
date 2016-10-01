/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Unidad;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IPresentacionDAO {
    public boolean ingresar(Unidad unidad) throws SQLException;
    public List<Unidad> Listar() throws SQLException; 
    public boolean editar(Unidad unidad) throws SQLException;
    public boolean eliminar(Unidad unidad) throws SQLException;
    public List<Unidad> buscarNombre(Unidad unidad) throws Exception;
    
}
