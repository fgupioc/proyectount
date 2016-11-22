/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio;

/**
 *
 * @author Franz
 */
public class Cabecera {

    private int id;
    private String descripcion, codigoMovimiento;

    public Cabecera() {
    }

    public Cabecera(int id, String descripcion, String codigoMovimiento) {
        this.id = id;
        this.descripcion = descripcion;
        this.codigoMovimiento = codigoMovimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoMovimiento() {
        return codigoMovimiento;
    }

    public void setCodigoMovimiento(String codigoMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
    }

}
