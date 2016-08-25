var queryUrl = root + "/quartzJobAllGrid";
var myitems = [];
var quartzGrid;
var _jobName = "";
var _jobGroup = "";
function getGrid() {
	var grid = {
		columns : [ 
			{
				display : "作业名称",
				name : "jobName",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false
			},
			{
				display : "作业分组",
				name : "jobGroup",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false
			},
			{
				display : "调用地址",
				name : "invokeUrl",
				minWidth : 20,
				width : "20%",
				align : "center",
				isSort : false,
				render : function(item) {
					return "<a title='" + item.invokeUrl + "'>" + item.invokeUrl + "</a>";
				}
			},
			{
				display : "状态",
				name : "triggerState",
				minWidth : 20,
				width : "5%",
				align : "center",
				isSort : false,
				render : function(item) {
					if(item.triggerState == "ACQUIRED"){
						return "正常运行";
					}
					if(item.triggerState == "PAUSED"){
						return "暂停运行";
					}
					if(item.triggerState == "WAITING"){
						return "等候运行";
					}	
				}
			},
			{
				display : "创建时间",
				name : "startTime",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false,
				render : function(item) {
					if(item.startTime&&item.startTime !='-1'){
						return stamp2datetime(item.startTime);
					}
				}
			},
			{
				display : "下次执行时间",
				name : "nextFireTime",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false,
				render : function(item) {
					if(item.nextFireTime&&item.nextFireTime !='-1'){
						return stamp2datetime(item.nextFireTime);
					}
				}
			},
			{
				display : "上次执行时间",
				name : "prevFireTime",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false,
				render : function(item) {
					if(item.prevFireTime&&item.prevFireTime !='-1'){
						return stamp2datetime(item.prevFireTime);
					}
				}
			},
			{
				display : "错误处理",
				name : "mistakeDo",
				minWidth : 20,
				width : "5%",
				align : "center",
				isSort : false,
				render : function(item) {
					if(item.mistakeDo == "1"){
						return "继续";
					}else if(item.mistakeDo == "0"){
						return "暂停";
					}else{
						return item.mistakeDo;
					}
				}
			},
			{
				display : "等待上一次执行完成",
				name : "waitPrev",
				minWidth : 20,
				width : "10%",
				align : "center",
				isSort : false,
				render : function(item) {
					if(item.waitPrev == "1"){
						return "是";
					}else if(item.waitPrev == "0"){
						return "否";
					}else{
						return item.waitPrev;
					}
				}
			},
			{
				display : "描述",
				name : "description",
				minWidth : 20,
				width : "20%",
				align : "center",
				isSort : false
			}
		],
		root : "data",
		record : "total",
		dataAction : "server",
		contentType:'application/json;charset=UTF-8',
		url : queryUrl,
		pageSizeOptions : [ 10, 15, 20, 30, 50, 100 ],
		pageSize : 30,
		sortName :'startTime',
		sortOrder :"desc",
		usePager : true,
		checkbox : true,
		width : "99.9%",
		height : "99.9%",
		pageParmName : "page",
		pagesizeParmName : "rows",
		sortnameParmName : "order",
		sortorderParmName : "sort",
		toolbar : {
			items : myitems
		}
	};
	return grid;
}

