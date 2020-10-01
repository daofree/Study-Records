##使用maven遇到的问题


### 最新版本3.6.3，创建工程，生成的pom，多了很多插件！新建文件没有jsp和Servlet选项,

### 设置-DarchetypeCatalog=internal
使用maven骨架插件创建maven工程的!!一般需要联网！
internal——内置的，即maven-archetype-plugin内置的archetypeCatalog文件
local——本地的，即本地~/.m2/下的archetypeCatalog文件
remote——远程的，即Maven中央仓库的archetypeCatalog文件
##
local——本地的，即本地~/.m2/下的archetypeCatalog文件
所以第三种可以不必那么麻烦，直接放在.m2文件下即可，指定为local
同时也可以指定多个来源，比如-DarchetypeCatalog=internal,local 


    再查找资料，发现Maven中的Tomcat是6.0.29,这个版本的不支持jdk1.8。我…
    不慌，加上一个插件，tomcat7…接着来！用的是tomcat7:run;
    如果继续用tomcat:run还是会使用Maven的Tomcat6;会继续出错…
https://blog.csdn.net/gaoxin_gx/article/details/100085161


## 有了pom，代码还是飘红，jar包还是无法引入！Unable to import Maven project？

后面发现好像是我用的maven版本高了我用的3.6.3，
然后下个低版本的maven。3.5.2，解决问题。


##maven一键构建，其内置tomcat插件6.0.29版本！  命令tomcat:run，默认执行的是6版本的拆件
不用本地的tomcat服务器！！
##若配置7的插件，就用命令tomcat7:run


##org.apache.jasper.JasperException: Unable to compile class for JSP:----------Apache Tomcat/6.0.29
##实质上是--解决jar包冲突问题--内置jar包与pom编译时需要的jar包冲突了，

 compile：编译范围，指 A在编译时依赖 B，此范围为默认依赖范围。编译范围的依赖会用在 编译、测试、运行，由于运行时需要所以编译范围的依赖会被打包。 
 
 provided：provided 依赖只有在当 JDK 或者一个容器已提供该依赖之后才使用， provided 依 赖在编译和测试时需要，在运行时不需要，比如：servlet api 被 tomcat 容器提供。 
 
 runtime：runtime 依赖在运行和测试系统的时候需要，但在编译的时候不需要。比如：jdbc 的驱动包。由于运行时需要所以 runtime 范围的依赖会被打包。 
 
 test：test 范围依赖 在编译和运行时都不需要，它们只有在测试编译和测试运行阶段可用， 比如：junit。由于运行时不需要所以test范围依赖不会被打包。      

 system：system 范围依赖与 provided 类似，但是你必须显式的提供一个对于本地系统中 JAR 文件的路径，需要指定 systemPath 磁盘路径，system依赖不推荐使用


##在 maven-web 工程中测试各个 scope。 
测试总结： 
     默认引入 的 jar 包 ------- compile 【默认范围 可以不写】（编译、测试、运行 都有效 ） 
     servlet-api 、jsp-api ------- provided （编译、测试 有效， 运行时无效 防止和 tomcat 下 jar 冲突）
     jdbc 驱动 jar 包 ---- runtime （测试、运行 有效 ） 
     junit ----- test （测试有效） 依赖范围由强到弱的顺序是：compile>provided>runtime>test 
    
    
    
    
    
    
    
    
    
    
    