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
public class Unidad {
    private int idunidad,estado;
    private String unidad;

    public Unidad() {
    }

    public Unidad(int idunidad, int estado, String unidad) {
        this.idunidad = idunidad;
        this.estado = estado;
        this.unidad = unidad;
    }

    public int getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(int idunidad) {
        this.idunidad = idunidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    
}
