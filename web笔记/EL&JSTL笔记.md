# 今日内容
	1. JSP:
		1. 指令
		2. 注释
		3. 内置对象

代码规范：
	2. MVC开发模式
简化jsp代码开发的技术	
	3. EL表达式
	4. JSTL标签
代码规范：	
	5. 三层架构



## JSP:
	1. 指令
		* 作用：用于配置JSP页面，导入资源文件
		* 格式：
			<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
		* 分类：
			1. page		： 配置JSP页面的
				* contentType：等同于response.setContentType()
					1. 设置响应体的mime类型以及字符集
					2. 设置当前jsp页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
				* import：导包
				* errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
				* isErrorPage：标识当前也是是否是错误页面。
#					* true：是，可以使用内置对象exception
					* false：否。默认值。不可以使用内置对象exception


			2. include	： 页面包含的。导入页面的资源文件
				* <%@include file="top.jsp"%>
				
			3. taglib	： 标签库，导入资源
				* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
					* prefix：前缀，自定义的
	2. 注释:
		1. html注释：
			<!-- -->:只能注释html代码片段，页面源码可见
		2. jsp注释：推荐使用，页面源码不可见
			<%-- --%>：可以注释所有


	3. 内置对象（jsp转换过去的java文件中service方法中已经声明好了）
		* 在jsp页面中不需要创建，直接使用的对象，
		* 一共有9个：4个域对象共享数据，setA/getA/removeA
				变量名					真实类型						作用
			* pageContext				PageContext					当前页面共享数据（设值获取），还可以获取其他八个内置对象
			* request					HttpServletRequest			一次请求访问的多个资源(转发)
			* session					HttpSession					一次会话的多个请求间
			* application				ServletContext				所有用户间共享数据(换个浏览器也能获取到)
			
			* response					HttpServletResponse			响应对象
			* page						Object						当前页面(Servlet)的对象  赋值this
			* out						JspWriter					输出对象，数据输出到页面上
			* config					ServletConfig				Servlet的配置对象
			
			* exception					Throwable					异常对象


## MVC：开发模式	
	1. jsp演变历史
		1. 早期只有servlet，只能使用response输出标签数据，非常麻烦
		2. 后来有了jsp，简化了Servlet的开发，如果过度使用jsp（mvc写在一起），在jsp中既写大量的java代码，又写html标签，还有js,相互嵌套，造成难于维护，难于分工协作
		3. 再后来，java的web开发，借鉴mvc开发模式，使得程序的设计更加合理性

	2. MVC：
		1. M：Model，模型。JavaBean
			* 完成具体的业务操作，如：查询数据库，封装对象
		2. V：View，视图。JSP
			* 展示数据
		3. C：Controller，控制器。Servlet
			* 获取用户的输入
			* 调用模型
			* 将数据交给视图进行展示（域对象）


		* 优缺点：
			1. 优点：
				1. 耦合性低，方便维护，可以利于分工协作
				2. 重用性高

			2. 缺点：
				1. 使得项目架构变得复杂，对开发人员要求高	




















