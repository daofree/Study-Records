# 今日内容
	1. Bootstrap




## Bootstrap：
	1. 概念： 一个前端开发的框架，Bootstrap，来自 Twitter，是目前很受欢迎的前端框架。
	          Bootstrap 是基于 HTML、CSS、JavaScript 的，它简洁灵活，使得 Web 开发更加快捷。
		* 框架:一个半成品软件，开发人员可以在框架基础上，在进行开发，简化编码。
		* 好处：
			1. 定义了很多的css样式和js插件。
			    * 我们开发人员直接可以使用这些样式和插件得到丰富的页面效果。
			2. 响应式布局。-----栅格系统，3个类，class容器-1行-12列
				* 同一套页面可以兼容不同分辨率的设备。


	2. 快速入门
		1. 下载Bootstrap，bootstrap-3.3.7-dist.zip
		2. 解压后，在项目中将这三个文件夹复制
		3. 创建html页面，引入必要的资源文件

##jQuery是JS重要的框架
##Bootstrap基本模板-----注意meta设置
		<!DOCTYPE html>
		<html lang="zh-CN">
		<head>
		    <meta charset="utf-8">
		    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		    <title>Bootstrap HelloWorld</title>
		
		    <!-- Bootstrap -->
		    <link href="css/bootstrap.min.css" rel="stylesheet">
		
		    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		    <script src="js/jquery-3.2.1.min.js"></script>
		    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		    <script src="js/bootstrap.min.js"></script>
		</head>
		<body>
		<h1>你好，世界！</h1>
		
		</body>
		</html>

## 响应式布局-----------https://v3.bootcss.com/css/#grid
	* 同一套页面可以兼容不同分辨率的设备。
	* 实现：
	    依赖于栅格系统：将一行平均分成12个格子，可以指定元素占几个格子
	* 3步骤：
		1. 定义容器（栅格系统/把行放到容器里）。相当于之前的table、
##			* 容器分类：
				1. container：两边留有空白
				2. container-fluid：每一种设备都是100%宽度
		2. 定义行。相当于之前的tr（行）   样式：row
		3. 定义元素。指定该元素在不同的设备上，所占的格子数目。col(列)，样式：col-设备代号-格子数目
			* 设备代号：
				1. xs：超小屏幕 手机 (<768px)：col-xs-12
				2. sm：小屏幕 平板 (≥768px)
				3. md：中等屏幕 桌面显示器 (≥992px)
				4. lg：大屏幕 大桌面显示器 (≥1200px)

		* 注意：
			1. 一行中如果格子数目超过12，则超出部分自动换行。-------自动换行
			2. 栅格类属性可以向上兼容。栅格类适用于与屏幕宽度大于或等于分界点大小的设备。------向上兼容即样式不变
			3. 如果真实设备宽度小于了设置栅格类属性的设备代码的最小值，会一个元素沾满一整行。----向下不兼容即样式变化
			
			
## CSS样式和JS插件
	1. 全局CSS样式：
##---https://v3.bootcss.com/css/
		* 按钮：class="btn btn-default"
		* 图片：
			*  class="img-responsive"：图片在任意尺寸都占100%
			*  图片形状
				*  <img src="..." alt="..." class="img-rounded">：方形
				*  <img src="..." alt="..." class="img-circle"> ： 圆形
				*  <img src="..." alt="..." class="img-thumbnail"> ：相框
				
		* 表格
##-----https://v3.bootcss.com/css/#tables
			* table
			* table-bordered
			* table-hover
		* 表单
##----https://v3.bootcss.com/css/#forms
			* 给表单项添加：class="form-group" class="form-control" 
	2. 组件：
##----https://v3.bootcss.com/components/
		* 导航条
##----https://v3.bootcss.com/components/#navbar
		-----哪里不会删哪里
		* 分页条
##----https://v3.bootcss.com/components/#pagination		
	3. 插件：
		* 轮播图
