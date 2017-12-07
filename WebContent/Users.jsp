<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users</title>
</head>
<body>
<form action="users" method="post">
	<h1>Search for a User by User ID</h1>
	<p>
		<label for="userid">User ID</label>
		<input id="userid" name="userid" value="${fn:escapeXml(param.userid)}">
	</p>
	<p>
		<input type="submit">
		<br/><br/><br/>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</form>
<br/>
<div id="usercreate"><a href="usercreate">Create User</a></div>
<div id="commonapps"><a href="commonapps">Go To Common Apps</a></div>
<div id="locationsearch"><a href="locationsearch">Search Pets By Location</a></div>
<br/>
<h1>Matching User</h1>
<table border="1">
	<tr>
		<th>ID</th>
		<th>UserName</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Email</th>
		<th>Password</th>
		<th>SimplePreferencesId</th>
		<th>DetailedPreferencesId</th>
		<th>NotificationsOn</th>
		<th>Foster</th>
	</tr>
	<tr>
		<td><c:out value="${user.getUserId()}" /></td>
		<td><c:out value="${user.getUserName()}" /></td>
		<td><c:out value="${user.getFirstName()}" /></td>
		<td><c:out value="${user.getLastName()}" /></td>
		<td><c:out value="${user.getEmail()}" /></td>
		<td><c:out value="${user.getPassword()}" /></td>
		<td><c:out value="${user.getSimplePreferencesId()}" /></td>
		<td><c:out value="${user.getDetailedPreferencesId()}" /></td>
		<td><c:out value="${user.getNotificationsOn()}" /></td>
		<td><c:out value="${user.getFoster()}" /></td>
		<td><a href="userdelete?userid=<c:out value="${user.getUserId()}"/>">Delete</a></td>
		<td><a href="simplesearch?userid=<c:out value="${user.getUserId()}"/>">Simple Search</a></td>
		<td><a href="detailedsearch?userid=<c:out value="${user.getUserId()}"/>">Detailed Search</a></td>
	</tr>
</table>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>