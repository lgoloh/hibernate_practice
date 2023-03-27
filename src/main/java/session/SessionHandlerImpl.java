package session;

import java.util.Arrays;
import java.util.List;

import session.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class SessionHandlerImpl implements SessionHandler {
    private SessionFactory sessionFactory = null;
    private Session session = null;

    public SessionHandlerImpl() {
        this.sessionFactory = SessionFactoryWrapper.getSessionFactory();
    }

    public List<Object[]> execQuery(String query) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Object[]> result = session.createQuery(query).list();
        /*for(Object[] arr : result){
            System.out.println(Arrays.toString(arr));
        }*/
        session.getTransaction().commit();
        session.close();
        session = null;
        return result;
    }

}