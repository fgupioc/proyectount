package c4_persistenciaConexion;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author FrAnzZ
 */
public class ConexionMYSQL extends GestorJDBC {

    private String host;
    private String db;
    private String user;
    private String pass;

    public ConexionMYSQL() {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("C://Users/junio_000/Documents/NetBeansProjects/SistemaAlmacenUNT/Config.xml");
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List lista_campos = rootNode.getChildren("campos");
            for (int j = 0; j < lista_campos.size(); j++) {
                Element campo = (Element) lista_campos.get(j);
                this.db = campo.getChildTextTrim("database");
                this.host = campo.getChildTextTrim("host") + "/" + db;
                this.user = campo.getChildTextTrim("user");
                this.pass = campo.getChildTextTrim("password");
            }
        } catch (IOException | JDOMException io) {
            JOptionPane.showMessageDialog(null, io.getMessage());
        }
    }

    @Override
    public void abrirConexion() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://" + host, user, pass);
        conexion.createStatement();
        if (conexion != null) {
            //JOptionPane.showMessageDialog(null, "Connecion exitosa");
        }
    }
}
