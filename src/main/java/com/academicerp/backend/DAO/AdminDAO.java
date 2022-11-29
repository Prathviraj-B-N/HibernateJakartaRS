package com.academicerp.backend.DAO;

import com.academicerp.backend.Bean.Admin;
import com.academicerp.backend.DAO.Interfaces.AdminDAOInterface;
import com.academicerp.backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.sound.midi.Track;
import java.util.List;

public class AdminDAO{
    public boolean handleLogin(Admin a) {
        try(Session s = SessionUtil.getSession() ){
            Transaction t = s.beginTransaction();
            Query q = s.createQuery("select a.password from Admin as a where username=:u",Admin.class);
            q.setParameter("u",a.getUsername());
            List<Object> password = q.list();
            if(password.size() < 1) return false;
            if(password.get(0).toString().equals(a.getPassword())) return true;
            return false;
        }catch (HibernateException e){
            return false;
        }
    }
}
