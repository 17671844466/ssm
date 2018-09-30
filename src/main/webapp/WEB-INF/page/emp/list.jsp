<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath(); // /hibernate01_lx
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="static/js/jquery.min.js">
</script>
</head>
<body>
<div>
<a href="emp/edit.do">新增员工</a>
</div>
<div>
员工姓名：<input type="text" name="ename"> 入职日期：<input type="date" name="hiredate"> <button>查询</button>
</div>
<table>
	<thead>
		<tr>
			<th>编号</th>
			<th>员工姓名</th>
			<th>职位</th>
			<th>入职日期</th>
			<th>薪资</th>
			<th>部门编号</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<!-- 	<tr>
			<td>asdsad</td>
			<td>asdsad</td>
			<td>asdsad</td>
			<td>asdsad</td>
			<td>asdsad</td>
			<td>asdsad</td>
		</tr> -->
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">
				<a class="pager" href="javascript:void(0)">首页</a>
				<a class="pager" href="javascript:void(0)">上一页</a>
				<a class="pager" href="javascript:void(0)">下一页</a>
				<a class="pager" href="javascript:void(0)">尾页</a>
				<span>共 <span id="nowPage"></span> 页</span>
				跳转到<input type="text" name="toPageNumber">页<button id="go">确定</button>
			</td>
		</tr>
	</tfoot>
</table>
<script type="text/javascript">

	//页面加载完之后立即发送请求查询分页数据
	$(function(){

		//创建一个参数对象，包含当前页和一月显示条数
		var options = {pageNumber:1, pageSize:10};
		//页面加载之后 立即执行函数
		data(options);

		//点击了首页
		$(".pager:eq(0)").on("click", function(){
			//如当前是第一页就不查
			if (options.pageNumber == 1) {
				return;
			}
			options.pageNumber = 1;
			data(options);
		});
		
		//点击上一页
		$(".pager:eq(1)").on("click", function(){
			if (options.pageNumber <= 1) {
				return;				
			}
			options.pageNumber--;
			data(options);
		});

		//下一页
		$(".pager:eq(2)").on("click", function(){
			if (options.pageNumber >= options.totalPage) {
				return;
			}
			options.pageNumber++;
			data(options);
		});

		//尾页
		$(".pager:eq(3)").on("click", function(){
			if (options.pageNumber >= options.totalPage) {
				return;
			}
			options.pageNumber = options.totalPage;
			data(options);
		});

		//跳转到指定页
		$("#go").on("click", function(){
			var toPageNumber = $("input[name='toPageNumber']").val();
			if (!toPageNumber) {
				alert("请输出需要跳转的页码!!!")
				return;
			}
			if (isNaN(toPageNumber)) {
				alert("请输入正常页码！！！");
				return;
			}
			options.pageNumber = toPageNumber;
			data(options);
		})
		
	})


	//把请求数据的js代码块封装成一个方法
	var data = function(options) {
		
		//发送一个ajax请求来请求数据
		$.ajax({
			url:"emp/list.do",
			type:"post",
			data:options,
			dataType:"json",
			success:function(result){
				$("#nowPage").html(result.pageNumber + "/" + result.totalPage);
				//给options对象添加总页数属性
				options.totalPage = result.totalPage;
				options.pageSize = result.pageSize;
				options.totalRows = result.totalRows;
				//取出结果中的列表数据
				var data = result.data;
				//请求成功对页面重新渲染
				var tbody = $("tbody");
				tbody.html("");
				var html = "";
				$.each(data, function(index, obj){
					html += "<tr>";
					html += "<td>"+ (index+1) +"</td>";
					html += "<td>"+ obj.ename +"</td>";
					html += "<td>"+ obj.job +"</td>";
					html += "<td>"+ obj.hiredate +"</td>";
					html += "<td>"+ obj.sal +"</td>";
					html += "<td>"+ obj.deptno +"</td>";
					html += "<td><a href='javascript:void(0)' onclick='edit("+ obj.empno +")'>修改</a>|<a>删除</a></td>";
					html += "</tr>";
				})
				tbody.append(html);		
			}
		});
	}

	//点击修改按钮跳转到修改页面
	var edit = function(empno) {
		console.log(empno);
		window.location.href = "emp/edit.do?empno=" + empno;
	}
</script>

</body>
</html>