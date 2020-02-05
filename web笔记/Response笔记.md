# 今日内容
	
	1. HTTP协议：响应消息
	2. Response对象(服务器创建，用来设置响应消息)
	3. ServletContext对象


## HTTP协议：
	1. 请求消息：客户端发送给服务器端的数据
		* 数据格式：
			1. 请求行
			2. 请求头
			3. 请求空行
			4. 请求体
	2. 响应消息：服务器端发送给客户端的数据
		* 数据格式：
			1. 响应行
				1. 组成：协议/版本 响应状态码 状态码描述
#				2. 响应状态码：服务器告诉客户端浏览器本次请求和响应的一个状态。
					1. 状态码都是3位数字 
					2. 分类：
						1. 1xx：服务器就收客户端消息，但没有接受完成，等待一段时间后，发送1xx多状态码
						2. 2xx：成功。代表：200
						3. 3xx：重定向。代表：302(重定向)，304(访问缓存）Not Modified
			                (访问缓存，图片资源一般固定，浏览器会缓存到本地！
			            浏览器再次访问这个资源时，服务器发现自己没有变化，而且你本地有缓存，304)
#						二进制文件占用通信时间比较长。
						4. 4xx：客户端错误。
							* 代表：
								* 404（请求路径没有对应的资源） 
								* 405：请求方式没有对应的doXxx方法
						5. 5xx：服务器端错误。代表：500(服务器内部出现异常)
							
					
#			2. 响应头：键值对
				1. 格式：头名称： 值
				2. 常见的响应头：
					1. Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式, 浏览器根据返回值，做出相应反应，调哪个解析器，用什么编码。
					2. Content-disposition：服务器告诉客户端以什么格式打开响应体数据
						* 值：
							* in-line:默认值,在当前页面内打开
							* attachment;filename=xxx：以附件形式打开响应体。文件下载
			3. 响应空行
			4. 响应体:传输的数据(html页面的内容)


#		* 响应字符串格式 键值头
			HTTP/1.1 200 OK
			Content-Type: text/html;charset=UTF-8
			Content-Length: 101
			Date: Wed, 06 Jun 2018 07:08:42 GMT
	
			<html>
			  <head>
			    <title>$Title$</title>
			  </head>
			  <body>
			  hello , response
			  </body>
			</html>



## Response对象
#	* 功能：设置响应消息
		1. 设置响应行
			1. 格式：HTTP/1.1 200 ok
			2. 设置状态码：setStatus(int sc) 
		2. 设置响应头：setHeader(String name, String value) 
			
		3. 设置响应体：
			* 使用步骤：
#				1. 获取输出流
					* 字符输出流：PrintWriter getWriter()

					* 字节输出流：ServletOutputStream getOutputStream()

				2. 使用输出流，将数据输出到客户端浏览器

	* 案例：
#		1. 完成重定向，路径包含虚拟目录
			* 重定向：资源跳转的方式
			* 代码实现：
				//1. 设置状态码为302
		        response.setStatus(302);
		        //2.设置响应头location
		        response.setHeader("location","/day15/responseDemo2");
-----------------------------------------------------------------------------------
                两步变一步    
		        //简单的重定向方法
		        response.sendRedirect("/day15/responseDemo2");

###			* 重定向的特点:redirect-------/day15/responseDemo2
				1. 地址栏发生变化
				2. 重定向可以访问其他站点(服务器)的资源
				3. 重定向是两次请求。不能使用request对象来共享数据
			* 转发的特点：forward-------/requestDemo9
				1. 转发地址栏路径不变
				2. 转发只能访问当前服务器下的资源
				3. 转发是一次请求，可以使用request对象来共享数据
			
#	面试		* forward 和  redirect 区别
				

##			* 路径写法：
				1. 路径分类
###					1. 相对路径：通过相对路径不可以确定唯一资源
						* 如：./index.html
##						* 不以/开头，以.开头路径

						* 规则：找到当前资源和目标资源之间的相对位置关系!
							* ./：当前目录
							* ../:后退一级目录
###					2. 绝对路径：通过绝对路径可以确定唯一资源
						* 如：http://localhost/day15/responseDemo2		/day15/responseDemo2  (省略了固定的http://localhost)
##						* 以/开头的路径

						* 规则：判断定义的路径是给谁用的？判断请求将来从哪儿发出？客户端？服务器？？
							* 给客户端浏览器使用：需要加虚拟目录(项目的访问路径)
							/day15虚拟目录写死了，如果改变了，代码里的都得改了！不方便
#								* 建议虚拟目录动态获取：request.getContextPath()
                                   jsp页面也可以动态获取，html就不行了
								* <a> , <form> 重定向...
								* <a href="/day15/responseDemo2">
								
								
							* 给服务器使用：不需要加虚拟目录
								* 转发路径
								req.getRequestDispatcher("/responseDemo2").forward(req,resp);
###重定向是客户端用的路径，转发是服务器用的路径	
	

#		2. 服务器输出字符数据到浏览器
			* 步骤：
				1. 获取字符输出流（流向客户端浏览器的）
				2. 输出数据

			* 注意：浏览器打开默认的字符集和当前操作系统的语言环境有关，操作系统中文,GBK2312
##				* 乱码问题：
					1. PrintWriter pw = response.getWriter();获取的流(tomcat返回的)的默认编码是ISO-8859-1
					2. 设置该流的默认编码，setCharacterEncoding
					3. 告诉浏览器响应体使用的编码，setHeader("content-type","text/html;charset=utf-8");

					//简单的形式，设置编码，是在获取流之前设置
        			response.setContentType("text/html;charset=utf-8");
        			

#		3. 服务器输出字节数据到浏览器
			* 步骤：
				1. 获取字节输出流
				2. 输出数据
		String的getBytes()方法是得到一个操作系统默认的编码格式的字节数组,"你好".getBytes() 得到的是GBK

	
	

