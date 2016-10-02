/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

import c2_aplicacion.GestionarUnidadServicio;
import c3_dominio.Unidad;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List; 
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

    public static void ingreso() {
        // Unidad dts = new Unidad();
        GestionarUnidadServicio func = new GestionarUnidadServicio();
        try {
            List<Unidad> unidades = new ArrayList();
            unidades = func.listarUnidad();
            for (Unidad unidad : unidades) {
                System.out.println("nombre : " + unidad.getUnidad());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    

}
