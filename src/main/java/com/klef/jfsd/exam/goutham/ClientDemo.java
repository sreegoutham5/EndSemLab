package com.klef.jfsd.exam.goutham;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo {
    public static void main(String[] args) {
        // Step 1: Configure Hibernate and create SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Step 2: Begin transaction
        Transaction transaction = session.beginTransaction();

        // Step 3: HQL update operation using positional parameters
        String hql = "UPDATE Department SET name = :name, location = :location WHERE departmentId = :deptId";
        Query query = session.createQuery(hql);
        query.setParameter("name", "Updated Department Name");
        query.setParameter("location", "New Location");
        query.setParameter("deptId", 1); // Replace with the actual department ID to update

        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);

        // Step 4: Commit transaction
        transaction.commit();

        // Step 5: Close session
        session.close();
        sessionFactory.close();
    }
}
