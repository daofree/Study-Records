在maven的web工程上，整合SSM
补充目录
补充web.xml约束头

SSM框架
是spring整合MVC和Mybaties框架
+ mybaties-spring 包


一个框架/模块，开放接口给外面用。
接口设置了标准（指定实现方法）。
只要谁实现了，就可以一起玩。
自己写的类，实现三方件的接口

控制层调用业务层，引用对象没注册，不在容器里-web整合spring

启动服务器，web.xml加载配置文件.注册容器创建对象，注册对象
手动加载配置文件，创建对象 --服务器web.xml加载
数据库增删改要自己管事务session.commit()

业务层调用数据层，代理对象不在容器里，spring整合mybaties.转移mybaties的配置


SSM整个应用的Bean,都是spring管理的。



ioc容器
aop增强


