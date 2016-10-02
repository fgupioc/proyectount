/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Ubicacion;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IUbicacionDAO;
import c4_persistenciaConexion.GestorJDBC; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class GestionarUbicacionServicio {
    private  GestorJDBC gestorJDBC;
    private IUbicacionDAO ubicacionDAO;
    private Ubicacion ubicacion;
    List<Ubicacion> ubicacions;

    public GestionarUbicacionServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        ubicacionDAO = fabricaAbstractaDAO.crearUbicacionDAO(gestorJDBC);
    }
    
    public boolean insertarUbicacion(Ubicacion ubicacion) throws Exception{
        boolean flag = false;
        return flag;
    }
    public List<Ubicacion> listarUbicacion()throws Exception{
        ubicacions = new ArrayList();
        return ubicacions;
    }
    public boolean editarUbicacion(Ubicacion ubicacion)throws Exception{
        boolean flag = false;
        return flag;  
    }
    public boolean eliminar(Ubicacion ubicacion)throws Exception{
        boolean flag = false;
        return flag;
    }
}
