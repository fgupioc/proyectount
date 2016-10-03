/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c3_dominio.Personal; 
import c3_dominio.TipoPersonal;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public interface IPersonalDAO {
     public boolean ingresar(Personal personal) throws SQLException;
    public List<Personal> Listar() throws SQLException; 
    public boolean editar(Personal personal) throws SQLException;
    public boolean eliminar(Personal personal) throws SQLException;
    public List<Personal> buscarNombre(Personal personal) throws Exception; 
    public List<TipoPersonal> listaTipoPersonal() throws Exception;
}
