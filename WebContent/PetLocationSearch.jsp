<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>PawMatch - Cats! (Also dogs...)</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
          rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/table-panel.css" rel="stylesheet">
    <link href="css/landing-page.min.css" rel="stylesheet">
</head>
<body>
<div style="margin: 0 auto;">
    <div style="margin-left: 20%">
        <h1>${messages.title}</h1>
        <form action="petlocationsearch" method="post">
            <p>
            <div <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
                <label for="zip">Zip Code</label>
                <input id="zip" name="zip" value="${fn:escapeXml(param.zip)}">
            </div>
            </p>
            <p>
			<span id="submitButton"
                  <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
			<input type="submit">
			</span>
            </p>
        </form>
    </div>
</div>
<br/><br/>

<div class="container">
    <div class="row">

        <p></p>
        <h1>Matching Pet Profiles</h1>
        <p></p>
        <p> </p>
        <p> </p>

        <div class="col-md-10 col-md-offset-1">

            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title"></h3>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-list">
                        <thead>
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
                            <th>Picture</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tr>
                        <c:forEach items="${profiles}" var="profile" varStatus="status">

                            <tr>
                                <td><c:out value="${profile.getPetProfileId()}"/></td>
                                <td><c:out value="${profile.getSpecies()}"/></td>
                                <td><c:out value="${profile.getSex()}"/></td>
                                <td><c:out value="${profile.getBreed()}"/></td>
                                <td><c:out value="${profile.getAge()}"/></td>
                                <td><c:out value="${profile.getSize()}"/></td>
                                <td><c:out value="${profile.getHouseTrained()}"/></td>
                                <td><c:out value="${profile.getCoatLength()}"/></td>
                                <td><c:out value="${profile.getLocation()}"/></td>
                                <td><c:out value="${profile.getShelteredLonger()}"/></td>
                                <td><a href="<c:out value="${full_img[status.index]}"/>"><img
                                        src="<c:out value="${thumbs_img[status.index]}"/>"></a></td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
</body>
</html>