https://blog.csdn.net/Nidson_IT/article/details/79381033

web容器（tomcat/jboss/weblogic/websphere/jetty/resin）


支持java的web服务器--tomcat
通过它我们可以很方便地接收和返回到请求（如果不用Tomcat，那我们需要自己写Socket来接收和返回请求）。

web工程需要tomcat
servlet server


web项目怎么创建？servlet？tomcat怎么搞？


本地创建的web项目开发完，打成war包给tomcat，放在webapps下面，就可以了

独立的Tomcat可以部署多个War，这是优势。今天这个优势没了


war模式：将web工程以war包的形式上传到服务器
war exploed模式：将web工程以当前文件夹的位置关系上传到服务器


    Java定义了与什么链接交互的接口，然后数据库，tomcat实现了这个接口！

    要想使用tomcat，就必须符合他的要求，格式，实现类
    函数式接口，我们实现...我们是怎么用filter的
    
    其实这就是
###      J2EE的十三种技术规范

##   选什么技术（规范），用什么能力，
    就实现什么接口，用什么jar包，实现什么功能！驱动类就是实现类。JDBC就是面向接口开发思想

https://zhuanlan.zhihu.com/p/88584198


tomcat启动问题！
Tomcat 问题：tomcat 有很多种启动方式，一种通过 startup.sh 启动。
另一种是写一个 Java文件 import 进入tomcat包，实例化一个类，然后启动 tomcat. 
你问题 springboot 就是这样启动的。感兴趣可以下载 tomcat 源码，顺着startup.sh一路看下去，就能明白了。







参考链接：https://www.zhihu.com/question/354071128/answer/944804846


tomcat官网版本https://tomcat.apache.org/
Core
Full documentation:
Deployer
Embedded 嵌入  bed(河) 床   给springboot 使用的

这是大佬
https://www.zhihu.com/people/netkiller


Servlet对象 有自己配置信息对象ServletConfig 还有容器环境对象ServletContext--获取整个web.xml里的配置信息

Tomcat创建了许多对象，Servlet对象，ServletConfig对象，ServletContext对象，请求，响应
