package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            System.out.println("=== HIBERNATE: Starting... ===");

            Configuration cfg = new Configuration();
            System.out.println("=== HIBERNATE: Config object created ===");

            cfg.configure("hibernate.cfg.xml");
            System.out.println("=== HIBERNATE: configure() OK ===");

            sessionFactory = cfg.buildSessionFactory();
            System.out.println("=== HIBERNATE: SessionFactory OK ===");

        } catch (Throwable ex) {
            System.err.println("=== HIBERNATE ERROR ===");
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}