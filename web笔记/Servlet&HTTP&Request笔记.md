# 今日内容：
	1. Servlet
	2. HTTP协议
	3. Request


## Servlet：
	1. 概念
	2. 步骤
	3. 执行原理
	4. 生命周期
	5. Servlet3.0 注解配置
	
	一次继承5个方法--自己实现，烦！有别人实现吗？
	
#	6. Servlet的体系结构	，自己实现Servlet，烦！有别人实现吗？
		Servlet -- 接口
			|
		GenericServlet -- 抽象类
			|
		HttpServlet  -- 抽象类

#		* GenericServlet：将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象（继承只需实现它）
			* 将来定义Servlet类时，可以继承GenericServlet，可仅实现一个service()方法即可

#		* HttpServlet：对http协议的一种封装，简化操作
			1. 定义类继承HttpServlet
			2. 复写doGet/doPost方法，(HttpServlet里的service()会判断get or post然后分发的)
	通过浏览器地址栏参数请求是，get方式
	
#	7. Servlet相关配置（web.xml与注解）
    		1. urlpartten:Servlet访问路径
    			1. 一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
####    			2. 资源路径定义规则： 注意：/*优先级最低，找不到了才找/*	
    				1. /xxx：路径匹配
    				2. /xxx/xxx:多层路径，目录结构
    				3. *.do：扩展名匹配
    			


## HTTP：
	* 概念：Hyper Text Transfer Protocol 超文本传输协议
		* 传输协议：定义了，客户端和服务器端通信时，发送数据的格式（才能完成解析动作）
		* 特点：
			1. 基于TCP/IP的高级协议
			2. 默认端口号:80
			3. 基于请求/响应模型的:一次请求对应一次响应
			4. 无状态的：每次请求之间相互独立，不能交互数据

		* 历史版本：每一个资源（图片等）都是一个请求。
			* 1.0：每一次请求响应都会建立新的连接。不断断连！耗时耗资源！
			* 1.1：复用连接。传完一个，等一会，有数据在发送，默认刚才那个链接。没了，就断开。
			    节约资源，提升速度。还有缓存优势
##数据的格式			    
# * 请求消息数据格式：行头空体（火狐浏览器有原始头）
		1. 请求行
			请求方式 请求url 请求协议/版本
			GET /login.html	HTTP/1.1

			* 请求方式：
				* HTTP协议有7中请求方式，常用的有2种
					* GET：
						1. 请求参数位置在请求行中，在url后（地址栏里面）。
						2. 请求的url长度有限制的
						3. 不太安全（网址参数肉眼可见）
					* POST：
						1. 请求参数位置在请求体中。不在网址后
						2. 请求的url长度没有限制的（文件上传）
						3. 相对安全
#		2. 请求头：客户端浏览器告诉服务器一些信息
			请求头名称: 请求头值（键值对）
			* 常见的请求头：
				1. User-Agent：浏览器告诉服务器，我访问你使用的浏览器版本信息
###					* 可以在服务器端获取该头的信息，解决浏览器的兼容性问题

###				2. Referer：http://localhost/login.html获取非我网址
					* 告诉服务器，我(当前请求)从哪里来？原网址
						* 作用：哪来的，获取非我网址既可以识别又可以统计。
							1. 防盗链：看图解，哪来的
							2. 统计工作：看图解，哪来的
#		3. 请求空行:空行,分隔用
			空行，就是用于分割POST请求的请求头，和请求体的。
#		4. 请求体(正文)：注意get方式没有请求体。
			* 封装POST请求消息的请求参数的。=

#		* 字符串格式：
			POST /login.html	HTTP/1.1
			Host: localhost
			User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0
			Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
			Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
			Accept-Encoding: gzip, deflate
			Referer: http://localhost/login.html
			Connection: keep-alive-----------链接可以复用
			Upgrade-Insecure-Requests: 1
			
			username=zhangsan	


 ## Request：原理图
 	1. request对象和response对象的原理----------图
 		1. request和response对象是由服务器tomcat创建的。我们来使用它们
 		2. request对象是来获取请求消息，response对象是来设置响应消息
 	
 	2. request对象继承体系结构：	
 		ServletRequest		--	接口
 			|	继承
 		HttpServletRequest	-- 接口
 			|	tomcat自己实现
 		org.apache.catalina.connector.RequestFacade 类(见tomcat源码)
 		
##    3. request功能：
#		1. 获取请求消息数据----行--头--体
			1. 获取请求行数据
				* GET /day14/demo1?name=zhangsan HTTP/1.1
				* 方法：
					1. 获取请求方式 ：GET
						* String getMethod()  
#					2. (*)获取虚拟目录：/day14
						* String getContextPath()
#					3. 获取Servlet路径: /demo1
						* String getServletPath()
#					4. 获取get方式请求参数：name=zhangsan
						* String getQueryString()
##					5. (*)获取请求URI：/day14/demo1（虚拟/资源）
						* String getRequestURI():		/day14/demo1
						* StringBuffer getRequestURL()  :http://localhost/day14/demo1

##				* URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
##				* URI：统一资源标识符 : /day14/demo1					共和国
					
#					6. 获取协议及版本：HTTP/1.1
						* String getProtocol()

#					7. 获取客户机的IP地址：
						* String getRemoteAddr()
					
#			2. 获取请求头数据
				* 方法：
					* (*)String getHeader(String name):通过请求头的名称获取请求头的值
					* Enumeration<String> getHeaderNames():获取所有的请求头名称
				     referer，直接访问是null值，其他网址间接访问才有值。referer获取的是别的网址！
###			3. 获取请求体数据:（request对象对请求体封装成了流）
				* 请求体：只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
				* 步骤：
##					1. 获取流对象
						*  BufferedReader getReader()：获取字符输入流，只能操作字符数据
						*  ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
							* 在文件上传知识点后讲解（文件，图片，视频等）

##					2. 再从流对象中拿数据


##		2. 其他功能：
			1. 获取请求参数通用方式：
			不论get还是post请求方式都可以使用下列方法来获取请求参数，故有了this.doPost(request,response);
				1. String getParameter(String name):
				    根据参数名称获取参数值    username=zs&password=123
				2. String[] getParameterValues(String name):复选框
				    根据参数名称获取参数值的数组  hobby=xx&hobby=game
				3. Enumeration<String> getParameterNames():获取所有请求的参数名称
				4. Map<String,String[]> getParameterMap():获取所有参数的map集合

#				* 中文乱码问题：
					* get方式：tomcat 8 已经将get方式乱码问题解决了(参数在url中)
					* post方式：会乱码(还是从流获取的参数，需要设置流的编码)
						* 解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");
			
					
##			2. 请求转发：一种在服务器内部的 资源跳转 方式（分工）
				1. 步骤：
					1. 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
					2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response) 

				2. 特点：
					1. 浏览器地址栏路径不发生变化；
					2. 只能转发到当前服务器内部资源中；
					3. 转发是一次请求，多个内部资源访问。

请求转发产生了域对象！
##			3. 共享数据：
				* 域对象：一个有作用范围的对象，可以在范围内共享数据
				* request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
				* 方法：
					1. void setAttribute(String name,Object obj):存储数据
					2. Object getAttitude(String name):通过键获取值
					3. void removeAttribute(String name):通过键移除键值对

			4. 获取ServletContext：org.apache.catalina.core.ApplicationContextFacade@7eeb6b8c
				* ServletContext getServletContext()










	