<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="Ride" method="post">
		<table style="with: 80%">
			<tr>
				<td>Source</td>
				<td>Destination</td>
				<td>Duration</td>
			</tr>
			<%-- 	<tr>
		<tr><td>UserId: <input type="hidden" name="userId" value=${userId}>${userId}</td></tr>
			    <c:forEach items="${rList}" var="route">
                <tr>
                    <td><input type="hidden" name="routeId" value=${route.routeId}>${route.routeId}</td>
                    <td>${route.source}</td>
                    <td>${route.destination}</td>
                    <td><input type="hidden" name="duration">${route.duration}</td>
                    <td><input type="hidden" name="userid" value=${userid} ></td>
                    <td><input type="hidden" name="action" value="Book" /><input value="Book" type="submit" /></td>
                </tr> 

 

            </c:forEach>
            --%>
			<c:forEach items="${rList}" var="route">
				<tr>
					<td><input type="hidden" name="routeId" value=${route.routeId}>${route.routeId}</td>
					<td>${route.source}</td>
					<td>${route.destination}</td>
					<td><input type="hidden" name="duration">${route.duration}</td>
					<td><input type="hidden" name="userid" value=${userId} ></td>
					<td><input type="hidden" name="action" value="book" /></td>
					<td><input value="book" type="submit" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>