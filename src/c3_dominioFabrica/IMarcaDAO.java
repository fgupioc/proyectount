/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Marca;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IMarcaDAO {
    public boolean ingresar(Marca marca) throws SQLException;
    public List<Marca> Listar() throws SQLException; 
    public boolean editar(Marca marca) throws SQLException;
    public boolean eliminar(Marca marca) throws SQLException;
    public List<Marca> buscarNombre(Marca marca) throws Exception;    
}
