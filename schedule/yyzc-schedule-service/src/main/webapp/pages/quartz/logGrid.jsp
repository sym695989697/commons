<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>参考例子</title>
<jsp:include page="/pages/index/all_css.jsp" />
<jsp:include page="/pages/index/all_js.jsp" />
<script src="<%=request.getContextPath()%>/scripts/js/quartz/logGrid.js" type="text/javascript"></script>

</head>
<body style="padding: 0px">
	<div class="conBox">
		<table border="0">
			<tr>
				<td height="40" width="80" align="right">
					作业名称：
				</td>
				<td width="70" align="left" >
					<input type="text" id="triggerName" name="triggerName" style="width:100px"/>
				</td>
				<td height="40" width="80" align="right">
					作业分组：
				</td>
				<td width="70" align="left" >
					<input type="text" id="triggerGroup" name="triggerGroup" style="width:100px"/>
				</td>
				<td height="40" width="80" align="right">
					状态：
				</td>
				<td width="70" align="left" >
					<select id="status" name="status">
						<option value="-1">请选择</option>
						<option value="0">开始调用</option>
						<option value="1">调用失败</option>
						<option value="2">调用成功</option>
						<option value="3">执行失败</option>
						<option value="4">执行成功</option>
					</select>
				</td>
				<td height="40" width="110" align="right">
					时间：
				</td>
				<td width="240" align="left" colspan="2">
					<input type="text" id="time1" name="time1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px"/>
					-
					<input type="text" id="time2" name="time2" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px"/>
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