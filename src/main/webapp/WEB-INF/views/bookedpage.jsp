<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Booking page
</h1>

<form action="rides" method="post">
		<table style="with: 80%">
			<tr>
				<td>Chose the Date:</td>
				<td><input type="date" name="date" /></td>
			</tr>
		</table>
		<input type = "hidden" name="action" value="book"/>
		<input type="submit" value="confirmed" />
	</form>


</body>
</html>
