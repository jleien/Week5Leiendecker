<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event Editor</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="editEventServlet" method="post">
		<input type="hidden" name="id" value="${eventToEdit.id}">
		Event Type: <input type="text" name="eventType" value="${eventToEdit.eventType}"><br /> 
			
			Event date: 
			<input type="text" name="month" placeholder="mm" size="4" value="${month}">
			<input type="text" name="day" placeholder="dd" size="4" value="${date}"> 
			<input type="text" name="year" placeholder="yyyy" size="4" value="${year}"> 
			
			Manager Name: <input
			type="text" name="managerName"
			value="${eventToEdit.standManager.managerName}"><br /> 
			
			Available Stands:<br /> <select name="allStandsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.ID}">${currentitem.name}|
					${currentitem.type}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit Event and Add Stands">
	</form>
	<a href="index.html">Go add new stands instead.</a>
</body>
</html>