package com.academicerp.backend.Controller;

import com.academicerp.backend.Bean.Student;
import jakarta.ws.rs.*;

import com.academicerp.backend.DAO.StudentDAO;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/student")
public class StudentController {

    private StudentDAO studentDAOobj;
    StudentController(){
        studentDAOobj = new StudentDAO();
    }
    @GET
    @Produces("text/plain")
    public String land() {
        return "Hello, student!";
    }

    @Path("/addStudent")
    @GET
    @Produces("text/plain")
    public String hello1() {
        Student s = new Student("MT2022170", "Prathviraj","B N","Prathviraj.b.n@gmail.com");
        if(studentDAOobj.addStudent(s) == true) return "success!";
        return "fail";
    }

    @Path("/getStudent/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("id") final Integer id) {
        List<Student> s = studentDAOobj.getStudent(id);
        if(s == null) Response.noContent().build();
        return Response.ok().entity(s).build();
    }
}

