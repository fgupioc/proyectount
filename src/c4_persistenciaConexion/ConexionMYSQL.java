package c4_persistenciaConexion;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author FrAnzZ
 */
public class ConexionMYSQL extends GestorJDBC {

    @Override
    public void abrirConexion() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacenbd", "root", "");
        conexion.createStatement();
        if (conexion != null) {
            //JOptionPane.showMessageDialog(null, "Connecion exitosa");
        }
    }

}
