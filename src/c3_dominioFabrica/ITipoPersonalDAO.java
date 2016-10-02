/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.TipoPersonal;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface ITipoPersonalDAO {
    public boolean ingresar(TipoPersonal tipoPersonal) throws SQLException;
    public List<TipoPersonal> Listar() throws SQLException; 
    public boolean editar(TipoPersonal tipoPersonal) throws SQLException;
    public boolean eliminar(TipoPersonal tipoPersonal) throws SQLException;
    public List<TipoPersonal> buscarNombre(TipoPersonal tipoPersonal) throws Exception;    
}
