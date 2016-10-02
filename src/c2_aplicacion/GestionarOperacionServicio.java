/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Operacion;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IOperacionDAO;
import c4_persistenciaConexion.GestorJDBC; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class GestionarOperacionServicio {
    private  GestorJDBC gestorJDBC;
    private IOperacionDAO operacionDAO;
    private Operacion operacion;
    List<Operacion> operacions;

    public GestionarOperacionServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        operacionDAO = fabricaAbstractaDAO.crearOperacionDAO(gestorJDBC);
    }
    
    public boolean insertarOperacion(Operacion operacion) throws Exception{
        boolean flag = false;
        return flag;
    }
    public List<Operacion> listarOperacion()throws Exception{
        operacions = new ArrayList();
        return operacions;
    }
    public boolean editarOperacion(Operacion operacion)throws Exception{
        boolean flag = false;
        return flag;  
    }
    public boolean eliminar(Operacion operacion)throws Exception{
        boolean flag = false;
        return flag;
    }
}
