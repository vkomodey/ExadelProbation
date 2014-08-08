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
<body ng-app="studentsApp">
<div class="container">
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Exadel</a>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="#/studentList">Student List</a></li>
            <li><a href="#/employeeList">Employee List</a></li>
            <li><a href="#/projectList">Project list</a></li>
        </ul>
        <form action="/do_logout" method="post">
            <ul class="nav navbar-nav navbar-right">
                <li><button class="btn btn-default navbar-btn" type="submit">Logout</button></li>
            </ul>
        </form>
    </div>
    </div>
</nav>
</div>
<div ng-view></div>
</body>
</html>