/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Marca;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.IMarcaDAO;
import c4_persistenciaConexion.GestorJDBC; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class GestionarMarcaServicio {
    private  GestorJDBC gestorJDBC;
    private IMarcaDAO marcaDAO;
    private Marca marca;
    List<Marca> marcas;

    public GestionarMarcaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        marcaDAO = fabricaAbstractaDAO.crearMarcaDAO(gestorJDBC);
    }
    
    public boolean insertarMarca(Marca marca) throws Exception{
        boolean flag = false;
        return flag;
    }
    public List<Marca> listarMarca()throws Exception{
        marcas = new ArrayList();
        return marcas;
    }
    public boolean editarMarca(Marca marca)throws Exception{
        boolean flag = false;
        return flag;  
    }
    public boolean eliminar(Marca marca)throws Exception{
        boolean flag = false;
        return flag;
    }
}
