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
import javax.swing.JComboBox;
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

    public boolean insertar(Unidad unidad) throws Exception {
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

    public List<Unidad> listar() throws Exception {
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
    
    public boolean editar(Unidad unidad) throws Exception{
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
    
    public boolean eliminar(Unidad unidad)throws Exception{
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
     public Unidad obtenerId(List<Unidad> unidades, String nombre) {
        unidad = new Unidad();
        int id = 0;
        for (Unidad tipo : unidades) { 
            if (tipo.getDescripcion().equals(nombre)) {
                unidad.setId(tipo.getId());
                unidad.setDescripcion(tipo.getDescripcion()); 
            }
        }
        return unidad;
    }
    public void llenarLista(JTable listado, List<Unidad> unidades) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Codigo"); 
        model.addColumn("Nombre"); 
        model.addColumn("estado"); 
        
        model.setNumRows(unidades.size());
        int i =0;
        for(Unidad dts:unidades){            
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
    
    public boolean buscarUnidadList(List<Unidad> unidades, String nombre){
        boolean flag = false; 
        for(Unidad dt:unidades){           
           if(dt.getDescripcion().equals(nombre)){ 
               flag = true;
               break;
           }else{ 
               flag = false;
           }
        }        
        return flag;
    }
    
    public int obtenerIndice(JComboBox combo ,String nombre){ 
        int indice =0;
        for(int i=0;i<combo.getItemCount();i++){             
            if(combo.getItemAt(i).toString().equals(nombre)){
                indice=i;                
            } 
        }  
        return indice;
    }
}
