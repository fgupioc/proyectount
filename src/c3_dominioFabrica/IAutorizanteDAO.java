/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Autorizante;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IAutorizanteDAO {
    public boolean ingresar(Autorizante autorizante) throws SQLException;
    public List<Autorizante> Listar() throws SQLException; 
    public boolean editar(Autorizante autorizante) throws SQLException;
    public boolean eliminar(Autorizante autorizante) throws SQLException;
    public List<Autorizante> buscarNombre(Autorizante autorizante) throws Exception;    
}
