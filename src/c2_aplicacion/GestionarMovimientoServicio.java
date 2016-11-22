/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Cabecera;
import c3_dominio.Movimiento;
import c3_dominio.Producto;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IMovimientoDAO;
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
public class GestionarMovimientoServicio {

    private GestorJDBC gestorJDBC;
    private IMovimientoDAO movimientoDAO;
    private Movimiento movimiento;
    List<Movimiento> movimientos;

    public GestionarMovimientoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        movimientoDAO = fabricaAbstractaDAO.crearMovimientoDAO(gestorJDBC);
    }

    public boolean insertarIngreso(Movimiento movimiento) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = movimientoDAO.ingreso(movimiento);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public boolean insertarSalida(Movimiento movimiento) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = movimientoDAO.salida(movimiento);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
//    public List<Movimiento> listar()throws Exception{
//        movimientos = new ArrayList();
//        gestorJDBC.abrirConexion();
//        try {
//            gestorJDBC.iniciarTransaccion();
//            movimientos = movimientoDAO.Listar();
//            gestorJDBC.terminarTransaccion();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            gestorJDBC.cancelarTransaccion();
//        }
//        gestorJDBC.cerrarConexion();
//        return movimientos;
//    }
//    public boolean editar(Movimiento movimiento)throws Exception{
//        boolean flag = false;
//        gestorJDBC.abrirConexion();
//        try {
//            gestorJDBC.iniciarTransaccion();
//            flag = movimientoDAO.editar(movimiento);
//            gestorJDBC.terminarTransaccion();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            gestorJDBC.cancelarTransaccion();
//        }
//        gestorJDBC.cerrarConexion();
//        return flag;  
//    }
//    public boolean eliminar(Movimiento movimiento)throws Exception{
//        boolean flag = false;
//        gestorJDBC.abrirConexion();
//        try {
//            gestorJDBC.iniciarTransaccion();
//            flag = movimientoDAO.eliminar(movimiento);
//            gestorJDBC.terminarTransaccion();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            gestorJDBC.cancelarTransaccion();
//        }
//        gestorJDBC.cerrarConexion();
//        return flag;
//    }
//    
//    public List<Movimiento> buscarNombre(Movimiento movimiento) throws Exception{
//        movimientos = new ArrayList();
//        gestorJDBC.abrirConexion();
//        try {
//            gestorJDBC.iniciarTransaccion();
//            movimientos = movimientoDAO.buscarNombre(movimiento);
//            gestorJDBC.terminarTransaccion();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            gestorJDBC.cancelarTransaccion();
//        }
//        gestorJDBC.cerrarConexion();
//        return movimientos;
//    }

    public void llenarLista(JTable listado, List<Movimiento> movimientos) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("idArticulo");
        model.addColumn("Cantidad");
        model.addColumn("Codigo");
        model.addColumn("Articulo");

        model.setNumRows(movimientos.size());
        int i = 0;
        for (Movimiento dts : movimientos) {
            model.setValueAt(dts.getProducto().getId(), i, 0);
            model.setValueAt(dts.getCantidad(), i, 1);
            model.setValueAt(dts.getProducto().getCodigo(), i, 2);
            model.setValueAt(dts.getProducto().getArticulo(), i, 3);
            i++;
        }
        listado.setModel(model);
        ocultar(listado);
    }

    private void ocultar(JTable listado) throws Exception {
        listado.getColumnModel().getColumn(0).setMaxWidth(0);
        listado.getColumnModel().getColumn(0).setMinWidth(0);
        listado.getColumnModel().getColumn(0).setPreferredWidth(0);
        listado.getColumnModel().getColumn(1).setMaxWidth(60);
        listado.getColumnModel().getColumn(1).setMinWidth(60);
        listado.getColumnModel().getColumn(1).setPreferredWidth(60);
        listado.getColumnModel().getColumn(2).setMaxWidth(60);
        listado.getColumnModel().getColumn(2).setMinWidth(60);
        listado.getColumnModel().getColumn(2).setPreferredWidth(60);
    }

    public boolean addCantidad(Movimiento movimiento) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = movimientoDAO.addCantidaProducto(movimiento);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public boolean removeCantidad(Movimiento movimiento) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = movimientoDAO.removeCantidaProducto(movimiento);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

//    public boolean buscarMovimientoList(List<Movimiento> movimientos, String nombre){
//        boolean flag = false; 
//        for(Movimiento dt:movimientos){           
//           if(dt.getDescripcion().equals(nombre)){ 
//               flag = true;
//               break;
//           }else{ 
//               flag = false;
//           }
//        }        
//        return flag;
//    }
    public DefaultTableModel consultaArea(String value) throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            modelo = movimientoDAO.consultaArea(value);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return modelo;
    }

    public DefaultTableModel consultaProductoMovimiento(String codigo) throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            modelo = movimientoDAO.consultaProductoMovimiento(codigo);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return modelo;
    }

    public boolean insertCabecera(Cabecera cabecera) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = movimientoDAO.insertCabecera(cabecera);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
}
