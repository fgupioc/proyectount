package c4_persistencia;

import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IUnidadDAO;
import c4_persistenciaConexion.ConexionMYSQL;
import c4_persistenciaConexion.GestorJDBC;

/**
 * @author Lain
 * @version 1.0
 * @created 01-jul-2014 04:38:54 p.m.
 */
public class FabricaDAOmysql extends FabricaAbstractaDAO {

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new ConexionMYSQL();
    }

    @Override
    public IUnidadDAO crearUnidadDAO(GestorJDBC gestorJDBC) {
        return new UnidadDAO(gestorJDBC);
    }

}
