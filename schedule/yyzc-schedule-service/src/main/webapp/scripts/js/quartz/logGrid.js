var queryUrl = root + "/queryLogGrid";
var logGrid;
function getGrid() {
	var grid = {
		columns : [ 
			{
				display : "作业名称",
				name : "triggerName",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false
			},
			{
				display : "作业分组",
				name : "triggerGroup",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false
			},
			{
				display : "状态",
				name : "status",
				minWidth : 20,
				width : "5%",
				align : "center",
				isSort : false,
				render : function(item) {
					if(item.status == "0"){
						return "开始调用";
					}else if(item.status == "1"){
						return "调用失败";
					}else if(item.status == "2"){
						return "调用成功";
					}else if(item.status == "3"){
						return "执行失败";
					}else if(item.status == "4"){
						return "执行成功";
					}
				}
			},
			{
				display : "时间",
				name : "triggerTime",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false,
				render : function(item) {
					if(item.triggerTime&&item.triggerTime !='-1'){
						return stamp2datetime(item.triggerTime);
					}
				}
			},
			{
				display : "操作",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false,
				render : function(item) {
					return '<a href="javascript:window.executeOnceJob(\'' + item.triggerName + '\',\'' + item.triggerGroup + '\')">触发一次</a>';
				}
			}
		],
		root : "data",
		record : "total",
		dataAction : "server",
		contentType:'application/json;charset=UTF-8',
		url : queryUrl,
		pageSizeOptions : [ 10, 15, 20, 30, 50, 100 ],
		pageSize : 30,
		sortName :'triggerTime',
		sortOrder :"desc",
		usePager : true,
		width : "99.9%",
		height : "99.9%",
		pageParmName : "page",
		pagesizeParmName : "rows",
		sortnameParmName : "order",
		sortorderParmName : "sort"
	};
	return grid;
}


function queryLog() {
	var parms=[];
	if($("#triggerName").val()){
		parms.push({
			name : 'like',
			value : {'triggerName' : '%' + $("#triggerName").val() + '%'}
		});
	}
	if($("#triggerGroup").val()){
		parms.push({
			name : 'like',
			value : {'triggerGroup' : '%' + $("#triggerGroup").val() + '%'}
		});
	}
	if($("#status").val() != -1){
		parms.push({
			name : 'equal',
			value : {'status' : $("#status").val()}
		});
	}
	if($("#time1").val()){
		parms.push({
			name : 'startwith',
			value : {'triggerTime':date2stamp($("#time1").val(), 0)}
		});
	}
	if($("#time2").val()){
		parms.push({
			name : 'endwith',
			value : {'triggerTime':date2stamp($("#time2").val(), 1)}
		});
	}

	logGrid.set('parms', parms);
	logGrid.changePage('first');
	logGrid.loadData(true);
}

function executeOnceJob(triggerName,triggerGroup) {
	var param = {};
	param["jobName"] = triggerName;
	param["jobGroup"] = triggerGroup;
	$.ajax({
		type : "POST",
		url : root+"/executeOnceJobAction",
		data : param,
		dataType : "json",
		success : function(data) {
			if (data.message == "1") {
				JSWK.clewBox("操作成功!", "clew_ico_succ", 1000);
				quartzGrid.loadData(true);
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

$(function() {
	logGrid = $("#grid").ligerGrid(getGrid());
	$("#preciseQuery").click(function(){
		queryLog();
	});
	
});