package c3_dominio;

public class Host {

    private String host, db, user, pass, puerto;

    public Host() {
    } 
    public Host(String host, String db, String user, String pass, String puerto) {
        this.host = host;
        this.db = db;
        this.user = user;
        this.pass = pass;
        this.puerto = puerto;
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
}
