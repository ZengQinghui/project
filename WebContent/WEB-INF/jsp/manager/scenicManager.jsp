<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	th{
		background:lightblue;
		text-align:center;
		font-family:微软雅黑;
		font-size:14px;
	}
	td{
		text-align:center;
		font-family:微软雅黑;
		font-size:14px;
	}
	#show {
	display: none;
	position: absolute;
	top: 25%;
	left: 45%;
	width: 40%;
	height: 60%;
	padding: 8px;
	margin:-50px 0 0 -50px;
	border: 1px solid #666;
	background-color:lightblue ;
	z-index: 1002;
	overflow: auto;
</style>
<h1>景点信息管理</h1>
<hr>

<div id="show">
	<!--  <span style="display:block;text-align:center"> -->
	<form action="updScenic.action" id="updScenicForm" method="post">
		<h2 align="center">修改景点信息</h2>
		<input type="hidden" name="id" />
		景点名称:<input type="text" name="name" /><br>
		景点位置:<input type="text"name="site" /><br>
		景点描述:<br>
			<textarea name="description" rows="10" cols="30"></textarea>
		 <br>
		开放时间:<input type="text" name="openingTime"/><br>
		景点价格:<input type="text" name="price"/><br>
		<input type="submit" value="确认修改" />  
		<input type="reset" value="取消" onclick="hidediv();" />	
	</form>

</div>

<div id="bg">
<table border="1" style="width:100%;border-collapse:collapse;margin-top: 10px ">
  <tr>
    <th>编号</th>
    <th>景点名称</th>
    <th>景点位置</th>
    <th>景点描述</th>
    <th>开放时间</th>
    <th>景点价格</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${scenicList }" var="c">
  <tr>
    <td id="check"><input type="checkbox" value="${c.id } " /></td>
    <td>${c.name }</td>
    <td>${c.site }</td>
    <td>${c.description }</td>
    <td>${c.openingTime }</td>
    <td>${c.price }</td>
    <td>
    	<a href="javascript:void(0);" val="${c.id }" class="upd">修改</a>
    	<a href="javascript:void(0);" val="${c.id }" class="del">删除</a>
    </td>
  </tr>
  </c:forEach>
</table>
</div>

<script>

$(function(){
	$("#updScenicForm").submit(function(){
		$(this).ajaxSubmit(function(){
			alert("修改成功");
			document.getElementById("bg").style.display = "none";
            document.getElementById("show").style.display = "none";
            $(".baseUI li :contains('景点管理')").trigger("click");
		});
		return false;
	});
	
	
});

function hidediv() {
    document.getElementById("bg").style.display = 'none';
    document.getElementById("show").style.display = 'none';
    $(".baseUI li :contains('景点管理')").trigger("click");
}

$(function(){
		$(".upd").off();
		$(".upd").on("click",function(){
			 var id=$(this).attr("val");
			 var name = $(this).parent().siblings()[1].firstChild.nodeValue;
			 var site = $(this).parent().siblings()[2].firstChild.nodeValue;
			 var description = $(this).parent().siblings()[3].firstChild.nodeValue;
			 var openingTime = $(this).parent().siblings()[4].firstChild.nodeValue;
			 var price = $(this).parent().siblings()[5].firstChild.nodeValue;
			 $("input[name='id']").val(id);
			 $("input[name='name']").val(name);
			 $("input[name='site']").val(site);
			 $("textarea[name='description']").val(description);
			 $("input[name='openingTime']").val(openingTime);
			 $("input[name='price']").val(price);
			 document.getElementById("bg").style.display = "block";
            document.getElementById("show").style.display = "block";
			
		});
	
		
	$(".del").off();
	$(".del").on("click",function(){
		var flag=confirm("确定要删除吗？");
		if(!flag){
			return false;
		}
		var id=$(this).attr("val");
		$.post("delScenic.action",{id:id},function (){
			$(".baseUI li :contains('景点管理')").trigger("click");
		});	
	});
	
});
</script>