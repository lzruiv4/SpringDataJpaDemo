package org.lam.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lam.config.ApplicationConfig;
import org.lam.pojo.Customer;
import org.lam.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


//@ContextConfiguration(classes = ApplicationConfig.class)   //基于junit4 spring 单元测试，这里记得spring.xml前面有一个斜杆
@ContextConfiguration("/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerSpringDataJpaTest {


    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testCreate(){
        Customer customerToBeCreate = new Customer();
        customerToBeCreate.setCustomerName("Lin");
        // save方法会保存实体类，并返回实体类
        Customer customer = customerRepository.save(customerToBeCreate);
        System.out.println(customer.getCustomerId());
    }

    @Test
    public void testRead() {
        Optional<Customer> customer = customerRepository.findById(UUID.fromString("5a63a36d-4c01-4b43-8943-74552fa7be3b"));

        System.out.println(customer.get().getCustomerName());
    }

//    @Test
//    public void testFindAll() {
//        Optional<Customer> customers = customerRepository.findAll().iterator(new Customer());
//    }


    @Test
    public void testSaveAll() {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setCustomerName("W");
        customers.add(customer1);
        Customer customer2 = new Customer();
        customer2.setCustomerName("L");
        customers.add(customer2);

        System.out.println(customerRepository.saveAll(customers));
    }


}
