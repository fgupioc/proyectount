/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

import c2_aplicacion.GestionarUnidadServicio;
import c3_dominio.Unidad; 
import javax.swing.JOptionPane;
/**
 *
 * @author Franz
 */
public class NewMain {
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        FormMenu form = new FormMenu();
        form.setVisible(true);
        //ingreso();              
    }
    public static void ingreso(){
        Unidad dts = new Unidad();
        GestionarUnidadServicio func = new GestionarUnidadServicio();
        
        dts.setUnidad("test1");
        dts.setDescripcion("descricion");
        dts.setEstado(1);
        
        try {
            int res = func.insertarUnidad(dts);
            if(res==1)
                JOptionPane.showMessageDialog(null,"guardada");
            else
                JOptionPane.showMessageDialog(null,"error ala guardar");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
