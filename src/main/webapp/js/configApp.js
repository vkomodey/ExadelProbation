var studentsApp = angular.module('studentsApp',['ngRoute', 'studentsControllers', 'studentsServices']);

        studentsApp.config(['$routeProvider', '$locationProvider', function($routeProvider,$locationProvider){
        $routeProvider.
            when('/studentList', {
                templateUrl: '/page/partials/students-list.html',
                controller: "StudentListCtrl",
                resolve: {
                    studentsList: StudentListCtrl.studentsList
                }
            }).
            when('/studentList/:studId', {
                templateUrl: '/page/partials/feedbacks-list.html',
                controller: "FeedbacksCtrl",
                resolve: {
                    feedbacks: FeedbacksCtrl.feedbacks,
                    studentInfo: StudentInfoCtrl.studentInfo
                }
            }).
            when('/employeeList', {
                templateUrl: '/page/partials/employee-list.html',
                controller: "EmployeeListCtrl",
                resolve: {
                    employees: EmployeeListCtrl.employees
                }
            }).
            otherwise({
                redirectTo: '/studentList'
            });

    }]);