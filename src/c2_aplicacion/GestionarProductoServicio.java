/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Producto;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IProductoDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franz
 */
public class GestionarProductoServicio {

    private GestorJDBC gestorJDBC;
    private IProductoDAO productoDAO;
    private Producto producto;
    List<Producto> productos;

    public GestionarProductoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        productoDAO = fabricaAbstractaDAO.crearProductoDAO(gestorJDBC);
    }

    public boolean insertar(Producto producto) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = productoDAO.ingresar(producto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public List<Producto> listar() throws Exception {
        productos = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            productos = productoDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return productos;
    }

    public boolean editar(Producto producto) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = productoDAO.editar(producto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public boolean eliminar(Producto producto) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = productoDAO.eliminar(producto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }

    public List<Producto> buscarNombre(Producto producto) throws Exception {
        productos = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            productos = productoDAO.buscarNombre(producto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return productos;
    }

    public List<Producto> searchItems(String location, String value, String tipo) throws Exception {
        productos = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            if (tipo.equals("Codigo")) {
                productos = productoDAO.buscarArticuloCodigo(location, value);
            } else {
                productos = productoDAO.buscarArticuloNombre(location, value);
            }
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        return productos;
    }

    public void llenarLista(JTable listado, List<Producto> productos) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Codigo");
        model.addColumn("Producto");
        model.addColumn("Registro");
        model.addColumn("Cantidad");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Color");
        model.addColumn("estado");
        model.addColumn("Categoria");
        model.addColumn("Tipo"); 
        model.addColumn("Almacen");
        model.addColumn("Unidad");

        model.setNumRows(productos.size());
        int i = 0;
        for (Producto dts : productos) {
            model.setValueAt(dts.getId(), i, 0);
            model.setValueAt(dts.getCodigo(), i, 1);
            model.setValueAt(dts.getArticulo(), i, 2);
            model.setValueAt(dts.getFechaRegistro(), i, 3);
            model.setValueAt(dts.getCantidad(), i, 4);
            model.setValueAt(dts.getMarca(), i, 5);
            model.setValueAt(dts.getModelo(), i, 6);
            model.setValueAt(dts.getColor(), i, 7);
            model.setValueAt(dts.getEstado(), i, 8);
            model.setValueAt(dts.getCategoria().getDescripcion(), i, 9);
            model.setValueAt(dts.getTipoProducto().getDescripcion(), i, 10);
            model.setValueAt(dts.getAlmacen().getDescripcion(), i, 11);
            model.setValueAt(dts.getUnidad().getDescripcion(), i, 12);
            i++;
        }
        listado.setModel(model);
        ocultar(listado);
    }

    public List<Producto> listLocation(List<Producto> listProductos, String location) throws Exception {
        productos = new ArrayList();
        for (Producto dts : listProductos) {
            if (dts.getAlmacen().getDescripcion().equals(location)) {
                productos.add(dts);
            }
        }
        return productos;
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

        listado.getColumnModel().getColumn(4).setMaxWidth(60);
        listado.getColumnModel().getColumn(4).setMinWidth(60);
        listado.getColumnModel().getColumn(4).setPreferredWidth(60);

        listado.getColumnModel().getColumn(5).setMaxWidth(0);
        listado.getColumnModel().getColumn(5).setMinWidth(0);
        listado.getColumnModel().getColumn(5).setPreferredWidth(0);

        listado.getColumnModel().getColumn(6).setMaxWidth(0);
        listado.getColumnModel().getColumn(6).setMinWidth(0);
        listado.getColumnModel().getColumn(6).setPreferredWidth(0);

        listado.getColumnModel().getColumn(7).setMaxWidth(0);
        listado.getColumnModel().getColumn(7).setMinWidth(0);
        listado.getColumnModel().getColumn(7).setPreferredWidth(0);

        listado.getColumnModel().getColumn(8).setMaxWidth(0);
        listado.getColumnModel().getColumn(8).setMinWidth(0);
        listado.getColumnModel().getColumn(8).setPreferredWidth(0);

        listado.getColumnModel().getColumn(9).setMaxWidth(0);
        listado.getColumnModel().getColumn(9).setMinWidth(0);
        listado.getColumnModel().getColumn(9).setPreferredWidth(0);

        listado.getColumnModel().getColumn(10).setMaxWidth(0);
        listado.getColumnModel().getColumn(10).setMinWidth(0);
        listado.getColumnModel().getColumn(10).setPreferredWidth(0);
        
        listado.getColumnModel().getColumn(11).setMaxWidth(0);
        listado.getColumnModel().getColumn(11).setMinWidth(0);
        listado.getColumnModel().getColumn(11).setPreferredWidth(0);
        
        listado.getColumnModel().getColumn(12).setMaxWidth(0);
        listado.getColumnModel().getColumn(12).setMinWidth(0);
        listado.getColumnModel().getColumn(12).setPreferredWidth(0);
    }

    public boolean buscarProductoList(List<Producto> productos, String nombre) {
        boolean flag = false;
        for (Producto dt : productos) {
            if (dt.getArticulo().equals(nombre)) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }
     public Producto buscarProductoCodigoList(List<Producto> productos, String codigo) {
       Producto obj = new Producto();
        for (Producto dt : productos) {
            if (dt.getCodigo().equals(codigo)) {
                obj =dt;
                break;
            } else {
                obj = null;
            }
        }
        return obj;
    }
    public boolean portafolio(Timestamp fecha, int  personal_id,int producto_id,String operacion,String descripcion) throws Exception {
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = productoDAO.portafolio(fecha, personal_id, producto_id, operacion, descripcion);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    public int obtenerIdProducto( String codigo) throws Exception {
        int res = 0;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            res = productoDAO.obtenetIdProducto(codigo);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return res;
    }
    
}
