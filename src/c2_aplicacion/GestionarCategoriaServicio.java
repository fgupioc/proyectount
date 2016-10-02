/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.Categoria;
import c3_dominioFabrica.FabricaAbstractaDAO;
import c3_dominioFabrica.ICategoriaDAO;
import c4_persistenciaConexion.GestorJDBC; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franz
 */
public class GestionarCategoriaServicio {
    private  GestorJDBC gestorJDBC;
    private ICategoriaDAO CategoriaDAO;
    private Categoria categoria;
    List<Categoria> categorias;

    public GestionarCategoriaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        CategoriaDAO = fabricaAbstractaDAO.crearCategoriaDAO(gestorJDBC);
    }
    
    public boolean insertarCategoria(Categoria categoria) throws Exception{
        boolean flag = false;
        return flag;
    }
    public List<Categoria> listarCategoria()throws Exception{
        categorias = new ArrayList();
        return categorias;
    }
    public boolean editarCategoria(Categoria categoria)throws Exception{
        boolean flag = false;
        return flag;  
    }
    public boolean eliminar(Categoria categoria)throws Exception{
        boolean flag = false;
        return flag;
    }
}
