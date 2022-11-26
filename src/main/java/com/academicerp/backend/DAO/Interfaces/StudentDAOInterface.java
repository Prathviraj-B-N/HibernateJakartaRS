package com.academicerp.backend.DAO.Interfaces;
import com.academicerp.backend.Bean.Student;

import java.util.List;

public interface StudentDAOInterface {
    boolean addStudent(Student s);
    List<Student> getStudent(Integer id);

}
