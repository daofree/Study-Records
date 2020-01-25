# 今日内容：

	1. HTML标签：表单标签

	2. CSS：样式与布局


##  HTML标签：表单标签,属性=
	* 表单：form
		* 概念：用于采集用户输入的数据的。用于和服务器进行交互。
		* form：用于定义表单的。可以定义一个范围，范围代表采集用户数据的范围
            * 属性：
                * action：指定提交数据的URL,#当前页面
                * method:指定提交方式
                    * 分类：一共7种，2种比较常用
                       * get：
                            1. 请求参数会在地址栏中显示。会封装到请求行中(HTTP协议后讲解)。
                            2. 请求参数大小是有限制的。
                            3. 不太安全。
                       * post：
                            2. 请求参数不会再地址栏中显示。会封装在请求体中(HTTP协议后讲解)
                            2. 请求参数的大小没有限制。
                            3. 较为安全。

            * 表单项中的数据要想被提交：必须指定其name属性
没有form不会提交，没有name，不被提交（没有提交内容）
		
		* form里面表单项标签：
			* 1.输入控件input：可以通过type属性值，改变元素展示的样式
				* type属性：
					* 默认text：文本输入框，默认值
						* placeholder：指定输入框的提示信息，当输入框的内容发生变化，会自动清空提示信息	
					* password：密码输入框
					* radio:单选框，不管哪一个，选中就是on，要value属性赋值
						* 注意：
							1. 要想让多个单选框实现单选的效果，则多个单选框的name属性值必须一样。
							2. 一般会给每一个单选框提供value属性，指定其被选中后提交的值
							3. checked属性，可以指定默认值
					* checkbox：复选框
						* 注意：
							1. 一般会给每一个单选框提供value属性，指定其被选中后提交的值
							2. checked属性，可以指定默认值

					* file：文件选择框
					* hidden：隐藏域，用于提交一些信息。
					* 按钮：
						* submit：普通提交按钮。可以提交表单
						* button：就是普通按钮,和js合作。
						* image：图片提交按钮（登录）
							* src属性指定图片的路径	

			   * 光标提示效果label：指定输入项的文字描述信息
				   * 注意：
					   * label的for属性一般会和 input 的 id属性值 对应。如果对应了，则点击label区域，会让input输入框获取焦点。
			* 2.select: 下拉列表
				* 子元素：option，指定列表项
				
    			* 3.textarea：文本域
				* cols：指定列数，每一行有多少个字符
				* rows：默认多少行。

## CSS：页面美化和布局控制
	1. 概念： Cascading Style Sheets 层叠样式表
		* 层叠：多个样式可以作用在同一个html的元素（标签）上，可以同时生效（层叠）

	2. 好处：
		1. 功能强大（html控制样式的属性单一，功能单一）
		2. 将内容展示和样式控制分离
			* 降低耦合度。即解耦。html中样式控制和元素显示在一起<font color="red"...
			* 解耦可以让分工协作更容易
			* 解耦可以提高开发效率
	参考示例，感受一下：https://www.runoob.com/try/demo_source/demo_default.htm

	3. CSS的使用：CSS需要与html结合
	方式有三：
		1. 内联样式---作用域：当前标签：style键值冒，内联style结合,属性：
			 * 在标签内使用style属性指定css代码
			 * 如：<div style="color:red;">hello css</div>
	      （不推荐，样式控制和元素展示在一起，没有达到内容展示和样式控制分离）
		2. 内部样式--作用域：当前页面所有选择的标签
			* 在head标签内，定义style标签，style标签的标签体内容就是css代码
			* 如：
				<style>
			        div{
			            color:blue;
			        }
			
			    </style>
				<div>hello css</div>
		3. 外部样式--作用域：其他页面link引用
			1. 定义css资源文件。
    		2. 在head标签内，定义link标签，引入外部的资源文件
    		* 如：
	    		* a.css文件：
					div{
					    color:green;
					}
				<link rel="stylesheet" href="css/a.css">
				<div>hello css</div>
				<div>hello css</div>

		* 注意：
			* 1,2,3种方式 css作用范围越来越大
			* 1方式不常用，后期常用2,3
			* 3种格式可以写为：
				<style>
			        @import "css/a.css";
			    </style>
