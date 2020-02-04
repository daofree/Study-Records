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

#		* GenericServlet：将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象（继承需要实现）
			* 将来定义Servlet类时，可以继承GenericServlet，可仅实现一个service()方法即可

#		* HttpServlet：对http协议的一种封装，简化操作
			1. 定义类继承HttpServlet
			2. 复写doGet/doPost方法，(HttpServlet里的service()会判断get or post然后分发的)
	通过浏览器请求是，get方式
	
	
	