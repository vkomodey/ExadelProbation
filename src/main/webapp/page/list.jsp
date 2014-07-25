<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div ng-controller="StudentListCtrl">
    <div class="content">

        <div ng-controller="CreateStudentCtrl" ng-init="PopupCssClass = 'popup-hide'">
            <button ng-click="PopupCssClass = 'popup-show'"></button>
            <!-- Modale window -->
            <div ng-class="PopupCssClass" >
                <h2 class="login-h2">Create User</h2>
                <fildset>
                    <form class="login">
                        <p><input type="text" ng-model="login" placeholder="Login"></p>
                        <button type="submit" ng-click="createStudent()">Create</button>
                        <button ng-click="PopupCssClass= 'popup-hide'">Cancel</button>
                    </form>
                </fildset>
            </div>
        </div>

        <button ng-click="tableParams.sorting({})" class="btn btn-default pull-right">Clear sorting</button>
        <!--<button ng-click="tableParams.filter({})" class="btn btn-default pull-right">Clear filter</button>-->
        <button ng-click="tableParams.reload()">reload</button>
        <!-- Table -->
        <input type="text" ng-model="search.fio" placeholder = "Search">
        <table ng-table="tableParams" show-filter="true" class="table" >
            <tr ng-repeat="user in students|filter:search |orderBy: params.orderBy()">
                <td data-title="'FIO'" sortable="'fio'"><a href="#studentList/{{user.id}}">{{user.fio}}</a></td>
                <td data-title="'DATE'" sortable="'date'" >{{user.date}}</td>
                <td data-title="'FUCULTY'" sortable="'faculty'" >{{user.faculty}}</td>
                <td data-title="'YEAR'" sortable="'year'" >{{user.year}}</td>
                <td data-title="'GROUP/COURSE'" sortable="'course'" >{{user.course}}</td>
                <td data-title="'HOURS'" sortable="'hours'" >{{user.hours}}</td>
                <td data-title="'BILLABILITY'" sortable="'billable'" >{{user.billable}}</td>
                <td data-title="'ROLE'" sortable="'role'" >{{user.role}}</td>
                <td data-title="'TECHNOLOGIES'" sortable="'technologies'" >{{user.technologies}}</td>
                <td data-title="'ENGLISH LEVEL'" sortable="'level'" >{{user.level}}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>