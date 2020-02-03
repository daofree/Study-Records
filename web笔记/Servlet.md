## Servlet：  server applet
	* 概念：运行在服务器端的小程序
	  遵守（规则==接口）==Servlet
		* Servlet就是一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则。
		* 将来我们自定义一个类，实现Servlet接口，复写方法。tomcat就可以识别。
		这个类称为Servlet。


	* 快速入门：
		1. 创建JavaEE项目，以前Java项目，就不行了。
		2. 定义一个类，实现Servlet接口
			* public class ServletDemo1 implements Servlet
		3. 实现接口中的5个抽象方法
##		4. 配置Servlet，映射资源名（/demo1），配置全类名路径	
			 在web.xml中配置：
		    <!--配置Servlet -->
		    <servlet>
		        <servlet-name>demo1</servlet-name>
		        <servlet-class>cn.daofree.web.servlet.ServletDemo1</servlet-class>
		    </servlet>
		
		    <servlet-mapping>
		        <servlet-name>demo1</servlet-name>
		        <url-pattern>/demo1</url-pattern>
		    </servlet-mapping>
#发现：定义了一个类，没有创建对象，也没有调用方法，居然自己被执行了

#	* 执行原理：反射,对象创建，方法调用都是服务器执行的，servlet依赖web容器
		1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
		2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
		3. 如果有，则在找到对应的<servlet-class>全类名
#看到全类名，在配置中，第一件事想到反射
		4. tomcat会将字节码文件加载进内存Class.forName(全类名)，并且创建其对象cls.newInstance();
		5. 调用其方法---如service().
