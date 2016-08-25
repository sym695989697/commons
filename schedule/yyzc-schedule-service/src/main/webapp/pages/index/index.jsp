<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%
	String root = request.getContextPath();
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>统一调度系统</title>
<jsp:include page="all_css.jsp" />
<jsp:include page="all_js.jsp" />
<script src="<%=root%>/scripts/js/index/index.js" type="text/javascript"></script>

</head>
<body style="padding: 0px">
	<div style="height: 65px; background: url('<%=root%>/images/top_Bj01.png') repeat-x;">
		<div style="height: 65px; background: url('<%=root%>/images/top_Bj02.png') no-repeat; width: 1000px; float: left;">
			<div id="logo_img_div" style="width: 295px; height: 52px; background: url('<%=root%>/images/vims.png') no-repeat; float: left; margin-top: 5px; margin-left: 20px; cursor: pointer;"></div>
			<!-- 菜单 -->
			<ul id="my_menu">
				<li style="margin-top: -11px; width: 1px;">
					<img src="<%=root%>/images/separa.png" height="65px"/>
				</li>
				<li style="margin-top: -11px; width: 85px;">
					<span class="menuspan">
						<a href="#">
							<p><img src="<%=root%>/images/quartz1.png" /></p>
							<p>调度管理</p>
						</a>
					</span>
					<ul>
						<li style="width: 100px">
							<a href="javascript:indexPage.f_addTab('1','调度列表','<%=root%>/quartzAllGrid')">调度列表</a>
						</li>
						<li style="width: 100px">
							<a href="javascript:indexPage.f_addTab('2','调度日志','<%=root%>/logGrid')">调度日志</a>
						</li>
					</ul>
				</li>
				<li style="margin-top: -11px; width: 1px;">
					<img src="<%=root%>/images/separa.png" height="65px"/>
				</li>
			</ul>
		</div>
	</div>
	
	 <!-- 主页面 -->
   <div id="layout1" style="width:99.2%; margin:0 auto; margin-top:0px; "> 
                
        <div position="center" id="framecenter"> 
            <div tabid="home" title="首页" >
                <iframe frameborder="0" name="home_iframe" id="home_iframe" src="<%=root%>/pages/index/welcome.jsp"></iframe>
            </div> 
        </div>        
   </div>
    <div id="jmask" style="position:fixed; left:0; top:0; width:100%; height:100%; display: none; z-index: 9999">	
    <div style="position:absolute; width:100%; height:100%; z-index:9999; background-color:#000; opacity:0.5; filter:alpha(opacity=50);"></div>
    <div class="" style="position: absolute; left:50%; top:50%; margin-left:-100px; width:200px; z-index:9999; color:#fff;">
        <img src="<%=request.getContextPath()%>/images/loading.gif"/>
	</div>
	</div>
	<%-- <div style="height: 560px">
		<iframe id="iframe" src="<%=root%>/quartzAllGrid" width="100%" height="100%" style="border: 0;padding-top: 5px">
		</iframe>
	</div> --%>
</body>
</html>
