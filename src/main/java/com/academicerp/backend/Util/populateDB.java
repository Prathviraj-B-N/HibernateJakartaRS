package com.academicerp.backend.Util;

import com.academicerp.backend.Bean.Student;
import com.academicerp.backend.DAO.StudentDAO;

public class populateDB {
    public static void populateStudent(){
        StudentDAO studentDAOobj = new StudentDAO();
        studentDAOobj.addStudent(new Student("MT2022170", "Prathviraj","B N","Prathviraj.b.n@gmail.com"));
        studentDAOobj.addStudent(new Student("MT2022171", "Nithin","Kumar","Prathviraj.b.n@gmail.com"));
        studentDAOobj.addStudent(new Student("MT2022172", "Rohit","Raman","Prathviraj.b.n@gmail.com"));
        studentDAOobj.addStudent(new Student("MT2022173", "Rahul Raj","Ambastha","Prathviraj.b.n@gmail.com"));
        studentDAOobj.addStudent(new Student("MT2022174", "Pratheek","Garg","Prathviraj.b.n@gmail.com"));
    }

}
