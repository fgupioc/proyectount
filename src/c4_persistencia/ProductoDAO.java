/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Almacen;
import c3_dominio.Categoria;
import c3_dominio.Marca;
import c3_dominio.Producto;
import c3_dominio.TipoProducto;
import c3_dominio.Unidad;
import c3_dominioFabrica.IProductoDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.Calendar;
import java.sql.Timestamp;

/**
 *
 * @author Franz
 */
public class ProductoDAO implements IProductoDAO {

    private GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs;
    private List<Producto> productos;
    private String mysql;
    private Producto producto;

    public ProductoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public boolean ingresar(Producto dts) throws SQLException {
        mysql = "{Call spProductoInsertar (?,?,?,?,?,?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getCodigo());
        cst.setString(2, dts.getArticulo()); 
        cst.setTimestamp(3, dts.getFechaRegistro()); 
        cst.setInt(4, dts.getCategoria().getId());
        cst.setInt(5, dts.getTipoProducto().getId());
        cst.setInt(6, dts.getMarca().getId());
        cst.setInt(7, dts.getAlmacen().getId());
        cst.setInt(8, dts.getUnidad().getId());
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public List<Producto> Listar() throws SQLException {
        productos = new ArrayList();
        ResultSet rs2, rs3, rs4, rs5, rs6,rs7;
        mysql = "{call spProductoListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            producto = new Producto();
            producto.setId(rs.getInt("id"));
            producto.setCodigo(rs.getString("codigo"));
            producto.setArticulo(rs.getString("articulo")); 
            producto.setFechaRegistro(rs.getTimestamp("fechaRegistro")); 
            producto.setCantidad(rs.getInt("cantidad")); 
            producto.setEstado(rs.getInt("estado"));
            rs3 = gestorJDBC.ejecutarProcedimiento("call spCategoriaId('" + rs.getInt("categoria_id") + "')");
            while (rs3.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs3.getInt("id"));
                categoria.setDescripcion(rs3.getString("descripcion"));
                categoria.setEstado(rs3.getInt("estado"));
                producto.setCategoria(categoria);
            }
            rs3.close();
            rs4 = gestorJDBC.ejecutarProcedimiento("call spTipo_ProductoId('" + rs.getInt("tipo_producto_id") + "')");
            while (rs4.next()) {
                TipoProducto tipoProducto = new TipoProducto();
                tipoProducto.setId(rs4.getInt("id"));
                tipoProducto.setDescripcion(rs4.getString("descripcion"));
                tipoProducto.setEstado(rs4.getInt("estado"));
                producto.setTipoProducto(tipoProducto);
            }
            rs4.close();
            rs5 = gestorJDBC.ejecutarProcedimiento("call spMarcaId('" + rs.getInt("marca_id") + "')");
            while (rs5.next()) {
                Marca marca = new Marca();
                marca.setId(rs5.getInt("id"));
                marca.setDescripcion(rs5.getString("descripcion"));
                marca.setEstado(rs5.getInt("estado"));
                producto.setMarca(marca);
            }
            rs5.close();
            rs6 = gestorJDBC.ejecutarProcedimiento("call spAlmacenId('" + rs.getInt("almacen_id") + "')");
            while (rs6.next()) {
                Almacen almacen = new Almacen();
                almacen.setId(rs6.getInt("id"));
                almacen.setDescripcion(rs6.getString("descripcion"));
                almacen.setEstado(rs6.getInt("estado"));
                producto.setAlmacen(almacen);
            }
            rs6.close();
             rs7 = gestorJDBC.ejecutarProcedimiento("call spUnidadId('" + rs.getInt("unidad_id") + "')");
            while (rs7.next()) {
                Unidad unidad = new Unidad();
                unidad.setId(rs7.getInt("id"));
                unidad.setDescripcion(rs7.getString("descripcion"));
                unidad.setEstado(rs7.getInt("estado"));
                producto.setUnidad(unidad);
            }
            rs7.close();
            productos.add(producto);
        }
        rs.close();
        return productos;
    }

    @Override
    public boolean editar(Producto dts) throws SQLException {
        mysql = "{call spProductoEditar(?,?,?,?,?,?,?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setInt(1, dts.getId());
        cst.setString(2, dts.getCodigo());
        cst.setString(3, dts.getArticulo()); 
        cst.setTimestamp(4, dts.getFechaRegistro()); 
        cst.setInt(5, dts.getCategoria().getId());
        cst.setInt(6, dts.getTipoProducto().getId());
        cst.setInt(7, dts.getMarca().getId());
        cst.setInt(8, dts.getAlmacen().getId());
        cst.setInt(9, dts.getUnidad().getId());
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public boolean eliminar(Producto dts) throws SQLException {
        mysql = "{call spProductoEliminar(?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setInt(1, dts.getId());
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public List<Producto> buscarNombre(Producto dts) throws Exception {
        productos = new ArrayList();
        ResultSet rs2, rs3, rs4, rs5, rs6,rs7;
        mysql = "{call spProductoBuscarNombre('" + dts.getArticulo() + "')}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            producto = new Producto();
            producto.setId(rs.getInt("id"));
            producto.setCodigo(rs.getString("codigo"));
            producto.setArticulo(rs.getString("articulo")); 
            producto.setFechaRegistro(rs.getTimestamp("fechaRegistro"));
            producto.setCantidad(rs.getInt("cantidad")); 
            producto.setEstado(rs.getInt("estado"));
            rs3 = gestorJDBC.ejecutarProcedimiento("call spCategoriaId('" + rs.getInt("categoria_id") + "')");
            while (rs3.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs3.getInt("id"));
                categoria.setDescripcion(rs3.getString("descripcion"));
                categoria.setEstado(rs3.getInt("estado"));
                producto.setCategoria(categoria);
            }
            rs3.close();
            rs4 = gestorJDBC.ejecutarProcedimiento("call spTipo_ProductoId('" + rs.getInt("tipo_producto_id") + "')");
            while (rs4.next()) {
                TipoProducto tipoProducto = new TipoProducto();
                tipoProducto.setId(rs4.getInt("id"));
                tipoProducto.setDescripcion(rs4.getString("descripcion"));
                tipoProducto.setEstado(rs4.getInt("estado"));
                producto.setTipoProducto(tipoProducto);
            }
            rs4.close();
            rs5 = gestorJDBC.ejecutarProcedimiento("call spMarcaId('" + rs.getInt("marca_id") + "')");
            while (rs5.next()) {
                Marca marca = new Marca();
                marca.setId(rs5.getInt("id"));
                marca.setDescripcion(rs5.getString("descripcion"));
                marca.setEstado(rs5.getInt("estado"));
                producto.setMarca(marca);
            }
            rs5.close();
            rs6 = gestorJDBC.ejecutarProcedimiento("call spAlmacenId('" + rs.getInt("almacen_id") + "')");
            while (rs6.next()) {
                Almacen almacen = new Almacen();
                almacen.setId(rs6.getInt("id"));
                almacen.setDescripcion(rs6.getString("descripcion"));
                almacen.setEstado(rs6.getInt("estado"));
                producto.setAlmacen(almacen);
            }
            rs6.close();
             rs7 = gestorJDBC.ejecutarProcedimiento("call spUnidadId('" + rs.getInt("unidad_id") + "')");
            while (rs7.next()) {
                Unidad unidad = new Unidad();
                unidad.setId(rs7.getInt("id"));
                unidad.setDescripcion(rs7.getString("descripcion"));
                unidad.setEstado(rs7.getInt("estado"));
                producto.setUnidad(unidad);
            }
            rs7.close();
            productos.add(producto);
        }
        rs.close();
        return productos;
    }

    public int idAlmacen(String value) throws Exception {
        int res = 0;
        mysql = "{call spAlmacenBuscarNombre('" + value + "')}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            res = rs.getInt("id");
        }
        rs.close();
        return res;
    }

    @Override
    public List<Producto> buscarArticuloCodigo(String location, String value) throws Exception {
        productos = new ArrayList();
        ResultSet rs2, rs3, rs4, rs5, rs6,rs7;
        mysql = "{call spBuscarArticuloLocationCodigo('" + value + "','" + idAlmacen(location) + "')}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            producto = new Producto();
            producto.setId(rs.getInt("id"));
            producto.setCodigo(rs.getString("codigo"));
            producto.setArticulo(rs.getString("articulo")); 
            producto.setFechaRegistro(rs.getTimestamp("fechaRegistro")); 
            producto.setCantidad(rs.getInt("cantidad")); 
            producto.setEstado(rs.getInt("estado"));
            rs3 = gestorJDBC.ejecutarProcedimiento("call spCategoriaId('" + rs.getInt("categoria_id") + "')");
            while (rs3.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs3.getInt("id"));
                categoria.setDescripcion(rs3.getString("descripcion"));
                categoria.setEstado(rs3.getInt("estado"));
                producto.setCategoria(categoria);
            }
            rs3.close();
            rs4 = gestorJDBC.ejecutarProcedimiento("call spTipo_ProductoId('" + rs.getInt("tipo_producto_id") + "')");
            while (rs4.next()) {
                TipoProducto tipoProducto = new TipoProducto();
                tipoProducto.setId(rs4.getInt("id"));
                tipoProducto.setDescripcion(rs4.getString("descripcion"));
                tipoProducto.setEstado(rs4.getInt("estado"));
                producto.setTipoProducto(tipoProducto);
            }
            rs4.close();
            rs5 = gestorJDBC.ejecutarProcedimiento("call spMarcaId('" + rs.getInt("marca_id") + "')");
            while (rs5.next()) {
                Marca marca = new Marca();
                marca.setId(rs5.getInt("id"));
                marca.setDescripcion(rs5.getString("descripcion"));
                marca.setEstado(rs5.getInt("estado"));
                producto.setMarca(marca);
            }
            rs5.close();
            rs6 = gestorJDBC.ejecutarProcedimiento("call spAlmacenId('" + rs.getInt("almacen_id") + "')");
            while (rs6.next()) {
                Almacen almacen = new Almacen();
                almacen.setId(rs6.getInt("id"));
                almacen.setDescripcion(rs6.getString("descripcion"));
                almacen.setEstado(rs6.getInt("estado"));
                producto.setAlmacen(almacen);
            }
            rs6.close();
             rs7 = gestorJDBC.ejecutarProcedimiento("call spUnidadId('" + rs.getInt("unidad_id") + "')");
            while (rs7.next()) {
                Unidad unidad = new Unidad();
                unidad.setId(rs7.getInt("id"));
                unidad.setDescripcion(rs7.getString("descripcion"));
                unidad.setEstado(rs7.getInt("estado"));
                producto.setUnidad(unidad);
            }
            rs7.close();
            productos.add(producto);
        }
        rs.close();

        return productos;
    }

    @Override
    public List<Producto> buscarArticuloNombre(String location, String value) throws Exception {
        productos = new ArrayList();
        ResultSet rs2, rs3, rs4, rs5, rs6,rs7;

        mysql = "{call spBuscarArticuloLocationNombre('" + value + "','" + idAlmacen(location) + "')}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            producto = new Producto();
            producto.setId(rs.getInt("id"));
            producto.setCodigo(rs.getString("codigo"));
            producto.setArticulo(rs.getString("articulo")); 
            producto.setFechaRegistro(rs.getTimestamp("fechaRegistro"));
            producto.setCantidad(rs.getInt("cantidad")); 
            producto.setEstado(rs.getInt("estado"));
            rs3 = gestorJDBC.ejecutarProcedimiento("call spCategoriaId('" + rs.getInt("categoria_id") + "')");
            while (rs3.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs3.getInt("id"));
                categoria.setDescripcion(rs3.getString("descripcion"));
                categoria.setEstado(rs3.getInt("estado"));
                producto.setCategoria(categoria);
            }
            rs3.close();
            rs4 = gestorJDBC.ejecutarProcedimiento("call spTipo_ProductoId('" + rs.getInt("tipo_producto_id") + "')");
            while (rs4.next()) {
                TipoProducto tipoProducto = new TipoProducto();
                tipoProducto.setId(rs4.getInt("id"));
                tipoProducto.setDescripcion(rs4.getString("descripcion"));
                tipoProducto.setEstado(rs4.getInt("estado"));
                producto.setTipoProducto(tipoProducto);
            }
            rs4.close();
            rs5 = gestorJDBC.ejecutarProcedimiento("call spMarcaId('" + rs.getInt("marca_id") + "')");
            while (rs5.next()) {
                Marca marca = new Marca();
                marca.setId(rs5.getInt("id"));
                marca.setDescripcion(rs5.getString("descripcion"));
                marca.setEstado(rs5.getInt("estado"));
                producto.setMarca(marca);
            }
            rs5.close();
            rs6 = gestorJDBC.ejecutarProcedimiento("call spAlmacenId('" + rs.getInt("almacen_id") + "')");
            while (rs6.next()) {
                Almacen almacen = new Almacen();
                almacen.setId(rs6.getInt("id"));
                almacen.setDescripcion(rs6.getString("descripcion"));
                almacen.setEstado(rs6.getInt("estado"));
                producto.setAlmacen(almacen);
            }
            rs6.close();
             rs7 = gestorJDBC.ejecutarProcedimiento("call spUnidadId('" + rs.getInt("unidad_id") + "')");
            while (rs7.next()) {
                Unidad unidad = new Unidad();
                unidad.setId(rs7.getInt("id"));
                unidad.setDescripcion(rs7.getString("descripcion"));
                unidad.setEstado(rs7.getInt("estado"));
                producto.setUnidad(unidad);
            }
            rs7.close();
            productos.add(producto);
        }
        rs.close();

        return productos;
    }

    
}
