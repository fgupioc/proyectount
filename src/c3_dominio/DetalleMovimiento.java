 
package c3_dominio;

 
public class DetalleMovimiento {
    private int id,movimiento_id,cantidad;
    private String  observacion,numSerie,codigoUnt,codigoSaneamiento;
    private Producto producto;

    public DetalleMovimiento() {
    }

    public DetalleMovimiento(int id, int movimiento_id, int cantidad, String observacion, String numSerie, String codigoUnt, String codigoSaneamiento, Producto producto) {
        this.id = id;
        this.movimiento_id = movimiento_id;
        this.cantidad = cantidad;
        this.observacion = observacion;
        this.numSerie = numSerie;
        this.codigoUnt = codigoUnt;
        this.codigoSaneamiento = codigoSaneamiento;
        this.producto = producto;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovimiento_id() {
        return movimiento_id;
    }

    public void setMovimiento_id(int movimiento_id) {
        this.movimiento_id = movimiento_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getCodigoUnt() {
        return codigoUnt;
    }

    public void setCodigoUnt(String codigoUnt) {
        this.codigoUnt = codigoUnt;
    }

    public String getCodigoSaneamiento() {
        return codigoSaneamiento;
    }

    public void setCodigoSaneamiento(String codigoSaneamiento) {
        this.codigoSaneamiento = codigoSaneamiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
       
}
