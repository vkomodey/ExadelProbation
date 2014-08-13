<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Index</title>
    <link rel="stylesheet" href="../css/bootstrap.css"/>
    <link rel="stylesheet" href="../css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="../css/ng-table.css"/>
    <link rel="stylesheet" href="../css/skillsTable.css"/>
    <link rel="stylesheet" href="../css/table-style.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="../js/built.js"></script>
</head>
<body ng-app="studentsApp" data-ng-controller="MakeRoleCtrl">
<div class="container">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <!-- <a class="navbar-brand" href="#">Exadel</a>-->
                <a href="" class="navbar-brand">
                    <img src="../img/exadel-logo.png" alt="Exadel"/>
                </a>
            </div>
            <ul class=" nav navbar-nav pull-right">
                <li><p class="navbar-brand">{{meName}}, {{parseRole(meRole)}}</p></li>
                <li><form action="/do_logout" method="post">
                    <button class="btn btn-default navbar-btn pull-right" type="submit">Logout</button>
                </form></li>
            </ul>

        </div>

    </nav>
</div>
<div class="container">
<ul class="nav nav-tabs" id="tab">
    <li class="active"><a href="#personInfo" data-toggle="tab" data-target="#personInfo">Person info</a></li>
    <li><a href="#contactInfo" data-toggle="tab" data-target="#contactInfo">Contact info</a></li>
    <li><a href="#studyInfo" data-toggle="tab">Study info</a></li>
    <li><a href="#skills" data-toggle="tab">Skills</a></li>
    <li><a href="#exams" data-toggle="tab">Exams</a></li>
