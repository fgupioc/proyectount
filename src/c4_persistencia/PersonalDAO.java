/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.Personal;
import c3_dominio.TipoPersonal;
import c3_dominioFabrica.IPersonalDAO;
import c4_persistenciaConexion.GestorJDBC;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Franz
 */
public class PersonalDAO implements IPersonalDAO {

    GestorJDBC gestorJDBC;
    private CallableStatement cst, cst2;
    private ResultSet rs, rs2;
    private List<Personal> personales;
    List<TipoPersonal> tipoPersonales;
    private String mysql, mysql2;
    private Personal personal;
    TipoPersonal tipoPersonal;

    PersonalDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public boolean ingresar(Personal dts) throws SQLException {
        mysql = "{Call spPersonalInsertar(?,?,?,?,?,?,?,?,?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setString(1, dts.getNombre());
        cst.setString(2, dts.getApellidoPaterno());
        cst.setString(3, dts.getApellidoMaterno());
        cst.setString(4, dts.getTipoDocumento());
        cst.setString(5, dts.getNumDocumento());
        cst.setString(6, dts.getUsuario());
        cst.setString(7, dts.getPassword());
        cst.setInt(8, dts.getEstado());
        cst.setInt(9, dts.getTipoPersonal().getIdtipoPersonal());
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public List<Personal> Listar() throws SQLException {
        personales = new ArrayList();
        mysql = "{call spPersonalListado}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            personal = new Personal();
            personal.setIdpersonal(rs.getInt("id"));
            personal.setNombre(rs.getString("nombre"));
            personal.setApellidoPaterno(rs.getString("apellidoPaterno"));
            personal.setApellidoMaterno(rs.getString("apellidoMaterno"));
            personal.setTipoDocumento(rs.getString("tipoDocumento"));
            personal.setNumDocumento(rs.getString("numDocumento"));
            personal.setUsuario(rs.getString("usuario"));
            personal.setEstado(rs.getInt("estado"));
            mysql2 = "{call spTipo_PersonalId('" + rs.getString("tipo_personal_id") + "')}";
            rs2 = gestorJDBC.ejecutarProcedimiento(mysql2);
            while (rs2.next()) {
                tipoPersonal = new TipoPersonal();
                tipoPersonal.setIdtipoPersonal(rs2.getInt("id"));
                tipoPersonal.setTipoPersonal(rs2.getString("descripcion"));
                tipoPersonal.setEstado(rs2.getInt("estado"));
                personal.setTipoPersonal(tipoPersonal);
            }
            personales.add(personal);
        }
        rs.close();
        return personales;
    }

