<%@page import="com.ctfo.csm.utils.SpringBUtils"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
String root = request.getContextPath();
%>

 <script src="<%=root%>/js/jquery/jquery-1.5.2.js" type="text/javascript"></script>
 
 <script src="<%=root%>/js/jquery/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
 <script src="<%=root%>/js/jquery/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
 <script src="<%=root%>/js/jquery/jquery-validation/messages_cn.js" type="text/javascript"></script>
 <script src="<%=root%>/js/csm/csm_validate.js" type="text/javascript"></script>
 
 <script src="<%=root%>/js/jquery/jquery.autocomplete.js" type="text/javascript"></script> 
 <script src="<%=root%>/js/jquery/jquery.form.js" type="text/javascript"></script>
 

<script src="<%=root%>/js/ligerUI_1.2.4/js/ligerui.all.js?v=g_version" type="text/javascript"></script> 

 <script src="<%=root%>/js/ligerUI_1.2.4/js/ligerGrid.showFilter.csm.js?v=g_version" type="text/javascript"></script> 
 
 <script src="<%=root%>/js/util_ajax.js?v=g_version" type="text/javascript"></script>
 
<script src="<%=root%>/js/csm/csm-all.js?v=g_version" type="text/javascript"></script>
 
<script src="<%=root%>/js/jquery/jquery.blockUI.js" type="text/javascript"></script>
 
 <script src="<%=root%>/js/DateUtil.js?v=g_version" type="text/javascript"></script>
  
 <script type="text/javascript">
    var root = "<%=root%>";
    
    var failShowTime = 4000;
    
    var subWidth=Math.round($(window).width() - ($(window).width() * 0.25));
    var subHeight=Math.round($(window).height() - ($(window).height() * 0.20));
    
</script>
