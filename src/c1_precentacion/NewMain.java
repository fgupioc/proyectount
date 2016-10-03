/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_precentacion;

import c2_aplicacion.GestionarConfiguracionServicio;
import c2_aplicacion.GestionarPersonalServicio;
import c2_aplicacion.GestionarUnidadServicio;
import c3_dominio.Configuracion;
import c3_dominio.Unidad;
import java.io.File;
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
    public static void main(String[] args) throws Exception {
        GestionarConfiguracionServicio conf = new GestionarConfiguracionServicio();
        Configuracion dir = new Configuracion(); 
        File fichero = new File(dir.directorioUrl());
        if (fichero.exists()) {
            if (conf.validarConexion()) {
                FormMenu form = new FormMenu();
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
