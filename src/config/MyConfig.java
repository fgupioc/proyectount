package config;
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
}
