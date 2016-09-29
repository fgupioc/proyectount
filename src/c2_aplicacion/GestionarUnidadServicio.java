/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Unidad;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IUnidadDAO;
import c4_persistenciaConexion.GestorJDBC;
import javax.swing.JOptionPane;

/**
 *
 * @author Franz
 */
public class GestionarUnidadServicio {

    private final GestorJDBC gestorJDBC;
    private final IUnidadDAO unidadDAO;

    public GestionarUnidadServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        unidadDAO = fabricaAbstractaDAO.crearUnidadDAO(gestorJDBC);
    }

    public int crearUnidad(Unidad unidad) throws Exception {
        int registros=0;
        gestorJDBC.abrirConexion(); 
        try {
            gestorJDBC.iniciarTransaccion();
            registros = unidadDAO.ingresar(unidad);
            gestorJDBC.terminarTransaccion();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            gestorJDBC.cancelarTransaccion();            
        }
        return registros;
    }

}
