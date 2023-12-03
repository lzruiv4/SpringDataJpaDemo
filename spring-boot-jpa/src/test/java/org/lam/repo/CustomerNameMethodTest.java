package org.lam.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lam.config.ApplicationConfig;
import org.lam.pojo.Customer;
import org.lam.repositories.CustomerNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@ContextConfiguration(classes = ApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerNameMethodTest {

    @Autowired
    CustomerNameRepository repository;

    @Test
    public void testFindByName() {
        List<Customer> customerList = repository.findByCustomerName("Lin");
        System.out.println(customerList.size());
    }

    @Test
    public void testLike() {
        List<Customer> list = repository.findByCustomerNameLike("L%");  //模糊查询%
        System.out.println(list.size());
    }

//    @Test
//    public void testDeleteNullAddress() {
//        System.out.println(repository.deleteCustomersByCustomerAddressNull());
//    }
}
