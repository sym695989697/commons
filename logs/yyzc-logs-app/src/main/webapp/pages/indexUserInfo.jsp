<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
    <title>用户信息</title>

    <jsp:include page="all_css.jsp" />
   
    <script src="<%=root%>/js/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>  
        
    <script src="<%=root%>/js/ligerUI/ligerui.all.js" type="text/javascript"></script>
    
    <script src="<%=root%>/js/csm/csm-all.js?v=g_version" type="text/javascript"></script>   

	<script src="<%=root%>/js/jquery/jquery.form.js" type="text/javascript"></script>
	
	<script src="<%=root%>/js/util_ajax.js?v=g_version" type="text/javascript"></script>  
	   
    <script src="<%=root%>/js/csm/alert.js?v=g_version" type="text/javascript"></script>
     
   
    <script type="text/javascript">
   		var root = "<%=root%>";
   		var iroleid=parent.INDEX_USER_ROLEID;
   		var id=parent.INDEX_USER_ID;
   		var userType=parent.INDEX_USER_TYPE;
   		var sgin = parent.INDEX_SYS_SIGN;
   		$(function (){
   			
   	        	JAjax(root + '/userJson/getObjectById.action', {'model.uaaUser.id':id}, 'json', function(data){       		
   					if(data.uaaUser){
   						$("#userType").text(MALQ_CODE.getCodeName('USER_TYPE', data.uaaUser.userType));
   						$("#userLogin").text(data.uaaUser.userLogin);
   						$("#userName").text(data.uaaUser.userName);
   						
   						 if(data.orgRoles && data.orgRoles.length>0){
   							 var columns=[
   				    		             {display : '当前角色', align : 'conter', name : "orgName", width : '15%',
   											render : function(row){
   												return '<input onclick="changeRole(\''+row.uaaOrgRole.id+'\');" id="myRole_radio" name="myRole_radio" type="radio" '+(row.uaaOrgRole.id==iroleid?'checked="checked"':'')+'/>';
   											}
	   									},	
	   		    		              	{display : '角色信息', align : 'left', name : "name", width : '35%',
	   										render : function(row){
	   											return row.uaaOrgRole.name;
	   										}
	   		    		              	},
	   		    		              	{display : '所属组织', align : 'left', name : "orgName", width : '50%'}		
   				    		      ];
	   					       	var options = {};
	   					       	options['columns']=columns;
	   					       	options['height']=160;
	   					       	options['width']='90%';
	   					       	options['usePager']=false;
	   					       	options['columns']=columns;
	   					       
	   					       	options['data']={Rows:data.orgRoles};
	   				           	$('#roleGrid').ligerGrid(options); 
	   			           	 	$("#roleGrid").ligerGetGridManager();     
   						 }
   						
   			    	   }else{
   			    		   $.ligerDialog.alert('获取数据失败！', '提示', 'error',failShowTime);  
   			    	   }	        	
   				}, null, true);
   				
   		});
   		
   		function changeRole(roleId){
   			$.ligerDialog.confirm('确定要切换角色吗？', 
   				function(yes){ 
   					if(!yes) return ;
   					var url = root + '/loginJson/switchRole.action';
	   				JAjax(url,{"id":roleId}, "json", function(data){ 
	   					if("success" == data){
	   						top.location=root+'/pages/index.jsp'; 
	   					}else{
	   						JSWK.clewBox(data,'clew_ico_fail',4000);
	   					}
	   	    		}, function(){JSWK.clewBox('切换角色异常!','clew_ico_fail',4000);}, true);
   				}
   			);
   		}
    </script>
</head>

<body style="padding:10px;background:#EAEEF5;overflow-x:auto;"> 

<div style="padding-left:20px;margin:auto;">
 	<div id="userDetailForIndex">
		<ul style="line-height: 30px; margin-left: 10px;">
			<li>登录名称：<span id="userLogin"></span></li>
			<li>用户姓名：<span id="userName" ></span></li>
			<li>用户类型：<span id="userType" ></span></li>
			<li>
				<div id="roleGrid">角色信息</div>    			         
			</li>
		</ul>
	</div>

</div>

</body>
</html>
