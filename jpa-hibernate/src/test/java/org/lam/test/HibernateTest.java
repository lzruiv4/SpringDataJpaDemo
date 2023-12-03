package org.lam.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lam.pojo.Customer;

public class HibernateTest {

    private SessionFactory sessionFactory;

    @Before
    public void init(){
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
        sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
    }

    @After
    public void doSomeThing(){
        sessionFactory.close();
    }

    @Test
    public void testCreate(){
        // 创建 Session
        Session session = sessionFactory.openSession();
        // 开始事务
        Transaction transaction = session.beginTransaction();
        // 创建消息实例
        Customer customer = new Customer();
        customer.setCustomer_name("张三");
        customer.setCustomer_address("koeln");
        // 保存消息
        session.save(customer);
        // 提交事务
        transaction.commit();
        //关闭Session
        session.close();
    }

    @Test
    public void testUpdate() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customerToBeUpdate = session.find(Customer.class, 1L);
        customerToBeUpdate.setCustomer_address("SWA");
        customerToBeUpdate.setCustomer_name("LISER");
        session.update(customerToBeUpdate);
        transaction.commit();
        session.close();
    }

    @Test
    public void testFind(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customerToBeFind = session.find(Customer.class, 1L);
        System.out.println(customerToBeFind.toString());

        transaction.commit();
    }

    /**
     * lazy road 懒加载
     * 使用load方法对对象进行查询，查询到的对象只有在使用到的时候才会被加载
     * */
    @Test
    public void testLazyRoad(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.load(Customer.class, 1L);
        System.out.println("++++===+++++");
        System.out.println(customer.toString());
        transaction.commit();
    }
}
