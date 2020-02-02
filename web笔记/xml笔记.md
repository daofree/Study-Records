# 今日内容
	1. XML
		1. 概念
		2. 语法
		3. 解析


## XML：
	1. 概念：Extensible Markup Language 可扩展标记语言
		* 可扩展：标签都是自定义的。 <user>  <student>
#标记语言：标签构成的语言
##		* 功能
##			* 存储数据
				1. 配置文件
				2. 在网络中传输（XML是纯文本的，跨平台，跟语言平台没关系，作为数据的载体很方便）
##		* xml与html的区别（来源于W3C）
			1. xml标签都是自定义的，html标签是预定义。
			2. xml的语法严格，html语法松散，怎么乱写（缺胳膊少腿的），浏览器（市场竞争）都支持解析。
			3. xml是存储数据的，html是展示数据。干死了properties配置文件（多个用户信息，乱了，只能存简单数据）。

		* w3c:万维网联盟

	2. 语法：
		* 基本语法：
			1. xml文档的后缀名 .xml
			2. xml第一行必须定义为文档声明<?xml version='1.0' ?>，不能为空
			3. xml文档中有且仅有一个根标签
			4. 属性值必须使用引号(单双都可)引起来
			5. 标签必须正确关闭
			6. xml标签名称区分大小写
		* 快速入门：
			<?xml version='1.0' ?>----文档声明
			<users>
				<user id='1'>
					<name>zhangsan</name>
					<age>23</age>
					<gender>male</gender>
					<br/>
				</user>
				
				<user id='2'>
					<name>lisi</name>
					<age>24</age>
					<gender>female</gender>
				</user>
			</users>
			
##		* 组成部分：
			1. 文档声明
				1. 格式：<?xml 属性列表 ?>
				2. 属性列表：
					* version：版本号，必须的属性。1.1不向下兼容。 
					* encoding：编码方式。告知解析引擎当前文档使用的字符集，默认值：ISO-8859-1
					* standalone：是否独立
						* 取值：
							* yes：不依赖其他文件
							* no：依赖其他文件
			2. 指令(了解)：结合css的
				* <?xml-stylesheet type="text/css" href="a.css" ?>
##			3. 标签：标签（==元素）名称自定义的
				* 规则：
					* 名称可以包含字母、数字以及其他的字符 
					* 名称不能以数字或者标点符号开始 
					* 名称不能以字母 xml（或者 XML、Xml 等等）开始 
					* 名称不能包含空格 

			4. 属性：键值对
				id属性值唯一
			5. 文本：特殊字符$lt;$amp;$gt;
				* CDATA区：在该区域中的数据会被原样展示
					* 格式：  <![CDATA[ 数据 ]]>
