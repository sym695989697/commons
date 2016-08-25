var addUrl = root + "/addJobAction";
$(function() {
});

function add() {
	if(!$("#jobName").val()){
		JSWK.clewBox("作业名称不能为空", "clew_ico_fail", 1000);
		return;
	}
	if(!$("#jobGroup").val()){
		JSWK.clewBox("作业分组不能为空", "clew_ico_fail", 1000);
		return;
	}
	if(!$("#url").val()){
		JSWK.clewBox("调用路径不能为空", "clew_ico_fail", 1000);
		return;
	}
	if(!$("#cronExpression").val()){
		JSWK.clewBox("时间策略不能为空", "clew_ico_fail", 1000);
		return;
	}
	
	var param = {};
	param["jobName"] = $("#jobName").val();
	param["jobGroup"] = $("#jobGroup").val();
	param["methodType"] = $("#methodType").val();
	param["cronExpression"] = $("#cronExpression").val();
	param["waitPrev"] = $("#waitPrev").val();
	param["mistakeDo"] = $("#mistakeDo").val();
	param["url"] = $("#url").val();
	if($("#description").val()){
		param["description"] = $("#description").val();
	}
	
	$.ajax({
		type : "POST",
		url : addUrl,
		data : param,
		dataType : "json",
		success : function(data) {
			if (data.message == "1") {
				JSWK.clewBox("操作成功!", "clew_ico_succ", 1000);
				parent.quartzGrid.loadData(true);
				setTimeout(function() {
					parent.$.ligerDialog.close();
				}, 1000);
				parent.$(".l-window-mask").remove();
			} else {
				JSWK.clewBox("操作失败!", "clew_ico_fail", 1000);
			}
		},
		error : function() {
			JSWK.clewBox("操作失败!", "clew_ico_fail", 1000);
		},
		async : false
	});
}
