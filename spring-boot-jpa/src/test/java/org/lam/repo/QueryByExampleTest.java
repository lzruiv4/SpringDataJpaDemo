package org.lam.repo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.lam.config.ApplicationConfig;
import org.lam.pojo.Customer;
import org.lam.repositories.QueryExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = ApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryByExampleTest {

    @Autowired
    QueryExampleRepository repo;

    @Test
    public void testQuery() {
        // 查询条件
        Customer customer = new Customer();
        customer.setCustomerName("Lin");
        customer.setCustomerAddress("koeln");

        // 可以通过添加匹配器来进行忽略或者更细致的查询
        ExampleMatcher matcher = ExampleMatcher
                                .matching()
                                .withIgnorePaths("customerName")
                                .withIgnoreCase("customerName");   // 设置忽略的属性
        Example<Customer> example = Example.of(customer, matcher);

        List<Customer> customers = (List<Customer>) repo.findAll(example);

        System.out.println(customers);
     }
}
