## 今日内容：
	1. JQuery 高级
		1. 动画
		2. 遍历
		3. 事件绑定
		4. 案例
		5. 插件




## JQuery 高级
	1. 动画
		1. 三种方式显示和隐藏元素
			1. 默认显示和隐藏方式
				1. show([speed,[easing],[fn]])
					1. 参数：
						1. speed：动画的速度。三个预定义的值("slow","normal", "fast")或表示动画时长的毫秒数值(如：1000)
						2. easing：用来指定切换效果，默认是"swing"，可用参数"linear"
							* swing：动画执行时效果是 先慢，中间快，最后又慢
							* linear：动画执行时速度是匀速的
						3. fn：在动画完成时执行的函数，每个元素执行一次。

				2. hide([speed,[easing],[fn]])
				3. toggle([speed],[easing],[fn])
			
			2. 滑动显示和隐藏方式
				1. slideDown([speed],[easing],[fn])
				2. slideUp([speed,[easing],[fn]])
				3. slideToggle([speed],[easing],[fn])

			3. 淡入淡出显示和隐藏方式
				1. fadeIn([speed],[easing],[fn])
				2. fadeOut([speed],[easing],[fn])
				3. fadeToggle([speed,[easing],[fn]])


	
	
