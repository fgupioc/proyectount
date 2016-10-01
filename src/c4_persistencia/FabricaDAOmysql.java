package c4_persistencia;

import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IAreaDAO;
import c3_dominioFabrica.ICategoriaDAO;
import c3_dominioFabrica.IMarcaDAO;
import c3_dominioFabrica.IOperacionDAO;
import c3_dominioFabrica.IPresentacionDAO;
import c3_dominioFabrica.ISolicitanteDAO;
import c3_dominioFabrica.ITipoPersonalDAO;
import c3_dominioFabrica.ITipoProductoDAO;
import c3_dominioFabrica.IUbicacionDAO;
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

    @Override
    public ICategoriaDAO crearCategoriaDAO(GestorJDBC gestorJDBC) {
        return new CategoriaDAO(gestorJDBC);
    }

    @Override
    public IPresentacionDAO crearPresentacionDAO(GestorJDBC gestorJDBC) {
        return new PresentacionDAO(gestorJDBC);
    }

    @Override
    public ITipoProductoDAO crearTipoProductoDAO(GestorJDBC gestorJDBC) {
        return new TipoProductoDAO(gestorJDBC);
    }

    @Override
    public IMarcaDAO crearMarcaDAO(GestorJDBC gestorJDBC) {
        return new MarcaDAO(gestorJDBC);
    }

    @Override
    public IUbicacionDAO crearUbicacionDAO(GestorJDBC gestorJDBC) {
        return new UbicacionDAO(gestorJDBC);
    }

    @Override
    public ITipoPersonalDAO crearTipoPersonalDAO(GestorJDBC gestorJDBC) {
         return new TipoPersonalDAO(gestorJDBC);
    }

    @Override
    public IAreaDAO crearArea(GestorJDBC gestorJDBC) {
         return new AreaDAO(gestorJDBC);
    }

    @Override
    public ISolicitanteDAO crearSolicitanteDAO(GestorJDBC gestorJDBC) {
         return new SolicitanteDAO(gestorJDBC);
    }

    @Override
    public IOperacionDAO crearOperacionDAO(GestorJDBC gestorJDBC) {
         return new OperacionDAO(gestorJDBC);
    }
    
   
}
