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
public List<Producto> searchItems(String location,String value,String tipo)throws Exception{
        productos = new ArrayList();
         gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            if(tipo.equals("Codigo")){ 
                productos = productoDAO.buscarArticuloCodigo(location,value);
            }else{ 
                productos = productoDAO.buscarArticuloNombre(location,value);
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
        model.addColumn("Descripcion");
        model.addColumn("Registro");
        model.addColumn("Cantidad");
        model.addColumn("estado"); 
        model.addColumn("Categoria");
        model.addColumn("Tipo");
        model.addColumn("Marca");
        model.addColumn("Almacen");

        model.setNumRows(productos.size());
        int i = 0;
        for (Producto dts : productos) {
            model.setValueAt(dts.getId(), i, 0);
            model.setValueAt(dts.getCodigo(), i, 1);
            model.setValueAt(dts.getArticulo(), i, 2);
            model.setValueAt(dts.getDescripcion(), i, 3);
            model.setValueAt(dts.getFechaRegistro(), i, 4);
            model.setValueAt(dts.getCantidad(), i, 5);
            model.setValueAt(dts.getEstado(), i, 6); 
            model.setValueAt(dts.getCategoria().getDescripcion(), i, 7);
            model.setValueAt(dts.getTipoProducto().getDescripcion(), i, 8);
            model.setValueAt(dts.getMarca().getDescripcion(), i, 9);
            model.setValueAt(dts.getAlmacen().getDescripcion(), i, 10);
            i++;
        }
        listado.setModel(model);
        ocultar(listado);
    }
    
    public List<Producto> listLocation(List<Producto> listProductos ,String location)throws Exception{
        productos = new ArrayList();
        for(Producto dts:listProductos){
            if(dts.getAlmacen().getDescripcion().equals(location)){
                productos.add(dts);
            }
        }
        return productos;
    }  
    private void ocultar(JTable listado) throws Exception {
        listado.getColumnModel().getColumn(0).setMaxWidth(0);
        listado.getColumnModel().getColumn(0).setMinWidth(0);
        listado.getColumnModel().getColumn(0).setPreferredWidth(0);
        listado.getColumnModel().getColumn(2).setMaxWidth(350);
        listado.getColumnModel().getColumn(2).setMinWidth(350);
        listado.getColumnModel().getColumn(2).setPreferredWidth(350);
        
        listado.getColumnModel().getColumn(3).setMaxWidth(0);
        listado.getColumnModel().getColumn(3).setMinWidth(0);
        listado.getColumnModel().getColumn(3).setPreferredWidth(0);
        
        listado.getColumnModel().getColumn(4).setMaxWidth(0);
        listado.getColumnModel().getColumn(4).setMinWidth(0);
        listado.getColumnModel().getColumn(4).setPreferredWidth(0);
        
        listado.getColumnModel().getColumn(5).setMaxWidth(50);
        listado.getColumnModel().getColumn(5).setMinWidth(50);
        listado.getColumnModel().getColumn(5).setPreferredWidth(50);
        
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

}
