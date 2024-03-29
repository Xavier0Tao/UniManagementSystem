<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: Tao
  Date: 2022/4/28
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>College Management</title>
</head>

<body>

<!-- ======= Header ======= -->
<%@ include file="header.jsp"%>

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed" href="index.html">
                <i class="bi bi-grid"></i>
                <span>控制台</span>
            </a>
        </li><!-- End Dashboard Nav -->



        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link " href="college-managment.jsp">
                <i class="bi bi-person"></i>
                <span>学院管理</span>
            </a>
        </li><!-- End 学院管理 Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="student-managment.jsp">
                <i class="bi bi-person"></i>
                <span>学生管理</span>
            </a>
        </li><!-- End 学生管理 Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="class-managment.jsp">
                <i class="bi bi-person"></i>
                <span>班级管理</span>
            </a>
        </li><!-- End 班级管理 Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="major-management.jsp">
                <i class="bi bi-person"></i>
                <span>专业管理</span>
            </a>
        </li><!-- End 班级管理 Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-register.html">
                <i class="bi bi-card-list"></i>
                <span>Register</span>
            </a>
        </li><!-- End Register Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-login.html">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Login</span>
            </a>
        </li><!-- End Login Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-error-404.html">
                <i class="bi bi-dash-circle"></i>
                <span>Error 404</span>
            </a>
        </li><!-- End Error 404 Page Nav -->

    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>College Manegment</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item active">College Managment</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="col-xl-4">

                <div class="card">
                    <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

                        <h2>学院管理</h2>
                        <div class="social-links mt-2">
                            <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                            <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                            <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                            <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-xl-8">

                <div class="card">
                    <div class="card-body pt-3">
                        <!-- Bordered Tabs -->
                        <ul class="nav nav-tabs nav-tabs-bordered">

                            <li class="nav-item">
                                <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">概览</button>
                            </li>

                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">添加学院</button>
                            </li>

                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-settings">删除学院</button>
                            </li>

                        </ul>

                        <div class="tab-content pt-2">

                            <div class="tab-pane fade show active profile-overview" id="profile-overview">
                                <a class=" btn btn-primary my-1" href="/collegeServlet/getAll">查看所有学院</a>
                                <p class="small fst-italic">点击上面的<span class="lead mx-1">按钮</span>查看所有学院信息</p>
                                ${colleges}

                            </div>

                            <div class="tab-pane fade  profile-edit pt-3" id="profile-edit">

                                <!-- Profile Edit Form -->
                                <form method="post" action="/collegeServlet/add">
                                    <div class="card-title">添加学院</div>

                                    <div class="row mb-3">
                                        <label for="collegeName" class="col-md-4 col-lg-3 col-form-label">College Name</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="collegeName" type="text" class="form-control" id="collegeName" placeholder="请输入学院名称">
                                        </div>
                                    </div>


                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">添  加</button>
                                    </div>
                                </form><!-- End Profile Edit Form -->

                            </div>

                            <div class="tab-pane fade pt-3" id="profile-settings">

                                <!-- Settings Form -->
                                <form action="/collegeServlet/delete" method="post">
                                    <div class="card-title">删除学院</div>

                                    <div class="row mb-3">
                                        <label for="collegeId" class="col-md-4 col-lg-3 col-form-label">College Id</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="collegeId" type="text" class="form-control" id="collegeId" placeholder="请输入学院编号">
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">Save Changes</button>
                                    </div>
                                </form><!-- End settings Form -->

                            </div>


                        </div><!-- End Bordered Tabs -->

                    </div>
                </div>

            </div>
        </div>
    </section>

</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>Bootstrap 5</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
        Designed by <a href="https://bootstrap.com/">Bootstrap</a>
    </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>


</body>

</html>