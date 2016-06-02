<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
th {
	background: lightblue;
	text-align: center;
	font-family: 微软雅黑;
	font-size: 14px;
}

td {
	text-align: center;
	font-family: 微软雅黑;
	font-size: 14px;
}

#show {
	display: none;
	position: absolute;
	top: 25%;
	left: 45%;
	width: 30%;
	height: 50%;
	padding: 8px;
	margin:-50px 0 0 -50px;
	border: 1px solid #666;
	background-color:lightblue ;
	z-index: 1002;
	overflow: auto;
}
</style>
<h1>文章管理</h1>
<hr>

<div id="show">
	<form action="updArticle.action" id="updArticleForm" method="post">
		<h2 align="center">修改文章信息</h2>
		<input type="hidden" name="id" />
		文章标题:<input type="text" name="title" /><br /> 
		文章作者:<input type="text"name="author" /><br /> 
		文章内容:<br/>
		<textarea name="content" rows="10" cols="30"></textarea> 
		<br/> 
		<input type="submit" value="确认修改" />   
		<input type="reset" value="取消" onclick="hidediv();" />
	</form>
</div>

<div id="bg">
	<table border="1"
		style="width: 100%; border-collapse: collapse; margin-top: 10px">
		<tr>
			<th>编号</th>
			<th>文章标题</th>
			<th>作者</th>
			<th>文章内容</th>
			<th>发表日期</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${articleList }" var="c">
			<tr>
				<td id="check"><input type="checkbox" value="${c.id } " /></td>
				<td>${c.title }</td>
				<td>${c.author }</td>
				<td>${c.content }</td>
				<td>${c.publisurDate }</td>
				<td><a href="javascript:void(0);" val="${c.id }" class="upd">修改</a>
					<a href="javascript:void(0);" val="${c.id }" class="del">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</div>

<script>
$(function(){
	$("#updArticleForm").submit(function(){
		$(this).ajaxSubmit(function(){
			alert("修改成功");
			document.getElementById("bg").style.display = "none";
            document.getElementById("show").style.display = "none";
            $(".baseUI li :contains('信息管理')").trigger("click");
		});
		return false;
	});
	
	
});

function hidediv() {
    document.getElementById("bg").style.display = 'none';
    document.getElementById("show").style.display = 'none';
    $(".baseUI li :contains('信息管理')").trigger("click");
}

$(function(){
		$(".upd").off();
		$(".upd").on("click",function(){
			 var id=$(this).attr("val");
			 var title = $(this).parent().siblings()[1].firstChild.nodeValue;
			 var author = $(this).parent().siblings()[2].firstChild.nodeValue;
			 var content = $(this).parent().siblings()[3].firstChild.nodeValue;
			 $("input[name='id']").val(id);
			 $("input[name='title']").val(title);
			 $("input[name='author']").val(author);
			 $("textarea[name='content']").val(content);
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
		$.post("delArticle.action",{id:id},function (){
			$(".baseUI li :contains('信息管理')").trigger("click");
		});	
	});
	
});
</script>