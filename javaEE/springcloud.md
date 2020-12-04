sprigCloud微服务（RPC架构的实现） = rest服务（核心技术）
从分布式开始

分布式集群
    web集群（多用户并发访问）
    业务中心
    数据库集群


微服务地址多，需要统一管理（Eurake比zk更好）
web端可以实现负载均衡，业务端怎么办？需要实现负载均衡的，在eurake中注册
注册中心注册微服务（微服务太多了）
客户端找注册中心就行了Eurake（物业管理，服务公司登记注册，controller找物业管理获取使用）

多业务端-负载均衡靠Ribbon
调用地址不如接口，fegin可以伪造接口，通过接口访问 

    微服务之间互相调用,遇到网络故障，机房断电，系统死机某个服务崩了，会出现什么情况？
        雪崩效应，调用链上一个接一个崩了。
        为了防止雪崩，Hystrix熔断服务来了。每个微服务都搞一个熔断处理。方法可用，返回的内容是错误的
 
Zuul代理--路径映射，路由规则（解决名称过多，名称改变问题。若改名，工作量大，维护问题）
    体现键值思想，也可以进行名称隐藏

    不可避免的配置文件！yml/properties。每个微服务都有配置文件，HA机制，负载均衡，独立的数据库等。成千上百个配置，咋整？
        SpringCloudConfig组件-配置中心。控制所有配置文件（连接github），一改全改，便于维护。
 
springBoot快速开发单个服务个体
springCloud管理这些单个个体，为它们提供配置路由等服务！全局服务治理
springcloud必须依赖springBoot，但springBoot可以独立使用




微服务，生产者消费者案例

生产者，业务层调用dao，生产即可（返回json就行了）
@RestController = @Controllet + @ResponseBody
返回json串


controller是消费者只管消费，不管生产，不找业务，和service没关系，不应该有service层
@Autowired
private RestTemplate re;  同 JDBCTemplate

RestTemplate提供了多种便捷访问远程Http服务的方法， 
是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集



https://www.zhihu.com/question/65502802

    restful了解
        REST确实不是标准，只是设计风格，目的只是让url看起来更简洁实用，是资源状态的一种表达。
        https://www.cnblogs.com/wmyskxz/p/9104368.html
        https://www.runoob.com/w3cnote/restful-architecture.html
        https://zhuanlan.zhihu.com/p/97761256
        https://zhuanlan.zhihu.com/p/136270398

https://www.cnblogs.com/edisonchou/p/java_spring_cloud_foundation_sample_list.html

        