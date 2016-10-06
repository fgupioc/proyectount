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
public class Solicitante {
    private int idsolicitante,estado;
    private String nombre,paterno,materno;

    public Solicitante() {
    }

    public Solicitante(int idsolicitante, int estado, String nombre, String paterno, String materno) {
        this.idsolicitante = idsolicitante;
        this.estado = estado;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
    }

    public int getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(int idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }
    
    
    
}
