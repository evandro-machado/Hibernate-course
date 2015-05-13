/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.source.test;

import com.course.entity.UserDetails;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.postgresql.jdbc2.optional.SimpleDataSource;

/**
 *
 * @author Evandro
 */
public class HibernateTest {
    public static void main (String[] args) throws ParseException{
        UserDetails user = new UserDetails();
        user.setUserName("Joelma");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2015-05-13");
        user.setJoinedDate(date);
        
//        entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
