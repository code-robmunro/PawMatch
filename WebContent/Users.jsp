<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
</body>
</html>