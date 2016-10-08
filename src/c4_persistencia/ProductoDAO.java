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
        mysql = "{Call spProductoInsertar (?,?,?,?,?,?,?,?,?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getCodigo());
        cst.setString(2, dts.getProducto());
        cst.setString(3, dts.getDescripcion());
        cst.setDate(4, dts.getFechaRegistro());
        cst.setInt(5, dts.getCantidad());
        cst.setInt(6, dts.getUnidad().getIdunidad());
        cst.setInt(7, dts.getCategoria().getId());
        cst.setInt(8, dts.getTipoProducto().getIdtipoproducto());
        cst.setInt(9, dts.getMarca().getId());
        cst.setInt(10, dts.getAlmacen().getId());
        cst.setInt(11, dts.getEstado());

        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public List<Producto> Listar() throws SQLException {
        productos = new ArrayList(); 
        ResultSet rs2,rs3,rs4,rs5,rs6;
        mysql = "{call spProductoListado}";        
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            producto = new Producto();
            producto.setIdproducto(rs.getInt("id"));
            producto.setCodigo(rs.getString("codigo"));
            producto.setProducto(rs.getString("producto"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setFechaRegistro(rs.getDate("fechaRegistro"));
            producto.setCantidad(rs.getInt("cantidad"));
            producto.setEstado(rs.getInt("estado"));
            rs2 = gestorJDBC.ejecutarProcedimiento("call spUnidadId('"+rs.getInt("unidad_id")+"')");
            while(rs2.next()){
                Unidad unidad = new Unidad();
                unidad.setIdunidad(rs2.getInt("id"));
                unidad.setUnidad(rs2.getString("descripcion"));
                unidad.setEstado(rs2.getInt("estado"));
                producto.setUnidad(unidad);
            }
            rs3 = gestorJDBC.ejecutarProcedimiento("call spCategoriaId('"+rs.getInt("categoria_id")+"')");
            while(rs3.next()){
                Categoria categoria = new Categoria();
                categoria.setId(rs3.getInt("id"));
                categoria.setDescripcion(rs3.getString("descripcion"));
                categoria.setEstado(rs3.getInt("estado"));
                producto.setCategoria(categoria);
            }
            //tipo_producto_id  spTipo_PersonalId
             rs4 = gestorJDBC.ejecutarProcedimiento("call spTipo_ProductoId('"+rs.getInt("tipo_producto_id")+"')");
            while(rs4.next()){
                TipoProducto tipoProducto = new TipoProducto();
                tipoProducto.setIdtipoproducto(rs4.getInt("id"));
                tipoProducto.setDescripcion(rs4.getString("descripcion"));
                tipoProducto.setEstado(rs4.getInt("estado"));
                producto.setTipoProducto(tipoProducto);
            }
             rs5 = gestorJDBC.ejecutarProcedimiento("call spMarcaId('"+rs.getInt("marca_id")+"')");
            while(rs5.next()){
                Marca marca = new Marca();
                marca.setId(rs5.getInt("id"));
                marca.setDescripcion(rs5.getString("descripcion"));
                marca.setEstado(rs5.getInt("estado"));
                producto.setMarca(marca);
            }
             rs6 = gestorJDBC.ejecutarProcedimiento("call spAlmacenId('"+rs.getInt("almacen_id")+"')");
            while(rs6.next()){
                Almacen almacen = new Almacen();
                almacen.setId(rs6.getInt("id"));
                almacen.setDescripcion(rs6.getString("descripcion"));
                almacen.setEstado(rs6.getInt("estado"));
                producto.setAlmacen(almacen);
            }
            
            productos.add(producto);
        } 
        return productos;
    } 
    @Override
    public boolean editar(Producto producto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Producto producto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> buscarNombre(Producto producto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
