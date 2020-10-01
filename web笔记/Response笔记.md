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
						3. 3xx：重定向。代表：302(重定向)，304(访问缓存）Not Modified没有更改
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
					1. Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式, 浏览器根据返回值（调用对应的解析引擎），做出相应反应，调哪个解析器，用什么编码。
					2. Content-disposition：服务器告诉客户端以什么格式打开响应体数据
						* 值：
							* in-line:默认值,在当前页面内打开
							* attachment;filename=xxx：以附件形式打开响应体。文件下载
			3. 响应空行
			4. 响应体:传输的数据(html页面的内容，图片的数据...)


#		* 响应字符串格式 键值头
			HTTP/1.1 200 OK
			Content-Type: text/html;charset=UTF-8---文本/html内容
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
#		1. 完成响应重定向，路径包含虚拟目录
			* 重定向：资源跳转的方式 sendRedirect
			* 代码实现：
				//1. 设置状态码为302
		        response.setStatus(302);
		        //2.设置响应头location，头是固定的
		        response.setHeader("location","/day15/responseDemo2");
-----------------------------------------------------------------------------------
                两步变一步    
		        //简单的重定向方法
		        response.sendRedirect("/day15/responseDemo2");

###			* 重定向的特点:redirect-------/day15/responseDemo2
				1. 地址栏发生变化
				2. 重定向可以访问其他站点(服务器)的资源
				3. 重定向是两次请求。两个请求对象，不能使用request对象来共享数据------响应res域对象夭折！
			* 转发的特点：forward-------/requestDemo9
				1. 转发地址栏路径不变
				2. 转发只能访问当前服务器下的资源
				3. 转发是一次请求，可以使用request对象来共享数据------产生了域对象
			
#	面试		* forward 和  redirect 区别--请求转发，响应重定向
				

##			* 路径写法：
				1. 路径分类
###					1. 相对路径：通过相对路径不可以确定唯一资源
						* 如：./index.html
##						* 不以/开头，以.开头路径

						* 规则：找到当前资源和目标资源之间的相对位置关系!
							* ./：当前目录，不写默认./
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
###重定向是客户端用的路径-加虚拟，转发是服务器用的路径--不加虚拟	
	

#		2. 服务器输出字符数据到浏览器
			* 步骤：
				1. 获取字符输出流（流向客户端浏览器的）PrintWriter pw = res.getWriter();
				2. 输出数据pw.writer("响应体");

			* 注意：浏览器打开默认的字符集和当前操作系统的语言环境有关，操作系统中文,GBK2312
##				* 乱码问题：让浏览器展示数据，要告诉浏览器用什么编码解析
					1. PrintWriter pw = response.getWriter();获取的流(tomcat返回的，老外)的默认编码是ISO-8859-1
					2. 设置该流的默认编码，setCharacterEncoding("GBK");(言下之意，要对应编码解流)，如何让浏览器听话？
					3. 告诉浏览器响应体使用的编码，setHeader("content-type","text/html;charset=utf-8");

					//简单的形式，设置编码，是在获取流之前设置，写这一个就行了
        			response.setContentType("text/html;charset=utf-8");
        			

#		3. 服务器输出字节数据到浏览器,案例见4
            response.setContentType("text/html;charset=utf-8");
			* 步骤：
				1. 获取字节输出流--一般输出图片
				2. 输出数据
				
				（本地new的流编码和本地系统有关）
		String的getBytes()方法是得到一个操作系统默认的编码格式的字节数组,"你好".getBytes() 得到的是GBK
	            浏览器默认字符集与当前操作系统语言环境有关系
	

#		4. 验证码（验证码图片在内存里，可用内存里的二进制数据写到页面上去）
			1. 本质：图片
			2. 目的：防止恶意表单注册
			内存中创建图片对象
			BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			...
			// ImageIO可以把内存中对象写到页面/任意流中
			ImageIO.write(image,"jpg",resp.getOutputStream());
	    
##获取图片，注意缓存！！img.src= "资源路径?"+ 加时间戳new Date().getTime();
                ?1--传个无意义的参数，改变路径，欺骗服务器，重新请求，拒绝缓存

虚拟目录动态获取：request.getContextPath()
response.setContentType("text/html;charset=utf-8");
Context：n.	(事情发生的) 背景，环境，来龙去脉; 上下文; 语境;

请求资源（web应用ServletContext）产生了请求对象，引出了资源对象（web应用-servlet容器）！

## ServletContext对象：
	1. 概念：代表整个web应用，可以和程序（servlet的）的容器(tomcat服务器)来通信。交互数据
##	web应用是部署在tomcat服务器里的
#	2. 获取： org.apache.catalina.core.ApplicationContextFacade@109bddec
		1. 通过request对象获取
			request.getServletContext();
		2. 通过HttpServlet获取
			this.getServletContext();
			
#	3. 功能：
##		1. 获取MIME类型：
			* MIME类型:在互联网通信过程中定义的一种文件数据类型（通信标准）
				* 格式： 大类型/小类型   text/html		image/jpeg
             记得码？？       response.setContentType("text/html;charset=utf-8");

			* 获取：String getMimeType(String file)    其实是通过扩展名（后缀名）获取的。  			
			为啥能获取到？
			    所有对应关系都在服务器里存的，ServletContext对象又能和tomcat通信，ServletContext就是tomcat创建的。
			    所有项目的web.xml都继承了apache-tomcat-8.5.31\conf\web.xml--总配置
			

##		2. 域对象：共享数据
			1. setAttribute(String name,Object value)
			2. getAttribute(String name)
			3. removeAttribute(String name)

			* ServletContext对象范围：所有用户所有请求的数据（换个浏览器也能获取到），
			            存的数据所有用户都可以操控，不安全，生命周期长，同服务器启停。若数据多，内存压力大。

##		3. 获取文件的真实(服务器)路径;/WEB-INF/classes==src（src类加载也可以）
        实际部署在服务器中的项目里面的路径，不是工作空间（源码）的路径
			1. 方法：String getRealPath(String path)  
				 String b = context.getRealPath("/b.txt");//web目录下资源访问
		         System.out.println(b); 观察/代表的是的路径，/WEB-INF/c.txt
		        
		        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
		        System.out.println(c);
		
		        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
		        System.out.println(a);
		        
		   /==项目部署路径docBase="D:\IdeaProjects\Study-Records\out\artifacts\day15_response_war_exploded"

        /WEB-INF/classes==src
        		src下还可以通过类加载器ClassLoder获取！只能在src下！不能获取web下，局限大
        		
        配置文件，src下最终到/WEB-INF/classes里面，web下，web-inf下

## 案例：           注意：图片能被浏览器解析
	* 文件下载需求：
		1. 页面显示超链接
		2. 点击超链接后弹出下载提示框（视频，浏览器解析不了）
		3. 完成图片文件下载


	* 分析：
		1. 超链接指向的资源如果能够被浏览器解析，则在浏览器中展示，如果不能解析，则弹出下载提示框。不满足需求
		2. 任何资源都必须弹出下载提示框
		3. 使用响应头设置资源的打开方式：以附件形式打开（文本-布置安排：附件；文件名）
			* content-disposition:attachment;filename=xxx


	* 步骤：
		1. 定义页面，编辑超链接href属性，指向Servlet，传递资源名称<a href="/day15/downServlet?filename=1.jpg"
		2. 定义Servlet
			1. 获取文件名称
#			2. 使用字节输入流加载文件进内存(需要文件真实路径)
			3. 指定response的响应头： content-disposition:attachment;filename=xxx
			4. 将数据写出到response输出流


	* 问题：下载弹出框，中文文件名，不展示，且不同浏览器展示的不一样！IE版本低直接报错--360-URLEncoding()--火狐_
		* 中文文件问题
			* 解决思路：
				1. 获取客户端使用的浏览器版本信息
				2. 根据不同的版本信息，响应不同的数据（设置filename的编码方式不同）

      https://www.boxuegu.com/ask/detail/1223
      IDE中找不到sun.misc.BASE64Encoder jar包,在项目开发过程中，安装了JDK 9以上版本，
      发现sun.misc.Base64Encoder和sun.misc.Base64Decoder无法使用。找不到导入的包  	
      原因：          
        查看官网发现，JDK中的/lib/tool.jar和/lib/rt.jar已经从Java SE 9中删除
      
      处理办法：      
        方法1. 切换JDK1.8      
        方法2. 直接用 java.util.Base64.Encoder 和 java.util.Base64.Decoder 替代使用。	