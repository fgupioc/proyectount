/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.TipoPersonal;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.ITipoPersonalDAO;
import c4_persistenciaConexion.GestorJDBC; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class GestionarTipoPersonalServicio {
    private  GestorJDBC gestorJDBC;
    private ITipoPersonalDAO tipoPersonalDAO;
    private TipoPersonal tipoPersonal;
    List<TipoPersonal> tipoPersonals;

    public GestionarTipoPersonalServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        tipoPersonalDAO = fabricaAbstractaDAO.crearTipoPersonalDAO(gestorJDBC);
    }
    
    public boolean insertarTipoPersonal(TipoPersonal tipoPersonal) throws Exception{
        boolean flag = false;
        return flag;
    }
    public List<TipoPersonal> listarTipoPersonal()throws Exception{
        tipoPersonals = new ArrayList();
        return tipoPersonals;
    }
    public boolean editarTipoPersonal(TipoPersonal tipoPersonal)throws Exception{
        boolean flag = false;
        return flag;  
    }
    public boolean eliminar(TipoPersonal tipoPersonal)throws Exception{
        boolean flag = false;
        return flag;
    }
}
