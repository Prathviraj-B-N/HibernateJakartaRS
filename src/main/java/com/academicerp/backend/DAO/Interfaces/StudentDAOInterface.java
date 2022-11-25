package com.academicerp.backend.DAO.Interfaces;
import com.academicerp.backend.Bean.Student;

public interface StudentDAOInterface {
    boolean addStudent(Student s);
    String getStudent(Integer id);

}
