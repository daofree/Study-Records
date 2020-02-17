# 今日内容

1. 数据库的基本概念


2. MySQL数据库软件
	1. 安装
	2. 卸载
	3. 配置

3. SQL


## 数据库的基本概念
	1. 数据库的英文单词： DataBase 简称 ： DB
	2. 什么数据库？
		* 用于存储和管理数据的仓库。
    数据写在文件里存储就是是持久化存储。
    
	3. 数据库的特点：
		1. 持久化存储数据的。其实数据库就是一个文件系统
		2. 承接1，文件系统---方便存储和管理数据
		3. 承接2，方便在使用了统一的方式操作数据库 -- SQL

	
	4. 常见的数据库软件---数据库概念的具体的实现（类似汽车与其具体实现）
		* 参见《MySQL基础.pdf》


# MySQL数据库软件
	1. 安装
##	    安装的是mysql服务器软件！安装完成后，会在window服务列表里注册一个mysql服务！
##	    服务==service,没有界面的应用程序！
		* 参见《MySQL基础.pdf》
	2. 卸载
		1. 去mysql的安装目录找到my.ini文件
			* 复制 datadir="C:/ProgramData/MySQL/MySQL Server 5.5/Data/"
		2. 卸载MySQL
		3. 删除C:/ProgramData目录下的MySQL文件夹。
		
#	3. 配置
##		* MySQL服务启动----服务开启才能用!!
			1. 手动。右击电脑-管理-找服务
			2. cmd--> services.msc 打开服务的窗口
##			3. 使用管理员打开cmd---net start/stop 服务名称
				* net start mysql : 启动mysql的服务
				* net stop mysql:关闭mysql服务
				
##		* MySQL登录
			1. mysql -uroot -p密码
			2. mysql -hip -uroot -p连接目标的密码
			3. mysql --host=ip --user=root --password=连接目标的密码
			
##		* MySQL退出
			1. exit
			2. quit
	
##		* MySQL目录结构
			1. MySQL安装目录：basedir="E:\MySQL"
				* 配置文件 my.ini
				
			2. MySQL数据目录：datadir="C:/ProgramData/MySQL/MySQL Server 5.5/Data/"
				* 几个概念---图解
					* 数据库==文件夹
					* 表==文件
					* 数据==数据
##          注：mysql安装好后，最少有3个数据库（3个文件夹）

