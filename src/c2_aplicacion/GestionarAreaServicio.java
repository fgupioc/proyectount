/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Area;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IAreaDAO;
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
public class GestionarAreaServicio {
    private  GestorJDBC gestorJDBC;
    private IAreaDAO areaDAO;
    private Area area;
    List<Area> areas;

    public GestionarAreaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        areaDAO = fabricaAbstractaDAO.crearAreaDAO(gestorJDBC);
    }
    
    public boolean insertar(Area area) throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = areaDAO.ingresar(area);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    public List<Area> listar()throws Exception{
        areas = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            areas = areaDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return areas;
    }
    public boolean editar(Area area)throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = areaDAO.editar(area);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;  
    }
    public boolean eliminar(Area area)throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = areaDAO.eliminar(area);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    
    public List<Area> buscarNombre(Area area) throws Exception{
        areas = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            areas = areaDAO.buscarNombre(area);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return areas;
    }
    
    public void llenarLista(JTable listado, List<Area> areaes) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("codigo");
        model.addColumn("Nombre"); 
        model.addColumn("estado"); 
        
        model.setNumRows(areaes.size());
        int i =0;
        for(Area dts:areaes){            
            model.setValueAt(dts.getId(), i, 0);
            model.setValueAt(dts.getCodigo(), i, 1);
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
        listado.getColumnModel().getColumn(1).setMaxWidth(80);
        listado.getColumnModel().getColumn(1).setMinWidth(80);
        listado.getColumnModel().getColumn(1).setPreferredWidth(80);
        listado.getColumnModel().getColumn(3).setMaxWidth(0);
        listado.getColumnModel().getColumn(3).setMinWidth(0);
        listado.getColumnModel().getColumn(3).setPreferredWidth(0);
    }
    
    public boolean buscarAreaList(List<Area> areas, String nombre){
        boolean flag = false; 
        for(Area dt:areas){           
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
