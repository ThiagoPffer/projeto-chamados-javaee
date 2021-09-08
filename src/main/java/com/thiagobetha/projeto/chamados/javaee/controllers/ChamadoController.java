package com.thiagobetha.projeto.chamados.javaee.controllers;

import com.thiagobetha.projeto.chamados.javaee.data.Chamado;
import com.thiagobetha.projeto.chamados.javaee.data.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
