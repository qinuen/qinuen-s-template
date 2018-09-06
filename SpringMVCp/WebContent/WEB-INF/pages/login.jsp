<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
<h1>登录</h1><hr/>
<hr/>
<form action="userLogin.action" method="post"> 
	账号:<input type="text" name="username" /><br/><br/>
	密码:<input type="text" name="password" /><br/><br/>
	<input type="submit" value="登录"/>
</form>
</body>
</html>