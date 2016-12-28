/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio;

import java.sql.Timestamp;

 

/**
 *
 * @author Franz
 */
public class Producto {
    private int id,cantidad,estado;
    private String codigo,articulo,descripcion,marca,modelo,color;
    private Timestamp fechaRegistro; 
    private Categoria categoria;
    private TipoProducto tipoProducto; 
    private Almacen almacen;
    private Unidad unidad;

    public Producto() {
    }

    public Producto(int id, int cantidad, int estado, String codigo, String articulo, String descripcion, String marca, String modelo, String color, Timestamp fechaRegistro, Categoria categoria, TipoProducto tipoProducto, Almacen almacen, Unidad unidad) {
        this.id = id;
        this.cantidad = cantidad;
        this.estado = estado;
        this.codigo = codigo;
        this.articulo = articulo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
        this.tipoProducto = tipoProducto;
        this.almacen = almacen;
        this.unidad = unidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    
    
}
