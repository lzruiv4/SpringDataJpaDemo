package org.lam.repositories;

import org.lam.pojo.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CustomerPagingRepository extends PagingAndSortingRepository<Customer, UUID> {
//
//    @Query(value = "select * from customers where cName =:cName", nativeQuery = true)
//    Optional<Customer> findCustomerByNameWithNative(@Param("cName") String customerName);

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE customer c SET c.cAddress=:newAddress WHERE c.cName =:cName", nativeQuery = true)
//    int updateByName(@Param("cName") String cName, @Param("newName") String newAddress);

}
