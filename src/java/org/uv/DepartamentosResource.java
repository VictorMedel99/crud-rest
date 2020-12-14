package org.uv;

import crud.departamento.DAODepartamento;
import crud.departamento.Departamento;
import crud.empleado.DAOEmpleado;
import crud.empleado.Empleado;
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
    public List<Departamento> getJson() {
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
    @Path("/(pojo)")
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento getJson(Departamento pojo) {
        daoDepartamento= new DAODepartamento();
        return daoDepartamento.mostrarByID(pojo);
    }
    

    /**
     * PUT method for updating or creating an instance of EmpleadosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean putJson(Departamento pojo) {
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
    public boolean postJson(Departamento pojo) {
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
    public boolean borrar(Departamento pojo) {
        boolean res=false;
        daoDepartamento= new DAODepartamento();
        if(daoDepartamento.borrar(pojo)){
            res=true;
            return res;
        }else{
            return res;
        }
    }
    
}
