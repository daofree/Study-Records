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

