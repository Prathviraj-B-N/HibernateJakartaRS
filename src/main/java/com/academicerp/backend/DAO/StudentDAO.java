package com.academicerp.backend.DAO;
import com.academicerp.backend.Bean.Student;
import com.academicerp.backend.DAO.Interfaces.StudentDAOInterface;
import com.academicerp.backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

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
    public List<Student> getStudent(Integer id) {
        try(Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            Query q=session.createQuery("from Student as s where s.domain_id.domainId=:id",Student.class);

            q.setParameter("id",id);
            List<Student> list=q.list();
            transaction.commit();
            return list;

        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            return Collections.emptyList();
        }
    }
}
