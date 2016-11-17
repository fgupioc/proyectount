package c3_dominio;

/**
 *
 * @author Franz
 */

/* 
 id int(11) AI PK 
 codigo varchar(20) 
 descripcion varchar(100) 
 estado tinyint(1)
 */
public class Area {

    private int id, estado;
    private String descripcion, codigo;

    public Area() {
    }

    public Area(int id, int estado, String descripcion, String codigo) {
        this.id = id;
        this.estado = estado;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
