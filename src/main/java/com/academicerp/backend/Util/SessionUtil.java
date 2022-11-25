package com.academicerp.backend.Util;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private static final SessionFactory sf;

    static {
        try{
            Configuration c = new Configuration();
            c.configure();

            sf = c.buildSessionFactory();
        }catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() throws HibernateException {
        return sf.openSession();
    }

}
