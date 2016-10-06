/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Solicitante;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.ISolicitanteDAO;
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
public class GestionarSolicitanteServicio {

    private GestorJDBC gestorJDBC;
    private ISolicitanteDAO solicitanteDAO;
    private Solicitante solicitante;
    List<Solicitante> solicitantes;

    public GestionarSolicitanteServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        solicitanteDAO = fabricaAbstractaDAO.crearSolicitanteDAO(gestorJDBC);
    }

    public boolean insertar(Solicitante solicitante) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = solicitanteDAO.ingresar(solicitante);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public List<Solicitante> listar() throws Exception {
        solicitantes = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            solicitantes = solicitanteDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e);
        }
        gestorJDBC.cerrarConexion();
        return solicitantes;
    }

    public boolean editar(Solicitante solicitante) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = solicitanteDAO.editar(solicitante);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public boolean eliminar(Solicitante solicitante) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = solicitanteDAO.eliminar(solicitante);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public List<Solicitante> buscarNombre(Solicitante solicitante) throws Exception {
        solicitantes = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            solicitantes = solicitanteDAO.buscarNombre(solicitante);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return solicitantes;
    }

    public void llenarLista(JTable listado, List<Solicitante> solicitantes) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Nombre");
        model.addColumn("paterno");
        model.addColumn("materno");
        model.addColumn("estado");

        model.setNumRows(solicitantes.size());
        int i = 0;
        for (Solicitante dts : solicitantes) {
            model.setValueAt(dts.getIdsolicitante(), i, 0);
            model.setValueAt(dts.getNombre(), i, 1);
            model.setValueAt(dts.getPaterno(), i, 2);
            model.setValueAt(dts.getMaterno(), i, 3);
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
