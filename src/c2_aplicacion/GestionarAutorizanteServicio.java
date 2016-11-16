/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Autorizante;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IAutorizanteDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franz
 */
public class GestionarAutorizanteServicio {

    private GestorJDBC gestorJDBC;
    private IAutorizanteDAO autorizanteDAO;
    private Autorizante autorizante;
    List<Autorizante> autorizantes;

    public GestionarAutorizanteServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        autorizanteDAO = fabricaAbstractaDAO.crearAutorizanteDAO(gestorJDBC);
    }

    public boolean insertar(Autorizante autorizante) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = autorizanteDAO.ingresar(autorizante);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public List<Autorizante> listar() throws Exception {
        autorizantes = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            autorizantes = autorizanteDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e);
        }
        gestorJDBC.cerrarConexion();
        return autorizantes;
    }

    public boolean editar(Autorizante autorizante) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = autorizanteDAO.editar(autorizante);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public boolean eliminar(Autorizante autorizante) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = autorizanteDAO.eliminar(autorizante);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public List<Autorizante> buscarNombre(Autorizante autorizante) throws Exception {
        autorizantes = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            autorizantes = autorizanteDAO.buscarNombre(autorizante);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return autorizantes;
    }
    public Autorizante obtenerId(List<Autorizante> autorizantes, String nombre) {
        autorizante = new Autorizante();
        int id = 0;
        for (Autorizante tipo : autorizantes) { 
            if (tipo.getDescripcion().equals(nombre)) {
                autorizante.setId(tipo.getId());
                autorizante.setDescripcion(tipo.getDescripcion()); 
            }
        }
        return autorizante;
    }
    public void llenarLista(JTable listado, List<Autorizante> autorizantes) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Nombre");
        model.addColumn("Especialidad");
        model.addColumn("Cargo");
        model.addColumn("estado");

        model.setNumRows(autorizantes.size());
        int i = 0;
        for (Autorizante dts : autorizantes) {
            model.setValueAt(dts.getId(), i, 0);
            model.setValueAt(dts.getDescripcion(), i, 1);
            model.setValueAt(dts.getEspecialidad(), i, 2);
            model.setValueAt(dts.getCargo(), i, 3);
            model.setValueAt(dts.getEstado(), i, 4);
            i++;
        }
        listado.setModel(model);
        ocultar(listado);
    }

    private void ocultar(JTable listado) throws Exception {
        listado.getColumnModel().getColumn(0).setMaxWidth(0);
        listado.getColumnModel().getColumn(0).setMinWidth(0);
        listado.getColumnModel().getColumn(0).setPreferredWidth(0);
        listado.getColumnModel().getColumn(4).setMaxWidth(0);
        listado.getColumnModel().getColumn(4).setMinWidth(0);
        listado.getColumnModel().getColumn(4).setPreferredWidth(0);
    }
}
