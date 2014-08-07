var studentsApp = angular.module('studentsApp',['ngRoute', 'studentsControllers', 'studentsServices']);

        studentsApp.config(['$routeProvider', '$locationProvider', function($routeProvider,$locationProvider){
        $routeProvider.
            when('/studentList', {
                templateUrl: '/page/partials/students-list.html',
                controller: "StudentListCtrl",
                resolve: {
                    studentsList: StudentListCtrl.studentsList
                    //filterParams: filterParamsCtrl.filterParams
                }
            }).
            when('/studentList/:studId', {
                templateUrl: '/page/partials/feedbacks-list.html',
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
            when('/test', {
                templateUrl: '/page/partials/test.html',
                controller: "testSend",
                resolve: {

                }
            }).
            otherwise({
                redirectTo: '/studentList'
            });

    }]);