/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.TipoProducto;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.ITipoProductoDAO;
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
public class GestionarTipoProductoServicio {

    private GestorJDBC gestorJDBC;
    private ITipoProductoDAO tipoProductoDAO;
    private TipoProducto tipoProducto;
    List<TipoProducto> tipoProductos;

    public GestionarTipoProductoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        tipoProductoDAO = fabricaAbstractaDAO.crearTipoProductoDAO(gestorJDBC);
    }

    public boolean insertar(TipoProducto tipoProducto) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = tipoProductoDAO.ingresar(tipoProducto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public List<TipoProducto> listar() throws Exception {
        tipoProductos = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            tipoProductos = tipoProductoDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e);
        }
        gestorJDBC.cerrarConexion();
        return tipoProductos;
    }

    public boolean editar(TipoProducto tipoProducto) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = tipoProductoDAO.editar(tipoProducto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public boolean eliminar(TipoProducto tipoProducto) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = tipoProductoDAO.eliminar(tipoProducto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public List<TipoProducto> buscarNombre(TipoProducto tipoProducto) throws Exception {
        tipoProductos = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            tipoProductos = tipoProductoDAO.buscarNombre(tipoProducto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return tipoProductos;
    }

    public TipoProducto obtenerId(List<TipoProducto> tipoProductos, String nombre) {
        tipoProducto = new TipoProducto();
        int id = 0;
        for (TipoProducto tipo : tipoProductos) {
            if (tipo.getDescripcion().equals(nombre)) {
                tipoProducto.setId(tipo.getId());
                tipoProducto.setDescripcion(tipo.getDescripcion());
            }
        }
        return tipoProducto;
    }

    public void llenarLista(JTable listado, List<TipoProducto> tipoProductos) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("estado");

        model.setNumRows(tipoProductos.size());
        int i = 0;
        for (TipoProducto dts : tipoProductos) {
            model.setValueAt(dts.getId(), i, 0);
            model.setValueAt(dts.getCodigo(), i, 1);
            model.setValueAt(dts.getDescripcion(), i, 2);
            model.setValueAt(dts.getEstado(), i, 3);
            i++;
        }
        listado.setModel(model);
        ocultar(listado);
    }

    private void ocultar(JTable listado) throws Exception {
        listado.getColumnModel().getColumn(0).setMaxWidth(0);
        listado.getColumnModel().getColumn(0).setMinWidth(0);
        listado.getColumnModel().getColumn(0).setPreferredWidth(0);
        listado.getColumnModel().getColumn(1).setMaxWidth(80);
        listado.getColumnModel().getColumn(1).setMinWidth(80);
        listado.getColumnModel().getColumn(1).setPreferredWidth(80);
        listado.getColumnModel().getColumn(3).setMaxWidth(0);
        listado.getColumnModel().getColumn(3).setMinWidth(0);
        listado.getColumnModel().getColumn(3).setPreferredWidth(0);
    }

    public boolean buscarTipoProductoList(List<TipoProducto> tipoProductos, String nombre) {
        boolean flag = false;
        for (TipoProducto dt : tipoProductos) {
            if (dt.getDescripcion().equals(nombre)) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }
}
