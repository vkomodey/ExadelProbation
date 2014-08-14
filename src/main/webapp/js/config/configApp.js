/**
 * Created by Administrator on 04.08.2014.
 */
studentsApp.config(['$routeProvider', '$locationProvider', function($routeProvider,$locationProvider){
    $routeProvider.
        when('/studentList', {
            templateUrl: '../page/partials/students-list.html',
            controller: "StudentListCtrl",
            resolve: {
                studentsList: StudentListCtrl.studentsList
            }
        }).
        when('/studentList/:studId', {
            templateUrl: '../page/partials/student-info.html',
            controller: "FeedbacksCtrl",
            resolve: {
                /*feedbacks: FeedbacksCtrl.feedbacks,
                 studentInfo: StudentInfoCtrl.studentInfo*/
                student: StudentListCtrl.student
            }
        }).
        when('/employeeList', {
            templateUrl: '/page/partials/employee-list.html',
            controller: "EmployeeListCtrl",

            resolve: {
                employees: EmployeeListCtrl.employees

            }
        }).
        when('/projectList', {
            templateUrl: '../page/partials/project-list.html',
            controller: "ProjectListCtrl",
            resolve: {
                projectList: ProjectListCtrl.projectList
            }
        }).
        when('/admin-page', {
            templateUrl: '/page/partials/admin-page.html',
            controller: "AdminPageCtrl",
            resolve: {
            }
        }).
        otherwise({
            redirectTo: '/studentList'
        });

}]);