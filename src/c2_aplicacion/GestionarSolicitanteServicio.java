/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Solicitante;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.ISolicitanteDAO;
import c4_persistenciaConexion.GestorJDBC; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class GestionarSolicitanteServicio {
    private  GestorJDBC gestorJDBC;
    private ISolicitanteDAO solicitanteDAO;
    private Solicitante solicitante;
    List<Solicitante> solicitantes;

    public GestionarSolicitanteServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        solicitanteDAO = fabricaAbstractaDAO.crearSolicitanteDAO(gestorJDBC);
    }
    
    public boolean insertarSolicitante(Solicitante solicitante) throws Exception{
        boolean flag = false;
        return flag;
    }
    public List<Solicitante> listarSolicitante()throws Exception{
        solicitantes = new ArrayList();
        return solicitantes;
    }
    public boolean editarSolicitante(Solicitante solicitante)throws Exception{
        boolean flag = false;
        return flag;  
    }
    public boolean eliminar(Solicitante solicitante)throws Exception{
        boolean flag = false;
        return flag;
    }
}
