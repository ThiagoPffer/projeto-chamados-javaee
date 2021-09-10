package com.thiagobetha.projeto.chamados.javaee.controllers;

import com.thiagobetha.projeto.chamados.javaee.data.Chamado;
import com.thiagobetha.projeto.chamados.javaee.enums.chamados.Status;
import com.thiagobetha.projeto.chamados.javaee.resources.ChamadoResource;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/chamados")
public class ChamadoController {
    
    @Inject
    ChamadoResource dao;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chamado> getAll(){
        try {
            return dao.listar();
        } catch (Exception exception) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, exception);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Chamado getOneById(@PathParam(value = "id") long id){
        try {
            return dao.selecionar(id);
        } catch (Exception exception) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, exception);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOne(Chamado chamado){
        try {
            dao.inserir(chamado);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception exception) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, exception);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOne(Chamado chamado){
        try {
            if(chamado.getStatus() != Status.FECHADO){
                chamado.setStatus(Status.PENDENTE);
            }
            dao.alterar(chamado);
            return Response.status(Response.Status.OK).build();
        } catch (Exception exception) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, exception);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteOne(@PathParam(value = "id") long id){
        try {
            dao.excluir(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception exception) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, exception);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }    
}
