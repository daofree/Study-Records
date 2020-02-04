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
##		4. 配置Servlet，映射资源名（/demo1），配置全类名路径(资源)	
#			 在web.xml中配置：写一个servlet,配置一个！。。。多！
		    <!--配置Servlet -->
		    <servlet>
		        <servlet-name>demo1</servlet-name>
		        <servlet-class>cn.daofree.web.servlet.ServletDemo1</servlet-class>
		    </servlet>
		
		    <servlet-mapping>
		        <servlet-name>demo1</servlet-name>
		        <url-pattern>/demo1</url-pattern>
		    </servlet-mapping>
#发现：定义了一个类，没有创建对象，也没有调用方法，居然自己被执行了？原理反射

#	* 执行原理：反射,对象创建，方法调用都是服务器执行的，servlet依赖web容器
		1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
		2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
		3. 如果有，则在找到对应的<servlet-class>全类名
#看到全类名，在配置中，第一件事想到反射
		4. tomcat会将字节码文件加载进内存Class.forName(全类名)，并且创建其对象cls.newInstance();
		5. 调用其方法---如service().

#	* Servlet中的方法及生命周期：
		1. 被创建：执行init方法，只执行一次
###			* Servlet什么时候被创建？ 访问？启动？
				* 默认情况下，第一次被访问时，Servlet被创建
				* 可以配置执行Servlet的创建时机。(值默认-1)
					* 在<servlet>标签下配置
						1. 第一次被访问时，创建
	                		* <load-on-startup>的值为负数
			            2. 在服务器启动时，创建
			                * <load-on-startup>的值为0或正整数
## init方法,加载资源多时或者执行前需要依赖其他servlet。

		* Servlet的init方法，从头到尾只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
			* 多个用户同时访问时，可能存在线程安全问题。
				* 解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，也不要对修改值。里面方法不被共享

		2. 提供服务：执行service方法，执行多次
			* 每次访问Servlet时，Service方法都会被调用一次。
			
		3. 被销毁：执行destroy方法，只执行一次
			* Servlet被销毁时执行。服务器关闭时，Servlet被销毁。
			* 只有服务器正常关闭时，才会执行destroy方法。
			* destroy方法在Servlet被销毁之前执行，一般用于释放资源
			
##  * Servlet3.0：javaEE 6之后支持
		* 好处：
			* 支持注解配置。可以不需要web.xml（多次配置，烦）了。

		* 步骤：
			1. 创建JavaEE项目，选择Servlet的版本3.0以上，可以不创建web.xml
			2. 定义一个类，实现Servlet接口
			3. 复写方法
			4. 在类上使用@WebServlet注解，进行配置
				* @WebServlet("资源路径")
				* (urlPatterns = "/demo")
				* (value = "/demo2")
				* ("/demo3")
##          注解说明WebServlet
                @Target({ElementType.TYPE})
				@Retention(RetentionPolicy.RUNTIME)
				@Documented
				public @interface WebServlet {
				    String name() default "";//相当于<Servlet-name>
				    String[] value() default {};//代表urlPatterns()属性配置
				    String[] urlPatterns() default {};//相当于<url-pattern>				
				    int loadOnStartup() default -1;//相当于<load-on-startup>				
				    WebInitParam[] initParams() default {};				
				    boolean asyncSupported() default false;				
				    String smallIcon() default "";				
				    String largeIcon() default "";				
				    String description() default "";				
				    String displayName() default "";
				}

###注：虚拟目录是项目的访问方式

## IDEA与tomcat的相关配置
	1. IDEA会为每一个tomcat部署的项目单独建立一份配置文件
		* 查看控制台启动日志的log：
IDEA单独配置当前项目的配置文件
##      Using CATALINA_BASE:   "C:\Users\lenovo\.IntelliJIdea2018.3\system\tomcat\_Study-Records"
#   项目存放路径位置：docBase="D:\IdeaProjects\Study-Records\out\artifacts\day13_servlet_war_exploded" />
#   源码路径位置：工作空间web项目

#	2. 工作空间web项目(源码)    和     tomcat部署的web项目(out)
		* tomcat真正访问的是“tomcat部署的web项目”，
##		* "tomcat部署的web项目"对应着"工作空间项目" 的web目录下的所有资源
##		（WEB-INF下的）classes（字节码）下的文件来源于src（源码）下的。
		* WEB-INF目录下的资源不能被浏览器直接访问。
		现在不要在里面放资源，但有其他技术可以访问
		
#	3. Javaweb的tomcat断点调试：使用"小虫子"启动 dubug 启动
	
