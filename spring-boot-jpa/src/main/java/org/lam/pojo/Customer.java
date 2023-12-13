package org.lam.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Entity     //hibernate 实体类
@Table(name = "customers")   //映射的表名
@Data
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
     *      name: 数据库表中字段的名称xs
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cId")
    private UUID customerId;

    @Column(name = "cName")
    private String customerName;

    @Column(name = "cAddress")
    private String customerAddress;

    /**
     * @cascade： 有几个枚举值
     *      ALL       -->  所有持久化操作
     *      PERSIST   -->  保存的时候
     *      MERGE     -->  修改的时候
     *      REMOVE    -->  删除的时候
     *
     *  @fetch：  有两种方式
     *      LAZY  --> 懒加载
     *      EAGER  --> 即刻
     *
     * @orphanRemoal:  关联的时候删除，默认为false
     *      true  -->  设置为true的时候，当一方的数据被删除了，另一方也会被删除
     *      false -->  只会删除要删除的一方，另一方不会被删除
     *
     * @optional: 限制关联的对象不能为null
     *      true   -->   可以为null  默认
     *      false  -->   不可以为null
     *
     * 当设置双向连接后，无法同时删除其中的数据，此时要么将其中一方的外键删除，在进行删除。
     * 或者使用@mappedBy
     * @mappedBy:  一般设置在被放弃一方，等于对方的属性名
     * */
    /****/
//    @OneToOne(cascade = CascadeType.ALL,
//              fetch = FetchType.LAZY,
//              orphanRemoval = true,
//              optional = true)
//    @JoinColumn(name = "account")
//    private Account account;
}
