package config;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author Franz
 */
public class MyConfig {
    private static final String company_name ="UNT";
    private static final String faculty ="QUIMICA";
    private static final String user="FRANZ JUNIOR GUPIOC VENTURA";     
    private static final String correo="dsdeg.9026@gmail.com";    
    private static final String ruta_base ="C://Users/junio_000/Documents/NetBeansProjects/SistemaAlmacenUNT/";
    private static final String rutaCredencialDB =ruta_base+"Config.xml";  
    private static final int version = 1; 
    private static final String adrress_report="C:/Users/junio_000/Documents/NetBeansProjects/SistemaAlmacenUNT/src/Reportes/RptSalida.jrxml";
    private static final String adrress_reportportafolio="C:/Users/junio_000/Documents/NetBeansProjects/SistemaAlmacenUNT/src/Reportes/RptPortafolioUser.jrxml";
    
    public static String getCorreo(){
        return correo;
    }
    public static int getVersion(){
        return version;
    }
    public static String getRutaCredencialDB() {
        return rutaCredencialDB; 
    }
    public static String getCompanyName(){
        return company_name;
    }
    public static String getUser(){
        return user;
    }
    public static String getFaculty(){
        return faculty;
    }
    public static String getAddressReport(){
        return adrress_report;
    }
    public static String getAddressReportPortafolio(){
        return adrress_reportportafolio;
    }
    public static String getGenerarCodigo(String num) {
        String res = "";
         
        if (num.length()== 1) {
            res = "00000" + num;
        }
        if (num.length() == 2) {
            res = "0000" + num;
        }
        if (num.length() == 3) {
            res = "000" + num;
        }
        if (num.length() == 4) {
            res = "00" + num;
        }
        if (num.length() == 5) {
            res = "0" + num;
        }
         if (num.length() >= 6) {
            res = "" + num;
        }
        return res;
    }
    public static boolean validarInt(String value) {
        long num;        
        try {
            num = Long.parseLong(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarTamanio(String value,int i) {
        try {
            if (value.length() <= i) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarIntString(String cadena) {
        for (int i = 0; i < cadena.length(); ++i) {
            char caracter = cadena.charAt(i);
            if (!Character.isLetterOrDigit(caracter)) {
                return false;
            }
        }
        return true;
    }
    
}
