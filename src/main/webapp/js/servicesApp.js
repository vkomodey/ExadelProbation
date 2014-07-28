studentsServices = angular.module('studentsServices',['ngResource']);

studentsServices.factory('feedbacksList',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/stud/:studId', {}, {
        getStudentsList: {method: 'GET', params: {studId: 'all'}, isArray: true},
        getFeedbacksList: {method: 'GET', isArray: true}
    });
} ]);