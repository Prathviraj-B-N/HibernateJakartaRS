package com.academicerp.backend.DAO;
import com.academicerp.backend.Bean.Student;
import com.academicerp.backend.DAO.Interfaces.StudentDAOInterface;
import com.academicerp.backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO implements StudentDAOInterface {

    @Override
    public boolean addStudent(Student studobj) {

        try(Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(studobj);
            transaction.commit();
            session.close();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public String getStudent(Integer id) {
        
        return "";
    }
}
