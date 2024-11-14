package com.ramoscodev.biblioteca.service;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/livros")
public class LivrosResources {
	
	@GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.ok("{\"mensagem\": \"Olá do Serviço Book Listar\"}").build();
    }
	
	@POST
    @Path("/cadastrar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar() {
        return Response.ok("{\"mensagem\": \"Olá do Serviço Book Cadastrar\"}").build();
    }
	
	@PUT
    @Path("/atualizar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar() {
        return Response.ok("{\"mensagem\": \"Olá do Serviço Book Atualizar\"}").build();
    }
	
	@DELETE
    @Path("/deletar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar() {
        return Response.ok("{\"mensagem\": \"Olá do Serviço Book Deletar\"}").build();
    }
}
