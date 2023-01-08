package com.academicerp.backend.Controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class RootPathController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response rootPath(){
        return Response.ok().entity("Welcome!").build();
    }
}
