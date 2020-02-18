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
					