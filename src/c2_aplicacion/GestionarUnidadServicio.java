/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Unidad;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IUnidadDAO;
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
public class GestionarUnidadServicio {

    private final GestorJDBC gestorJDBC;
    private final IUnidadDAO unidadDAO;
    private Unidad unidad;
    List<Unidad> unidades;

    public GestionarUnidadServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        unidadDAO = fabricaAbstractaDAO.crearUnidadDAO(gestorJDBC);
    }

    public boolean insertarUnidad(Unidad unidad) throws Exception {
        boolean registros = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            registros = unidadDAO.ingresar(unidad);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return registros;
    }

    public List<Unidad> listarUnidad() throws Exception {
        unidades = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            unidades = unidadDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return unidades; 
    }
    
    public boolean editarUnidad(Unidad unidad) throws Exception{
        boolean res = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            res = unidadDAO.editar(unidad);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return res;
    }
    
    public boolean eliminarUnidad(Unidad unidad)throws Exception{
        boolean res = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            res = unidadDAO.eliminar(unidad);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return res;
    }
    
    public List<Unidad> buscarNombre(Unidad unidad) throws Exception{
        unidades = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            unidades = unidadDAO.buscarNombre(unidad);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return unidades;
    }
    
    public void llenarLista(JTable listado, List<Unidad> unidades) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Nombre");
        model.addColumn("Descripcion");
        model.addColumn("estado"); 
        
        model.setNumRows(unidades.size());
        int i =0;
        for(Unidad dts:unidades){            
            model.setValueAt(dts.getIdunidad(), i, 0);
            model.setValueAt(dts.getUnidad(), i, 1);
            model.setValueAt(dts.getDescripcion(), i, 2);
            model.setValueAt(dts.getEstado(), i, 3);
            i++;
        }       
         listado.setModel(model);
         ocultar(listado);
    }
    
    private void ocultar(JTable listado) throws Exception{
        listado.getColumnModel().getColumn(0).setMaxWidth(0);
        listado.getColumnModel().getColumn(0).setMinWidth(0);
        listado.getColumnModel().getColumn(0).setPreferredWidth(0);
        listado.getColumnModel().getColumn(3).setMaxWidth(0);
        listado.getColumnModel().getColumn(3).setMinWidth(0);
        listado.getColumnModel().getColumn(3).setPreferredWidth(0);
    }
    
    public boolean buscarUnidadList(List<Unidad> unidades, String nombre){
        boolean flag = false; 
        for(Unidad dt:unidades){           
           if(dt.getUnidad().equals(nombre)){ 
               flag = true;
               break;
           }else{ 
               flag = false;
           }
        }        
        return flag;
    }
    
}
