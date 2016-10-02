/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Configuracion;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c4_persistenciaConexion.GestorJDBC;

import java.io.File; 
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.transform.Transformer; 
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

 
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Franz
 */
public class GestionarConfiguracionServicio {

    private GestorJDBC gestorJDBC;
    private Configuracion configuracion;

    public GestionarConfiguracionServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
    }

    public boolean guardar(Configuracion conf) {
        boolean flag = false;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("tables");
            doc.appendChild(rootElement);

            Element campos = doc.createElement("campos");
            rootElement.appendChild(campos);

            Element host = doc.createElement("host");
            host.appendChild(doc.createTextNode(conf.getHost()));
            campos.appendChild(host);

            Element database = doc.createElement("database");
            database.appendChild(doc.createTextNode(conf.getDb()));
            campos.appendChild(database);

            Element user = doc.createElement("user");
            user.appendChild(doc.createTextNode(conf.getUser()));
            campos.appendChild(user);

            Element pasword = doc.createElement("password");
            pasword.appendChild(doc.createTextNode(conf.getPass()));
            campos.appendChild(pasword);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C://Users/junio_000/Documents/NetBeansProjects/SistemaAlmacenUNT/Config.xml"));

            transformer.transform(source, result);
            flag = (result != null) ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return flag;
    }

    public boolean validarConexion() throws Exception {
        boolean flag = false;
        try {
            flag = gestorJDBC.comprobarConexion();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

}
