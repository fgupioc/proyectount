/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Movimiento;
import c3_dominio.Producto;
import c3_dominioFabrica.IMovimientoDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Franz
 */
public class MovimientoDAO implements IMovimientoDAO {

    public GestorJDBC gestorJDBC;
    private CallableStatement cst;
    private ResultSet rs;
    private List<Movimiento> movimientos;
    private String mysql;
    private Movimiento movimiento;

    public MovimientoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public boolean ingreso(Movimiento dts) throws SQLException {
        mysql = "{call spIngresoArticulo(?,?,?,?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getOperacion());
        cst.setTimestamp(2, dts.getFechaRegistro());
        cst.setString(3, dts.getNumIngreso());
        cst.setInt(4, dts.getCantidad());
        cst.setInt(5, dts.getPersonal().getIdpersonal());
        cst.setInt(6, dts.getProducto().getId());
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public boolean salida(Movimiento dts) throws SQLException {
        mysql = "{call spSalidaProducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getOperacion());
        cst.setTimestamp(2, dts.getFechaRegistro());
        cst.setString(3, dts.getNumSalida());
        cst.setString(4, dts.getNumExpediente());
        cst.setString(5, dts.getNumDocumento());
        cst.setString(6, dts.getAsunto());
        cst.setString(7, dts.getSolicitante());
        cst.setString(8, dts.getReferencia());
        cst.setInt(9, dts.getCantidad());
        cst.setString(10, dts.getModelo());
        cst.setString(11, dts.getColor());
        cst.setString(12, dts.getNumSerie());
        cst.setString(13, dts.getCodigoUnt());
        cst.setString(14, dts.getCodigoSaneamiento());
        cst.setString(15, dts.getObservacion());
        cst.setInt(16, dts.getAutorizante().getId());
        cst.setInt(17, dts.getPersonal().getIdpersonal());
        cst.setInt(18, dts.getProducto().getId());
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public boolean addCantidaProducto(Movimiento dts) throws SQLException {
        mysql = "{call spAddArticulo(?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setInt(1, dts.getProducto().getId());
        cst.setString(2, dts.getProducto().getCodigo());
        cst.setInt(3, dts.getCantidad());
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public boolean removeCantidaProducto(Movimiento dts) throws SQLException {
        mysql = "{call spRemoveArticulo(?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setInt(1, dts.getProducto().getId());
        cst.setString(2, dts.getProducto().getCodigo());
        cst.setInt(3, dts.getCantidad());
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public List<Movimiento> Listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Movimiento movimiento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Movimiento movimiento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimiento> buscarNombre(Movimiento movimiento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
