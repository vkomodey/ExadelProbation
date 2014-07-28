
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="studentsApp">
<head lang="en">
    <meta charset="UTF-8">
    <title>Index</title>
    <!--<link rel="stylesheet" href="../css/popup-style2.css" type="text/css" media="screen" charset="utf-8"/>
    <link rel="stylesheet" href="../css/nav-style.css" type="text/css" media="screen" charset="utf-8"/>
    <link rel="stylesheet" href="../css/content-style.css" type="text/css" media="screen" charset="utf-8"/>
    <link rel="stylesheet" href="../css/popup-style3.css" type="text/css" media="screen" charset="utf-8"/>-->
    <link rel="stylesheet" href="../css/ng-table.css" type="text/css" media="screen" charset="utf-8"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css" media="screen" charset="utf-8"/>
   <!-- <link rel="stylesheet" href="../css/UserListStyle.css" type="text/css" media="screen" charset="utf-8"/>-->
    <link rel="stylesheet" href="../css/ExadelProbationStyle.css" type="text/css" media="screen" charset="utf-8"/>
    <script type="text/javascript" src="../lib/angular.min.js"></script>
    <script type="text/javascript" src="../lib/angular-route.min.js"></script>
    <script type="text/javascript" src="../lib/angular-animate.min.js"></script>
    <script type="text/javascript" src="../lib/angular-animate.min.js.map"></script>
    <script type="text/javascript" src="../lib/angular-resource.min.js"></script>
    <script type="text/javascript" src="../lib/ng-table.js"></script>
    <script type="text/javascript" src="../js/configApp.js"></script>
    <script type="text/javascript" src="../js/controllersApp.js"></script>
    <script type="text/javascript" src="../js/servicesApp.js"></script>

</head>
<body class="user-list-container">
<div class="nav"><!-- для навигационной панели навигационной(невидима) -->
    <div class="nav-menu"> <!-- навигационное меню  -->
        <ul id="nav">
            <li><a href="#">Menu</a>
                <ul>
                    <li><a href="#">Home</a></li>
                  <!--  <li><a href=#>Create User</a></li>-->
                    <li><a href="#/studentList">Students</a></li>
                    <li><a href=#>Employees</a></li>
                </ul>
            </li>
            <li>
                <form action="/do_logout" method="post">
                    <button type="submit">Logout</button>
                </form>
            </li>
            <%--<li><a href="log.html">Log out</a>--%>
            </li>
        </ul>
    </div>
</div>
<div ng-view></div>
</body>
</html>