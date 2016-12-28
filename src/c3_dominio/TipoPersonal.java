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
public class TipoPersonal {
    private int idtipoPersonal,estado;
    private String tipoPersonal,codigo;

    public TipoPersonal() {
    }

    public TipoPersonal(int idtipoPersonal, int estado, String tipoPersonal,String codigo) {
        this.idtipoPersonal = idtipoPersonal;
        this.estado = estado;
        this.tipoPersonal = tipoPersonal;
        this.codigo = codigo;
    }

    public int getIdtipoPersonal() {
        return idtipoPersonal;
    }

    public void setIdtipoPersonal(int idtipoPersonal) {
        this.idtipoPersonal = idtipoPersonal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
}
