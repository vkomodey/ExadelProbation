
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div ng-controller="StudentListCtrl">
    <div class="content">

        <div ng-controller="CreateStudentCtrl" ng-init="PopupCssClass = 'popup-hide'">
            <button ng-click="PopupCssClass = 'popup-show'">Add student</button>
            <!-- Modale window -->
            <div ng-class="PopupCssClass" >
                <h2 class="login-h2">Create User</h2>
                <fildset>
                    <form class="login-popup">
                        <p><input type="text" ng-model="login" placeholder="Login"></p>
                        <button type="submit" ng-click="createStudent()">Create</button>
                        <button ng-click="PopupCssClass= 'popup-hide'">Cancel</button>
                    </form>
                </fildset>
            </div>
        </div>

        <button ng-click="tableParams.sorting({})" class="btn btn-default pull-right">Clear sorting</button>
        <!--<button ng-click="tableParams.filter({})" class="btn btn-default pull-right">Clear filter</button>-->
        <button ng-click="reloadList()">reload</button>
        <!-- Table -->
        <input type="text" ng-model="search.surname" placeholder = "Search">
        <table ng-table="tableParams"   class="table" >
            <tr ng-repeat="user in students | filter:search | orderBy:params.orderBy()">
                <td width="30" style="text-align: left" header="'ng-table/headers/checkbox.html'">
                    <input type="checkbox" ng-model="checkboxes.items[user.id]" />
                </td>
                <td data-title="'FIO'" sortable="'surname'"><a style="color: black;" href="#/studentList/{{user.id}}">{{user.firstName + " "+user.surname}}</a></td>
                <td data-title="'DATE'" sortable="'workStartDate'" >{{user.work.workStartDate}}</td>
                <td data-title="'FACULTY'" sortable="'study.faculty'" >{{user.study.faculty}}</td>
                <td data-title="'YEAR'" sortable="'graduate_year'" >{{user.study.graduate_year}}</td>
                <td data-title="'COURSE/GROUP'" sortable="'course_group'" >{{user.study.course_group}}</td>
                <td data-title="'HOURS'" sortable="'hours_current'" >{{user.work.hours_current}}</td>
                <td data-title="'BILLABLE'" sortable="'billable'" >{{user.work.billable}}</td>
                <td data-title="'ROLE'" sortable="'currentProjectRole'" >{{user.work.currentProjectRole}}</td>
                <td data-title="'TECHNOLOGIES'" sortable="'projectTechnologies'">
                    <span ng-repeat="technologies in user.work.projectTechnologies"> {{technologies.name}}</span>
                    <!--{{user.work.projectTechnologies[0].name}}-->
                </td>
                <td data-title="'ENGLISH LEVEL'" sortable="'level'" >{{user.english}}</td>
            </tr>
        </table>
    </div>
</div>