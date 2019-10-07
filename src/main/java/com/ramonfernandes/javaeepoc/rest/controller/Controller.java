package com.ramonfernandes.javaeepoc.rest.controller;


import com.google.gson.Gson;
import com.ramonfernandes.javaeepoc.rest.dao.DAO;
import com.ramonfernandes.javaeepoc.rest.dto.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;


@Path("/library")
public class Controller {

    private DAO dao = new DAO();
    private Gson gson = new Gson();

    @GET
    @Produces({ "application/json" })
    public Response get() {
        try {
            return Response.status(200).entity(gson.toJson(dao.get())).build();
        }catch (Exception e) {
            return Response.status(500).entity(e.toString()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces({ "text/plain" })
    public Response delete(@PathParam("id") int id) {
        try {
            dao.delete(id);
            return Response.status(200).build();
        }catch (Exception e) {
            return Response.status(500).entity(e.toString()).build();
        }
    }

    @PUT
    @Produces({ "text/plain" })
    @Path("{id}")
    @Consumes("application/json")
    public Response update(@PathParam("id") int id, final Book book) {
        try {
            dao.update(id, book);
            return Response.status(200).build();
        }catch (Exception e) {
            return Response.status(500).entity(e.toString()).build();
        }
    }

    @POST
    @Produces({ "text/plain" })
    @Consumes("application/json")
    public Response create(final Book book) {
        try {
            dao.create(book);
            return Response.status(200).build();
        }catch (Exception e) {
            return Response.status(500).entity(e.toString()).build();
        }
    }


}
