<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Customer Booking Details</h1>
<body>
	<table style="with: 80%">
		<tr>
			<td>RideId</td>
			<td>UserId</td>
			<td>RouteId</td>
			<td>Date</td>
		</tr>

		<c:forEach items="${rideList}" var="ride">
			<tr>
				<td>${ride.RideId}</td>
				<td>${ride.UserId}</td>
				<td>${ride.RouteId}</td>
				<td>${ride.datetime}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>