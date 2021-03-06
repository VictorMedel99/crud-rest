package org.uv;

import crud.departamento.DAODepartamento;
import crud.departamento.Departamento;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author victorm
 */
@Path("departamentos")
public class DepartamentosResource {
    private DAODepartamento daoDepartamento;
    private List<Departamento> listaDepartamento;
    
    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of EmpleadosResource
     */
    public DepartamentosResource() {
    }
    
    /**
     * Retrieves representation of an instance of org.uv.DepartamentosResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Departamento> mostrarTodos() {
        listaDepartamento= new ArrayList<>();
        daoDepartamento= new DAODepartamento();
        listaDepartamento=daoDepartamento.mostrarTodos();
        if(listaDepartamento!=null){
            System.out.println("operacion exitosa");
            return listaDepartamento;
        }else{
            System.out.println("operacion no exitosa");

        }
        return listaDepartamento;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento mostrarById(@PathParam("id") int id) {
        Departamento dep=new Departamento();
        dep.setId(id);
        daoDepartamento= new DAODepartamento();
        return daoDepartamento.mostrarByID(dep);
    }
    

    /**
     * PUT method for updating or creating an instance of EmpleadosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean Actualizar(Departamento pojo) {
        boolean res=false;
        daoDepartamento= new DAODepartamento();
        if(daoDepartamento.actualizar(pojo)){
            res=true;
            return res;
        }else{
            return res;
        }
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean guardar(Departamento pojo) {
        boolean res=false;
        daoDepartamento= new DAODepartamento();
        if(daoDepartamento.guardar(pojo)){
            res=true;
            return res;
        }else{
            return res;
        }
    }
    
    @DELETE
    @Path("{id}")
    public boolean borrar(@PathParam("id") int id) {
        boolean res=false;
        Departamento pojo = new Departamento();
        pojo.setId(id);
        daoDepartamento= new DAODepartamento();
        if(daoDepartamento.borrar(pojo)){
            res=true;
            return res;
        }else{
            return res;
        }
    }
    
}
