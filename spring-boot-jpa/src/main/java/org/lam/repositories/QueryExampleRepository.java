package org.lam.repositories;

import org.lam.pojo.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface QueryExampleRepository
        extends PagingAndSortingRepository<Customer, UUID>,
                QueryByExampleExecutor<Customer> {

    /**
     * Query by Example
     *
     *  1. 只支持查询
     *      1.1 不支持嵌套或分组的属性约束，如 firstName = "Yi" && lastName = "Lin"
     *      1.2 只支持字符串 start / contains / ends / regex 匹配和其他属性的精确匹配
     * */

}
