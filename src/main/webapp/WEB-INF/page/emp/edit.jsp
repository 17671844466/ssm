<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String contextPath = request.getContextPath(); // /hibernate01_lx
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ contextPath + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:if test="${empty emp }">新增员工信息</c:if> <c:if
		test="${not empty emp }"> 修改员工信息 </c:if></title>
<script type="text/javascript" src="static/js/jquery.min.js">
	
</script>
</head>
<body>
	<form action="emp/save.do" method="post">
		<c:if test="${not empty emp }">
		员工编号：<input type="text" name="empno" value="${emp.empno }"
				readonly="readonly">
			<br>
		</c:if>
		员工姓名：<input type="text" name="ename" value="${emp.ename }"><br>
		职位：<input type="text" name="job" value="${emp.job }"><br>
		上级领导：<select name="mgr">
			<option>----- 请选择 ------</option>
		</select><br> 
		入职日期：<input type="date" name="hiredate" value="<fmt:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd"/>"><br>
		薪资：<input type="text" name="sal" value="${emp.sal }"><br>
		部门：<select name="deptno"><option>----- 请选择 ------</option>
			<c:forEach items="${depts }" var="dept">
				
				<option value="${dept.deptno }">
					<c:if test="${emp.deptno eq dept.deptno}">selected</c:if> ${dept.dname } </option>
				
				
			</c:forEach>
		</select><br>
		
					<input type="submit" value="保存">
			</form>
			
			
				
		<script type="text/javascript">
			$(function(){
				getMgr();
			});
	
	var getMgr = function(){
		console.log(${emp.mgr})
		
		$.get("emp/getMgr.do", {}, function(result){
			//遍历结果集渲染下拉框
			var html = "";
			$.each(result, function(index, obj){
				html += "<option value="+ obj.empno +" >"+ obj.ename +"</option>";
			})
			//向下拉框中追加option
			$("select[name='mgr']").append(html);
			var mgr = "${emp.mgr}";
			if (mgr) {
				$("select[name='mgr']").find("option[value="+ ${emp.mgr} +"]").attr("selected", "selected")
			}
		}, "json");

	}
</script>
</body>
</html>