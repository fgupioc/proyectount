/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.TipoProducto;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.ITipoProductoDAO;
import c4_persistenciaConexion.GestorJDBC; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class GestionarTipoProductoServicio {
    private  GestorJDBC gestorJDBC;
    private ITipoProductoDAO tipoProductoDAO;
    private TipoProducto tipoProducto;
    List<TipoProducto> tipoProductos;

    public GestionarTipoProductoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        tipoProductoDAO = fabricaAbstractaDAO.crearTipoProductoDAO(gestorJDBC);
    }
    
    public boolean insertarTipoProducto(TipoProducto tipoProducto) throws Exception{
        boolean flag = false;
        return flag;
    }
    public List<TipoProducto> listarTipoProducto()throws Exception{
        tipoProductos = new ArrayList();
        return tipoProductos;
    }
    public boolean editarTipoProducto(TipoProducto tipoProducto)throws Exception{
        boolean flag = false;
        return flag;  
    }
    public boolean eliminar(TipoProducto tipoProducto)throws Exception{
        boolean flag = false;
        return flag;
    }
}
