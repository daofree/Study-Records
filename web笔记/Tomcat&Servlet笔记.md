# 今日内容
	1. web相关概念回顾
	2. web服务器软件：Tomcat
	3. Servlet入门学习




## web相关概念回顾
	1. 软件架构
		1. C/S：客户端/服务器端
		2. B/S：浏览器/服务器端

#	2. 资源分类
		1. 静态资源：所有用户访问后，得到的结果都是一样的，称为静态资源.
#		    静态资源可以直接被浏览器解析
			* 如： html,css,JavaScript
		2. 动态资源:每个用户访问相同资源后，得到的结果可能不一样。称为动态资源。
#		    动态资源被访问后，需要先转换为静态资源，在返回给浏览器
			* 如：servlet/jsp,php,asp....
#返回 称为响应			

#请求
	3. 网络通信三要素
		1. IP：电子设备(计算机)在网络中的唯一标识。
		2. 端口：应用程序在计算机中的唯一标识。 0~65536
		3. 传输协议：规定了数据传输的规则
			1. 基础协议：
				1. tcp:安全协议，三次握手。 速度稍慢
				2. udp：不安全协议。 速度快


## web服务器软件：
	* 服务器：安装了服务器软件的计算机,安装了mysql的mysql服务器软件(别人通过用户名密码，可以访问)；
	* 服务器软件：接收用户的请求，处理请求，做出响应(别人通过用户名密码，可以访问)；
	
##	* web服务器软件：接收用户（通过浏览器）的请求，处理请求，做出响应。
		* 在web服务器软件中，可以部署web项目，让用户通过浏览器来访问这些项目
		* web容器


	* 常见的java相关的web服务器软件：
		* webLogic：oracle公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
		* webSphere：IBM公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
		* JBOSS：JBOSS公司的，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
		* Tomcat：Apache基金组织，中小型的JavaEE服务器，仅仅支持少量的JavaEE规范servlet/jsp。开源的，免费的。


#	* JavaEE：Java语言在企业级开发中使用的技术规范的总和，一共规定了13项大的规范

##	* Tomcat：web服务器软件
		1. 下载：http://tomcat.apache.org/
		2. 安装：解压压缩包即可。
			* 注意：安装目录建议不要有中文和空格
		3. 卸载：删除目录就行了
		4. 启动：
			* bin/startup.bat ,双击运行该文件即可
			* 访问：浏览器输入：http://localhost:8080 回车访问自己
			                  http://127.0.0.1:8080
							  http://别人的ip:8080 访问别人
			
			* 可能遇到的问题：
				1. 黑窗口一闪而过：
					* 原因： 没有正确配置JAVA_HOME环境变量(根本没配置JAVA_HOME)
					* 解决方案：正确配置JAVA_HOME环境变量
					* 启动文件（批处理文件）中，脚本需要使用JAVA_HOME.

##				2. 启动报错：pid进程号
					1. 暴力：找到占用的端口号获取pid进程号，并且任务管理器找到对应的进程pid，杀死该进程
						* 查看所有的端口占用情况netstat -ano
						* 查看指定端口的占用情况netstat -ano|findstr 8080
																		
					2. 温柔：修改自身的端口号
##						* conf/server.xml
						* <Connector port="8888" protocol="HTTP/1.1"
			               connectionTimeout="20000"
			               redirectPort="8445" />
						* 一般会将tomcat的默认端口号修改为80。80端口号是http协议的默认端口号。
							* 好处：在访问时，就不用输入端口号
#http协议的默认端口号80

		5. 关闭：
			1. 正常关闭：
				* bin/shutdown.bat
				* 窗口 ctrl+c
			2. 强制关闭：
				* 点击启动窗口的×


#		6. 部署配置:
##			* 部署项目的方式：直接，间接，冷，热
				1. 直接将项目放到webapps目录下即可。http://127.0.0.1:8080/hello/hello.html
					* /hello：项目的访问路径（同项目名称）-叫->虚拟目录
					hello.html 资源名称
##					* 简化部署：将项目打成一个war包，再将war包放置到webapps目录下。
						* tomcat开启状态，war包放进去会自动解压缩
						* 卸载时，只要直接删除war包即可，解压文件随之删除
            缺点：1.虚拟目录名称==项目名称
                 2.需要拷到webapps下
            
				2. 配置conf/server.xml文件（重启生效）
					在<Host>标签体中配置（文档最后面）
#					<Context docBase="D:\hello" path="/suiyihuamming" />
					* docBase:项目存放的路径
					* path：虚拟目录(访问的)
#					http://127.0.0.1:8080/suiyihuamming/hello.html
           缺点：server.xml是tomcat核心配置文件。在里面配置多个项目，可能会搞坏了，很不安全
           
           
##				3. 在conf\Catalina\localhost创建任意名称（虚拟目录）的xml文件。在文件中编写
## 这是热部署	
					<Context docBase="D:\hello" />
					* 虚拟目录：xml文件的名称
					http://127.0.0.1:8080/xml文件名/hello.html
				
#Catalina就是Tomcat的servlet容器.			
			
    内部寓意就是tomcat的脚本文件，寄寓，是个小岛的名字，开发者曾在岛上生活过。
    Tomcat的这个单词的意思是“公猫”，因为它的开发者姆斯·邓肯·戴维森希望用一种能够自己照顾自己的动物代表这个软件，
    于是命名为tomcat，它的Logo兼吉祥物也被设计成了一只公猫形象。
    Catalina是美国西海岸靠近洛杉矶22英里的一个小岛，因为其风景秀丽而著名。
    Servlet运行模块的最早开发者Craig McClanahan因为喜欢Catalina岛故以Catalina命名他所开这个模块，
    尽管他从来也没有去过那里。
    另外在开发的早期阶段，Tomcat是被搭建在一个叫Avalon的服务器框架上，
    而Avalon则是Catalina岛上的一个小镇的名字，于是想一个与小镇名字相关联的单词也是自然而然。
    还有一个原因来自于Craig McClanahan养的猫，他养的猫在他写程序的时候喜欢在电脑周围闲逛。
    可能是Catalina岛是个悠闲散步的好地方，猫的闲逛让Craig McClanahan想起了那里。
    catalina和tomcat的关系
    catalina 就是Tomcat服务器使用的 Apache实现的servlet容器的名字。
    Tomcat的核心分为3个部分: 
    （1）Web容器—处理静态页面； 
    （2）catalina — 一个servlet容器—–处理servlet; 
    （3）还有就是JSP容器，它就是把jsp页面翻译成一般的servlet。

