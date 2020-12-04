对spring进行封装。快速使用spring

https://zhuanlan.zhihu.com/p/59663308

学习Spring Boot开发不需要安装Tomcat、Maven和数据库
Wrapper包装
https://start.spring.io/

嵌入式的特点，轻量级，仅仅是一个jar包（插件）


问题：
    java复杂度高，维护难
    云时代要求快速部署快速启动
    随着技术的整合AQ,MQ.redis,shiro,Druid等集成，spring的配置越来越重。
    依赖管理耗时耗力
    
核心功能--框架整合已经做好了
    起步依赖(以功能为单位，版本控制直接做好了)
        maven依赖以功能为单位！
        主包引导类@SpringBootApplication
        子包在主包下
    自动装配
        
没有@ResponseBody，以为返回的是return ""的页面，就是跳转！
加了就是rest结构


只要jdk,不需要其他容器！内部自带

@RestController = @Controllet + @ResponseBody
返回json串
            