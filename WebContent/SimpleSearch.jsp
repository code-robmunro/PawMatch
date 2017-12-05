<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search based on simple preferences</title>
</head>
<body>
<h1>${messages.title}</h1>
<form action="simplesearch" method="post">
	<p>
	<div <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
		<label for="userid">User ID</label>
		<input id="userid" name="userid" value="${fn:escapeXml(param.userid)}">
	</div>
	</p>
	<p>
			<span id="submitButton" <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
			<input type="submit">
			</span>
	</p>
</form>
<br/><br/>
<h1>Matching Pet Profiles</h1>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Species</th>
		<th>Sex</th>
		<th>Breed</th>
		<th>Age</th>
		<th>Size</th>
		<th>HouseTrained</th>
		<th>CoatLength</th>
		<th>Location</th>
		<th>ShelteredLonger</th>
		<th>PicturesId</th>
		<th>VideosId</th>
		 <%--TODO: finish all fields--%>
	</tr>
	<c:forEach items="${profiles}" var="profile" >
		<tr>
			<td><c:out value="${profile.getPetProfileId()}" /></td>
			<td><c:out value="${profile.getSpecies()}" /></td>
			<td><c:out value="${profile.getSex()}" /></td>
			<td><c:out value="${profile.getBreed()}" /></td>
			<td><c:out value="${profile.getAge()}" /></td>
			<td><c:out value="${profile.getSize()}" /></td>
			<td><c:out value="${profile.getHouseTrained()}" /></td>
			<td><c:out value="${profile.getCoatLength()}" /></td>
			<td><c:out value="${profile.getLocation()}" /></td>
			<td><c:out value="${profile.getShelteredLonger()}" /></td>
			<td><c:out value="${profile.getPicturesId()}" /></td>
			<td><c:out value="${profile.getVideosId()}" /></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>