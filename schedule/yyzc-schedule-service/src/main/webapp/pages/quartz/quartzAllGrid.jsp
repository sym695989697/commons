<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>参考例子</title>
<jsp:include page="/pages/index/all_css.jsp" />
<jsp:include page="/pages/index/all_js.jsp" />
<script src="<%=request.getContextPath()%>/scripts/js/quartz/quartzAllGrid.js" type="text/javascript"></script>

</head>
<body style="padding: 0px">
	<div class="conBox">
		<table border="0">
			<tr>
				<td height="40" width="80" align="right">
					作业名称：
				</td>
				<td width="70" align="left" >
					<input type="text" id="jobName" name="jobName" style="width:100px"/>
				</td>
				<td height="40" width="80" align="right">
					作业分组：
				</td>
				<td width="70" align="left" >
					<input type="text" id="jobGroup" name="jobGroup" style="width:100px"/>
				</td>
				<td height="40" width="80" align="right">
					状态：
				</td>
				<td width="70" align="left" >
					<select id="triggerState" name="triggerState">
						<option value="-1">请选择</option>
						<option value="ACQUIRED">正常运行</option>
						<option value="PAUSED">暂停运行</option>
						<option value="WAITING">等候运行</option>
					</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td height="40" width="110" align="right">
					创建时间：
				</td>
				<td width="240" align="left" colspan="2">
					<input type="text" id="createTime1" name="createTime1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px"/>
					-
					<input type="text" id="createTime2" name="createTime2" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px"/>
				</td>
				<td height="40" width="110" align="right">
					下次执行时间：
				</td>
				<td width="240" align="left" colspan="2">
					<input type="text" id="nextTime1" name="nextTime1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px"/>
					-
					<input type="text" id="nextTime2" name="nextTime2" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px"/>
				</td>
				<td height="40" width="110" align="right">
					上次执行时间：
				</td>
				<td width="240" align="left" colspan="2">
					<input type="text" id="prevTime1" name="prevTime1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px"/>
					-
					<input type="text" id="prevTime2" name="prevTime2" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px"/>
				</td>
				<td width="110"  style="text-align: center;">
					<input type="button" value="查询" style="width: 50px" id="preciseQuery"/>
				</td>
			</tr>
		</table>
	</div>
	<div id="grid"></div>
</body>
</html>