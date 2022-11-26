package com.academicerp.backend.Controller;

import com.academicerp.backend.Util.SessionUtil;
import jakarta.ws.rs.*;

import com.academicerp.backend.DAO.DomainsDAO;
import com.academicerp.backend.Bean.Domains;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Path("/domains")
public class DomainsController {
    private DomainsDAO DomainDAOobj;

    DomainsController(){
        DomainDAOobj = new DomainsDAO();
    }
    @GET
    @Produces("application/json")
    public Response getAllDom() {
        return Response.ok().entity(DomainDAOobj.getAllDomains()).build();
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Domains d) throws URISyntaxException {
        try(Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(d);
            transaction.commit();
            session.close();
            Map<String,String> mp = new HashMap<>();
            mp.put("result", "Success");
            return Response.status(Response.Status.OK).entity(mp).build();
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            Map<String,String> mp = new HashMap<>();
            mp.put("result", "fail");
            return Response.status(203).entity(mp).build();
        }
    }


}
