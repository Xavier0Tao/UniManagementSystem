<%-- Created by IntelliJ IDEA. User: Tao Date: 2022/4/28 Time: 15:55 To change this template use File | Settings | File
    Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Student Management</title>
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

            <li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                    <i class="bi bi-menu-button-wide"></i><span>Components</span><i
                        class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="components-alerts.html">
                            <i class="bi bi-circle"></i><span>Alerts</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-accordion.html">
                            <i class="bi bi-circle"></i><span>Accordion</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-badges.html">
                            <i class="bi bi-circle"></i><span>Badges</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-breadcrumbs.html">
                            <i class="bi bi-circle"></i><span>Breadcrumbs</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-buttons.html">
                            <i class="bi bi-circle"></i><span>Buttons</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-cards.html">
                            <i class="bi bi-circle"></i><span>Cards</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-carousel.html">
                            <i class="bi bi-circle"></i><span>Carousel</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-list-group.html">
                            <i class="bi bi-circle"></i><span>List group</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-modal.html">
                            <i class="bi bi-circle"></i><span>Modal</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-tabs.html">
                            <i class="bi bi-circle"></i><span>Tabs</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-pagination.html">
                            <i class="bi bi-circle"></i><span>Pagination</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-progress.html">
                            <i class="bi bi-circle"></i><span>Progress</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-spinners.html">
                            <i class="bi bi-circle"></i><span>Spinners</span>
                        </a>
                    </li>
                    <li>
                        <a href="components-tooltips.html">
                            <i class="bi bi-circle"></i><span>Tooltips</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End Components Nav -->

            <li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
                    <i class="bi bi-journal-text"></i><span>Forms</span><i class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="forms-elements.html">
                            <i class="bi bi-circle"></i><span>Form Elements</span>
                        </a>
                    </li>
                    <li>
                        <a href="forms-layouts.html">
                            <i class="bi bi-circle"></i><span>Form Layouts</span>
                        </a>
                    </li>
                    <li>
                        <a href="forms-editors.html">
                            <i class="bi bi-circle"></i><span>Form Editors</span>
                        </a>
                    </li>
                    <li>
                        <a href="forms-validation.html">
                            <i class="bi bi-circle"></i><span>Form Validation</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End Forms Nav -->

            <li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                    <i class="bi bi-layout-text-window-reverse"></i><span>Tables</span><i
                        class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="tables-general.html">
                            <i class="bi bi-circle"></i><span>General Tables</span>
                        </a>
                    </li>
                    <li>
                        <a href="tables-data.html">
                            <i class="bi bi-circle"></i><span>Data Tables</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End Tables Nav -->

            <li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
                    <i class="bi bi-bar-chart"></i><span>Charts</span><i class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="charts-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="charts-chartjs.html">
                            <i class="bi bi-circle"></i><span>Chart.js</span>
                        </a>
                    </li>
                    <li>
                        <a href="charts-apexcharts.html">
                            <i class="bi bi-circle"></i><span>ApexCharts</span>
                        </a>
                    </li>
                    <li>
                        <a href="charts-echarts.html">
                            <i class="bi bi-circle"></i><span>ECharts</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End Charts Nav -->

            <li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#icons-nav" data-bs-toggle="collapse" href="#">
                    <i class="bi bi-gem"></i><span>Icons</span><i class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="icons-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="icons-bootstrap.html">
                            <i class="bi bi-circle"></i><span>Bootstrap Icons</span>
                        </a>
                    </li>
                    <li>
                        <a href="icons-remix.html">
                            <i class="bi bi-circle"></i><span>Remix Icons</span>
                        </a>
                    </li>
                    <li>
                        <a href="icons-boxicons.html">
                            <i class="bi bi-circle"></i><span>Boxicons</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End Icons Nav -->

            <li class="nav-heading">Pages</li>

            <li class="nav-item">
                <a class="nav-link collapsed" href="college-managment.jsp">
                    <i class="bi bi-person"></i>
                    <span>学院管理</span>
                </a>
            </li><!-- End 学院管理 Nav -->

            <li class="nav-item">
                <a class="nav-link" href="student-managment.jsp">
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
                <a class="nav-link collapsed" href="users-profile.html">
                    <i class="bi bi-person"></i>
                    <span>Profile</span>
                </a>
            </li><!-- End Profile Page Nav -->

            <li class="nav-item">
                <a class="nav-link collapsed" href="pages-faq.html">
                    <i class="bi bi-question-circle"></i>
                    <span>F.A.Q</span>
                </a>
            </li><!-- End F.A.Q Page Nav -->

            <li class="nav-item">
                <a class="nav-link collapsed" href="pages-contact.html">
                    <i class="bi bi-envelope"></i>
                    <span>Contact</span>
                </a>
            </li><!-- End Contact Page Nav -->

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

            <li class="nav-item">
                <a class="nav-link collapsed" href="pages-blank.html">
                    <i class="bi bi-file-earmark"></i>
                    <span>Blank</span>
                </a>
            </li><!-- End Blank Page Nav -->

        </ul>

    </aside><!-- End Sidebar-->

    <!-- ======= main ======= -->
    <main id="main" class="main">

        <div class="pagetitle">
            <h1>Student Manegment</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item active">Student Managment</li>
                </ol>
            </nav>
        </div><!-- End Page Title -->

        <section class="section profile">
            <div class="row">
                <div class="col-xl-4">

                    <div class="card">
                        <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

                            <h2>Students Management</h2>
                            <div class="social-links mt-2">
                                <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                                <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                                <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                                <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="col-xl-8" id="studentManagement">
                    <div class="card">
                        <%--标签页--%>
                        <div class="card-body pt-3">
                            <!-- Bordered Tabs -->
                            <ul class="nav nav-tabs nav-tabs-bordered">

                                <li class="nav-item">
                                    <button class="nav-link active" data-bs-toggle="tab"
                                            data-bs-target="#profile-overview">概览</button>
                                </li>

                                <li class="nav-item">
                                    <button class="nav-link" data-bs-toggle="tab"
                                            data-bs-target="#profile-edit">添加</button>
                                </li>

                                <li class="nav-item">
                                    <button class="nav-link" data-bs-toggle="tab"
                                            data-bs-target="#profile-settings">删除</button>
                                </li>

                                <li class="nav-item">
                                    <button class="nav-link" data-bs-toggle="tab"
                                            data-bs-target="#student-getScore">统计成绩</button>
                                </li>
                                <li class="nav-item">
                                    <button class="nav-link" data-bs-toggle="tab"
                                            data-bs-target="#student-course">统计所学课程和学分</button>
                                </li>
                                <li class="nav-item">
                                    <button class="nav-link" data-bs-toggle="tab"
                                            data-bs-target="#student-setScore">录入成绩</button>
                                </li>

                            </ul>
                        </div>
                        <%--标签页END--%>

                        <div class="tab-content pt-2 ps-2 ps-md-4">
                            <%--查看所有学生--%>
                            <div class="tab-pane fade show active profile-overview" id="profile-overview">
                                <a class=" btn btn-primary my-1" href="/stuServlet/getAll">查看所有学生</a>
                                <p class="small fst-italic">点击上面的<span class="lead mx-1">按钮</span>查看所有学生信息</p>
                                ${students}
                            </div>
                            <%--查看所有学生END--%>

                            <%--添加学生--%>
                            <div class="tab-pane fade  profile-edit pt-3" id="profile-edit">
                                <!-- Custom Styled Validation -->
                                <form class="row g-3 needs-validation" action="/stuServlet/add" method="post"  validate>
                                    <div class="card-title">添加学生</div>

                                    <!--===============name===============-->
                                    <div class="col-md-4">
                                        <label  class="form-label">Student name</label>
                                        <input type="text" name="sname" class="form-control"
                                               placeholder="请输入学生姓名" required>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <!--===============Identity===============-->
                                    <div class="col-md-6">
                                        <label class="form-label">身份证号</label>
                                        <input type="text" class="form-control" name="identity"
                                               placeholder="必填" title="身份证" >
                                        <div class="invalid-feedback">
                                            Please provide a valid id.
                                        </div>
                                    </div>

                                    <!--============== sex ==================-->
                                    <div class="col-md-4">
                                        <label for="validationCustom02" class="form-label">Sex</label>

                                        <select class="form-select" name="sex" id="validationCustom02" required>
                                            <option selected disabled value="">Choose...</option>
                                            <option value="male">male</option>
                                            <option value="female">female</option>
                                        </select>

                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <!--===============College Id============-->
                                    <div class="col-md-4">
                                        <label for="validationCustomUsername"
                                               class="form-label">College Id</label>
                                        <div class="input-group has-validation">
                                            <span class="input-group-text" id="inputGroupPrepend">@</span>
                                            <input type="number" class="form-control"
                                                   id="validationCustomUsername"
                                                   name="collid" placeholder="*选填" title="学院编号">
                                            <div class="invalid-feedback">
                                                Please enter a college id.
                                            </div>
                                        </div>
                                    </div>

                                    <%--专业编号--%>
                                    <div class="col-md-6">
                                        <label for="validationCustom04" class="form-label">Major No</label>
                                        <input type="number" class="form-control" name="mno" id="validationCustom04"
                                               placeholder="*选填" title="专业编号" >
                                        <div class="invalid-feedback">
                                            Please provide a valid major id.
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <label for="validationCustom05" class="form-label">City</label>
                                        <input type="text" class="form-control" name="city" id="validationCustom05"
                                               placeholder="*选填" title="生源地" >
                                        <div class="invalid-feedback">
                                            Please provide a valid city.
                                        </div>
                                    </div>


                                    <%--承诺同意--%>
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
                            <%--添加学生END--%>

                            <%--删除学生--%>
                            <div class="tab-pane fade pt-3" id="profile-settings">

                                <!-- Settings Form -->
                                <form action="/stuServlet/delete" method="delete">
                                    <div class="card-title">删除学生</div>

                                    <div class="row mb-3">
                                        <label for="collegeId" class="col-md-4 col-lg-3 col-form-label">Student
                                            Id</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="stuId" type="number" class="form-control"
                                                   id="collegeId" placeholder="请输入学生编号">
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">Save Changes</button>
                                    </div>
                                </form><!-- End settings Form -->

                            </div>
                            <%--删除学生 END--%>

                            <%--统计学生成绩--%>
                            <div class="tab-pane fade pt-3" id="student-getScore">
                                <form class="row g-3 needs-validation" action="/stuServlet/add" method="post"  validate>
                                    <div class="card-title">统计学生成绩</div>

                                    <!--===============学生编号===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Student Number</label>
                                        <input type="number" v-model="stuScore.stuNo" class="form-control"
                                               placeholder="请输入学生编号" required>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <!--===============学年===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Academic Year</label>
                                        <input type="number" class="form-control" v-model="stuScore.academicYear"
                                               placeholder="选填" title="Academic Year" >
                                        <div class="invalid-feedback">
                                            Please provide a valid id.
                                        </div>
                                    </div>

                                    <!--===============是否排序===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Order Ascendingly</label>
                                        <input type="number" class="form-control" v-model="stuScore.order"
                                               placeholder="选填" title="Order" >
                                        <div class="invalid-feedback">
                                            Please provide a valid id.
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="button" class="btn btn-primary" @click="queryStuScore">查询统计</button>
                                    </div>
                                </form>

                                <!--学生成绩表TABLE-->
                                <table class="table table-responsive-sm table-striped" id="studentScores" >
                                    <thead>
                                    <tr>
                                        <th scope="col" v-for="items in stuScore.tableHead">{{items}}</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr v-for="(item,index) in stuScore.data">
                                        <td>{{item.sno}}</td>
                                        <td>{{item.cterm}}</td>
                                        <td>{{item.academicYear}}</td>
                                        <td>{{item.cno}}</td>
                                        <td>{{item.score}}</td>
                                        <td>{{item.tid}}</td>
                                    </tr>
                                    </tbody>
                                </table>

                            </div>
                            <%--统计学生成绩END--%>

                            <%--统计学生所学课程--%>
                            <div class="tab-pane fade pt-3" id="student-course">
                                <%--id="student-course" 是为了和标签页的toggle配对--%>

                                <form class="row g-3 needs-validation" >
                                    <div class="card-title">Grade and Credits</div>

                                    <!--===============学生编号===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Student Number</label>
                                        <input type="number" v-model="stuCourse.stuNo" class="form-control"
                                               placeholder="请输入学生编号" required>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="button" class="btn btn-primary" @click="queryStuCourse">Query</button>
                                    </div>
                                </form>

                                <!--学生所学课程表-->
                                <table class="table table-responsive-sm table-striped">
                                    <thead>
                                    <tr>
                                        <th scope="col" v-for="item in stuCourse.tableHead">{{item}}</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr v-for="(item,index) in stuCourse.data">
                                        <td>{{item.stuNo}}</td>
                                        <td>{{item.stuName}}</td>
                                        <td>{{item.courseNo}}</td>
                                        <td>{{item.courseName}}</td>
                                        <td>{{item.courseCredit}}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <%--统计学生所学课程END--%>                           

                            <%--录入学生成绩--%>
                            <div class="tab-pane fade pt-3" id="student-setScore">
                                <%--id="student-setScore" 是为了和标签页的toggle配对--%>

                                <form class="row g-3 needs-validation" >
                                    <div class="card-title">录入学生成绩</div>

                                    <!--===============学生编号===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Student Number</label>
                                        <input type="number" v-model="recordScore.sno" class="form-control"
                                               placeholder="请输入学生编号" required>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <!--===============课程编号===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Course Code</label>
                                        <input type="number" v-model="recordScore.cno" class="form-control"
                                               placeholder="请输入课程编号" required>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <!--===============成绩===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Mark</label>
                                        <input type="number" v-model="recordScore.score" class="form-control"
                                               placeholder="请输入成绩" required>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <!--===============学期===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Semester</label>
                                        <input type="number" v-model="recordScore.cterm" class="form-control"
                                               placeholder="请输入学期" required>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <!--===============教师编号===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Teacher Number</label>
                                        <input type="number" v-model="recordScore.tid" class="form-control"
                                               placeholder="*选填" required>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <!--===============学生学分===============-->
                                    <div class="col-md-4">
                                        <label class="form-label">Credits</label>
                                        <input type="number" disabled v-model="recordScore.credits" class="form-control"
                                               placeholder="学生学分" required>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="button" class="btn btn-primary" @click="uploadStuScore">录入</button>
                                    </div>

                                </form>

                            </div>
                            <%--录入学生成绩END--%>


                        </div><!-- End Bordered Tabs -->
                    </div>
                </div>
            </div>
        </section>

    </main><!-- End #main -->

    <script src="vuejs/student-management.js"></script>
    <%@include file="footer.jsp" %>

</body>

</html>