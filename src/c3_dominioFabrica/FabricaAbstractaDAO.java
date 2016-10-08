/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominioFabrica;

import c4_persistenciaConexion.GestorJDBC;
import c5_parametros.LectorDeParametros;

/**
 *
 * @author Franz
 */
public abstract class FabricaAbstractaDAO {

    public static FabricaAbstractaDAO getInstancia() {
        String nombreClaseFabricaDAO;
        FabricaAbstractaDAO FabricaDAO;
        try {
            LectorDeParametros lectorDeParametros = new LectorDeParametros();
            nombreClaseFabricaDAO = lectorDeParametros.getValorParametro("claseFabricaDAO");
            FabricaDAO = (FabricaAbstractaDAO) Class.forName(nombreClaseFabricaDAO).newInstance();
            return FabricaDAO;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public abstract GestorJDBC crearGestorJDBC();

    public abstract IUnidadDAO crearUnidadDAO(GestorJDBC gestorJDBC); 
    
    public abstract ICategoriaDAO crearCategoriaDAO(GestorJDBC gestorJDBC);
    
    public abstract IPresentacionDAO crearPresentacionDAO(GestorJDBC gestorJDBC);
    
    public abstract ITipoProductoDAO crearTipoProductoDAO(GestorJDBC gestorJDBC);
    
    public abstract IMarcaDAO crearMarcaDAO(GestorJDBC gestorJDBC);
    
    public abstract IAlmacenDAO crearAlmacenDAO(GestorJDBC gestorJDBC);
    
    public abstract ITipoPersonalDAO crearTipoPersonalDAO(GestorJDBC gestorJDBC);
    
    public abstract IAreaDAO crearAreaDAO(GestorJDBC gestorJDBC);
    
    public abstract ISolicitanteDAO crearSolicitanteDAO(GestorJDBC gestorJDBC);
    
    public abstract IPersonalDAO crearPersonalDAO(GestorJDBC gestorJDBC);
    
    public abstract IProductoDAO crearProductoDAO(GestorJDBC gestorJDBC);
   
}
