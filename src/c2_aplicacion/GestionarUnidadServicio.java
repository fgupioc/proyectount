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
import java.util.ArrayList;
import java.util.List;
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

    public int insertarUnidad(Unidad unidad) throws Exception {
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
        gestorJDBC.cerrarConexion();
        return registros;
    }
    
    public List<Unidad> listarUnidad() throws Exception{
        List<Unidad> unidades= new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            unidades = unidadDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        gestorJDBC.cerrarConexion();
        return unidades;
    }

}
