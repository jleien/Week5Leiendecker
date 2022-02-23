
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stand List</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div>
	<form method="post" action="navigationServlet">

		<table>

			<c:forEach items="${requestScope.allStands}" var="currentstand">
				<tr>
					<td><input type="radio" name="ID" value="${currentstand.ID}"></td>
					<td>${currentstand.name}</td>
					<td>${currentstand.type}</td>
					<td>${currentstand.startCash}</td>
					<td>${currentstand.open}</td>
				</tr>
			</c:forEach>
		</table>


		<input type="submit" value="edit" name="doThisToStand"> <input
			type="submit" value="delete" name="doThisToStand"> <input
			type="submit" value="add" name="doThisToStand">

	</form>
	</div>
	<nav>
		<a href="index.html">Return Home</a>
	</nav>
</body>
</html>