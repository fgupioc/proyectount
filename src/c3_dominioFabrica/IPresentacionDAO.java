/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Presentacion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IPresentacionDAO {
    public boolean ingresar(Presentacion presentacion) throws SQLException;
    public List<Presentacion> Listar() throws SQLException; 
    public boolean editar(Presentacion presentacion) throws SQLException;
    public boolean eliminar(Presentacion presentacion) throws SQLException;
    public List<Presentacion> buscarNombre(Presentacion presentacion) throws Exception;
    
}
