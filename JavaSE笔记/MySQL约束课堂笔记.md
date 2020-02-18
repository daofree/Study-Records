# 今日内容
	
	1. DQL:查询语句
		1. 排序查询
		2. 聚合函数
		3. 分组查询
		4. 分页查询

	2. 约束
	3. 多表之间的关系
	4. 范式--设计表时遵守
	5. 数据库的备份和还原

# DQL:查询语句
	1. 排序查询
		* 语法：order by 子句
			* order by 排序字段1 排序方式1 ，  排序字段2 排序方式2...

		* 排序方式：
			* ASC：升序，默认的。
			* DESC：降序。
			
            SELECT * FROM student ORDER BY math DESC;
            
		* 注意：
###			* 如果有多个排序条件，则当前边的条件值一样时，才会判断第二条件。否则第二条件无效。
              SELECT * FROM student ORDER BY math ASC,english ASC;


	2. 聚合函数：将一列数据作为一个整体，进行纵向的计算。
###		1. count：计算个数，是排除null值后的个数。
			1. 一般选择非空的列：主键
			2. count(*)
		2. max：计算最大值
		    SELECT MAX(math) FROM student;
		3. min：计算最小值
		    SELECT MIN(math) FROM student;
		4. sum：计算和
		    SELECT SUM(math) FROM student;
		5. avg：计算平均值
		    SELECT AVG(math) FROM student;

		* 注意：聚合函数的计算，排除null值。
			解决方案：
				1. 选择不包含非空的列进行计算
				2. IFNULL函数
            SELECT COUNT(english) FROM student;
            SELECT COUNT(IFNULL(english,0)) FROM student;


	3. 分组查询:
		1. 语法：group by 分组字段；
		2. 注意：
###			1. 分组之后查询的字段：分组字段,聚合函数

###			2. where 和 having 的区别？
				1. where 在分组之前进行限定，如果不满足条件，则不参与分组。
				   having在分组之后进行限定，如果不满足结果，则不会被查询出来
				2. where 后不可以跟聚合函数，having可以进行聚合函数的判断。（注意1）

			-- 按照性别分组。分别查询男、女同学的平均分

			SELECT sex , AVG(math) FROM student GROUP BY sex;
			
			-- 按照性别分组。分别查询男、女同学的平均分,人数
			
			SELECT sex , AVG(math),COUNT(id) FROM student GROUP BY sex;
			
			--  按照性别分组。分别查询男、女同学的平均分,人数 要求：分数低于70分的人，不参与分组
			SELECT sex , AVG(math),COUNT(id) FROM student WHERE math > 70 GROUP BY sex;
			
			--  按照性别分组。分别查询男、女同学的平均分,人数 要求：分数低于70分的人，不参与分组,分组之后。人数要大于2个人
			SELECT sex , AVG(math),COUNT(id) FROM student WHERE math > 70 GROUP BY sex HAVING COUNT(id) > 2;
			别名
			SELECT sex , AVG(math),COUNT(id) 人数 FROM student WHERE math > 70 GROUP BY sex HAVING 人数 > 2;


			
	4. 分页查询
###		1. 语法：limit 开始的索引,每页查询的条数;
###		2. 公式：开始的索引 = （当前的页码 - 1） * 每页显示的条数
			-- 每页显示3条记录 

			SELECT * FROM student LIMIT 0,3; -- 第1页
			
			SELECT * FROM student LIMIT 3,3; -- 第2页
			
			SELECT * FROM student LIMIT 6,3; -- 第3页

		3. limit 是一个MySQL"方言"，Oracle用rownumber.


## 约束
	* 概念： 对表中的数据进行限定，保证数据的正确性、有效性和完整性。	
	* 分类：
		1. 主键约束：primary key
		2. 非空约束：not null
		3. 唯一约束：unique
		4. 外键约束：foreign key

