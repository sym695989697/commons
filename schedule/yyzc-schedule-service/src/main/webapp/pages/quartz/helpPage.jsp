<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
<!--
div{
	width: 850px;
	margin-left: 25px;
}
h3{
	margin-top: 20px;
}
-->
</style>
<title>触发器设置帮助文档</title>
</head>
<body>
	<div>
		 <p style="text-indent: 2em;">
		 	被调用方法全路径:被调用方法就是定时业务要调用的方法，本系统统一采用HTTP的POST请求调用方法。
		 	路径书写方式为：路径（例如：http://....）+方法名（例如：find....()）如果有参数在方法名后面写“？”号
		 	再写参数1=...（例如：name..=...）&&参数2=...(例如：password..=...)。参数之间用“&&”相连。
		 	完整例子：http://www.wzlz.com/sayHello?name=nihao&&pwd=123。
		 </p>
		 <p style="text-indent: 2em;">
			 触发器：它用于定义 Job 何时执行。最常用的是 SimpleTrigger 和 CronTrigger 。
			 一般来说，如果你需要在一个固定的时间和重复次数，那么 SimpleTrigger 比较合适；
			 如果你有许多复杂的作业调度，那么 CronTrigger 比较合适。关于状态，有状态的情况
			 下上次执行完毕才执行下次任务。如果上次执行阻塞则下次执行等待中。无状态就不存在这个问题
			 类似于方法同步。
		 </p>
		 <p style="text-indent: 2em;">
			 当需要在规定的时间执行一次或在规定的时间段以一定的时间间隔重复触发执行Job时，
			 SimpleTrigger就可以满足要求；SimpleTrigger的属性有：开始时间、重复次数和重复的时间间隔，
			 重复次数属性的值可以为0。</br>
			而CronTrigger我们需要的只是一个 cron 表达式。比如:“ 0 0 12 * * ? ”会在每天中午 12 点触发 执行；
			</br>“ 0 15 10 ? * 6L ”会在每个月的最后一个星期五的早上 10:15 触发 Job 执行。
		</p>
		cron表达式规则：
		<table>
			<tr>
				<td>字段名</td>
				<td>允许的值 </td>
				<td>允许的特殊字符</td>
			</tr>
			<tr>
				<td>秒 </td>
				<td>0-59</td>
				<td>, - * /</td>
			</tr>
			<tr>
				<td>分 </td>
				<td>0-59</td>
				<td>, - * /</td>
			</tr>
			<tr>
				<td>小时 </td>
				<td>0-59</td>
				<td>, - * /</td>
			</tr>
			<tr>
				<td>日 </td>
				<td>1-31 </td>
				<td>, - * ? / L W C</td>
			</tr>
			<tr>
				<td>月</td>
				<td>1-12 or JAN-DEC</td>
				<td>, - * /</td>
			</tr>
			<tr>
				<td>周几</td>
				<td>1-7 or SUN-SAT</td>
				<td>, - * ? / L C #</td>
			</tr>
			<tr>
				<td>年 (可选字段)</td>
				<td>empty, 1970-2099</td>
				<td>, - * /</td>
			</tr>
		</table>
		<p>  
			'*' 字符可以用于所有字段，在“分”字段中设为"*"表示"每一分钟"的含义。
		</p> 
		<p>
			'?' 字符可以用在“日”和“周几”字段. 它用来指定 '不明确的值'. 这在你需要指定这两个字段中的某一个值而不是另外一个的时候
			会被用到。在后面的例子中可以看到其含义。
		</p> 
		<p> 	
			'-' 字符被用来指定一个值的范围，比如在“小时”字段中设为"10-12"表示"10点到12点".
		</p> 	
		<p> 	
			',' 字符指定数个值。比如在“周几”字段中设为"MON,WED,FRI"表示"the days 
			Monday, Wednesday, and Friday".
		</p> 	
		<p> 
			'/' 字符用来指定一个值的的增加幅度. 比如在“秒”字段中设置为"0/15"表示"第0, 15, 30, 和 45秒"。而 "5/15"
			则表示"第5, 20, 35, 和 50". 在'/'前加"*"字符相当于指定从0秒开始. 每个字段都有一系列可以开始或结束的数值。
			对于“秒”和“分”字段来说，其数值范围为0到59，对于“小时”字段来说其为0到23, 对于“日”字段来说为0到31, 
			而对于“月”字段来说为1到12。"/"字段仅仅只是帮助你在允许的数值范围内从开始"第n"的值。 因此对于“月”字段来说"7/6"
			只是表示7月被开启而不是“每六个月”, 请注意其中微妙的差别。
		</p> 	
		<p> 
			'L'字符可用在“日”和“周几”这两个字段。它是"last"的缩写, 但是在这两个字段中有不同的含义。
			例如,“日”字段中的"L"表示"一个月中的最后一天" —— 对于一月就是31号对于二月来说就是28号（非闰年）。
			而在“周几”字段中, 它简单的表示"7" or "SAT"，但是如果在“周几”字段中使用时跟在某个数字之后, 
			它表示"该月最后一个星期×" —— 比如"6L"表示"该月最后一个周五"。当使用'L'选项时,指定确定的列表或者范围非常重要，
			否则你会被结果搞糊涂的。
		</p> 	
		<p> 	
			'W' 可用于“日”字段。用来指定历给定日期最近的工作日(周一到周五) 。
			比如你将“日”字段设为"15W"，意为: "离该月15号最近的工作日"。因此如果15号为周六，
			触发器会在14号即周五调用。如果15号为周日, 触发器会在16号也就是周一触发。如果15号为周二,那么当天就会触发。
			然而如果你将“日”字段设为"1W", 而一号又是周六, 触发器会于下周一也就是当月的3号触发,因为它不会越过当月的值的范围边界。</br>
			'W'字符只能用于“日”字段的值为单独的一天而不是一系列值的时候。
			'L'和'W'可以组合用于“日”字段表示为'LW'，意为"该月最后一个工作日"。
		</p> 	
		<p> 	
			'#' 字符可用于“周几”字段。该字符表示“该月第几个周×”，比如"6#3"表示该月第三个周五( 6表示周五而"#3"该月第三个)。
			再比如: "2#1" = 表示该月第一个周一而 "4#5" = 该月第五个周三。注意如果你指定"#5"该月没有第五个“周×”，
			该月是不会触发的。
		</p> 	
		<p> 	
			'C' 字符可用于“日”和“周几”字段，它是"calendar"的缩写。它表示为基于相关的日历所计算出的值（如果有的话）。
			如果没有关联的日历, 那它等同于包含全部日历。“日”字段值为"5C"表示"日历中的第一天或者5号以后"，
			“周几”字段值为"1C"则表示"日历中的第一天或者周日以后"。
			对于“月份”字段和“周几”字段来说合法的字符都不是大小写敏感的。
		</p>  
		下面是一些完整的例子:
		<table>
			<tr>
				<td>表达式</td>
				<td>含义</td>
			</tr>
			<tr>
				<td>"0 0 12 * * ?" </td>
				<td>每天中午十二点触发</td>
			</tr>
			<tr>
				<td>"0 15 10 ? * *" </td>
				<td>每天早上10：15触发</td>
			</tr>
			<tr>
				<td>"0 15 10 * * ?" </td>
				<td>每天早上10：15触发</td>
			</tr>
			<tr>
				<td>"0 15 10 * * ? *"</td>
				<td>每天早上10：15触发</td>
			</tr>
			<tr>
				<td>"0 15 10 * * ? 2005"</td>
				<td>2005年的每天早上10：15触发</td>
			</tr>
			<tr>
				<td>"0 * 14 * * ?" </td>
				<td>每天从下午2点开始到2点59分每分钟一次触发</td>
			</tr>
			<tr>
				<td>"0 0/5 14 * * ?" </td>
				<td>每天从下午2点开始到2：55分结束每5分钟一次触发</td>
			</tr>
			<tr>
				<td>"0 0/5 14,18 * * ?" </td>
				<td>每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发</td>
			</tr>
			<tr>
				<td>"0 0-5 14 * * ?" </td>
				<td>每天14:00至14:05每分钟一次触发</td>
			</tr>
			<tr>
				<td>"0 10,44 14 ? 3 WED" </td>
				<td>三月的每周三的14：10和14：44触发</td>
			</tr>
			<tr>
				<td>"0 15 10 ? * MON-FRI"</td>
				<td>每个周一、周二、周三、周四、周五的10：15触发</td>
			</tr>
			<tr>
				<td>"0 15 10 15 * ?" </td>
				<td>每月15号的10：15触发</td>
			</tr>
			<tr>
				<td>"0 15 10 L * ?" </td>
				<td>每月的最后一天的10：15触发</td>
			</tr>
			<tr>
				<td>"0 15 10 ? * 6L" </td>
				<td>每月最后一个周五的10：15触发</td>
			</tr>
			<tr>
				<td>"0 15 10 ? * 6L"</td>
				<td>每月最后一个周五的10：15触发</td>
			</tr>
			<tr>
				<td>"0 15 10 ? * 6L 2002-2005"</td>
				<td>2002年至2005年的每月最后一个周五的10：15触发</td>
			</tr>
			<tr>
				<td>"0 15 10 ? * 6#3"</td>
				<td>每月的第三个周五的10：15触发</td>
			</tr>
		</table> 	  	
	</div>
</body>
</html>