</ul>
<form name="studentInfoForm" class="form-horizontal" ng-controller="StudentPageCtrl">
    <div class="tab-content">
    <div class="tab-pane active" id="personInfo">
        <div class="pull-right well-sm">
            <a data-ng-click="sendStudentInfo()" data-ng-disabled="studentInfoForm.$invalid"
               class="btn btn-primary btn-primary"><span class="glyphicon glyphicon-ok"></span> Save</a>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-1">
                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="firstName">First name</label>
                    <input id="firstName" name="firstName" type="text"  ng-model="studentInfo.firstName" ng-pattern="/^[a-zA-Z]+$/"
                           class="form-control input-md">
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="firstName">Middle Name</label>
                    <input id="middleName" name="middleName" type="text" ng-model="studentInfo.middleName" ng-pattern="/^[a-zA-Z]+$/"
                           class="form-control input-md">
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" >Surname</label>
                    <input id="surname" name="firstName" type="text" ng-model="studentInfo.surname" ng-pattern="/^[a-zA-Z]+$/"
                           class="form-control input-md">
                </div>
            </div>
        </div>
    </div>
    <div class="tab-pane" id="contactInfo">
        <div class="pull-right well-sm">
            <a data-ng-click="sendStudentInfo()" data-ng-disabled="studentInfoForm.$invalid"
               class="btn btn-primary btn-primary"><span class="glyphicon glyphicon-ok"></span> Save</a>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-1">
                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="email">Email</label>
                    <input id="email" name="email" type="email" ng-model="studentInfo.email"
                           ng-pattern="/^([^\@]+)\@([^\.]+)\.([a-zA-Z]+)$/"
                           class="form-control input-md">
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="skype">Skype</label>
                    <input id="skype" name="skype" type="text" ng-model="studentInfo.skype"
                           class="form-control input-md">
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="firstName">Phone</label>
                    <input id="phone" name="phone" type="text" ng-model="studentInfo.phone"
                           data-ng-pattern="/( +)?((\+?7|8) ?)?((\(\d{3}\))|(\d{3}))?( )?(\d{3}[\- ]?\d{2}[\- ]?\d{2})( +)?$/" class="form-control input-md">
                </div>
            </div>
        </div>
    </div>
    <div class="tab-pane" id="studyInfo">
        <div class="pull-right well-sm">
            <a data-ng-click="sendStudentInfo()" data-ng-disabled="studentInfoForm.$invalid"
               class="btn btn-primary btn-primary"><span class="glyphicon glyphicon-ok"></span> Save</a>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-1">

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="graduateYear">Graduate year</label>
                    <input type="text" id="graduateYear" name="graduateYear"  ng-model="studentInfo.study.graduate_year"
                           ng-pattern ="/^(([2-9][0-9][1-9][4-9])|([2-9][1-9][0-9][0-9])|([2-9][0-9][2-9][0-9])){1}$/" class="form-control input-md" >
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="university">University</label>
                    <select class="form-control" data-ng-model="studentInfo.study.university"
                            data-ng-options="item.name for item in universityNames">
                    </select>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="faculty">Faculty</label>
                    <input id="faculty" name="faculty" type="text" ng-model="studentInfo.study.faculty"
                           class="form-control input-md">
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="specialty">Specialty</label>
                    <input id="specialty" name="specialty" type="text" ng-model="studentInfo.study.specialty"
                           class="form-control input-md">
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="control-label" for="course_group">Course/group</label>
                    <input id="course_group" name="course_group" type="text" ng-model="studentInfo.study.course_group"
                           ng-pattern="/^[2-6]/([0-9a-zA-Z]+)$/"
                           class="form-control input-md">
                </div>
            </div>
        </div>
    </div>
    <div class="tab-pane" id="skills">
        <div class="pull-right well-sm">
            <a data-ng-click="sendStudentInfo()" data-ng-disabled="studentInfoForm.$invalid"
               class="btn btn-primary btn-primary"><span class="glyphicon glyphicon-ok"></span> Save</a>
        </div>
        <!--<div class="row">
            <div class="col-md-6 col-md-offset-1">
                <!-- Text input
                <div class="form-group">
                    <label class="control-label" for="englishLevel">English level</label>
                    <input id="englishLevel" name="englishLevel" type="text" placeholder=""
                           class="form-control input-md">
                </div>
            </div>
        </div>-->
        <div class="row">
            <div class="col-md-8 col-md-offset-1 well-sm">
                <table class="table skills-table">
                    <thead>
                    <tr>
                        <th>Skill name</th>
                        <th>Skill level</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>English</td>
                        <td><select class="form-control" ng-model="studentInfo.english"
                                    ng-options="englishLevel.value as englishLevel.name for englishLevel in englishLevels">
                        </select></td>
                        <td></td>
                    </tr>
                    <tr ng-repeat="skill in studentInfo.skillSet track by $index">
                        <td>
                            <select id="skillType{{$index}}" ng-model="studentInfo.skillSet[$index].type"
                                    class="form-control"
                                    ng-options="skillType.name for skillType in skillTypes track by skillType.id">
                            </select>
                        </td>
                        <td>
                            <input id="skillLevel" name="englishLevel" type="text"
                                   class="form-control input-sm">
                        </td>
                        <td class="text-center">
                            <a data-ng-click="deleteSkill($index)" class="btn btn-sm btn-danger"><span
                                    class="glyphicon glyphicon-trash"></span></a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2 col-md-offset-7"><a ng-click="addSkill()" class="btn btn-sm btn-success"><span class="glyphicon glyphicon-plus"></span> Add skill</a></div>
        </div>
    </div>
    <div class="tab-pane" id="exams">
        <div class="pull-right well-sm">
            <a data-ng-click="sendStudentInfo()" data-ng-disabled="studentInfoForm.$invalid"
               class="btn btn-primary btn-primary"><span class="glyphicon glyphicon-ok"></span> Save</a>
        </div>

        <div class="row">
            <div class="col-md-2">
                <label class="control-label" for="exam-3">Semester-3</label>
                <input data-ng-model="studentInfo.study.exams.sem3" id="exam-3" name="exam-3" type="text" placeholder="Grade"
                       class="form-control input-sm" ng-pattern="/^((10)|([0-9])|([0-9][.]([0-9]+)))$/">
            </div>
            <div class="col-md-2">
                <label class="control-label" for="exam-4">Semester-4</label>
                <input data-ng-model="studentInfo.study.exams.sem4" id="exam-4" name="exam-4" type="text" placeholder="Grade"
                       class="form-control input-sm" ng-pattern="/^((10)|([0-9])|([0-9][.]([0-9]+)))$/">
            </div>
            <div class="col-md-2">
                <label class="control-label" for="exam-5">Semester-5</label>
                <input data-ng-model="studentInfo.study.exams.sem5" id="exam-5" name="exam-5" type="text" placeholder="Grade"
                       class="form-control input-sm" ng-pattern="/^((10)|([0-9])|([0-9][.]([0-9]+)))$/">
            </div>
            <div class="col-md-2">
                <label class="control-label" for="exam-6">Semester-6</label>
                <input data-ng-model="studentInfo.study.exams.sem6" id="exam-6" name="exam-6" type="text" placeholder="Grade"
                       class="form-control input-sm" ng-pattern="/^((10)|([0-9])|([0-9][.]([0-9]+)))$/">
            </div>
        </div>

        <div class="row">
            <div class="col-md-2">

                <label class="control-label" for="exam-7">Semester-7</label>
                <input data-ng-model="studentInfo.study.exams.sem7" id="exam-7" name="exam-7" type="text" placeholder="Grade"
                       class="form-control input-sm" ng-pattern="/^((10)|([0-9])|([0-9][.]([0-9]+)))$/">
            </div>
            <div class="col-md-2">
                <label class="control-label" for="exam-8">Semester-8</label>
                <input data-ng-model="studentInfo.study.exams.sem8" id="exam-8" name="exam-8" type="text" placeholder="Grade"
                       class="form-control input-sm" ng-pattern="/^((10)|([0-9])|([0-9][.]([0-9]+)))$/">
            </div>
            <div class="col-md-2">
                <label class="control-label" for="exam-9">Semester-9</label>
                <input data-ng-model="studentInfo.study.exams.sem9" id="exam-9" name="exam-9" type="text" placeholder="Grade"
                       class="form-control input-sm" ng-pattern="/^((10)|([0-9])|([0-9][.]([0-9]+)))$/">
            </div>
            <div class="col-md-2">
                <label class="control-label" for="exam-10">Semester-10</label>
                <input data-ng-model="studentInfo.study.exams.sem10" id="exam-10" name="exam-10" type="text" placeholder="Grade"
                       class="form-control input-sm" ng-pattern="/^((10)|([0-9])|([0-9][.]([0-9]+)))$/">
            </div>
        </div>
    </div>
        </div>
</form>
</div>
</body>
</html>
