/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Cabecera;
import c3_dominio.DetalleMovimiento;
import c3_dominio.Movimiento; 
import c3_dominioFabrica.IMovimientoDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Timestamp;
import java.util.List;
import javax.swing.table.DefaultTableModel;

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
        mysql = "{call spIngresoArticulo(?,?,?,?)}"; 
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getOperacion());
        cst.setTimestamp(2, dts.getFechaRegistro());
        cst.setString(3, dts.getNumIngreso()); 
        cst.setInt(4, dts.getPersonal().getIdpersonal()); 
        return (cst.executeUpdate() == 1) ? true : false;
    }
     @Override
    public int obtenerIdIngreso(String codigo, int Personal_id) throws Exception {
        int res = 0;
        mysql = "{call spObtenerIdMovimientoingreso('" + Personal_id + "','" + codigo + "')}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            res = rs.getInt("id");
        }
        rs.close();
        return res;
    }
      public int obtenerIdSalida(String codigo, int Personal_id) throws Exception {
        int res = 0;
        mysql = "{call spObtenerIdMovimientoSalida('" + Personal_id + "','" + codigo + "')}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            res = rs.getInt("id");
        }
        rs.close();
        return res;
    }
    
    @Override
     public boolean detalleIngreso(DetalleMovimiento dts,int id)throws Exception{
        mysql = "{call spIngresoDetallerArticulos(?,?,?)}"; 
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setInt(1, id);
        cst.setInt(2, dts.getProducto().getId());
        cst.setInt(3, dts.getCantidad());  
        return (cst.executeUpdate() == 1) ? true : false;
     }
    @Override
    public boolean salida(Movimiento dts) throws SQLException {
        mysql = "{call spSalidaProducto(?,?,?,?,?,?,?,?,?,?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql); 
        cst.setString(1, dts.getOperacion());
        cst.setTimestamp(2, dts.getFechaRegistro());
        cst.setString(3, dts.getNumSalida());
        cst.setString(4, dts.getNumExpediente());
        cst.setString(5, dts.getNumDocumento());
        cst.setString(6, dts.getCabecera());  
        cst.setString(7, dts.getAsunto());
        cst.setString(8, dts.getSolicitante());
        cst.setString(9, dts.getReferencia());  
        cst.setInt(10, dts.getAutorizante().getId());
        cst.setInt(11, dts.getPersonal().getIdpersonal()); 
        cst.setInt(12, dts.getArea().getId());
        return (cst.executeUpdate() == 1) ? true : false;
    }
@Override
     public boolean detalleSalida(DetalleMovimiento dts,int id)throws Exception{
        mysql = "{call spSalidaDetallerArticulos(?,?,?,?,?,?,?)}"; 
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setInt(1, id);
        cst.setInt(2, dts.getProducto().getId());
        cst.setString(3, dts.getObservacion());
        cst.setInt(4, dts.getCantidad());  
        cst.setString(5, dts.getNumSerie());
        cst.setString(6, dts.getCodigoUnt());
        cst.setString(7, dts.getCodigoSaneamiento());
        return (cst.executeUpdate() == 1) ? true : false;
     }
    @Override
    public boolean addCantidaProducto(int id,String codigo,int cantidad) throws SQLException {
        mysql = "{call spAddArticulo(?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setInt(1, id);
        cst.setString(2,codigo);
        cst.setInt(3,cantidad);
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public boolean removeCantidaProducto(int id,String codigo,int cantidad) throws SQLException {
        mysql = "{call spRemoveArticulo(?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setInt(1, id);
        cst.setString(2, codigo);
        cst.setInt(3, cantidad);
        return (cst.executeUpdate() == 1) ? true : false;
    } 
    @Override
    public DefaultTableModel consultaArea(String value) throws Exception {
        DefaultTableModel modelo;
        String[] titulos = {"Memo", "Solicitante"};
        String[] registros = new String[2];
        modelo = new DefaultTableModel(null, titulos); 
        mysql ="{call spConsutaArea('"+value+"')}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            registros[0] = rs.getString("numMemo");
            registros[1] = rs.getString("solicitante");
            modelo.addRow(registros);
        }
        return modelo;
    }

    @Override
    public DefaultTableModel consultaProductoMovimiento(String codigo) throws Exception {
        DefaultTableModel modelo; 
        String[] titulos ={"Codigo","Articulo","Operacion","Cantidad","Fecha","Solicitante"};
        String[] registros = new String[6];
        modelo = new DefaultTableModel(null, titulos);
        mysql ="{call spConsultaProductoMovimiento('"+codigo+"')}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            registros[0] = rs.getString("codigo");
            registros[1] = rs.getString("articulo");
            registros[2] = rs.getString("operacion");
            registros[3] = rs.getString("cantidad");
            registros[4] = rs.getString("fechaRegistro");
            registros[5] = rs.getString("solicitante");
            modelo.addRow(registros);
        }
        return modelo;
    } 
    
    @Override
    public boolean insertCabecera(Cabecera dts) throws Exception {
        mysql= "{Call spCabeceraInsertar (?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getDescripcion()); 
        cst.setString(2, dts.getCodigoMovimiento());  
        return (cst.executeUpdate()==1);  
    }
    public String consultaCodigo()throws Exception{
       mysql =  "{call spConsultaCodigo}";
       String codigo = "";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) { 
            codigo=rs.getString("numSalida");             
        }
        rs.close(); 
        return codigo ;    
    }

    @Override
    public boolean portafolio(Timestamp fecha, int personal_id, int movimiento_id,String operacion, String detalle) throws Exception {
        mysql = "{Call spPortafolioMovimiento(?,?,?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql); 
        cst.setTimestamp(1,fecha);  
        cst.setInt(2, personal_id);
        cst.setInt(3, movimiento_id); 
        cst.setString(4, operacion);
        cst.setString(5, detalle);
        return (cst.executeUpdate() == 1) ? true : false;
    }

   

}
