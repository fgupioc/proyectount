/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;
 
import c3_dominio.DetalleMovimiento;
import c3_dominio.Movimiento;
import c3_dominio.Producto;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IMovimientoDAO;
import c4_persistenciaConexion.GestorJDBC;
import config.MyConfig;
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
    public boolean insertarIngreso(Movimiento movimiento,List<DetalleMovimiento> detalles) throws Exception {
        boolean flag = false;
        String det ="A Ingresado :: ";
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            movimientoDAO.ingreso(movimiento); 
            int id = movimientoDAO.obtenerIdIngreso(movimiento.getNumIngreso(),movimiento.getPersonal().getIdpersonal()); 
            for(DetalleMovimiento dts : detalles){
                det +="=> Articulo :"+dts.getProducto().getArticulo()+" Cantidada: "+dts.getCantidad()+"; ";
                movimientoDAO.detalleIngreso(dts,id);                
                movimientoDAO.addCantidaProducto(dts.getProducto().getId(), dts.getProducto().getCodigo(),dts.getCantidad());                
            } 
            movimientoDAO.portafolio(movimiento.getFechaRegistro(),movimiento.getPersonal().getIdpersonal(),id,"Ingreso del Stock",det);
            flag= true;
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            flag= false;
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public boolean insertarSalida(Movimiento movimiento,List<DetalleMovimiento> detalles ) throws Exception {
        boolean flag = false;
        String det ="A Salido :: ";
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            movimientoDAO.salida(movimiento); 
           
            int id = movimientoDAO.obtenerIdSalida(movimiento.getNumSalida(),movimiento.getPersonal().getIdpersonal()); 
             System.out.println("cod "+id);
            for(DetalleMovimiento dts : detalles){
                det +="=> Articulo :"+dts.getProducto().getArticulo()+" Cantidada: "+dts.getCantidad()+"; ";
                movimientoDAO.detalleSalida(dts,id);                
                movimientoDAO.removeCantidaProducto(dts.getProducto().getId(), dts.getProducto().getCodigo(),dts.getCantidad());                
            } 
            movimientoDAO.portafolio(movimiento.getFechaRegistro(),movimiento.getPersonal().getIdpersonal(),id,"Salida del Stock",det);
            flag= true;
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
 
    public void llenarLista(JTable listado, List<DetalleMovimiento> movimientos) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("idArticulo");
        model.addColumn("Cantidad");
        model.addColumn("Codigo");
        model.addColumn("Articulo");

        model.setNumRows(movimientos.size());
        int i = 0;
        for (DetalleMovimiento dts : movimientos) {
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

    public boolean addCantidad( List<DetalleMovimiento> detalles) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            for(DetalleMovimiento dts : detalles){
                 flag = movimientoDAO.addCantidaProducto(dts.getProducto().getId(), dts.getProducto().getCodigo(),dts.getCantidad());
            }
            
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
             
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
 
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
 

    public void reporteMemo(String id) throws Exception {
        gestorJDBC.abrirConexion(); 
        Map p = new HashMap();
        p.put("numSalida", id);
        JasperReport report;
        JasperPrint print;
        try {
            gestorJDBC.iniciarTransaccion();
            report = JasperCompileManager.compileReport(MyConfig.getAddressReport());
            print = JasperFillManager.fillReport(report, p, gestorJDBC.cn());
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de Portafolio de usuario Nº"+id);
            view.setVisible(true);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
    }
     public void reportePortafolio(String id) throws Exception {
        gestorJDBC.abrirConexion(); 
        Map p = new HashMap();
        p.put("id_personal", id);
        JasperReport report;
        JasperPrint print;
        try {
            gestorJDBC.iniciarTransaccion();
            report = JasperCompileManager.compileReport(MyConfig.getAddressReportPortafolio());
            print = JasperFillManager.fillReport(report, p, gestorJDBC.cn());
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de Memorando Nº"+id);
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
