<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Test SSM</title>
</head>
<body>
<a href="student/query/1.action">获取id=1的student</a>
<hr/>
<form action="student/add.action" method="post">
	<p>name:<input type="text" name="name"/></p>
	<p><input type="submit" value="添加"/></p>
</form>
<a href="student/del/1.action">删除id=1的student</a>
</body>
</html>