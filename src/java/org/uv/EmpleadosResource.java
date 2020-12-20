/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import crud.empleado.*;
import crud.departamento.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
/**
 * REST Web Service
 *
 * @author victorm
 */
@Path("empleados")
public class EmpleadosResource {
    private DAOEmpleado daoEmp;
    private List<Empleado> listaEmpleado;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmpleadosResource
     */
    public EmpleadosResource() {
    }

    /**
     * Retrieves representation of an instance of org.uv.EmpleadosResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empleado> mostrarTodos() {
        listaEmpleado= new ArrayList<>();
        daoEmp= new DAOEmpleado();
        listaEmpleado=daoEmp.mostrarTodos();
        if(listaEmpleado!=null){
            System.out.println("operacion exitosa");
            return listaEmpleado;
        }else{
            System.out.println("operacion no exitosa");

        }
        return listaEmpleado;
    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empleado mostrarById(@PathParam("id") int id) {
        Empleado emp=new Empleado();
        emp.setId(id);
        daoEmp= new DAOEmpleado();
        return daoEmp.mostrarByID(emp);
    }
    

    /**
     * PUT method for updating or creating an instance of EmpleadosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean actualizar(Empleado pojo) {
        boolean res=false;
        daoEmp= new DAOEmpleado();
        if(daoEmp.actualizar(pojo)){
            res=true;
            return res;
        }else{
            return res;
        }
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean guardar(Empleado pojo) {
        boolean res=false;
        daoEmp= new DAOEmpleado();
        if(daoEmp.guardar(pojo)){
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
        Empleado pojo=new Empleado();
        pojo.setId(id);
        daoEmp= new DAOEmpleado();
        if(daoEmp.borrar(pojo)){
            res=true;
            return res;
        }else{
            return res;
        }
    }
    
}
