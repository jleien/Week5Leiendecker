<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editStandServlet" method="post">
Name: <input type ="text" name = "name" value= "${standToEdit.name}">>
Type: <input type = "text" name = "type" value= "${standToEdit.type}">>
Starting Cash: <input type = "text" name = "startcash" value= "${standToEdit.startCash}">>
Status (Open/Close): <input type = "text" name = "status" value= "${standToEdit.open}">>

<input type = "hidden" name = "ID" value="${standToEdit.ID}">
<input type = "submit" value="Save Edited Item">
</form>

</body>
</html>