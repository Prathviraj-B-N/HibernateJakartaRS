package com.academicerp.backend.DAO;

import com.academicerp.backend.Bean.Domains;
import com.academicerp.backend.DAO.Interfaces.DomainsDAOInterface;
import com.academicerp.backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DomainsDAO implements DomainsDAOInterface {
    @Override
    public boolean addDomain(Domains d) {
        try(Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(d);
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
    public boolean updateDomian(Domains d, Integer id) {
        try(Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            Query q=session.createQuery("update Domains set batch=:b, program=:p ,capacity=:c,qualification=:q where domainId =:i");
            q.setParameter("b",d.getBatch());
            q.setParameter("p",d.getProgram());
            q.setParameter("c",d.getCapacity());
            q.setParameter("q",d.getQualification());
            q.setParameter("i",id);

            q.executeUpdate();
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
    public List<Domains> getAllDomains() {
        try(Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            Query q=session.createQuery("from Domains ", Domains.class);
            List<Domains> list=q.list();
            transaction.commit();
            session.close();
            return list;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            return null;
        }
    }
}
