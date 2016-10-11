
package c3_dominio; 

import java.sql.Timestamp;

public class Movimiento {
private int id,estado,cantidad;;
private String unidad ,autoriza,referencia,modelo,medida,color,numSerie,codigo,operacion,numIngreso,numSalida,numExpediente,numDocumento,asunto,codigoUnt,codigoSaneamiento,observacion;
private Timestamp fechaRegistro;
private Area area;
private Solicitante solicitamte;
private Personal personal;
private Producto producto;

    public Movimiento() {
    }

    public Movimiento(int id, int estado, int cantidad, String unidad,String autoriza, String referencia, String modelo, String medida, String color, String numSerie, String codigo, String operacion, String numIngreso, String numSalida, String numExpediente, String numDocumento, String asunto, String codigoUnt, String codigoSaneamiento, String observacion, Timestamp fechaRegistro, Area area, Solicitante solicitamte, Personal personal, Producto producto) {
        this.id = id;
        this.estado = estado;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.autoriza = autoriza;
        this.referencia = referencia;
        this.modelo = modelo;
        this.medida = medida;
        this.color = color;
        this.numSerie = numSerie;
        this.codigo = codigo;
        this.operacion = operacion;
        this.numIngreso = numIngreso;
        this.numSalida = numSalida;
        this.numExpediente = numExpediente;
        this.numDocumento = numDocumento;
        this.asunto = asunto;
        this.codigoUnt = codigoUnt;
        this.codigoSaneamiento = codigoSaneamiento;
        this.observacion = observacion;
        this.fechaRegistro = fechaRegistro;
        this.area = area;
        this.solicitamte = solicitamte;
        this.personal = personal;
        this.producto = producto;
    }

    public String getNumIngreso() {
        return numIngreso;
    }

    public void setNumIngreso(String numIngreso) {
        this.numIngreso = numIngreso;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getNumSalida() {
        return numSalida;
    }

    public void setNumSalida(String numSalida) {
        this.numSalida = numSalida;
    }

    public String getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Solicitante getSolicitamte() {
        return solicitamte;
    }

    public void setSolicitamte(Solicitante solicitamte) {
        this.solicitamte = solicitamte;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
}
