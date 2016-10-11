/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

 
import c3_dominio.Almacen;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IAlmacenDAO;
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
public class GestionarAlmacenServicio {
    private  GestorJDBC gestorJDBC;
    private IAlmacenDAO almacenDAO;
    private Almacen almacen;
    List<Almacen> almacenes;

    public GestionarAlmacenServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        almacenDAO = fabricaAbstractaDAO.crearAlmacenDAO(gestorJDBC);
    }
    
     public boolean insertar(Almacen almacen) throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = almacenDAO.ingresar(almacen);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    public List<Almacen> listar()throws Exception{
        almacenes = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            almacenes = almacenDAO.Listar();
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return almacenes;
    }
    public boolean editar(Almacen almacen)throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = almacenDAO.editar(almacen);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;  
    }
    public boolean eliminar(Almacen almacen)throws Exception{
        boolean flag = false;
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            flag = almacenDAO.eliminar(almacen);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return flag;
    }
    
    public List<Almacen> buscarNombre(Almacen almacen) throws Exception{
        almacenes = new ArrayList();
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            almacenes = almacenDAO.buscarNombre(almacen);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            gestorJDBC.cancelarTransaccion();
        }
        gestorJDBC.cerrarConexion();
        return almacenes;
    }
      public Almacen obtenerId(List<Almacen> almacens, String nombre) {
        almacen = new Almacen();
        int id = 0;
        for (Almacen tipo : almacens) {
            if (tipo.getDescripcion().equals(nombre)) {
                almacen.setId(tipo.getId());
                almacen.setDescripcion(tipo.getDescripcion());
            }
        }
        return almacen;
        }
    public void llenarLista(JTable listado, List<Almacen> almacenes) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id");
        model.addColumn("codigo");
        model.addColumn("Nombre"); 
        model.addColumn("estado"); 
        
        model.setNumRows(almacenes.size());
        int i =0;
        for(Almacen dts:almacenes){            
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
    
    public boolean buscarAlmacenList(List<Almacen> almacens, String nombre){
        boolean flag = false; 
        for(Almacen dt:almacens){           
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
