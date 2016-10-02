/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Area;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IAreaDAO;
import c4_persistenciaConexion.GestorJDBC; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class GestionarAreaServicio {
    private  GestorJDBC gestorJDBC;
    private IAreaDAO areaDAO;
    private Area area;
    List<Area> areas;

    public GestionarAreaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        areaDAO = fabricaAbstractaDAO.crearArea(gestorJDBC);
    }
    
    public boolean insertarArea(Area area) throws Exception{
        boolean flag = false;
        return flag;
    }
    public List<Area> listarArea()throws Exception{
        areas = new ArrayList();
        return areas;
    }
    public boolean editarArea(Area area)throws Exception{
        boolean flag = false;
        return flag;  
    }
    public boolean eliminar(Area area)throws Exception{
        boolean flag = false;
        return flag;
    }
}
