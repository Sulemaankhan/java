<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<h3 align="center">Register Employee</h3>

	<form:form  action="save" method="post" modelAttribute="employee">
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 300px" align="center">
			
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="ename" /></td>
			</tr>
			<tr>
				<td>Project Name :</td>
				<td><form:input type="text" path="projactname" /></td>
			</tr>
			<tr>
				<td>email :</td>
				<td><form:input type="email" path="email" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
			</tr>
		</table>
		</div>
	</form:form>
</body>
</html>