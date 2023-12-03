package org.lam.pojo;


import javax.persistence.*;

@Entity     //hibernate 实体类
@Table(name = "HCustomers")   //映射的表名
public class Customer {
    /**
     * @Id: 声明主键的配置
     * @GenerateValue： 配置主键生成的策略
     *      strategy
     *          GenerationType.IDENTITY : 自增。 mysql
     *              -> 底层数据库必须支持自动增长（底层数据库支持的自动增长方式，id自增）
     *          GenerationType.SEQUENCE : 序列， oracle
     *              -> 底层数据库必须支持序列
     *          GenerationType.TABLE : jpa 提供的一种机制，通过一张数据库表的形式帮助我们完成
     *          GenerationType.AUTO : 由程序自动的帮助我们选择主键生成策略
     *
     * @Column: 配置属性和字段的映射关系
     *      name: 数据库表中字段的名称
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long customer_id;

    @Column(name = "name")
    private String customer_name;

    @Column(name = "address")
    private String customer_address;

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
}
