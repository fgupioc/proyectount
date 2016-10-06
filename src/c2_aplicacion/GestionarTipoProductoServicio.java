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
    private  GestorJDBC gestorJDBC;
    private ITipoProductoDAO tipoProductoDAO;
    private TipoProducto tipoProducto;
    List<TipoProducto> tipoProductos;

    public GestionarTipoProductoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        tipoProductoDAO = fabricaAbstractaDAO.crearTipoProductoDAO(gestorJDBC);
    }
    
    public boolean insertar(TipoProducto tipoProducto) throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = tipoProductoDAO.ingresar(tipoProducto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    public List<TipoProducto> listarTipoProducto()throws Exception{
        tipoProductos = new ArrayList();
         gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            tipoProductos = tipoProductoDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return tipoProductos;
    }
    public boolean editar(TipoProducto tipoProducto)throws Exception{
        boolean flag = false;
         gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = tipoProductoDAO.editar(tipoProducto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;  
    }
    public boolean eliminar(TipoProducto tipoProducto)throws Exception{
        boolean flag = false;
         gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = tipoProductoDAO.eliminar(tipoProducto);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
     public List<TipoProducto> buscarNombre(TipoProducto tipoProducto) throws Exception{
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
    
    public void llenarLista(JTable listado, List<TipoProducto> tipoProductos) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Nombre"); 
        model.addColumn("estado"); 
        
        model.setNumRows(tipoProductos.size());
        int i =0;
        for(TipoProducto dts:tipoProductos){            
            model.setValueAt(dts.getIdtipoproducto(), i, 0);
            model.setValueAt(dts.getDescripcion(), i, 1); 
            model.setValueAt(dts.getEstado(), i, 2);
            i++;
        }       
         listado.setModel(model);
         ocultar(listado);
    }
    
    private void ocultar(JTable listado) throws Exception{
        listado.getColumnModel().getColumn(0).setMaxWidth(0);
        listado.getColumnModel().getColumn(0).setMinWidth(0);
        listado.getColumnModel().getColumn(0).setPreferredWidth(0);
        listado.getColumnModel().getColumn(2).setMaxWidth(0);
        listado.getColumnModel().getColumn(2).setMinWidth(0);
        listado.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    public boolean buscarTipoProductoList(List<TipoProducto> tipoProductos, String nombre){
        boolean flag = false; 
        for(TipoProducto dt:tipoProductos){           
           if(dt.getDescripcion().equals(nombre)){ 
               flag = true;
               break;
           }else{ 
               flag = false;
           }
        }        
        return flag;
    }
}
