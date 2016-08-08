<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="scrips/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    	
    	$(function(){
    		
    		$(":input[name=eName]").change(function(){
    			
    			var $this = $(this);
    			
    			var val = $(this).val();
    			val = $.trim(val);
    			if(val != ""){
    				$this.nextAll("font").remove();
    				var url = "emp-validateName";
    				var args = {"eName":val};
    				$.post(url, args, function(data){
    				
    					if(data == "1"){
    						$this.after("<font color='green'>name可用</font>");
    					}else if(data == "0"){
    						$this.after("<font color='red'>name不可用</font>");
    					}else{
    						alert("服务器错误");
    					}
    				
    				});
    				
    			}else{
    				alert("name 不能为空！");
    				$(this).val("");
    			}
    			
    		});
    		
    	})
    	
    	
    </script>
  </head>
  
  <body>
		<s:form action="emp-save" method="post">
			<s:if test="eId != null">
				<s:textfield name="eName" label="Name" disabled="true"></s:textfield>
				<s:hidden name="eId"></s:hidden>
				<%--
				<!-- 通过隐藏域的方法进行提交是可以的 -->
				<s:hidden name="eName"></s:hidden>
				<s:hidden name="createTime"></s:hidden>
				 --%>
			</s:if>
			<s:else>
				<s:textfield name="eName" label="Name"></s:textfield>
			</s:else>
			<s:textfield name="email" label="Email"></s:textfield>
			<s:textfield name="birth" label="Birth"></s:textfield>
			<s:select list="#request.departements" listKey="deptId" listValue="deptName" 
			name="dept.deptId" label="Departement"></s:select>
			<s:submit value="Submit"></s:submit>
		</s:form>
  </body>
</html>