##	* 非空约束：not null，值不能为null
		1. 创建表时添加约束
			CREATE TABLE stu(
				id INT,
				NAME VARCHAR(20) NOT NULL -- name为非空
			);
		2. 创建表完后，添加非空约束---有空值，添加约束失败
			ALTER TABLE stu MODIFY NAME VARCHAR(20) NOT NULL;

		3. 删除name的非空约束
			ALTER TABLE stu MODIFY NAME VARCHAR(20);
	
	
##	* 唯一约束（索引）：unique，值不能重复,但可以为null
		1. 创建表时，添加唯一约束
			CREATE TABLE stu(
				id INT,
				phone_number VARCHAR(20) UNIQUE -- 添加了唯一约束
			
			);
##			* 注意mysql中，唯一约束限定的列的值可以有多个null
		
		
##		2. 删除唯一约束---DROP INDEX
		    MODIFY删不掉；
			ALTER TABLE stu DROP INDEX phone_number;
		
		3. 在创建表后，添加唯一约束---存在数据不唯一，添加约束会失败
			ALTER TABLE stu MODIFY phone_number VARCHAR(20) UNIQUE;
	
##	* 主键约束：primary key。
		1. 注意：
			1. 含义：非空且唯一
			2. 一张表只能有一个字段为主键
			3. 主键就是表中记录的唯一标识

		2. 在创建表时，添加主键约束
			create table stu(
				id int primary key,-- 给id添加主键约束
				name varchar(20)
			);

		3. 删除主键------因为唯一，所以直接删除！
			-- 错误 alter table stu modify id int ;
			ALTER TABLE stu DROP PRIMARY KEY;

		4. 创建完表后，添加主键
			ALTER TABLE stu MODIFY id INT PRIMARY KEY;

#		5. 自动增长：---auto_increment---比上一个多一
			1.  概念：如果某一列是数值类型的，使用 auto_increment 可以来完成值得自动增长

			2. 在创建表时，添加主键约束，并且完成主键自增长
			create table stu(
				id int primary key auto_increment,-- 给id添加主键约束
				name varchar(20)
			);

			
			3. 删除自动增长
			ALTER TABLE stu MODIFY id INT;
			4. 添加自动增长
			ALTER TABLE stu MODIFY id INT AUTO_INCREMENT;

注意：主键是给数据库和程序使用的，不是给最终的客户使用的。所以主键有没有含义没有关系，只要不重复，非空就行。 



##背景：单表数据容易出现（员工部门）
        1）数据冗余
        2）后期还会出现增删改的问题，一改都改!
解决：表的拆分（员工+部门） 

##	* 外键约束：foreign key,让表与表产生关系，从而保证数据的正确性。--可以为null,不可以为不存在的值
		1. 在创建表时，可以添加外键---前提是references的外表要存在!
			* 语法：
				create table 表名(
					....
					外键列 int,
					constraint 外键名称 foreign key (外键列名称) references 主表名称(主表列名称)
					constraint emp_dept_fk foreign key (dep_id) references department(id);
				);

		2. 删除外键
			ALTER TABLE 表名 DROP FOREIGN KEY 外键名称;

		3. 创建表之后，添加外键
			ALTER TABLE 表名 ADD CONSTRAINT 外键名称 FOREIGN KEY (外键字段名称) REFERENCES 主表名称(主表列名称);
		
##		背景：改外键的值很麻烦
            update employ set dep_id = null where dep_id = 1;
            update department set id = 5 where id =1;
            update employ set dep_id = 5 where dep_id is null;
		
		4. 级联操作---设置级联更新，级联删除
###			1. 添加级联操作
				语法：ALTER TABLE 表名 ADD CONSTRAINT 外键名称 
						FOREIGN KEY (外键字段名称) REFERENCES 主表名称(主表列名称) ON UPDATE CASCADE ON DELETE CASCADE  ;
			2. 分类：
				1. 级联更新：ON UPDATE CASCADE 
				2. 级联删除：ON DELETE CASCADE ---一删都删了---谨慎操作
				
		5. 默认 default 
		    如果一列没有值，使用默认值 		
