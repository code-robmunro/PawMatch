<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Robert
  Date: 12/7/2017
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <style>
        html, body, .container-table {
            height: 100%;
        }

        .container-table {
            display: table;
        }

        .vertical-center-row {
            display: table-cell;
            vertical-align: middle;
        }
    </style>

</head>
<body>
<div style="margin: 0 auto;">
    <div style="margin-left: 20%">
        <form action="usersearch" method="post">
            <h1>Search for a User by User ID</h1>
            <label for="userid">User ID</label>
            <input id="userid" name="userid" value="${fn:escapeXml(param.userid)}">
            <input type="submit">
            <br/><br/>
            <span id="successMessage"><b>${messages.success}</b></span>
        </form>
    </div>
</div>

<div class="container">
    <div class="row">

        <p></p>
        <h1>Matching User</h1>
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
                            <th><em class="fa fa-cog"></em></th>
                            <th>Simple</th>
                            <th>Detailed</th>
                            <th class="hidden-xs">ID</th>
                            <th>UserName</th>
                            <th>FirstName</th>
                            <th>LastName</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>NotificationsOn</th>
                            <th>Foster</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td align="center">
                                <a href="userdelete?userid=<c:out value="${user.getUserId()}"/>"
                                   class="btn btn-danger"><em class="fa fa-trash"></em></a>
                            </td>
                            <td align="center">
                                <a href="simplesearch?userid=<c:out value="${user.getUserId()}"/>"
                                   class="btn btn-warning"><em
                                        class="fa fa-search"></em></a>
                            </td>
                            <td align="center">
                                <a href="detailedsearch?userid=<c:out value="${user.getUserId()}"/>"
                                   class="btn btn-success"><em
                                        class="fa fa-search"></em></a>
                            </td>
                            <td><c:out value="${user.getUserId()}"/></td>
                            <td><c:out value="${user.getUserName()}"/></td>
                            <td><c:out value="${user.getFirstName()}"/></td>
                            <td><c:out value="${user.getLastName()}"/></td>
                            <td><c:out value="${user.getEmail()}"/></td>
                            <td><c:out value="${user.getPassword()}"/></td>
                            <td><c:out value="${user.getNotificationsOn()}"/></td>
                            <td><c:out value="${user.getFoster()}"/></td>
                        </tr>
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