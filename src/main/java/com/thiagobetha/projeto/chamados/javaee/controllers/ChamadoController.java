package com.thiagobetha.projeto.chamados.javaee.controllers;

import com.thiagobetha.projeto.chamados.javaee.data.Chamado;
import com.thiagobetha.projeto.chamados.javaee.data.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/chamados")
public class ChamadoController {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chamado> getAll(){
        List<Chamado> list = new ArrayList<>();
        Chamado c1 = new Chamado("Assunto 1", "Mensagem 1", Status.NOVO);
        Chamado c2 = new Chamado("Assunto 2", "Mensagem 2", Status.NOVO);
        Chamado c3 = new Chamado("Assunto 3", "Mensagem 3", Status.NOVO);
    
        list.addAll(Arrays.asList(c1, c2, c3));
        return list;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Chamado getOneById(@PathParam(value = "id") long id){
        Chamado chamado = new Chamado("Assunto "+id, "Mensagem "+id, Status.NOVO);
        chamado.setId(id);
        return chamado;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOne(){
        return Response.ok().build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateOne(@PathParam(value = "id") long id){
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteOne(@PathParam(value = "id") long id){
        return Response.ok().build();
    }    
}
