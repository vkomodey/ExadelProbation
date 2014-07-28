studentsServices = angular.module('studentsServices',['ngResource']);

studentsServices.factory('studentsList',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/stud/:studId', {}, {
        getStudentsList: {method: 'GET', params: {studId: 'all'}, isArray: true},
    });
} ]);

studentsServices.factory('feedbacksList',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/stud/:studId/feedbacks/get', {}, {
        getFeedbacksList: {method: 'GET', isArray: true}
    });
} ]);