## 数据库的设计

	1. 多表之间的关系
		1. 分类：
			1. 一对一(了解)：
				* 如：人和身份证
				* 分析：一个人只有一个身份证，一个身份证只能对应一个人
			2. 一对多(多对一)：
				* 如：部门和员工
				* 分析：一个部门有多个员工，一个员工只能对应一个部门
			3. 多对多：
				* 如：学生和课程
				* 分析：一个学生可以选择很多门课程，一个课程也可以被很多学生选择
		2. 实现3种关系：
			1. 一对多(多对一)：
				* 如：部门和员工
				* 实现方式：在多的一方建立外键，指向一的一方的主键。
			2. 多对多：
				* 如：学生和课程
				* 实现方式：多对多关系实现需要借助第三张中间表。中间表至少包含两个字段，这两个字段作为第三张表的外键，分别指向两张表的主键
			3. 一对一(了解)：---唯一外键 或者合成一张表
				* 如：人和身份证
				* 实现方式：一对一关系实现，可以在任意一方添加唯一外键指向另一方的主键。
		3. 案例
		复合主键（含有一个以上的字段组成）
##		联合主键（同时是两个表的主键组合起来的）

##      意义：用2个字段(或者多个字段,后面具体都是用2个字段组合)来确定一条记录，
##		说明，这2个字段都不是唯一的，2个字段单独可以分别重复，但组合起来必须是唯一的！ 
        这么设置的好处，可以很直观的看到某个重复字段的记录条数。

