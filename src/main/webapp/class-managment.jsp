<%-- Created by IntelliJ IDEA. User: Tao Date: 2022/4/28 Time: 15:55 To change this template use File | Settings | File
    Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Class Management</title>
</head>

<body>
<%@include file="header.jsp" %>

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
            <a class="nav-link collapsed" href="college-managment.jsp">
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
            <a class="nav-link" href="class-managment.jsp">
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

<!-- ======= main ======= -->
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Class Manegment</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item active">Class Managment</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="col-xl-4">

                <div class="card">
                    <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

                        <h2>班级管理</h2>
                        <div class="social-links mt-2">
                            <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                            <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                            <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                            <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-xl-8" id="class-managementSection">

                <div class="card">
                    <div class="card-body pt-3">
                        <!-- Bordered Tabs -->
                        <ul class="nav nav-tabs nav-tabs-bordered">

                            <li class="nav-item">
                                <button class="nav-link active" data-bs-toggle="tab"
                                        data-bs-target="#profile-overview">概览</button>
                            </li>

                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab"
                                        data-bs-target="#profile-edit">添加班级</button>
                            </li>

                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab"
                                        data-bs-target="#profile-settings">删除班级</button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab"
                                        data-bs-target="#class-courses">班级开设课程</button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab"
                                        data-bs-target="#course-avg">课程平均分查询</button>
                            </li>
                        </ul>

                        <div class="tab-content pt-2">

                            <!--查看所有班级-->
                            <div class="tab-pane fade show active profile-overview" id="profile-overview">
                                <a class=" btn btn-primary my-1" href="/classServlet/getAll">查看所有班级</a>
                                <p class="small fst-italic">点击上面的<span class="lead mx-1">按钮</span>查看所有班级信息</p>
                                ${classes}
                            </div>
                            <!--查看所有班级END-->

                            <!-- ================添加班级================= -->
                            <div class="tab-pane fade  profile-edit pt-3" id="profile-edit">
                                <form class="row g-3 needs-validation" action="/classServlet/add" method="post"  validate>
                                    <div class="card-title">添加班级</div>

                                    <div class="col-md-4">
                                        <label for="validationCustomUsername"
                                               class="form-label">Major Id</label>
                                        <div class="input-group has-validation">
                                            <span class="input-group-text" id="addClass">@</span>
                                            <input type="number" class="form-control"
                                                   id="" placeholder="请输入班级所属专业的编号"
                                                   name="majorId" title="专业编号" required>
                                            <div class="invalid-feedback">
                                                Please enter a major id.
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value=""
                                                   id="invalidCheck" required>
                                            <label class="form-check-label" for="invalidCheck">
                                                Agree to terms and conditions
                                            </label>
                                            <div class="invalid-feedback">
                                                You must agree before submitting.
                                            </div>
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">添 加</button>
                                    </div>
                                </form><!-- End Custom Styled Validation -->
                            </div>
                            <!-- ================添加班级END================= -->

                            <!--===========删除班级==========-->
                            <div class="tab-pane fade pt-3" id="profile-settings">

                                <!-- Settings Form -->
                                <form action="/classServlet/delete" method="post" validate>
                                    <div class="card-title">删除班级</div>

                                    <!--===============College Id============-->
                                    <div class="col-md-4">
                                        <label for="validationCustomUsername"
                                               class="form-label">Class Id</label>
                                        <div class="input-group has-validation">
                                            <span class="input-group-text" id="inputGroupPrepend">@</span>
                                            <input type="number" class="form-control"
                                                   id="validationCustomUsername"
                                                   name="classNo"  title="班级编号" required>
                                            <div class="invalid-feedback">
                                                Please enter a class id.
                                            </div>
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">Save Changes</button>
                                    </div>
                                </form><!-- End settings Form -->

                            </div>

                            <!--===========班级开设课程查询==========-->
                            <div class="tab-pane fade pt-3" id="class-courses">
                                <!-- Settings Form -->
                                <form action="/classServlet/delete" method="post" validate>
                                    <div class="card-title">班级课程开设查询</div>

                                    <!--===============Class Id============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Class Id</label>
                                        <div class="input-group">
                                            <span class="input-group-text" >@</span>
                                            <input type="number" v-model="class_course.classNo" class="form-control" title="班级编号">
                                        </div>
                                    </div>

                                    <!--学生成绩表TABLE-->
                                    <table class="table table-responsive-sm table-striped">
                                        <thead>
                                        <tr>
                                            <th scope="col" v-for="items in class_course.tableHead">{{items}}</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr v-for="(item,index) in class_course.courses">
                                            <td>{{item.courseNo}}</td>
                                            <td>{{item.courseName}}</td>
                                            <td>{{item.courseCredit}}</td>
                                            <td>{{item.courseHours}}</td>
                                            <td>{{item.courseForm}}</td>
                                            <td>{{item.courseTerm}}</td>
                                            <td>{{item.classNo}}</td>
                                        </tr>
                                        </tbody>
                                    </table>

                                    <div class="text-center">
                                        <button type="button" @click="queryClassCourse" class="btn btn-primary">Query</button>
                                    </div>
                                </form><!-- End settings Form -->

                            </div>

                            <!--===========每门课程平均成绩统计==========-->
                            <div class="tab-pane fade pt-3" id="course-avg">
                                <!-- Settings Form -->
                                <form action="/classServlet/delete" method="post" validate>
                                    <div class="card-title">课程平均成绩</div>

                                    <!--学生成绩表TABLE-->
                                    <table class="table table-responsive-sm table-striped">
                                        <thead>
                                        <tr>
                                            <th scope="col" v-for="items in courseAvg.tableHead">{{items}}</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr v-for="(item,index) in courseAvg.data">
                                            <td>{{item.courseNo}}</td>
                                            <td>{{item.courseName}}</td>
                                            <td>{{item.avg}}</td>
                                        </tr>
                                        </tbody>
                                    </table>

                                    <div class="text-center">
                                        <button type="button" @click="queryCourseAvg" class="btn btn-primary">Query</button>
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

<script src="vuejs/class-management.js"></script>

<%@include file="footer.jsp" %>

</body>

</html>