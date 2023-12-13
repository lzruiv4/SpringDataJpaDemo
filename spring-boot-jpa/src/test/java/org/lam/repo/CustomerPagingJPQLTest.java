package org.lam.repo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.lam.repositories.CustomerPagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerPagingJPQLTest {

    @Autowired
    CustomerPagingRepository repo;
//
//    @Test
//    public void testReadWithNative() {
//        System.out.println(repo.findCustomerByNameWithNative("LL"));
//    }

//    @Test
//    public void testRead() {
//        System.out.println(repo.updateByName("LL", "TEST_ADDRESS"));
//    }
}
