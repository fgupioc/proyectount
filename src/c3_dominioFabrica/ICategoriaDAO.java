/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Categoria;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface ICategoriaDAO {
    public boolean ingresar(Categoria categoria) throws SQLException;
    public List<Categoria> Listar() throws SQLException; 
    public boolean editar(Categoria categoria) throws SQLException;
    public boolean eliminar(Categoria categoria) throws SQLException;
    public List<Categoria> buscarNombre(Categoria categoria) throws Exception;    
}
