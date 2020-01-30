# 今日内容：
	1. JavaScript：
		1. ECMAScript：基础语法+基本对象
		2. BOM：浏览器对象
		3. DOM：文档对象
			1. 事件

## DOM简单学习：为了满足案例要求
	* 功能：控制（增删改查）html（标签属性内容注释等）文档的内容
	此处先知道一个，在dom中，标签(元素)都被封装一个对象，叫Element对象。
	* 获取页面标签(元素)对象：Element。
		* document.getElementById("id值"):通过元素的id获取元素对象
不要先执行脚本，后加载，要先加载 后执行脚本！！

	* 操作Element对象：
		1. 修改属性值：
			1. 明确获取的对象是哪一个？
			2. 查看API文档，找其中有哪些属性可以设置
		2. 修改标签体里面的内容：
			* 属性：对象.innerHTML = "XXXXX";
			1. 获取元素对象，html中每一个标签元素，都是DOM对象！
			2. 使用innerHTML属性修改标签体内容

## 事件简单学习
	* 功能： 某些组件被执行了某些操作(比如点击等)后，触发某些代码的执行（改变结果）。
		* 造句：  xxx被xxx,我就xxx
			* 我方水晶被摧毁后，我就责备对友。
			* 敌方水晶被摧毁后，我就夸奖自己。

	* 如何绑定事件
	##两种方式
		1. 直接在html标签上，指定事件的属性(操作)，属性值就是js代码
			1. 其中一个事件：onclick--- 单击事件
## 注意：标签与事件绑定在一起了，耦合度高
		2. 通过js获取元素对象，指定事件属性，设置一个函数
		
##注意： 
        1.注意是否可以先执行JS，后加载html；（获取不到元素对象）
        2.直接绑定包括直接代码（不可取）和间接代码（onclick="fun();"）；
        3.DOM获取元素对象间接绑定；
        4.通过案例发现：一个方法只能绑定一次，第二次绑定无效。
        
# BOM:描述与浏览器进行交互的方法和接口
	1. 概念：Browser Object Model 浏览器对象模型
		* 即：将浏览器的各个组成部分封装成对象。

	2. 5个组成：
		* Window：窗口对象（最重要，当前窗口又包括：地址栏Location对象，历史记录History对象（前进后退），中间Body网页内容对象）
            * History：历史记录对象
            * Location：地址栏对象
            * 网页（html）显示内容，即DOM对象（Document）
		* Navigator：浏览器对象（浏览器本身就是对象）
		* Screen：显示器屏幕对象

	3. Window：窗口对象(弹框，窗口，定时器)
	    1. 创建
	    2. 方法,注意有的有返回值如选择框。
	         1. 与弹出框有关的方法：
##警告，选择，输入三个框
	            alert()	显示带有一段消息和一个确认按钮的警告框。
	            confirm()	显示带有一段消息以及确认按钮和取消按钮的对话框。
	                * 如果用户点击确定按钮，则方法返回true
	                * 如果用户点击取消按钮，则方法返回false
	            prompt()	显示可提示用户输入的对话框。
	                * 返回值：获取用户输入的值
	                
	         2. 与打开关闭有关的方法：
	            close()	关闭浏览器窗口。
	                * 谁调用我 ，我关谁。默认当前的window对象。
	            open()	打开一个新的浏览器窗口
	                * 返回新的Window对象,给close用。
	         3. 与定时器有关的方法（一次与周期）
	            setTimeout()	在指定的毫秒数后调用函数或计算表达式。
	                * 参数：
	                    1. js代码或者方法对象
	                    2. 毫秒值
	                * 返回值：唯一标识，用于取消定时器
	            clearTimeout()	取消由 setTimeout() 方法设置的 timeout。
	
	            setInterval()	按照指定的周期（以毫秒计）来调用函数或计算表达式。
	            clearInterval()	取消由 setInterval() 设置的 timeout。
	
	    3. Window的属性：
	        1. 获取其他BOM对象：
	            history
	            location
	            Navigator
	            Screen:
	        2. 获取DOM对象
	            document
	    4. 特点
	        * Window对象不需要创建可以直接使用 window使用。 window.方法名();
	        * window引用可以省略。  方法名();


	4. Location：地址栏对象
		1. 创建(获取)：
			1. window.location
			2. location

		2. 方法：
			* reload()	重新加载当前文档。刷新
		3. 属性
			* href	设置=""或返回完整的 URL。
##    location.href = "https://www.baidu.com"
##    let href = location.href;

	5. History：历史记录对象
        1. 创建(获取)：
            1. window.history
            2. history

        2. 方法：
            * back()	加载 history 列表中的前一个 URL。
            * forward()	加载 history 列表中的下一个 URL。
            * go(参数)	加载 history 列表中的某个具体页面。
                * 参数：
                    * 正数：前进几个历史记录
                    * 负数：后退几个历史记录
        3. 属性：
            * length	返回当前窗口历史列表中的 URL 数量。