##		 PRIMARY KEY(rid,uid), -- 联合主键
		
            -- 创建旅游线路分类表 tab_category
			-- cid 旅游线路分类主键，自动增长
			-- cname 旅游线路分类名称非空，唯一，字符串 100
			CREATE TABLE tab_category (
				cid INT PRIMARY KEY AUTO_INCREMENT,
				cname VARCHAR(100) NOT NULL UNIQUE
			);
			
			-- 创建旅游线路表 tab_route
			/*
			rid 旅游线路主键，自动增长
			rname 旅游线路名称非空，唯一，字符串 100
			price 价格
			rdate 上架时间，日期类型
			cid 外键，所属分类
			*/
			CREATE TABLE tab_route(
				rid INT PRIMARY KEY AUTO_INCREMENT,
				rname VARCHAR(100) NOT NULL UNIQUE,
				price DOUBLE,
				rdate DATE,
				cid INT,
				FOREIGN KEY (cid) REFERENCES tab_category(cid)
			);
			
			/*创建用户表 tab_user
			uid 用户主键，自增长
			username 用户名长度 100，唯一，非空
			password 密码长度 30，非空
			name 真实姓名长度 100
			birthday 生日
			sex 性别，定长字符串 1
			telephone 手机号，字符串 11
			email 邮箱，字符串长度 100
			*/
			CREATE TABLE tab_user (
				uid INT PRIMARY KEY AUTO_INCREMENT,
				username VARCHAR(100) UNIQUE NOT NULL,
				PASSWORD VARCHAR(30) NOT NULL,
				NAME VARCHAR(100),
				birthday DATE,
				sex CHAR(1) DEFAULT '男',
				telephone VARCHAR(11),
				email VARCHAR(100)
			);
			
			/*
			创建收藏表 tab_favorite
			rid 旅游线路 id，外键
			date 收藏时间
			uid 用户 id，外键
##			rid 和 uid 不能重复，设置复合主键，同一个用户不能收藏同一个线路两次
			*/
			CREATE TABLE tab_favorite (
				rid INT, -- 线路id
				DATE DATETIME,
				uid INT, -- 用户id
				-- 创建复合主键
				PRIMARY KEY(rid,uid), -- 联合主键
				FOREIGN KEY (rid) REFERENCES tab_route(rid),
				FOREIGN KEY(uid) REFERENCES tab_user(uid)
			);		
	
	
	2. 数据库设计的范式--递次规范
		* 概念：设计数据库时，需要遵循的一些规范。要遵循后边的范式要求，必须先遵循前边的所有范式要求

			设计关系数据库时，遵从不同的规范要求，设计出合理的关系型数据库，这些不同的规范要求被称为不同的范式，各种范式呈递次规范，越高的范式数据库冗余越小。
			目前关系数据库有六种范式：第一范式（1NF）、第二范式（2NF）、第三范式（3NF）、巴斯-科德范式（BCNF）、第四范式(4NF）和第五范式（5NF，又称完美范式）。

##			学生信息表遇到问题：
			    1）存在数据冗余！姓名，系名，系主任
			    2）数据添加存在问题！新系无人
			    3）删除学生，系也没了
		* 分类：
		
			1. 第一范式（1NF）：每一列都是不可分割的原子数据项--（系列-系名与系主任）--简而言之，第一范式每一列不可再拆分，称为原子性
                见1NF.png
##			2. 第二范式（2NF）：在1NF的基础上，非码属性必须完全依赖于码（在1NF基础上消除非主属性对主码的部分函数依赖）
				* 几个概念：属性组（学号，课程名称）
					1. 函数依赖：A-->B,如果通过A属性(属性组)的值，可以确定唯一B属性的值。则称B依赖于A
						例如：学号-->姓名。  属性组（学号，课程名称） --> 分数
					2. 完全函数依赖：A-->B， 如果A是一个属性组（学号，课程名称），则B属性值得确定需要依赖于A属性组中所有的属性值。
						例如：（学号，课程名称） --> 分数
					3. 部分函数依赖：A-->B， 如果A是一个属性组，则B属性值得确定只需要依赖于A属性组中某一些值即可。
						例如：（学号，课程名称） -- > 姓名
						
					4. 传递函数依赖：A-->B, B -- >C . 如果通过A属性(属性组)的值，可以确定唯一B属性的值，
					                在通过B属性（属性组）的值可以确定唯一C属性的值，则称 C 传递函数依赖于A
						例如：学号-->系名，系名-->系主任
						
#					5. 码：如果在一张表中，一个属性或属性组，被其他所有属性所完全依赖，则称这个属性(属性组)为该表的码
						例如：该学生表中码为：（学号，课程名称），这样的属性组（称为码）可以确定唯一其他属性。
						* 主属性：码属性组中的所有属性
						* 非主属性：除过码属性组的属性
						
###			2NF要消除部分依赖：姓名 系名 系主任只依赖学号，不是完全依赖与码（学号，课程名称），分数是完全依赖码！	
				实现： 表拆分，表一（姓名 系名 系主任）表二（学号，课程名称，分数），解决了问题一
				见2NF.png
			3. 第三范式（3NF）：在2NF基础上，任何非主属性不依赖于其它非主属性（在2NF基础上消除传递依赖）
			3NF消除传递依赖：学号-->系名-->系主任，系主任传递依赖于学号
			    实现： 表再拆分，解决了剩下的问题
			    见3NF.png
       			
		范式 特点 
		1NF 原子性：表中每列不可再拆分。 
		2NF 不产生局部依赖，一张表只描述一件事情 
		3NF 不产生传递依赖，表中每一列都直接依赖于主键。而不是通过其它列间接依赖于主键。 	
			
## 数据库的备份和还原（DBA数据库管理员）

	1. 命令行：
		* 语法：
			* 备份： mysqldump -u用户名 -p密码 数据库名称 > 保存的路径
			        mysqldump -u用户名 -p密码 db1 > d://a.sql
			* 还原：
				1. 登录数据库
				2. 创建数据库--create database db;
				3. 使用数据库--use db;
				4. 执行文件。source 文件路径--source d://a.sql;
	2. 图形化工具：
	
	
	
							