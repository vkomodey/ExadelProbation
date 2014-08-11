<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Index</title>
    <link rel="stylesheet" href="../css/bootstrap.css"/>
    <link rel="stylesheet" href="../css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="../css/ng-table.css"/>
    <link rel="stylesheet" href="../css/skillsTable.css"/>
    <link rel="stylesheet" href="../css/projectListTable.css"/>
    <link rel="stylesheet" href="../css/table-style.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="../js/built.js"></script>
</head>
<body ng-app="studentsApp" data-ng-controller="MakeRoleCtrl">
<div class="container">
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Exadel</a>
    </div>
        <ul class="nav navbar-nav">
            <li><a href="#/studentList">Student List</a></li>
            <li data-ng-if="link_EmployeeList"><a href="#/employeeList">Employee List</a></li>
            <li data-ng-if="link_ProjectList"><a href="#/projectList">Project list</a></li>
        </ul>
        <form action="/do_logout" method="post">
              <button class="btn btn-default navbar-btn pull-right" type="submit">Logout</button>
            </form>
    </div>

</nav>
</div>
<div ng-view></div>
</body>
</html>