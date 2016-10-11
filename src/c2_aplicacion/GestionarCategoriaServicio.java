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
    
    public boolean insertar(Categoria categoria) throws Exception{
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
    public List<Categoria> listar()throws Exception{
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
    public boolean editar(Categoria categoria)throws Exception{
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
    public boolean eliminar(Categoria categoria)throws Exception{
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
        public Categoria obtenerId(List<Categoria> categorias, String nombre) {
        categoria = new Categoria();
        int id = 0;
        for (Categoria tipo : categorias) {
            if (tipo.getDescripcion().equals(nombre)) {
                categoria.setId(tipo.getId());
                categoria.setDescripcion(tipo.getDescripcion());
            }
        }
        return categoria;
        }
    public void llenarLista(JTable listado, List<Categoria> unidades) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("codigo");
        model.addColumn("Nombre"); 
        model.addColumn("estado"); 
        
        model.setNumRows(unidades.size());
        int i =0;
        for(Categoria dts:categorias){            
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
    
    public boolean buscarCategoriaList(List<Categoria> categorias, String nombre){
        boolean flag = false; 
        for(Categoria dt:categorias){           
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
