<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30.07.2014
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student</title>
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
    <script type="text/javascript" src="../js/studentPageApp.js"></script>
</head>
<body ng-app="appForStudent">
<div class="nav"><!-- для навигационной панели навигационной(невидима) -->
    <div class="nav-menu"> <!-- навигационное меню  -->
        <ul id="nav">
            <%--<li><a href="log.html">Log out</a>--%>
            <li style="float: right;">
                <form action="/do_logout" method="post">
                    <button id="btn" type="submit">Log out</button>
                </form>
            </li>
        </ul>
    </div>
</div>
<div class="content student-info-content">
<div ng-controller="ctrlForStudent">
    <table class="student-info-table">
    <tr><td>First Name</td>
        <td><input type="text" ng-model="studentInfo.firstName"/></td></tr>
     <tr><td>Second Name</td>
        <td><input type="text" ng-model="studentInfo.secondName"/></td></tr>
    <tr><td>Surname</td>
        <td><input type="text" ng-model="studentInfo.surname"/></td></tr>
    <tr><td>Email</td>
        <td><input type="text" ng-model="studentInfo.email"/></td></tr>
    <tr><td>Skype</td>
        <td><input type="text" ng-model="studentInfo.skype"/></td></tr>
    <tr><td>Phone</td>
        <td><input type="text" ng-model="studentInfo.phone"/></td></tr>
        <tr>
            <td>English level</td>
            <td><select ng-model="studentInfo.englishLevel">
                <option ng-value="beginner">Begginer</option>
                <option ng-value="elementary">Elementary</option>
                <option ng-value="preintermediate">Pre-Intermediate</option>
                <option ng-value="intermediate">Intermediate </option>
                <option ng-value="upperintermediate">Upper-Intermediate</option>
                <option ng-value="advanced">Advanced</option>
            </select></td>
        </tr>
        <tr>
            <td>Graduate year</td>
            <td><input type="number" ng-model="studentInfo.study.graduate_year"/></td>
        </tr>
        <tr>
            <td>University</td>
            <td> <input type="text" ng-model="studentInfo.study.university"/></td>
        </tr>
        <tr>
            <td>Faculty</td>
            <td> <input type="text" ng-model="studentInfo.study.faculty"/></td>
        </tr>
        <tr>
            <td>Specialty</td>
            <td><input type="text" ng-model="studentInfo.study.specialty"/></td>
        </tr>
        <tr>
            <td>Course/group</td>
            <td>  <input type="text" ng-model="studentInfo.study.course_group"/></td>
        </tr>
        <tr>
            <td>Skills</td>
            <td>
                <table ng-table="skillsParams" class="table exams-table">
                    <tr class="table" ng-repeat="skill in studentInfo.skillSet track by $index">
                        <td data-title="'Skill name'">
                            <select ng-model="studentInfo.skillSet[$index].type">
                                <option ng-repeat="skillType in skillTypes" ng-value="skillType">{{skillType.name}}</option>
                            </select>
                        </td>
                        <td data-title="'Skill level'"><input type="text" ng-model="studentInfo.skillSet[$index].level"/></td>
                        <td data-title=""><button ng-click="deleteSkill($index)" class="modern">X</button></td>
                    </tr>
                </table>     <button ng-click="addSkill()" class="modern" class="add-field">+</button>
            </td>
        </tr>
        <tr class="exams">
            <td>Exams</td>
            <td>  <table ng-table="examsParams" class="table exams-table">
                <tr class="table" ng-repeat="exam in studentInfo.study.exams track by $index">
                    <td data-title="'GRADE'"><input type="number" ng-model="studentInfo.study.exams[$index].grade"/></td>
                    <td data-title="'Summer/winter'">
                        <input type="radio"   ng-model="studentInfo.study.exams[$index].summer"
                               ng-value="true"
                               id="r{{$index*2}}">
                        <label for="r{{$index*2}}">Summer </label><br/>
                        <input type="radio"   ng-model="studentInfo.study.exams[$index].summer"
                               ng-value="false"
                               id="r{{$index*2+1}}">
                        <label for="r{{$index*2+1}}">Winter</label>
                    </td>
                    <td data-title="'Course'"><input type="number" ng-model="studentInfo.study.exams[$index].course"/></td>
                    <td data-title=""><button ng-click="deleteExam($index)" class="modern">X</button></td>
                </tr>
            </table>     <button ng-click="addExam()" class="modern" class="add-field">+</button> </td>
        </tr>
    </table>
    <button ng-click="sendStudentInfo()" class="modern">Save</button>
</div>
</div>
    </div>
</body>
</html>
