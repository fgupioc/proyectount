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
public class Marca {
    private int idmarca,estado;
    private String marca;

    public Marca() {
    }

    public Marca(int idmarca, int estado, String marca) {
        this.idmarca = idmarca;
        this.estado = estado;
        this.marca = marca;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    
}
