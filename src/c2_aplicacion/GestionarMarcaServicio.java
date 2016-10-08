/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Marca;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IMarcaDAO;
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
public class GestionarMarcaServicio {
    private  GestorJDBC gestorJDBC;
    private IMarcaDAO marcaDAO;
    private Marca marca;
    List<Marca> marcas;

    public GestionarMarcaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        marcaDAO = fabricaAbstractaDAO.crearMarcaDAO(gestorJDBC);
    }
    
    public boolean insertar(Marca marca) throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = marcaDAO.ingresar(marca);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    public List<Marca> listar()throws Exception{
        marcas = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            marcas = marcaDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return marcas;
    }
    public boolean editar(Marca marca)throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = marcaDAO.editar(marca);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;  
    }
    public boolean eliminar(Marca marca)throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = marcaDAO.eliminar(marca);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
     public List<Marca> buscarNombre(Marca marca) throws Exception{
        marcas = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            marcas = marcaDAO.buscarNombre(marca);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return marcas;
    }
    
    public void llenarLista(JTable listado, List<Marca> marcas) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Codigo");
        model.addColumn("Nombre"); 
        model.addColumn("estado"); 
        
        model.setNumRows(marcas.size());
        int i =0;
        for(Marca dts:marcas){            
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
    
    public boolean buscarMarcaList(List<Marca> unidades, String nombre){
        boolean flag = false; 
        for(Marca dt:marcas){           
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
