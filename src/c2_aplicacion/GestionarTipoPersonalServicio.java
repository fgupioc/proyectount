/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.TipoPersonal;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.ITipoPersonalDAO;
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
public class GestionarTipoPersonalServicio {
    private  GestorJDBC gestorJDBC;
    private ITipoPersonalDAO tipoPersonalDAO;
    private TipoPersonal tipoPersonal;
    List<TipoPersonal> tipoPersonales;

    public GestionarTipoPersonalServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        tipoPersonalDAO = fabricaAbstractaDAO.crearTipoPersonalDAO(gestorJDBC);
    }
    
    public boolean insertarTipoPersonal(TipoPersonal tipoPersonal) throws Exception{
        boolean res = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            res = tipoPersonalDAO.ingresar(tipoPersonal);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return res;
    }
    public List<TipoPersonal> listarTipoPersonal()throws Exception{
        tipoPersonales = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            tipoPersonales = tipoPersonalDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return tipoPersonales;
    }
    public boolean editarTipoPersonal(TipoPersonal tipoPersonal)throws Exception{
        boolean flag = false;
         gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = tipoPersonalDAO.editar(tipoPersonal);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;  
    }
    public boolean eliminar(TipoPersonal tipoPersonal)throws Exception{
        boolean flag = false;
         gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = tipoPersonalDAO.eliminar(tipoPersonal);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    
     public List<TipoPersonal> buscarNombre(TipoPersonal tipoPersonal) throws Exception{
        tipoPersonales = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            tipoPersonales = tipoPersonalDAO.buscarNombre(tipoPersonal);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return tipoPersonales;
    }
    
    public void llenarLista(JTable listado, List<TipoPersonal> tipoPersonales) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Nombre"); 
        model.addColumn("estado"); 
        
        model.setNumRows(tipoPersonales.size());
        int i =0;
        for(TipoPersonal dts:tipoPersonales){            
            model.setValueAt(dts.getIdtipoPersonal(), i, 0);
            model.setValueAt(dts.getTipoPersonal(), i, 1); 
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
    
    public boolean buscarTipoPersonalList(List<TipoPersonal> tipoPersonales, String nombre){
        boolean flag = false; 
        for(TipoPersonal dt:tipoPersonales){           
           if(dt.getTipoPersonal().equals(nombre)){ 
               flag = true;
               break;
           }else{ 
               flag = false;
           }
        }        
        return flag;
    }
}
