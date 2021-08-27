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
            <c:redirect url="login.jsp" />
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
        <link rel="stylesheet" href="resourses/css/addcourse.css">
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </head>

    <body>
        <c:set var="c" value="${requestScope['course']}"/>
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

            <!--sidebar-->
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

                    </div>
                </div>
            </aside>

            <!--  Main-->
            <main class="main">
                <div class="wrapper">
                    <h2 class="heading">Edit Course</h2>

                    <form method="POST" action="CourseController?ac=update&id=${c.id}">
                        <div class="form-wrapper">
                            <div class="sub-section">
                                <div class="form-group">
                                    <label class="form-lable" for="courseName">Course's name</label>
                                    <input class="form-input" type="text" name="name" autocomplete="off" value="${c.name}">
                                    <span class="form-message"></span>
                                </div>

                                <div class="trainer-wrapper">
                                    <h3 class="section-heading">Assign Topic</h3>
                                    <div class="select-wrapper">
                                        <label class="form-lable" for="topics">Choose a topic:</label>
                                        <select id="topics" name="topic_id" >
                                            <c:forEach var="topic" items="${topics}">
                                                <c:if  test="${c.topic_id == topic.id}">
                                                    <option value="${topic.id}" selected>${topic.name}</option>
                                                </c:if>
                                                <c:if  test="${c.topic_id != topic.id}">
                                                    <option value="${topic.id}" >${topic.name}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <!-- <div class="select-wrapper">
                                        <label class="form-lable" for="trainers">Choose a trainer:</label>
                                        <select id="trainers" name="trainer_id">
                                            <option value="1">Bui Duy Linh</option>
                                            <option value="2">Nguyen Thai Cuong</option>
                                        </select>
                                    </div>-->

                                </div>
                            </div>

                            <div class="sub-section">
                                <div class="section-heading">Details</div> 

                                <div class="select-wrapper">
                                    <label class="form-lable" for="categories">Choose a category:</label>
                                    <select id="categories" name="cate_id">
                                        <c:forEach var="cate" items="${cates}">
                                            <c:if  test="${c.cate_id == cate.id}">
                                                <option value="${cate.id}" selected>${cate.name}</option>
                                            </c:if>
                                            <c:if  test="${c.cate_id != cate.id}">
                                                <option value="${cate.id}" >${cate.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label class="form-lable" for="start_date">Start (date):</label>
                                    <input class="form-input"  value="${c.start_date}" type="date" id="start_date" name="start_date">
                                </div>
                                <div class="form-group">
                                    <label class="form-lable" for="end_date">End (date):</label>
                                    <input class="form-input" value="${c.end_date}" type="date" id="end_date" name="end_date">
                                </div>

                                <div class="form-group">
                                    <label class="form-lable" for="description">Description</label>
                                    <textarea style="min-height:150px" class="form-input" type="text" name="description" autocomplete="off">${c.description}</textarea>
                                    <span class="form-message"></span>
                                </div>
                            </div>
                        </div>

                        <div class="btn-action">
                            <button class="form-submit"><a href="CourseController?ac=view">Cancel</a></button>
                            <button class="form-submit" type="submit">Save</button>
                        </div>
                    </form>
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
