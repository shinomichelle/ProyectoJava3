package com.carrillo.proyectojava3;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import org.hibernate.cfg.Configuration;
public class DAO {
    

private static final ThreadLocal session = new ThreadLocal();
 private static final SessionFactory sessionFactory;
 static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
   public DAO() {  }
                    
    public static Session getSession() {
          Session session = (Session) DAO.session.get();
           if (session == null) {
             session = sessionFactory.openSession();
            DAO.session.set(session);
                  }
    return session;
   }
    protected  void begin() {
getSession().beginTransaction();
}
protected   void commit() {
getSession().getTransaction().commit();
}
protected  void rollback() {
try {
getSession().getTransaction().rollback();
} catch( HibernateException e ) {

}
try {
getSession().close();
} catch( HibernateException e ) {

}
DAO.session.set(null);
}

public static void close() {
getSession().close();
DAO.session.set(null);
}

}