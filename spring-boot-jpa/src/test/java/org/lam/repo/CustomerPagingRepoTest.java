package org.lam.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lam.config.ApplicationConfig;
import org.lam.pojo.Customer;
import org.lam.repositories.CustomerPagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = ApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerPagingRepoTest {

    @Autowired
    CustomerPagingRepository customerPagingRepository;

    @Test
    public void testPagingFindAll() {
        Page<Customer> page = customerPagingRepository.findAll(PageRequest.of(0, 5));
        System.out.println("Page size: " + page.getSize());
        System.out.println("Customers: " + page.getContent());
        System.out.println("All：" + page.getContent().size());
    }

    @Test
    public void testSort() {
        // Sort sort = Sort.by("customerId").descending();

        // 使用属性
        Sort.TypedSort<Customer> sortType = Sort.sort(Customer.class);
        Sort sort = sortType.by(Customer::getCustomerId).descending();

        Iterable<Customer> all = customerPagingRepository.findAll(sort);
        System.out.println(all);
    }
}
