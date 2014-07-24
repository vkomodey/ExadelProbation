studentsServices = angular.module('studentsServices',['ngResource']);

studentsServices.factory('feedbacksList',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('json/:studId.json', {}, {
        getStudentsList: {method: 'GET', params: {studId: 'students'}, isArray: true},
        getFeedbacksList: {method: 'GET', isArray: true}
    });
} ]);