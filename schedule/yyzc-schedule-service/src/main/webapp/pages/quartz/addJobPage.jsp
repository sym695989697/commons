<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/pages/index/all_css.jsp" />
<jsp:include page="/pages/index/all_js.jsp" />
<script src="<%=request.getContextPath()%>/scripts/js/quartz/addJobPage.js" type="text/javascript"></script>
<style type="text/css">
<!--
span{
	color: red;
}
table{
	font-size: 13px;
}
td{
	width: 400px;
}
tr{
	height: 50px;
}
input{
	width: 100px;
}
.nameRows{
	text-align: right;
	padding-right: 15px;
	width: 150px;
}
#FromTable{
	margin-left: 120px;
}
-->
</style>
<title>添加任务</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<td class="nameRows">
					作业名称：
				</td>
				<td>
					<input type="text" id="jobName" name="jobName"/>
					<span id="jobNameSign">*</span>
				</td>
			</tr>
			<tr>
				<td class="nameRows">
					作业组名：
				</td>
				<td>
					<input type="text" id="jobGroup" name="jobGroup"/>
					<span id="jobGroupSign">*</span>
				</td>
			</tr>
			<tr>
				<td class="nameRows">
					触发策略：
				</td>
				<td>
					<input type="text" id="cronExpression" name="cronExpression" value="0 0 12 * * ?"/>
					<span id="cronSign">*</span>
					<span id="cronSign">默认每天中午12点触发。更多请查看帮助文档。</span>
				</td>
			</tr>
			<tr>
				<td class="nameRows">
					等待上一次执行完成：
				</td>
				<td>
					<select id="waitPrev" name="waitPrev">
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
					<span id="cronSign">任务执行时间过程，下次触发时间到了后是否进行任务触发</span>
				</td>
			</tr>
			<tr>
				<td class="nameRows">
					错误处理：
				</td>
				<td>
					<select id="mistakeDo" name="mistakeDo">
						<option value="1">继续</option>
						<option value="0">暂停</option>
					</select>
					<span id="cronSign">任务执行发生错误，是继续触发还是暂停</span>
				</td>
			</tr>
			<tr>
				<td class="nameRows">
					调用路径：
				</td>
				<td>
					<input type="text" id="url" name="url" style="width: 240px"/>
					<span id="urlSign">*</span>
				</td>
			</tr>
			<tr>
				<td class="nameRows">
					作业简述：
				</td>
				<td>
					<textarea rows="2" cols="34" id="description" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<td class="nameRows" colspan="2" style="text-align: center;">
					<input type="button" id="submitButton" value="提交任务" style="width: 100px;" onclick="javascript:add()"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>