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
public interface IUnidadDAO {

    public int ingresar(Unidad dts) throws SQLException;
    public List<Unidad> Listar() throws SQLException; 
    //public int editar(Unidad dts) throws SQLException;
    //public int eliminar(Unidad dts) throws SQLException;
}
