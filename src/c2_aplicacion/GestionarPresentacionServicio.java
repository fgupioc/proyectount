/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Presentacion;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IPresentacionDAO;
import c4_persistenciaConexion.GestorJDBC; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class GestionarPresentacionServicio {
    private  GestorJDBC gestorJDBC;
    private IPresentacionDAO presentacionDAO;
    private Presentacion presentacion;
    List<Presentacion> presentacions;

    public GestionarPresentacionServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        presentacionDAO = fabricaAbstractaDAO.crearPresentacionDAO(gestorJDBC);
    }
    
    public boolean insertarPresentacion(Presentacion presentacion) throws Exception{
        boolean flag = false;
        return flag;
    }
    public List<Presentacion> listarPresentacion()throws Exception{
        presentacions = new ArrayList();
        return presentacions;
    }
    public boolean editarPresentacion(Presentacion presentacion)throws Exception{
        boolean flag = false;
        return flag;  
    }
    public boolean eliminar(Presentacion presentacion)throws Exception{
        boolean flag = false;
        return flag;
    }
}
