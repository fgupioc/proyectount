/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Categoria;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.ICategoriaDAO;
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
public class GestionarCategoriaServicio {
    private  GestorJDBC gestorJDBC;
    private ICategoriaDAO CategoriaDAO;
    private Categoria categoria;
    List<Categoria> categorias;

    public GestionarCategoriaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        CategoriaDAO = fabricaAbstractaDAO.crearCategoriaDAO(gestorJDBC);
    }
    
    public boolean insertarCategoria(Categoria categoria) throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = CategoriaDAO.ingresar(categoria);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    public List<Categoria> listarCategoria()throws Exception{
        categorias = new ArrayList();
         gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            categorias = CategoriaDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return categorias;
    }
    public boolean editarCategoria(Categoria categoria)throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = CategoriaDAO.editar(categoria);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    public boolean eliminarCategoria(Categoria categoria)throws Exception{
         boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = CategoriaDAO.eliminar(categoria);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            JOptionPane.showMessageDialog(null,e);
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
       public List<Categoria> buscarNombre(Categoria categoria) throws Exception{
        categorias = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            categorias = CategoriaDAO.buscarNombre(categoria);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return categorias;
    }
    public void llenarLista(JTable listado, List<Categoria> unidades) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("Nombre"); 
        model.addColumn("estado"); 
        
        model.setNumRows(unidades.size());
        int i =0;
        for(Categoria dts:categorias){            
            model.setValueAt(dts.getIdcategoria(), i, 0);
            model.setValueAt(dts.getCategoria(), i, 1); 
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
    
    public boolean buscarCategoriaList(List<Categoria> categorias, String nombre){
        boolean flag = false; 
        for(Categoria dt:categorias){           
           if(dt.getCategoria().equals(nombre)){ 
               flag = true;
               break;
           }else{ 
               flag = false;
           }
        }        
        return flag;
    }
    
}
