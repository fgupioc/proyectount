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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

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

    public void reporteMemo(String id) throws Exception {
        gestorJDBC.abrirConexion();
        String dir = "C:/Users/junio_000/Documents/NetBeansProjects/SistemaAlmacenUNT/src/Reportes/RptSalida.jrxml";
        Map p = new HashMap();
        p.put("numSalida", id);
        JasperReport report;
        JasperPrint print;
        try {
            gestorJDBC.iniciarTransaccion();
            report = JasperCompileManager.compileReport(dir);
            print = JasperFillManager.fillReport(report, p, gestorJDBC.cn());
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("reprote");
            view.setVisible(true);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
    }
    public String consultaCodigo() throws Exception {
       String codigo="";
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            codigo = movimientoDAO.consultaCodigo();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return codigo;
    }
}
