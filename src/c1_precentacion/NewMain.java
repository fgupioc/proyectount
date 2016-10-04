/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

import c2_aplicacion.GestionarConfiguracionServicio; 
import c3_dominio.Configuracion; 
import java.io.File; 
import javax.swing.JOptionPane; 

/**
 *
 * @author Franz
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        GestionarConfiguracionServicio conf = new GestionarConfiguracionServicio();
        Configuracion dir = new Configuracion(); 
        File fichero = new File(dir.directorioUrl());
        if (fichero.exists()) {
            if (conf.validarConexion()) {
               FormLogin form = new FormLogin();
               form.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"Error en la autenticación a la base de datos","Erros en las credenciales",0);
                FormConfigurarHost form = new FormConfigurarHost();
                form.setVisible(true);
            }
        } else {
            FormConfigurarHost form = new FormConfigurarHost();
            form.setVisible(true);
        } 
       
    } 

}
