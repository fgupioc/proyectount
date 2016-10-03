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
        areaDAO = fabricaAbstractaDAO.crearArea(gestorJDBC);
    }
    
    public boolean insertarArea(Area area) throws Exception{
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
    public List<Area> listarArea()throws Exception{
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
    public boolean editarArea(Area area)throws Exception{
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
        model.addColumn("Nombre"); 
        model.addColumn("estado"); 
        
        model.setNumRows(areaes.size());
        int i =0;
        for(Area dts:areaes){            
            model.setValueAt(dts.getIdarea(), i, 0);
            model.setValueAt(dts.getArea(), i, 1); 
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
    
    public boolean buscarAreaList(List<Area> areas, String nombre){
        boolean flag = false; 
        for(Area dt:areas){           
           if(dt.getArea().equals(nombre)){ 
               flag = true;
               break;
           }else{ 
               flag = false;
           }
        }        
        return flag;
    }
    
}
