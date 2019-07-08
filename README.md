[TOC]

# hui-base-springcloud

微服务项目骨架，集成各种组件。该项目为了快速开发和备忘创建。

## 开发环境

- JDK1.8
- IDEA
- Maven
- Git
- Redis
- RabbitMQ

## Branches

- `master`  融合最新分支  
- `springcloud-finchley` Finchley.RELEASE
- `springcloud-greenwich` Greenwich.RELEASE

|         branche         | springcloud-version |                       note                        |
| :---------------------: | :-----------------: | :-----------------------------------------------: |
|        `master`         |  Greenwich.RELEASE  |                   融合最新分支                    |
| `springcloud-greenwich` |  Greenwich.RELEASE  | 使用consul替换了eureka和config，用gateway替代zuul |
| `springcloud-finchley`  |  Finchley.RELEASE   |            集成了springcloud大部分组件            |



## 项目结构

├─hui-base-springcloud  
  ├─hui-base-springcloud-api-gateway  （网关中心）  
  ├─hui-base-springcloud-common （通用工具包）   
  ├─hui-base-springcloud-config （finchley版本是配置中心）  
  ├─hui-base-springcloud-eureka（finchley版本是注册中心）  
  ├─hui-base-springcloud-order (demo1:order-service)  
  │  ├─hui-base-springcloud-order-model  
  │  ├─hui-base-springcloud-order-rest  
  │  └─hui-base-springcloud-order-service  
  ├─hui-base-springcloud-product  (demo2:product-service)  
  |  ├─hui-base-springcloud-product-model  
  |  ├─hui-base-springcloud-product-rest  
  |  └─hui-base-springcloud-product-service  
  └─hui-base-springcloud-tx-lcn （分布式事务管理器中心）  

## 软件架构

1. 该项目是基于springcloud的微服务项目骨架
2. 除了tx-lcn外基本都采用了spring的框架，所有的package都可以从maven仓库下载
3. springcloud版本为Greenwich.RELEASE
4. 服务发现采用了Eureka
5. 配置中心采用了spring-cloud-starter-consul-config
6. 网关采用springcloiud-gateway
7. 分布式事务处理增加tx-lcn（同步分布式事务解决方案）

## 启动教程

### 0.初始化数据库

SQL/init_table.sql

### 1. 基础服务

|   service    | service-name | port |          Note           |
| :----------: | :----------: | :--: | :---------------------: |
| 关系型数据库 |    mysql     | 3306 | 开发的时候使用了5.6版本 |
| NOSQL数据库  |    redis     | 6379 |  供TX-LCN-MANAGER使用   |
|   消息队列   |   RabbitMQ   | 5672 |  提供给MQ和Stream组件   |

### 2.系统服务

|     service      | service-name（Greenwich/Finchley） |             features             | note |
| :--------------: | :--------------------------------: | :------------------------------: | :--: |
|     注册中心     |           Consul/Eureka            |     注册中心，服务发现和治理     |      |
|     配置中心     |      Consul/ConfigApplication      | 配置中心，动态获取配置，灵活配置 |      |
| 分布式事务TX-LCN |        LcnServerApplication        |                                  |      |
|     网关中心     |         GatewayApplication         |      网关中心，配置路由映射      |      |
|   微服务DEMO1    |          OrderApplication          |                                  |      |
|   微服务DEMO2    |         ProductApplication         |                                  |      |



## 服务集成

| 功能特性 | 功能服务 |       对应分支        |      技术选型       | 进度 | 备注 |
| :------: | :------: | :-------------------: | :-----------------: | :--: | :--: |
|          | 注册中心 | springcloud-greenwich |       Eureka        |  √   |      |
|          | 配置中心 | springcloud-greenwich | SpringCloud-Config  |  √   |      |
|          | 网关中心 | springcloud-greenwich | SpringCloud-Gateway |  √   |      |
|          | 服务调用 | springcloud-greenwich |      OpenFeign      |  √   |      |
|          | 注册中心 | springcloud-finchley  |       Consul        |  √   |      |
|          | 配置中心 | springcloud-finchley  |       Consul        |  √   |      |
|          | 网关中心 | springcloud-finchley  |        Zuul         |  √   |      |
|          | 服务监控 |          ALL          |  SpringBoot Admin   |  ×   |      |
|          | 链路追踪 |          ALL          |                     |  ×   |      |
|          | 文档管理 |          ALL          |      Swagger2       |  √   |      |
|          | 日志管理 |                       |                     |  ×   |      |





## 使用说明

使用github的config仓库作为配置中心  
https://github.com/ithuhui/hui-base-springcloud-config-repo

## Author

```
 作者：HuHui
 转载：欢迎一起讨论web和大数据问题,转载请注明作者和原文链接，感谢
```