    @Override
    public boolean editar(Personal dts) throws SQLException {
        if (dts.getPassword().equals("")) {
            mysql = "{call spPersonalEditar(?,?,?,?,?,?,?,?,?)}";
            cst = gestorJDBC.procedimientoAlmacenado(mysql);
            cst.setInt(1, dts.getIdpersonal());
            cst.setString(2, dts.getNombre());
            cst.setString(3, dts.getApellidoPaterno());
            cst.setString(4, dts.getApellidoMaterno());
            cst.setString(5, dts.getTipoDocumento());
            cst.setString(6, dts.getNumDocumento());
            cst.setString(7, dts.getUsuario());
            cst.setInt(8, dts.getEstado());
            cst.setInt(9, dts.getTipoPersonal().getIdtipoPersonal());
        } else {
            mysql = "{call spPersonalEditarPass(?,?,?,?,?,?,?,?,?,?)}";
            cst = gestorJDBC.procedimientoAlmacenado(mysql);
            cst.setInt(1, dts.getIdpersonal());
            cst.setString(2, dts.getNombre());
            cst.setString(3, dts.getApellidoPaterno());
            cst.setString(4, dts.getApellidoMaterno());
            cst.setString(5, dts.getTipoDocumento());
            cst.setString(6, dts.getNumDocumento());
            cst.setString(7, dts.getUsuario());
            cst.setString(8, dts.getPassword());
            cst.setInt(9, dts.getEstado());
            cst.setInt(10, dts.getTipoPersonal().getIdtipoPersonal());
        }
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public boolean eliminar(Personal dts) throws SQLException {
        mysql = "{call spPersonalEliminar(?)}";
        cst = gestorJDBC.procedimientoAlmacenado(mysql);
        cst.setInt(1, dts.getIdpersonal());
        return (cst.executeUpdate() == 1) ? true : false;
    }

    @Override
    public List<Personal> buscarNombre(Personal dts) throws Exception {
        personales = new ArrayList();

        mysql = "{call spPersonalBuscarNombre('" + dts.getNombre() + "')}";

        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            personal = new Personal();
            personal.setIdpersonal(rs.getInt("id"));
            personal.setNombre(rs.getString("nombre"));
            personal.setApellidoPaterno(rs.getString("apellidoPaterno"));
            personal.setApellidoMaterno(rs.getString("apellidoMaterno"));
            personal.setTipoDocumento(rs.getString("tipoDocumento"));
            personal.setNumDocumento(rs.getString("numDocumento"));
            personal.setUsuario(rs.getString("usuario"));
            personal.setEstado(rs.getInt("estado"));
            mysql2 = "{call spTipo_PersonalId('" + rs.getString("tipo_personal_id") + "')}";
            rs2 = gestorJDBC.ejecutarProcedimiento(mysql2);
            while (rs2.next()) {
                tipoPersonal = new TipoPersonal();
                tipoPersonal.setIdtipoPersonal(rs2.getInt("id"));
                tipoPersonal.setTipoPersonal(rs2.getString("descripcion"));
                tipoPersonal.setEstado(rs2.getInt("estado"));
                personal.setTipoPersonal(tipoPersonal);
            }
            personales.add(personal);
        }
        rs.close();
        return personales;
    }

    @Override
    public List<TipoPersonal> listaTipoPersonal() throws Exception {
        tipoPersonales = new ArrayList();
        mysql = "{call spTipo_PersonalListado()}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);
        while (rs.next()) {
            tipoPersonal = new TipoPersonal();
            tipoPersonal.setIdtipoPersonal(rs.getInt("id"));
            tipoPersonal.setTipoPersonal(rs.getString("descripcion"));
            tipoPersonales.add(tipoPersonal);
        }
        return tipoPersonales;
    }

    @Override
    public Personal loginPersonal(String user, String pass) throws Exception {      
           
        mysql ="{call spLoginUser('"+user+"','"+pass+"')}";
        rs = gestorJDBC.ejecutarProcedimiento(mysql);        
        while (rs.next()) {
            personal = new Personal();
            personal.setIdpersonal(rs.getInt("id"));
            personal.setNombre(rs.getString("nombre"));
            personal.setApellidoPaterno(rs.getString("apellidoPaterno"));
            personal.setApellidoMaterno(rs.getString("apellidoMaterno"));
            personal.setTipoDocumento(rs.getString("tipoDocumento"));
            personal.setNumDocumento(rs.getString("numDocumento"));
            personal.setUsuario(rs.getString("usuario"));
            personal.setEstado(rs.getInt("estado"));
            mysql2 = "{call spTipo_PersonalId('" + rs.getString("tipo_personal_id") + "')}";
            rs2 = gestorJDBC.ejecutarProcedimiento(mysql2);
            while (rs2.next()) {
                tipoPersonal = new TipoPersonal();
                tipoPersonal.setIdtipoPersonal(rs2.getInt("id"));
                tipoPersonal.setCodigo(rs2.getString("codigo"));
                tipoPersonal.setTipoPersonal(rs2.getString("descripcion"));
                tipoPersonal.setEstado(rs2.getInt("estado"));
                personal.setTipoPersonal(tipoPersonal);
            } 
          
        }        
        return personal;
    }

}
