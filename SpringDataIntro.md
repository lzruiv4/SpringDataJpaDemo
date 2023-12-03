# 什么是JPA？

## 相同处

    1. 都跟数据库操作有关，JPA是JDBC的升华，升级
    2. JDBC 和 JPA 都是一组规范接口
    3. 都是由SUN公司推出

## 不同处
    
    1. JDBC是由各个关系型数据库实现的，JPA是由ORM框架实现
    2. JDBC使用SQL语句和数据库通信。JPA用面向对象方式，
        通过ORM框架来生成SQL，进行操作
    3. JPA在JDBC之上，JPA要依赖 JDBC 才能操作数据库

