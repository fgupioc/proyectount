package c4_persistencia;

import c3_dominioFabrica.FabricaAbstractaDAO; 
import c3_dominioFabrica.ICategoriaDAO;
import c3_dominioFabrica.IMarcaDAO; 
import c3_dominioFabrica.IPresentacionDAO;
import c3_dominioFabrica.IAutorizanteDAO;
import c3_dominioFabrica.ITipoPersonalDAO;
import c3_dominioFabrica.ITipoProductoDAO;
import c3_dominioFabrica.IAlmacenDAO;
import c3_dominioFabrica.IAreaDAO; 
import c3_dominioFabrica.IMovimientoDAO;
import c3_dominioFabrica.IPersonalDAO;
import c3_dominioFabrica.IProductoDAO;
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
    public IAlmacenDAO crearAlmacenDAO(GestorJDBC gestorJDBC) {
        return new AlmacenDAO(gestorJDBC);
    }

    @Override
    public ITipoPersonalDAO crearTipoPersonalDAO(GestorJDBC gestorJDBC) {
         return new TipoPersonalDAO(gestorJDBC);
    } 

    @Override
    public IAutorizanteDAO crearAutorizanteDAO(GestorJDBC gestorJDBC) {
         return new AutorizanteDAO(gestorJDBC);
    }

    @Override
    public IPersonalDAO crearPersonalDAO(GestorJDBC gestorJDBC) {
        return new PersonalDAO(gestorJDBC);
    }

    @Override
    public IProductoDAO crearProductoDAO(GestorJDBC gestorJDBC) {
        return new ProductoDAO(gestorJDBC);
    }

    @Override
    public IMovimientoDAO crearMovimientoDAO(GestorJDBC gestorJDBC) {
        return new MovimientoDAO(gestorJDBC);
    }

    @Override
    public IAreaDAO crearAreaDAO(GestorJDBC gestorJDBC) {
        return new AreaDAO(gestorJDBC);
    } 
   
}
