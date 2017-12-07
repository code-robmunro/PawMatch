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
	<title>Common Applications</title>
</head>
<body>
	<form action="commonapps" method="post">
		<h1>Search for a Common Application by User ID</h1>
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
	<div id="commonapplicationcreate"><a href="commonapplicationcreate">Create Common Application</a></div>
	<br/>
	<h1>Matching Common Application</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Body</th>
                <th>User</th>
            </tr>
                <tr>
                    <td><c:out value="${commonApp.getCommonApplicationId()}" /></td>
                    <td><c:out value="${commonApp.getApplicationBody()}" /></td>
                    <td><c:out value="${commonApp.getUserId()}" /></td>
                  	<td><a href="commonapplicationdelete?userid=<c:out value="${commonApp.getUserId()}"/>">Delete</a></td>
                    <td><a href="commonapplicationupdate?userid=<c:out value="${commonApp.getUserId()}"/>">Update</a></td>
                </tr>
       </table>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
