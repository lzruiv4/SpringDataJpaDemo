package org.lam.test;

import org.junit.Before;
import org.junit.Test;
import org.lam.pojo.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPATest {

    EntityManagerFactory emf;

    @Before
    public void init(){
        emf = Persistence.createEntityManagerFactory("hibernateJPA");
    }

    @Test
    public void testJPACreate() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        //开始事务
        et.begin();

        Customer customerToBeCreate = new Customer();
        customerToBeCreate.setCustomer_name("1LI");
        customerToBeCreate.setCustomer_address("koeln");

        em.persist(customerToBeCreate);

        //提交事务
        et.commit();
    }

    @Test
    public void testJPADelete() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Customer customerToBeDelete = em.find(Customer.class, 6L);
        //customerToBeDelete.setCustomer_id(7L);
        if(customerToBeDelete != null){
            em.remove(customerToBeDelete);
        } else {
            System.out.println("Not find!");
        }
        et.commit();
    }
}
