package org.lam.repositories;

import jakarta.transaction.Transactional;
import org.lam.pojo.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerNameRepository extends PagingAndSortingRepository<Customer, UUID> {

    List<Customer> findByCustomerName(String customerName);

    List<Customer> findByCustomerNameLike(String name);

    @Transactional
    @Modifying
    Boolean deleteCustomersByCustomerAddressNull();
}
