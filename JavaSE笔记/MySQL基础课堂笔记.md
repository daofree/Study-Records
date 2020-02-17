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
				* 几个概念---参考图解
					* 数据库==文件夹
					* 表==文件
					* 数据==数据
##          注：mysql安装好后，最少有3个数据库（3个文件夹）

# SQL

	1.什么是SQL？
		Structured Query Language：结构化查询语言
		其实就是定义了操作所有关系型（relational）数据库的规则。每一种数据库操作的方式存在不一样的地方，称为“方言”。
		
	2.SQL通用语法
		1. SQL 语句可以单行或多行书写，以分号结尾。
		2. 可使用空格和缩进来增强语句的可读性。
		3. MySQL 数据库的 SQL 语句不区分大小写，关键字建议使用大写。
		4. 3 种注释
			* 单行注释: --空格+注释内容  或  # 注释内容(mysql 特有) 
			* 多行注释: /* 注释 */
		
	3. SQL分类
		1) DDL(Data Definition Language)数据定义语言
			用来定义数据库对象：数据库，表，列等。关键字：create, drop,alter 等
		2) DML(Data Manipulation Language)数据操作语言
			用来对数据库中表的数据进行增删改。关键字：insert, delete, update 等
		3) DQL(Data Query Language)数据查询语言
			用来查询数据库中表的记录(数据)。关键字：select, where 等
		4) DCL(Data Control Language)数据控制语言(了解)
			用来定义数据库的访问权限和安全级别，及创建用户。关键字：GRANT， REVOKE 等

	
## DDL:操作数据库、表

	1. 操作数据库：CRUD
		1. C(Create):创建
			* 创建数据库：
				* create database 数据库名称;
			* 创建数据库，判断不存在，再创建：
###				* create database if not exists 数据库名称;
			* 创建数据库，并指定字符集
				* create database 数据库名称 character set 字符集名;

			* 练习： 创建db4数据库，判断是否存在，并制定字符集为gbk
				* create database if not exists db4 character set gbk;
		2. R(Retrieve)：查询
			* 查询所有数据库的名称:
				* show databases;
			* 查询某个数据库的创建语句--可以查询某个数据库的字符集：
				* show create database 数据库名称;
				
		3. U(Update):修改
			* 修改数据库的字符集，utf8，不是utf-8
				* alter database 数据库名称 character set 字符集名称;
		4. D(Delete):删除
			* 删除数据库
				* drop database 数据库名称;
			* 判断数据库存在，存在再删除
				* drop database if exists 数据库名称;
		5. 使用数据库
			* 查询当前正在使用的数据库名称
				* select database();
			* 使用数据库
				* use 数据库名称;


	2. 操作表
		1. C(Create):创建
			1. 语法：
				create table 表名(
					列名1 数据类型1,
					列名2 数据类型2,
					....
					列名n 数据类型n
				);
###				* 注意：最后一列，不需要加逗号（,）
###				* 数据库类型：
					1. int：整数类型
						* age int,
					2. double:小数类型
						* score double(5,2),--最大值999.99
					3. date:日期，只包含年月日，yyyy-MM-dd
					4. datetime:日期，包含年月日时分秒	 yyyy-MM-dd HH:mm:ss
					time--时分秒；datetime=date+time
##					5. timestamp:时间戳类型	包含年月日时分秒	 yyyy-MM-dd HH:mm:ss	
						* 如果将来不给timestamp这个字段赋值，或赋值为null，则默认使用当前的系统时间，来自动赋值

					6. varchar：字符串
						* name varchar(20):姓名最大20个字符
						* zhangsan 8个字符  张三 2个字符
				

			* 创建表
				create table student(
					id int,
					name varchar(32),
					age int ,
					score double(4,1),
					birthday date,
					insert_time timestamp
				);
				
##			* 复制表：
				* create table 新表名 like 被复制的表名;	  	
				
		2. R(Retrieve)：查询
			* 查询某个数据库中所有的表名称
				* show tables;
			* 查询表结构
				* desc 表名;
			* 查询建表语句--可以查询某个数据库的字符集
				* show create table  表名;
###		3. U(Update):修改
			1. 修改表名
				alter table 表名 rename to 新的表名;
			2. 修改表的字符集
				alter table 表名 character set 字符集名称;
				
			3. 添加一列
				alter table 表名 add 列名 数据类型;
			4. 修改列名称 类型
				alter table 表名 change 原列名 新列别 新数据类型;
				alter table 表名 modify 列名 新数据类型;
			5. 删除列
				alter table 表名 drop 列名;
				
		4. D(Delete):删除
			* drop table 表名;
			* drop table  if exists 表名 ;

* 客户端图形化工具：SQLYog	
	
			    