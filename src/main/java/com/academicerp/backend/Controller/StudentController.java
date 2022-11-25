package com.academicerp.backend.Controller;

import com.academicerp.backend.Bean.Student;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import com.academicerp.backend.DAO.StudentDAO;

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
    @Produces("text/plain")
    public String getStudent() {
        return "Hello, student2!";
    }
}

