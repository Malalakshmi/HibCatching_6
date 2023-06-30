package com.learningTech.DemoHibCatching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	SessionFactory sf = config.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	Alien al = (Alien) session.get(Alien.class, "lakshmi");
    	System.out.println(al);
    	tx.commit();
    	session.close();
        
        Session session2 = sf.openSession();
    	Transaction tx1 = session2.beginTransaction();
    	Alien a2 = (Alien) session2.get(Alien.class, "lakshmi");
    	System.out.println(a2);
    	
        tx1.commit();
        session2.close();
    }
}
