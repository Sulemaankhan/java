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
<p>Ride Successfully booked<p>
	<table style="with: 80%">
		<tr>
			<td>RideId</td>
			<td>UserId</td>
			<td>RouteId</td>
			<td>Date</td>
		</tr>

		<c:forEach items="${rideList}" var="ride">
			<tr>
				<td>${ride.rideId}</td>
				<td>${ride.userId}</td>
				<td>${ride.routeId}</td>
				<td>${ride.dateTime}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>