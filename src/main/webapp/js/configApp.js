var studentsApp = angular.module('studentsApp',['ngRoute', 'studentsControllers', 'studentsServices']);

        studentsApp.config(['$routeProvider', function($routeProvider){
        $routeProvider.
            when('/studentList', {
                templateUrl: '/page/partials/students-list.html',
                controller: 'StudentListCtrl'
            }).
            when('/studentList/:studId', {
                templateUrl: '/page/partials/feedbacks-list.html',
                conroller: 'FeedbacksCtrl'
            }).
            otherwise({
                redirectTo: '/studentList'
            });

    }]);