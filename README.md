# spring_security_demo

#### 介绍
jwt+springsecurity+springboot的验证登陆系统，其中有防止sql注入和xss攻击过滤的过滤器 这里的jwt简单使用jws实现 基于jjwt 以后会基于其他工具实现jwe jwk等 可直接用于用户登陆系统或二次开发.内置了redis的二级缓存功能,暂未启用.针对前端vue的管理系统也进行了部分适配.

#### 软件架构
##### springboot

##### jwt

jwt使用最简单的加密,这里的jwt简单使用jws实现 基于jjwt 以后其他项目可能会基于其他工具实现jwe jwk等 

##### redis

有二级缓存的配置,暂未启用,项目速度较快,不太需要

##### mybatis-plus

这个工具还挺好用的

##### swagger

master分支已升级到knife4j版本,页面比较友好,这里就不动了

##### mysql


#### 安装教程

1.  maven import就行,分支选择dev_vue,第一次启动需要在mysql建数据库,然后把yml文件的注释开放,会自己建表

#### 使用说明



