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

	




















