<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	
	<div class="table-responsive">
		<h2 align="center">Search Employee</h2>
			<form action="searchDetails" method="GET">
				<table class="table table-bordered" style="width: 300px"
					align="center">
					<tr>
						<td>Name ::</td>
						<td><input type="text" name="proname"></td>
						<td><input class="btn btn-primary btn-sm" type="submit"
							value="search" /></td>
					</tr>
				</table class="table table-bordered" style="width: 300px" align="center">
			</form>
		</div>

	<h3 align="center">List of Employees</h3>
	<table class="table table-bordered" style="width: 300px" align="center">
		<tr>
			<th>EID</th>
			<th>Ename</th>
			<th>ProjectName</th>
			<th>Email Id</th>
			<th>Find By Id</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">
			<tr>
				<td width="60" align="center">${employee.id}</td>
				<td width="60" align="center">${employee.ename}</td>
				<td width="60" align="center">${employee.projactname}</td>
				<td width="60" align="center">${employee.email}</td>
				<td><a href="employeesDetails">${employee.id}findById</a></td>
			</tr>
		</c:forEach>
		
		
		
</body>
</html>