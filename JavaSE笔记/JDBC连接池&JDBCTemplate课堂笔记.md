# 今日内容
	1. 数据库连接池

	2. Spring JDBC : JDBC Template




背景：之前每个类（day04中JDBC1-10）跑一次，都要申请连接资源然后又释放！！！耗时浪费

## 数据库连接 池
	1. 概念：其实就是一个容器(集合)，存放数据库连接的容器。
		    当系统初始化好后，容器被创建，容器中会申请一些连接对象，
		    当用户来访问数据库时，从容器中获取连接对象，用户访问完之后，会将连接对象归还给容器。

	2. 好处：
		1. 节约资源
		2. 用户访问高效

##	3. 实现：
###		1. 标准接口：DataSource   javax.sql包下的
			1. 方法：
				* 获取连接：getConnection()
				* 归还连接：Connection.close()。
				        如果连接对象Connection是从连接池中获取的，
				        那么调用Connection.close()方法，则不会再关闭连接了。而是归还连接

		2. 一般我们不去实现它，有数据库厂商来实现
			1. C3P0：数据库连接池技术
			2. Druid：数据库连接池实现技术，由阿里巴巴提供的


	4. C3P0：数据库连接池技术--------可连接不同数据源，默认default
		* 步骤：
			1. 导入jar包 (两个) c3p0-0.9.5.2.jar 依赖mchange-commons-java-0.2.12.jar ，
				* 不要忘记导入数据库驱动jar包
			2. 定义配置文件：
				* 名称： c3p0.properties 或者 c3p0-config.xml
				* 路径：直接将文件放在src目录下即可。

			3. 创建核心对象 数据库连接池对象 ComboPooledDataSource
			4. 获取连接： getConnection
		* 代码：
			 //1.创建数据库连接池对象
	        DataSource ds  = new ComboPooledDataSource();
	        //2. 获取连接对象
	        Connection conn = ds.getConnection();
	        
###	5. Druid：数据库连接池实现技术，由阿里巴巴提供的
		1. 步骤：
			1. 导入jar包 druid-1.0.9.jar
			2. 定义配置文件：
				* 是properties形式的
				* 可以叫任意名称，可以放在任意目录下----不会自动加载，手动指定路径和名称加载
			3. 加载配置文件。Properties
			4. 获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
			5. 获取连接：getConnection
		* 代码：
			 //3.加载配置文件
	        Properties pro = new Properties();
	        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
	        pro.load(is);
	        //4.获取连接池对象
	        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
	        //5.获取连接
	        Connection conn = ds.getConnection();
	        
		2. 定义工具类
			1. 定义一个类 JDBCUtils
			2. 提供静态代码块加载配置文件，初始化连接池对象
			3. 提供连接方法
				1. 获取连接方法：通过数据库连接池获取连接
				2. 释放资源
				3. 获取连接池的方法

		* 代码：JDBCUtils
		
			