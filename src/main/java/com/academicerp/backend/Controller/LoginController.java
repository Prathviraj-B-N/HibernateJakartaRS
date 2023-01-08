package com.academicerp.backend.Controller;

import com.academicerp.backend.Bean.Admin;
import com.academicerp.backend.DAO.AdminDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class LoginController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Admin a){
        AdminDAO adao = new AdminDAO();
        if(adao.handleLogin(a)) return Response.ok().entity("true").build();
        return Response.ok().entity("false").build();
    }
}
