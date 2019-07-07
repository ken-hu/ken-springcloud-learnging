# hui-base-springcloud
微服务项目骨架 SpringCloud(Finchley.RELEASE)  
集成了zuul + stream + rabbitmq + config-server + tx-lcn + eureka 

## 介绍
SpringCloud版本是Finchley.RELEASE  

1. 【hui-base-springcloud-api-gateway】网关（zuul）
2. 【ui-base-springcloud-common】通用包
3. 【hui-base-springcloud-config】配置中心(confg-server)
4. 【hui-base-springcloud-eureka】服务发现(eureka)
5. 【hui-base-springcloud-order】微服务demo（order-server）
6. 【hui-base-springcloud-product】微服务demo（product-server）
7. 【hui-base-springcloud-tx-lcn】分布式事务管理器(tx-lcn-server)

## 项目结构
├─hui-base-springcloud  
  ├─hui-base-springcloud-api-gateway  
  ├─hui-base-springcloud-common  
  ├─hui-base-springcloud-config  
  ├─hui-base-springcloud-eureka  
  ├─hui-base-springcloud-order  
  │  ├─hui-base-springcloud-order-model  
  │  ├─hui-base-springcloud-order-rest  
  │  └─hui-base-springcloud-order-service  
  ├─hui-base-springcloud-product  
  |  ├─hui-base-springcloud-product-model  
  |  ├─hui-base-springcloud-product-rest  
  |  └─hui-base-springcloud-product-service  
  └─hui-base-springcloud-tx-lcn 


## 软件架构
软件架构说明
1. 该项目是基于springcloud的微服务项目骨架
2. 除了tx-lcn外基本都采用了spring的框架，所有的package都可以从maven仓库下载
3. springcloud版本为Finchley.RELEASE
4. 服务发现采用了Eureka
5. 配置中心采用了springcloud-starter-config
6. 网关采用springcloiud-zuul
7. 分布式事务处理增加tx-lcn（同步分布式事务解决方案）
8. 初始化数据库使用 SQL/init_table.sql 

## 使用教程
0. 起RabbitMQ,Redis
1. 启用EurekaApplication
2. 启用ConfigApplication（可以不启动）
3. 启用ZuulApplication（可以不启动）
4. 启用LcnServerApplication
5. 启用OrderApplication
6. 启用ProductApplication

## 使用说明
使用github的config仓库作为配置中心  
https://github.com/ithuhui/hui-base-springcloud-config-repo

bootstrap.yml里面有不使用配置中心的版本  

测试lcn可调用 order-server/clientController 的 testTCC&testTXC

## Author
```
 作者：HuHui
 转载：欢迎一起讨论web和大数据问题,转载请注明作者和原文链接，感谢
```
