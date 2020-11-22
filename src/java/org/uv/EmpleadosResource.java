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

/**
 * REST Web Service
 *
 * @author victorm
 */
@Path("empleados")
public class EmpleadosResource {

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
    public Empleado getJson() {
        Empleado emp=new Empleado();
        emp.setId("1");
        emp.setNombre("victor");
        emp.setDireccion("mexico");
        emp.setTelefono("2712338");
        return emp;
    }

    /**
     * PUT method for updating or creating an instance of EmpleadosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
