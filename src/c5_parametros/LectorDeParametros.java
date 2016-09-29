/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c5_parametros;

//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Lain
 */
public class LectorDeParametros {
    
    public String getValorParametro(String parametro){
        String valorParametro;
        InputStream canalDeEntrada;
        Properties propiedades = new Properties();
        try {
            canalDeEntrada = Thread.currentThread().getContextClassLoader().getResourceAsStream("c5_parametros/Parametros.properties");
            propiedades.load(canalDeEntrada);            
            valorParametro = propiedades.getProperty(parametro);
            return valorParametro;
        } catch (IOException e) {
            return null;
        }
    }
    
}
