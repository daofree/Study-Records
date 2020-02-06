# 今日内容
	1. 会话技术
		1. Cookie
		2. Session
	2. JSP：入门学习


请求又引出了会话技术！（如购物时每次加入购物车操作）
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
#			2. 发送Cookie对象
				* response.addCookie(Cookie cookie) 
#			3. 获取Cookie，拿到数据
				* Cookie[]  request.getCookies() 
    每次doPost，烦；
    模板设置Settings设置：File and Code Templates-->other-->web-->				 
    @WebServlet("/cookieDemo1") ==<== <url-pattern>/RegistServlet</url-pattern>

#    3. 实现原理--图解+抓包，http协议里
		* 基于响应头set-cookie和请求头cookie实现 
		
	4. cookie的细节
		1. 一次可不可以发送多个cookie?
			* 可以,多个在浏览器会以;号隔开
			* 可以创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可。
		2. cookie在浏览器中保存多长时间？
			1. 默认情况下，当浏览器关闭后，Cookie数据被销毁
#			2. 持久化存储：
				* setMaxAge(int seconds)
					1. 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
					2. 负数：默认值
					3. 零：删除cookie信息,(都没了)
		3. cookie能不能存中文？
			* 在tomcat 8 之前 cookie中不能直接存储中文数据。
				* tomcat 8 之前需要将中文数据转码---一般采用URL编码(%E3)
			* 在tomcat 8 之后，cookie支持中文数据。特殊字符还是不支持，32空格错误！建议使用URL编码存储，URL解码解析
		4. cookie共享问题？范围有多大？？
			1. 假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
				* 默认情况下cookie不能共享（只在当前的虚拟目录）

				* setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录c1.setPath("/day16");
#					* 如果要共享(tomcat下其他项目也能获取这个数据)，则可以将path设置为"/"

			
##			2. 不同的tomcat服务器间cookie共享问题？（百度首页不同模块（新闻，贴吧）肯定不是部署在一个服务器里，访问量）
				* setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
				.baidu.com一级域名，tieba二级域名
					* setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共享	
				电商项目：域名映射，分布式部署可能用到

	5. Cookie的特点和作用
		1. cookie存储数据在客户端浏览器，不安全
		2. 浏览器对于单个cookie 的大小有限制(4kb) 以及 对同一个域名下的总cookie数量也有限制(20个)

		* 作用：
			1. cookie一般用于存出少量的不太敏感的数据
			2. 在不登录的情况下，完成服务器对客户端的身份识别

	6. 案例：记住上一次访问时间,cookie键一样，值会覆盖！！
		1. 需求：
			1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
			2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串

		2. 分析：
			1. 可以采用Cookie来完成
			2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
				1. 有：不是第一次访问
					1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
					2. 写回Cookie：lastTime=2018年6月10日11:50:01
				2. 没有：是第一次访问
					1. 响应数据：您好，欢迎您首次访问
					2. 写回Cookie：lastTime=2018年6月10日11:50:01

		3. 代码实现：
                cookie设值包含空格(32)，浏览器报错误！因特殊字符仍不支持，建议使用URL编码存储，URL解码解析。
                cookie设值，键一样，会覆盖之前原来的值。


## JSP：入门学习:   动静结合的页面只能response.getWrite().write()往页面上响应数据，标签，一写万千百行！
	1. 概念：
		* Java Server Pages： java服务器端页面
			* 可以理解为：一个特殊的页面，其中既可以指定定义html标签，又可以定义java代码
			* 用于简化书写！！！


#	2. 原理：jsp文件转换为java文件，编译成字节码文件.class,提供访问，作出响应。
		* 字节码文件能被浏览器访问到，JSP本质上就是一个Servlet！（只有Servlet才能被访问到）
        work运行时产生的资源文件！
   每一个项目的配置目录
C:\Users\lenovo\.IntelliJIdea2018.3\system\tomcat\_Study-Records\conf\Catalina\localhost
一访问jsp,生成了work目录,放置对应生成的java与字节码文件！
tomcat帮我们写了静态页面，index_jsp.java,还编译index_jsp.class
C:\Users\lenovo\.IntelliJIdea2018.3\system\tomcat\_Study-Records\work\Catalina\localhost\day16\org\apache\jsp


#	3. <% JSP的脚本 %>：JSP定义Java代码的方式，代表位置不同;  jsp脚本可以被截断   
		1. <%  代码 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。
		2. <%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置。
		3. <%= 代码 %>：定义的java代码，就近原则输出，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。


	4. JSP的内置对象：
		* 在jsp页面中不需要获取和创建，可以直接使用的对象
		* jsp一共有9个内置对象。
		* 今天学习3个：
			* request
			* response
			* out：字符输出流对象。可以将数据输出到页面上。和response.getWriter()类似
#				* response.getWriter()和out.write()的区别：
##					* 在tomcat服务器真正给客户端做出响应之前，会先找response缓冲区数据，再找out缓冲区数据。
					* response.getWriter()数据输出永远在out.write()之前
				
5. 案例:改造Cookie案例:	
                jsp脚本可以被截断,写Java代码和html标签非常方便！但页面不方便阅读，展示+流程控制，难写复杂！  
                
                 
## Session：主菜
	1. 概念：服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存在服务器端的对象中。HttpSession
	2. 快速入门：
		1. 获取HttpSession对象：
			HttpSession session = request.getSession();
		2. 使用HttpSession对象：
			Object getAttribute(String name)  
			void setAttribute(String name, Object value)
			void removeAttribute(String name)  
	
	3. 原理--图解--tomcat间接创建了cookie!
		* Session的实现是依赖于Cookie（响应头，请求头）的。
	   过程：	
		第一次获取session时（没有session获取不到，没有id），也是没有cookie的，
		会在内存中创建session,并有唯一一个id值，
		当给务器响应时，会发送一个响应头set-cookie:JSESSIONID=值;
		第二次访问时，服务器会获取cookie信息。并根据JSESSIONID的id在内存中查找有没有id。。。

											   