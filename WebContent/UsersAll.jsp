<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

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

<!-- Icons Grid -->
<section class="features-icons bg-light text-center">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-0 mb-lg-0 mb-lg-0">
                    <a href="usersearch" style="text-decoration: none">
                        <div class="features-icons-icon d-flex">
                            <i class="icon-user m-auto text-primary"></i>
                        </div>
                        <h3>Search by User ID</h3>
                    </a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-0 mb-lg-0 mb-lg-0">
                    <a href="usersall" style="text-decoration: none">
                        <div class="features-icons-icon d-flex">
                            <i class="icon-cloud-download m-auto text-primary"></i>
                        </div>
                        <h3>List all Users</h3>
                    </a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-0 mb-lg-0">
                    <a href="home" style="text-decoration: none">
                        <div class="features-icons-icon d-flex">
                            <i class="icon-check m-auto text-primary"></i>
                        </div>
                        <h3>Back home</h3>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="container">
    <div class="row">

        <p></p>
        <h1>Users Panel</h1>
        <p> </p>
        <p> </p><p> </p>

        <div class="col-md-10 col-md-offset-1">

            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title"></h3>
                        </div>
                        <div class="col col-xs-6 text-right">
                            <a href="usercreate"><button type="button" class="btn btn-sm btn-primary btn-create">Create New</button></a>
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
                        <c:forEach var="userInstance" items="${allusers}">
                        <tr>
                            <td align="center">
                                <a href="userdelete?userid=<c:out value="${user.getUserId()}"/>" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                            </td>
                            <td align="center">
                                <a href="simplesearch?userid=<c:out value="${user.getUserId()}"/>" class="btn btn-warning"><em class="fa fa-search"></em></a>
                            </td>
                            <td align="center">
                                <a href="detailedsearch?userid=<c:out value="${user.getUserId()}"/>" class="btn btn-success"><em class="fa fa-search"></em></a>
                            </td>

                                <td><c:out value="${userInstance.getUserId()}" /></td>
                                <td><c:out value="${userInstance.getUserName()}" /></td>
                                <td><c:out value="${userInstance.getFirstName()}" /></td>
                                <td><c:out value="${userInstance.getLastName()}" /></td>
                                <td><c:out value="${userInstance.getEmail()}" /></td>
                                <td><c:out value="${userInstance.getPassword()}" /></td>
                                <td><c:out value="${userInstance.getNotificationsOn()}" /></td>
                                <td><c:out value="${userInstance.getFoster()}" /></td>


                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>

        </div></div></div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>