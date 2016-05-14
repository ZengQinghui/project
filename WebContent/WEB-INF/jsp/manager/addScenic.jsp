<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form = $("#addScenicForm");
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			form[0].reset();
			alert("添加成功！");
		});
		return false;
	});
});

</script>
<h1>添加景点信息</h1>
<hr>
<form action="addScenic.action" method="post" id="addScenicForm">
	景点名称:<input type="text" name="name"/><br/>
	景点地点:<input type="text" name="site"/><br/>
	景点描述:
			<textarea name="describe" rows="10" cols="30"></textarea>
		<br/>
	景点价格:<input type="text" name="price"/><br/>
	<input type="submit" value="提交"/><br/>
</form>