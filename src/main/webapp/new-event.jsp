<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event Creator</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="createNewEventServlet" method="post">
		Event Type: <input type="text" name="eventType"><br /> 
		
		Event Date: 
		
		<input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4"> 
		<input type="text" name="year" placeholder="yyyy" size="4"> 
		
		Manager Name: <input type="text" name="managerName"><br /> 
		
		Available Stands:<br /> <select name="allStandsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.ID}">${currentitem.name} |
					${currentitem.type}</option>
			</c:forEach>
		</select> 
		<br /> <input type="submit" value="Create Event and Add Stands">

	</form>
	<nav>
	<a href="index.html">Go add new stands instead</a>
	</nav>
</body>
</html>