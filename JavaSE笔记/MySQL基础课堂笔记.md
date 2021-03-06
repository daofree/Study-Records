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
					3. date:日期，只包含年月日，格式：yyyy-MM-dd
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
	

## DML：增删改表中数据

	1. 添加数据：
		* 语法：
			* insert into 表名(列名1,列名2,...列名n) values(值1,值2,...值n);
		* 注意：
			1. 列名和值要一一对应。
			2. 如果表名后，不定义列名，则默认给所有列添加值
				insert into 表名 values(值1,值2,...值n);
			3. 除了数字类型，其他类型需要使用引号(单双都可以)引起来
			
	2. 删除数据：
		* 语法：
			* delete from 表名 [where 条件]
		* 注意：
			1. 如果不加条件，则删除表中所有记录。
##			2. 如果要删除所有记录
				1. delete from 表名; -- 不推荐使用。有多少条记录就会执行多少次删除操作
				2. TRUNCATE TABLE 表名; -- 推荐使用，效率更高 先删除表（drop），然后再创建一张一样的表。
	3. 修改数据：
		* 语法：
			* update 表名 set 列名1 = 值1, 列名2 = 值2,... [where 条件];

		* 注意：
			1. 如果不加任何条件，则会将表中所有记录全部修改。
        
        sql中drop、truncate和delete的区别？
        drop > truncate > delete
        drop      表结构+表数据（立即生效）
        truncate  数据（不能回滚-立即生效）
        delete    数据（一条一条删，且记录日志供回滚--提交生效）
        			
## DQL：查询表中的记录
	* select * from 表名;
	
	1. 语法：w伟ghl
		select
			字段列表
		from
			表名列表
		where
			条件列表
		group by
			分组字段
		having
			分组之后的条件
		order by
			排序
		limit
			分页限定
    
	2. 基础查询
	
	            CREATE TABLE student3 (   
                    id int,  -- 编号   
                    name varchar(20), -- 姓名   
                    age int, -- 年龄   
                    sex varchar(5),  -- 性别   
                    address varchar(100),  -- 地址   
                    math int, -- 数学   
                    english int -- 英语 
                );
                
                INSERT INTO student3
                        (id,NAME,age,sex,address,math,english) 
                VALUES 
                        (1,'马云',55,'男', '杭州',66,78),
                        (2,'马化腾',45,'女','深圳',98,87),
                        (3,'马景涛',55,'男','香港',56,77),
                        (4,'柳岩',20,'女','湖南',76,65),
                        (5,'柳青',20,'男','湖南',86,NULL),
                        (6,'刘德华',57,'男','香港 ',99,99),
                        (7,'马德',22,'女','香港',99,99),
                        (8,'德玛西亚',18,'男','南京',56,65); 
			
		1. 多个字段的查询
			select 字段名1，字段名2... from 表名；
			* 注意：
				* 如果查询所有字段，则可以使用*来替代字段列表。
##		2. 去除重复：
			* distinct
			SELECT DISTINCT address FROM student;
##		3. 计算列
			* 一般可以使用四则运算计算一些列的值。（一般只会进行数值型的计算）
			SELECT NAME,math,english,math+IFNULL(english,0) FROM student;
			
##			问题：null参与的运算，计算结果都为null。如何解决？？
			* ifnull(表达式1,表达式2)：
				* 表达式1：哪个字段需要判断是否为null
				* 如果该字段为null后的替换值。
##		4. 起别名：
			* as：as也可以省略
			SELECT NAME,math,english,math+IFNULL(english,0) AS 总分 FROM student;


	3. 条件查询                     
    		1. where子句后跟条件
    		2. 运算符
    			* > 、< 、<= 、>= 、= 、<>不等于(!=)
    			    不等于
    			    SELECT * FROM student WHERE age <> 20;
                    SELECT * FROM student WHERE age != 20;
                
    			* BETWEEN...AND  ---单表里，动值比定值
    			* and  或 &&
    			    SELECT * FROM student WHERE age >= 20 && age <=30;
                    SELECT * FROM student WHERE age >= 20 AND age <=30;
                    SELECT * FROM student WHERE age BETWEEN 20 AND 30;
                
##    			* IN(集合) 
                * or  或 || 
    			    SELECT * FROM student WHERE age=22 OR age = 18 OR age=25;
                    SELECT * FROM student WHERE age IN (22,18,25);                    

###    			* IS NULL  （null值不能使用 = （!=） 判断）
    			问题：错误语句SELECT * FROM student WHERE english = NULL; 
    			
    			        SELECT * FROM student WHERE english IS NULL;
                    	SELECT * FROM student WHERE english  IS NOT NULL;
                    	   		  			
    			* not  或 !（!= 与 IS NOT NULL）
    			
##    			* LIKE：模糊查询
    				* 占位符：占一个多个
    					* _: 单个任意字符
    					* %：多个任意字符    			
    			    
    				-- 查询姓马的有哪些？ like
    				SELECT * FROM student WHERE NAME LIKE '马%';
    				-- 查询姓名第二个字是化的人
    				
    				SELECT * FROM student WHERE NAME LIKE "_化%";
    				
    				-- 查询姓名是3个字的人
    				SELECT * FROM student WHERE NAME LIKE '___';
    				
    				
    				-- 查询姓名中包含德的人
    				SELECT * FROM student WHERE NAME LIKE '%德%';				    