/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio;

import java.sql.Date;

 

/**
 *
 * @author Franz
 */
public class Producto {
    private int idproducto,cantidad,estado;
    private String codigo,producto,descripcion;
    private Date fechaRegistro;
    private Unidad unidad;
    private Categoria categoria;
    private TipoProducto tipoProducto;
    private Marca marca;
    private Almacen almacen;

    public Producto() {
    }

    public Producto(int idproducto, int cantidad, int estado, String codigo, String producto, String descripcion, Date fechaRegistro, Unidad unidad, Categoria categoria, TipoProducto tipoProducto, Marca marca, Almacen almacen) {
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.estado = estado;
        this.codigo = codigo;
        this.producto = producto;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.unidad = unidad;
        this.categoria = categoria;
        this.tipoProducto = tipoProducto;
        this.marca = marca;
        this.almacen = almacen;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }
    
    
     
    
}
