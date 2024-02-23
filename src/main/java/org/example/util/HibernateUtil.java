package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    public static SessionFactory sessionFactory;

    static {
        try {
            // Create a StandardServiceRegistry
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml") // Provide hibernate configuration file
                    .build();

            // Create MetadataSources
            MetadataSources sources = new MetadataSources(standardRegistry);

            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            // Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Initialization of SessionFactory failed.");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
