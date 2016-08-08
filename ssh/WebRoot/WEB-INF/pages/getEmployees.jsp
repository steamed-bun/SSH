<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %>
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
    		$(".delete").click(function(){
    			var eName = $(this).next(":input").val();
    			var flag = confirm("确定要删除" + eName + "的信息")
    			if(flag){
    				var $tr = $(this).parent().parent();
    				var url = this.href;
    				var args = {"time":new Date()};
    				$.post(url, args, function(data){
    					//若data的返回值为1，则删除成功，为0则失败
    					if(data == "1"){
    						alert("删除成功！")
    						$tr.remove();
    					}else{
    						alert("删除失败！");
    					}
    				});
    			}
    			//取消超链接的默认行为
    			return false;
    		})
    	})
    </script>
  </head>
  
  <body>
	<s:if test="#request.employees == null ||  request.employees.size() == 0">
		没有员工信息
	</s:if>
	<s:else>
		<table cellpadding="10">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>EMAIL</td>
				<td>BIRTH</td>
				<td>CREAT_TIME</td>
				<td>DEl</td>
				<td>Edit</td>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${eId }</td>
					<td>${eName }</td>
					<td>${email }</td>
					<td>
						<s:date name="birth" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="createTime" format="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<td>${dept.deptName }</td>
					<td>
						<a href="emp-delete?eId=${eId }" class="delete">delete</a>
						<input type="hidden" value="${eName }"/>
					</td>
					<td>
						<a href="emp-add?eId=${eId }">edit</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
	
  </body>
</html>
