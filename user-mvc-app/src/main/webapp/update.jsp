<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
		<input type="hidden" name="id" value="${u.getId() }"> 
		Name<input type="text" name="name" value="${u.getName() }"><br>
		Age<input type="number" name="age" value="${u.getAge() }"><br>
		Phone<input type="tel" name="phone" value="${u.getPhone() }"><br>
		Email<input type="email" name="email" value="${u.getEmail() }"><br>
		Password<input type="password" name="password" value="${u.getPassword() }"><br> 
		<input type="submit" value="Update">
	</form>
</body>
</html>