function initToolBar() {
	
	var item = {};
	item["text"] = "添加任务";
	item["click"] = addJobPage;
	myitems.push(item);
	myitems.push({
		line : true
	});
	
	var item = {};
	item["text"] = "暂停任务";
	item["click"] = pauseJob;
	myitems.push(item);
	myitems.push({
		line : true
	});
	
	var item = {};
	item["text"] = "恢复任务";
	item["click"] = resumeJob;
	myitems.push(item);
	myitems.push({
		line : true
	});
	
	var item = {};
	item["text"] = "删除任务";
	item["click"] = deleteJob;
	myitems.push(item);
	myitems.push({
		line : true
	});
	
	var item = {};
	item["text"] = "测试任务";
	item["click"] = testJob;
	myitems.push(item);
	myitems.push({
		line : true
	});
	
	var item = {};
	item["text"] = "查看帮助文档";
	item["click"] = openHelpPage;
	myitems.push(item);
	myitems.push({
		line : true
	});
}
function queryJob() {
	var parms=[];
	var like={};
	var equal={};
	var startwith={};
	var endwith={};
	if($("#jobName").val()){
		like.jobName='%' + $("#jobName").val() + '%';
	}
	if($("#jobGroup").val()){
		like.jobGroup='%' + $("#jobGroup").val() + '%';
	}
	if($("#triggerState").val() != -1){
		equal.triggerState= $("#triggerState").val();
	}
	if($("#createTime1").val()){
		startwith.startTime=date2stamp($("#createTime1").val(), 0);
	}
	if($("#createTime2").val()){
		endwith.startTime=date2stamp($("#createTime2").val(), 1);
	}
	if($("#nextTime1").val()){
		startwith.nextFireTime=date2stamp($("#nextTime1").val(), 0);
	}
	if($("#nextTime2").val()){
		endwith.nextFireTime=date2stamp($("#nextTime2").val(), 1);
	}
	if($("#prevTime1").val()){
		startwith.prevFireTime=date2stamp($("#prevTime1").val(), 0);
	}
	if($("#prevTime2").val()){
		endwith.prevFireTime=date2stamp($("#prevTime2").val(), 1);
	}
	if(objectIsNull(like)){
		parms.push({
			name : 'like',
			value : like
		});
	}
	if(objectIsNull(equal)){
		parms.push({
			name : 'equal',
			value : equal
		});
	}
	if(objectIsNull(startwith)){
		parms.push({
			name : 'startwith',
			value : startwith
		});
	}
	if(objectIsNull(endwith)){
		parms.push({
			name : 'endwith',
			value : endwith
		});
	}
	quartzGrid.set('parms', parms);
	quartzGrid.changePage('first');
	quartzGrid.loadData(true);
}

function objectIsNull(obj){
	var k=0;
	for(var i in obj){
	    k++;
	}
	if(k == 0){
	    return false;
	}else{
		return true;
	}
}

function openHelpPage() {
	
	var url = root+"/pages/quartz/helpPage.jsp";
	var title = "帮助文档";
	dialog_update = $.ligerDialog.open({
		url : url,
		height : 500,
		width : 950,
		showMax : false,
		showToggle : false,
		showMin : false,
		isDrag : false,
		isResize : false,
		modal : true,
		title : title
	});
}

function addJobPage() {
	
	var url = root+"/pages/quartz/addJobPage.jsp";
	var title = "添加任务";
	dialog_update = $.ligerDialog.open({
		url : url,
		height : 500,
		width : 600,
		showMax : false,
		showToggle : false,
		showMin : false,
		isDrag : false,
		isResize : false,
		modal : true,
		title : title
	});
}

function pauseJob() {
	var rows = quartzGrid.getCheckedRows();
	if (rows.length != 1) {
		JSWK.clewBox("请选择一条记录", "clew_ico_fail", 1000);
		return;
	}
	if(rows[0]['triggerState'] == 'PAUSED'){
		JSWK.clewBox("当前已经为暂停状态", "clew_ico_fail", 1000);
		return;
	}
	var param = {};
	param["jobName"] = rows[0]['jobName'];
	param["jobGroup"] = rows[0]['jobGroup'];
	$.ajax({
		type : "POST",
		url : root+"/pauseJobAction",
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

function resumeJob() {
	var rows = quartzGrid.getCheckedRows();
	if (rows.length != 1) {
		JSWK.clewBox("请选择一条记录", "clew_ico_fail", 1000);
		return;
	}
	if(rows[0]['triggerState'] != 'PAUSED'){
		JSWK.clewBox("暂停状态才能恢复", "clew_ico_fail", 1000);
		return;
	}
	var param = {};
	param["jobName"] = rows[0]['jobName'];
	param["jobGroup"] = rows[0]['jobGroup'];
	$.ajax({
		type : "POST",
		url : root+"/resumeJobAction",
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

function deleteJob() {
	var rows = quartzGrid.getCheckedRows();
	if (rows.length != 1) {
		JSWK.clewBox("请选择一条记录", "clew_ico_fail", 1000);
		return;
	}
	if(rows[0]['triggerState'] != 'PAUSED'){
		JSWK.clewBox("暂停状态才能删除", "clew_ico_fail", 1000);
		return;
	}
	var param = {};
	param["jobName"] = rows[0]['jobName'];
	param["jobGroup"] = rows[0]['jobGroup'];
	$.ajax({
		type : "POST",
		url : root+"/deleteJobAction",
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

function testJob() {
	var rows = quartzGrid.getCheckedRows();
	if (rows.length != 1) {
		JSWK.clewBox("请选择一条记录", "clew_ico_fail", 1000);
		return;
	}
	var param = {};
	window.open(rows[0]['invokeUrl']);
}

$(function() {
	initToolBar();
	quartzGrid=$("#grid").ligerGrid(getGrid());
	$("#preciseQuery").click(function(){
		queryJob();
	});
	
});