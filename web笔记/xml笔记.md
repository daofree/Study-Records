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
					
#     * 约束：规定xml文档的书写规则
##---------要求：读懂
			* 作为框架的使用者(程序员)：
				1. 能够在xml中引入约束文档
				2. 能够简单的读懂约束文档
			
			* 分类：
				1. DTD:一种简单的约束技术
				2. Schema:一种复杂的约束技术


#			* DTD（.dtd文件）：-----限制不了里面的内容
##				* 引入dtd文档到xml文档中
					* 内部dtd：将约束规则定义在xml文档中
					* 外部dtd：将约束的规则定义在外部的dtd文件中
						* 本地SYSTEM：<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">
						* 网络PUBLIC：<!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件的位置URL">
<!ATTLIST student number ID #REQUIRED>
属性number，属性类型ID，必须出现，ID表示number唯一
（#PCDATA）是字符串



#			* Schema（.xsd文件）:（DTD限制不了字符串里面的内容）
				* 引入：在根标签里面引入
					1.填写xml文档的根元素
					2.引入xsi前缀.  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
					3.引入xsd文件命名空间.  xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"
					4.为每一个xsd约束声明一个前缀,作为标识  xmlns="http://www.itcast.cn/xml" 

				<students   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
					xmlns="http://www.itcast.cn/xml"
					xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd">


约束文件定义的所有元素的别名targetNamespace（命名空间）  约束文件名

#  3. 解析：操作xml文档，将文档中的数据读取到内存中
		* 操作xml文档
			1. 解析(读取)：将文档中的数据读取到内存中
			2. 写入：将内存中的数据保存到xml文档中。持久化的存储

		* 解析xml的方式：两种思想
			1. DOM：将标记语言文档一次性加载进内存，在内存中形成一颗dom树
				* 优点：操作方便，可以对文档进行CRUD的所有操作
				* 缺点：占内存（树的内存是文档的几千倍）
				* 服务器端
			2. SAX：逐行读取，读一行释放一行，指针下移一行；所以是基于事件驱动的。
				* 优点：不占内存。
				* 缺点：只能读取，不能增删改
				* 移动端，如安卓


# * xml常见的解析器：思想的实现（三方工具）
			1. JAXP：sun公司提供的解析器，支持dom和sax两种思想，（烂，性能低，麻烦）
			2. DOM4J：一款非常优秀的解析器。
			3. Jsoup：jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。
			    它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
			4. PULL：Android操作系统内置的解析器，sax方式的。




#		* Jsoup：jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。
#        它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
#Jsoup是因为爬虫程序火起来的
			* 快速入门：
				* 步骤：
					1. 导入jar包
					2. 获取Document对象
					3. 获取对应的标签Element对象
					4. 获取数据

			* 代码：
				 //2.1获取student.xml的path
		        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
		        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
		        Document document = Jsoup.parse(new File(path), "utf-8");
		        //3.获取元素对象 Element
		        Elements elements = document.getElementsByTag("name");
		
		        System.out.println(elements.size());
		        //3.1获取第一个name的Element对象
		        Element element = elements.get(0);
		        //3.2获取数据
		        String name = element.text();
		        System.out.println(name);

#      * 对象的使用：
			1. Jsoup：工具类，可以解析html或xml文档，返回Document
				* parse：解析html或xml文档，返回Document
					* 文件parse​(File in, String charsetName)：解析xml或html文件的。
					* 字符串parse​(String html)：解析xml或html字符串
					* 远程parse​(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
# 远程parse------->爬虫
			2. Document：文档对象。代表内存中的dom树
				* 获取任意Element对象
					* getElementById​(String id)：根据id属性值获取唯一的element对象
					* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
					* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
					* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
			3. Elements：元素Element对象的集合。可以当做 ArrayList<Element>来使用
			4. Element：元素对象
				1. 获取子元素对象
					* getElementById​(String id)：根据id属性值获取唯一的element对象
					* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
					* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
					* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合

				2. 获取属性值
					* String attr(String key)：根据属性名称获取属性值
				3. 获取文本内容
					* String text():获取所有子标签纯文本内容
					* String html():获取该标签体里面的所有内容(包括子标签的标签和文本内容)
					
			5. Node：节点对象
				* 是Document和Element的父类。方法大家都可用！















