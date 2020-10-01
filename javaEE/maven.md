jar包多，又遇到冲突
文件多 一个一个编译
单元测试发现bug
整合资源打包卖

减少项目空间，增加仓库空间（1个仓库大家用）
编译运行时，通过配置文件自己找！ 依赖管理
一键构建mvn:tomcat run
 
 本地 -联网- 中央
 本地 - b2b远程/私服 自己上传/<-联网- 中央
 

核心代码 维护升级需要复打包
配置文件
测试代码
测试配置

maven 标准目录

src/main/java
src/main/resources
src/test/java
src/test/resources
        --maven Java工程
src/main/webapp(web-info-->classes+lib)   js css 图片 页面资源
            
        --maven Web工程
        打包后都在web-inf/classes里面,webapp里面就是最后打包目录
        
mvn之前 只有src目录

命令 --层层递进--清理生命周期 + 默认生命周期 + 站点...用的少
mvn clean 删除target(内含每个人项目本地编译信息。清除别人的项目编译信息) 

mvn compile ->target/classes 

mvn test ->target/test-classes

mvn package ->target/*.war..

mvn install 走全程/并把包安装到本地仓库

mvn deploy 发布--需要配置才能执行

mvn clean install -Dmaven.test.skip

使用内置tomcat运行
mvn tomcat:run
mvn tomcat7:run


target 不包含 main/java路径

依赖管理（直接+间接，帮助解决传递依赖问题）--依赖管理声明不引入jar包 <dependencyManagement>
pom.xml项目对象模型
项目自身信息
依赖信息 -- 依赖管理模型--g公司组织a项目v
运行环境信息build插件jar包参数信息


一键构建--不用本地，mvn用自己的插件
每个生命周期 构建命令对应一个插件

根据archetype创建maven项目会从网络下载catalog文件
maven提供的骨架不联网也能用 
-DarchetypeCatalog=internal

mvn -java工程骨架创建的工程，目录不完整
手动补齐目录
web骨架少3个目录，自己补齐，设置资源目录

IDEA中资源文件夹 与 普通文件夹是不同的

导入tomcat中的jar,与插件冲突
<scope>provided</scope>
写代码时起作用，项目运行时用插件里的


注意： 内置默认tomcat6版本兼容报错


maven 自身用tomcat插件时tomcat6
使用其他版本，需要自己在pom.xml里配置

创建maven工程就可以用maven跑起来

https://gitee.com/daofree/mysql_maven


本地-远程-镜像->中央仓库没有收录的三方件，必须安装/上传到仓库。直接是放不行的
maven - 所有依赖不上仓库不能用!
约定大于配置！

maven使用的jar--叫插件，也就是jar包，可以完成某些功能，执行maven命令，干完活还移动！

我们使用的jar--就是三方件jar包

继承 聚合（拆分）

web 的 maven项目怎么启动运行的？
把项目放到tomcat里

tomcat:run 与 IDEA配置的独立的tomcat??
    黑马用tomcat:run
    动力节点用IDEA配置的独立的tomcat
        配置时候遇到war exploed问题！？
    war模式：将web工程以war包的形式上传到服务器
    war exploed模式：将web工程以当前文件夹的位置关系上传到服务器



web项目结构创建完成，想做web开发？servlet?jsp？
以前要在项目中加tomcat...?
用了maven，在pom里配置servlet依赖，jsp依赖就行了

downloding??
    maven的各种操作执行 需要 许多插件完成的
    每个插件干了啥，控制台日志上有。移动资源，编译class，删除文件。。。
    
    maven自带tomcat插件
    
    
mvn 在pom文件位置，mvn tomcat:run，就可以启动项目运行起来
没打包，也没找独立的tomcat的webapps
    使用mvn运行，比本地tomcat运行更方便
    
参考
tomcat7:deploy	部署一个web war包
tomcat7:reload	重新加载web war包
tomcat7:start启动tomcat
tomcat7:stop停止tomcat
tomcat7:undeploy
停止一个war包
tomcat7:run	启动嵌入式tomcat ，并运行当前项目  



很多时候spring的pom.xml中会添加tomcat插件，这个时候可以使用spring的内嵌tomcat
？？spring也有tomcat??



指定端口运行
mvn clean -Dmaven.tomcat.port=8181 tomcat:run

##  一个干一个
springboot默认带有tomcat和maven？
springboot 没有自带maven
Spring Boot没有内置Maven,感觉Spring Boot内置了Maven的，应该是用
start.spring.io(Spring Initializr)生成了Spring Boot应用骨架，下载的Zip包里有Maven Wrapper。

独立的Tomcat可以部署多个War，这是优势。
但是现在很少这样用了！
现在不管是一个云虚拟主机，还是一个Dock容器，里面只会跑一个Web应用,
没有一个Tomcat里部署多个Web应用的场景需求!

用内置的方便啊。区别在于，内置的设置tomcat参数就是配置文件方式，或者代码方式！


一个管理jar包的工具

属性设置
全局变量
 resources里面的文件会打到target/classes里面。
 但src/main/java里的资源文件，没人处理，没人移动，怎么办？
 需要配置资源插件！打包时一起移动
 
 
 
 打包时mvn约定的目录都消失了，mvn约定目录是给各种插件定位使用的！
 
 
 冲突解决：
 优先指定，位置/距离
 exclude
 
 
 工程是独立的，只能使用自己内部资源
 模块是属于父工程的，父工程所有资源都可以使用！子模块之间天生没关系！后天可以建立依赖
 父子继承，兄弟依赖。兄弟依赖，也得从本地仓库走！不上仓库不能用!
 
 传递下来的包是否能用？看红不红
 
 <packaging>war/jar/pom/...</packaging>
 web工程/java工程/父工程
 
 继承，子module里的<parent>
 聚合，父project里的<modules>