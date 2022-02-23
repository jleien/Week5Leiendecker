<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event List</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div>
	<form method="post" action="eventNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.id}"></td>
					<td><h2>${currentlist.eventType}</h2></td>
				</tr>

				<tr>
					<td colspan="3">Event Date: ${currentlist.eventDate}</td>
				</tr>

				<tr>
					<td colspan="3">Manager: ${currentlist.standManager.managerName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlist.listOfStands}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.name}, ${listVal.type}, ${listVal.startCash}, ${listVal.open}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		
		<input type="submit" value="edit" name="doThisToEvent"> <input
			type="submit" value="delete" name="doThisToEvent"> 
	</form>
	</div>
	<nav>
	<a href="addStandToEventServlet">Create a new event</a>
	<br />
	<a href="index.html">Create a new stand</a>
	</nav>
</body>
</html>