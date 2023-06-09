package session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryWrapper {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        // A SessionFactory is set up once for an application!
        if (sessionFactory != null) {
            return sessionFactory;
        }

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            System.out.print(sessionFactory == null);
        } catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                StandardServiceRegistryBuilder.destroy( registry );
        }
        return sessionFactory;
    }
}