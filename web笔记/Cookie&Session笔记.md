# 今日内容
	1. 会话技术
		1. Cookie
		2. Session
	2. JSP：入门学习


请求又引出了会话技术！
##背景
        因为http协议是无状态的，每次请求响应与其他请求响应都是独立的！不能进行数据交流交换！会话技术就是来解决
## 会话技术
	1. 会话：一次会话中包含多次请求和响应。
		* 一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到有一方断开为止
#	2. 功能：在一次会话的范围内的多次请求间，共享数据。（如购物时每次加入购物车操作）
	
	3. 方式：
		1. 客户端会话技术：Cookie
		2. 服务器端会话技术：Session


## Cookie：
	1. 概念：客户端会话技术，将数据保存到客户端

	2. 快速入门：
		* 使用步骤：
			1. 创建Cookie对象，绑定数据
				* new Cookie(String name, String value) 
			2. 发送Cookie对象
				* response.addCookie(Cookie cookie) 
			3. 获取Cookie，拿到数据
				* Cookie[]  request.getCookies() 
    每次doPost，烦；
    模板设置Settings设置：File and Code Templates-->other-->web-->				 
    @WebServlet("/cookieDemo1") ==<== <url-pattern>/RegistServlet</url-pattern>

    3. 实现原理--图解+抓包
		* 基于响应头set-cookie和请求头cookie实现 
		
		   