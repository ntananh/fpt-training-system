<%-- 
    Document   : course
    Created on : Aug 25, 2021, 10:26:05 AM
    Author     : Tan Anh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <c:if test="${empty sessionScope['username']}">
            <jsp:forward page="login.jsp"> 
                <jsp:param name="message" value="Login first"/> 
            </jsp:forward>
        </c:if>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Courses Manage</title>

        <!-- Bootstrap core CSS -->
        <link href="resourses/css/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="resourses/css/reset.css">
        <link rel="stylesheet" href="resourses/css/course.css">
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </head>

    <body>
        <c:if test="${empty requestScope['courses']}">
            <jsp:forward page="CourseController?ac=view"/>
        </c:if>
        <div class="app">
            <!--Header-->
            <header class="header">
                <div class="header__label">

                    <span>Manage</span>
                    <span class="section">Courses</span>
                </div>

                <ul class="navbar_list">
                    <li class="list-items">
                        <a href="#">
                            <ion-icon class="icon" name="notifications-outline"></ion-icon>
                        </a>
                    </li>

                    <li class="list-items">
                        <div class="avatar">
                            <a href="logout.jsp">
                                <img src="./resourses/image/course/avatar.jpg" alt="avatar">

                            </a>
                        </div>
                    </li>
                </ul>
            </header>

            <!--Sidebar-->
            <aside class="sidebar">
                <div class="logo">
                    <a href="#">
                        <img src="./resourses/image/course/logo.png" alt="FPT Learning">
                    </a>

                </div>

                <div class="sidebar__wrapper">
                    <ul class="nav-list">
                        <li class="nav-item"><a href="#"><ion-icon name="bar-chart-outline"></ion-icon>Dashboard</a></li>
                        <li class="nav-item"><ion-icon name="people-outline"></ion-icon>User</li>
                        <li class="nav-item"><ion-icon name="file-tray-full-outline"></ion-icon>Topic</li>
                        <li class="nav-item"><ion-icon name="filter-outline"></ion-icon>Category</li>
                        <li class="nav-item active"><ion-icon name="documents-outline"></ion-icon>Course</li>
                    </ul>


                    <div class="user__wrapper">
                        <h1>Username: ${sessionScope.username}</h1>
                    </div>
                </div>
            </aside>

            <!--  Main-->
            <main class="main">
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-6">
                                    <!-- Search section-->
                                </div>
                                <div class="col-sm-6">
                                    <a href="CourseController?ac=add" class="btn btn-success"><span>Add New Course</span></a>					
                                </div>
                            </div>
                        </div>
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>NAME</th>
                                    <th>TOPIC</th>
                                    <th>CATEGORY</th>
                                    <th>DESCRIPTION</th>
                                    <th>ACTIONS</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="course" items="${courses}">
                                    <tr>
                                        <td>${course.name}</td>

                                        <c:forEach var="topic" items="${topics}">
                                            <c:if test="${course.topic_id == topic.id}">
                                                <td>${topic.name}</td>
                                            </c:if>
                                        </c:forEach> 

                                        <c:forEach var="cate" items="${cates}">
                                            <c:if test="${course.cate_id == cate.id}">
                                                <td>${cate.name}</td>
                                            </c:if>
                                        </c:forEach>         

                                        <td>${course.description}</td>
                                        <td>
                                            <a href="CourseController?ac=delete&id=${course.id}" alt="delete" class="delete"><ion-icon name="trash-outline"></ion-icon></a>
                                            <a href="CourseController?ac=edit&id=${course.id}" alt="edit" class="edit"><ion-icon name="create"></ion-icon></a>
                                            <!--<a href="#" alt="view" class="view"><ion-icon name="information-circle-outline"></ion-icon></a>-->
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="clearfix">
                            <div class="hint-text">Showing 10 out of 50 entries</div>
                            <ul class="pagination">
                                <li class="page-item disabled"><a href="#">Previous</a></li>
                                <li class="page-item active"><a href="#" class="page-link">1</a></li>
                                <li class="page-item"><a href="#" class="page-link">2</a></li>
                                <li class="page-item "><a href="#" class="page-link">3</a></li>
                                <li class="page-item"><a href="#" class="page-link">4</a></li>
                                <li class="page-item"><a href="#" class="page-link">5</a></li>
                                <li class="page-item"><a href="#" class="page-link">Next</a></li>
                            </ul>
                        </div>
                    </div>
                </div>        
            </main>
        </div>
        <!-- Delete Modal HTML -->

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="./resourses/js/jquery-slim.min.js"><\/script>')</script>
        <script src="resourses/js/bootstrap.min.js"></script>
        <script src="resourses/js/popper.min.js"></script>
    </body>
</html>
