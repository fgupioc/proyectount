package c3_dominio;

public class Configuracion {

    private String host, db, user, pass, puerto, directorio;

    public Configuracion() {
    }

    public Configuracion(String host, String db, String user, String pass, String puerto) {
        this.host = host;
        this.db = db;
        this.user = user;
        this.pass = pass;
        this.puerto = puerto;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String directorioUrl() {
        return this.directorio = "C://Users/junio_000/Documents/NetBeansProjects/SistemaAlmacenUNT/Config.xml";
    }

    public String generarCodigo(String num) {
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
