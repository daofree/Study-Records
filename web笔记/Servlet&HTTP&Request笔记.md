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

###				2. Referer：http://localhost/login.html
					* 告诉服务器，我(当前请求)从哪里来？
						* 作用：哪来的，既可以识别又可以统计。
							1. 防盗链：看图解，哪来的
							2. 统计工作：看图解，哪来的
#		3. 请求空行:空行,分隔用
			空行，就是用于分割POST请求的请求头，和请求体的。
#		4. 请求体(正文)：get方式没有请求体。
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


#	* 响应消息数据格式

    














	