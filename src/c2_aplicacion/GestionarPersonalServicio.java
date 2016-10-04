/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Personal;
import c3_dominio.TipoPersonal;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IPersonalDAO;
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
public class GestionarPersonalServicio {

    private final GestorJDBC gestorJDBC;
    private final IPersonalDAO personalDAO;
    private Personal personal;
    private TipoPersonal tipoPersonal;
    List<Personal> personales;
    List<TipoPersonal> tipoPersonales;

    public GestionarPersonalServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        personalDAO = fabricaAbstractaDAO.crearPersonalDAO(gestorJDBC);
    }

    public boolean insertarPersonal(Personal personal) throws Exception {
        boolean registros = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            registros = personalDAO.ingresar(personal);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return registros;
    }

    public List<Personal> listarPersonal() throws Exception {
        personales = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            personales = personalDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return personales;
    }

    public boolean editarPersonal(Personal personal) throws Exception {
        boolean res = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            res = personalDAO.editar(personal);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return res;
    }

    public boolean eliminarPersonal(Personal personal) throws Exception {
        boolean res = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            res = personalDAO.eliminar(personal);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return res;
    }

    public List<Personal> buscarNombre(Personal personal) throws Exception {
        personales = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            personales = personalDAO.buscarNombre(personal);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return personales;
    }

    public List<TipoPersonal> listarCargos() throws Exception {
        tipoPersonales = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            tipoPersonales = personalDAO.listaTipoPersonal();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return tipoPersonales;
    }

    public TipoPersonal obtenerId(List<TipoPersonal> tipoPersonales, String nombre) {
        tipoPersonal = new TipoPersonal();
        int id = 0;
        for (TipoPersonal tipo : tipoPersonales) {
            if (tipo.getTipoPersonal().equals(nombre)) {
                tipoPersonal.setIdtipoPersonal(tipo.getIdtipoPersonal());
                tipoPersonal.setTipoPersonal(tipo.getTipoPersonal());
            }
        }
        return tipoPersonal;
    }
    
    public Personal loginPersonal(String user, String pass)throws Exception{
        personal = new Personal();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            personal= personalDAO.loginPersonal(user, pass);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return personal;
    }
    public void llenarLista(JTable listado, List<Personal> personales) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Nombre");
        model.addColumn("Paterno");
        model.addColumn("Materno");
        model.addColumn("Tipo Documento");
        model.addColumn("Numero");
        model.addColumn("Usuario");
        model.addColumn("Estado");
        model.addColumn("idcargo");
        model.addColumn("Cargo");

        model.setNumRows(personales.size());
        int i = 0;
        for (Personal dts : personales) {
            model.setValueAt(dts.getIdpersonal(), i, 0);
            model.setValueAt(dts.getNombre(), i, 1);
            model.setValueAt(dts.getApellidoPaterno(), i, 2);
            model.setValueAt(dts.getApellidoMaterno(), i, 3);
            model.setValueAt(dts.getTipoDocumento(), i, 4);
            model.setValueAt(dts.getNumDocumento(), i, 5);
            model.setValueAt(dts.getUsuario(), i, 6);
            model.setValueAt(dts.getEstado(), i, 7);
            model.setValueAt(dts.getTipoPersonal().getIdtipoPersonal(), i, 8);
            model.setValueAt(dts.getTipoPersonal().getTipoPersonal(), i, 9);
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
        listado.getColumnModel().getColumn(7).setMaxWidth(0);
        listado.getColumnModel().getColumn(7).setMinWidth(0);
        listado.getColumnModel().getColumn(7).setPreferredWidth(0);
        listado.getColumnModel().getColumn(8).setMaxWidth(0);
        listado.getColumnModel().getColumn(8).setMinWidth(0);
        listado.getColumnModel().getColumn(8).setPreferredWidth(0);
    }

    public boolean buscarUsuarioList(List<Personal> personales, String nombre) {
        boolean flag = false;
        for (Personal dt : personales) {
            if (dt.getUsuario().equals(nombre)) {

                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }

}
