package org.lam.pojo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.lam.config.ApplicationConfig;
import org.lam.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@ContextConfiguration(classes = ApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class tableTest {

    @Autowired
    CustomerRepository repo;

    @Test
    public void testCreate() {
        Customer customer = new Customer();
        customer.setCustomerName("Lin");
        customer.setCustomerAddress("SWA");
//        customer.setCustomerId(UUID.fromString("TEST_ID"));

        Account account = new Account();
        account.setState(90.99);

        //customer.setAccount(account);

        repo.save(customer);
    }

    @Test
    /**
     * 为什么懒加载要配置事务？
     * 当通过repo调用查询方法时， session就会立即关闭，一旦session关闭就不能在查询
     * 添加了 @Transactional 后， 会在事务方法执行完后，才会结束
     * */
    @Transactional(readOnly = true) //搭配懒加载使用
    public void testOneToOneRead() {
        System.out.println(repo.findById(UUID.fromString("TEST_ID")));
    }

    @Test
    public void testOneToOneDelete() {
        Customer customer = new Customer();
        customer.setCustomerId(UUID.fromString("cc704931-a42c-4fcb-9a7f-d3aeecf5a3a0"));
        repo.delete(customer);
    }

    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setCustomerId(UUID.fromString("cc704931-a42c-4fcb-9a7f-d3aeecf5a3a0"));
        customer.setCustomerAddress("oooo");
        customer.setCustomerName("test");
        Account account = new Account();
        account.setState(99999.99);
        //customer.setAccount(account);

        repo.save(customer);
    }
}
