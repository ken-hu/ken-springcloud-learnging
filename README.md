# hui-base-springcloud

微服务项目骨架 SpringCloud(Greenwich.RELEASE)  
集成了springcloud-gateway + stream + rabbitmq + consul-config + tx-lcn + consul-discovery

## 注意 
SpringCloud-Greenwich分支采用了consul做服务发现和配置中心
【hui-base-springcloud-discovery】和【hui-base-springcloud-config】已经没有用处，只是为了保护项目结构。不用在意

## 介绍
SpringCloud版本是Finchley.RELEASE  
1. 【hui-base-springcloud-api-gateway】网关（zuul）
2. 【hui-base-springcloud-common】通用包
3. 【hui-base-springcloud-order】微服务demo（order-server）
4. 【hui-base-springcloud-product】微服务demo（product-server）
5. 【hui-base-springcloud-tx-lcn】分布式事务管理器(tx-lcn-server)

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
3. springcloud版本为Greenwich.RELEASE
4. 服务发现采用了Eureka
5. 配置中心采用了spring-cloud-starter-consul-config
6. 网关采用springcloiud-gateway
7. 分布式事务处理增加tx-lcn（同步分布式事务解决方案）

## 使用教程

1. 起RabbitMQ,Redis
2. 安装consul（windows/centos） consul agent -dev 启动consul服务
3. 启用LcnServerApplication
4. 启用OrderApplication
5. 启用ProductApplication
6. 初始化数据库使用 SQL/init_table.sql 
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