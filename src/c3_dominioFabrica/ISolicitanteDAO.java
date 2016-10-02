/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Solicitante;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface ISolicitanteDAO {
    public boolean ingresar(Solicitante solicitante) throws SQLException;
    public List<Solicitante> Listar() throws SQLException; 
    public boolean editar(Solicitante solicitante) throws SQLException;
    public boolean eliminar(Solicitante solicitante) throws SQLException;
    public List<Solicitante> buscarNombre(Solicitante solicitante) throws Exception;    
}
