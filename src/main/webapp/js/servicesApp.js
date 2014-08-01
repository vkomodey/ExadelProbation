studentsServices = angular.module('studentsServices',['ngResource']);

studentsServices.factory('studentsListFactory',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/stud/:studId', {}, {
        getStudentsList: {method: 'GET', params: {studId: 'all'}, isArray: true},
        getStudent: {method: 'GET', isArray: false}
    });
} ]);

studentsServices.factory('feedbacksListFactory',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/stud/:studId/feedbacks/get', {}, {
        getFeedbacksList: {method: 'GET', isArray: true}
    });
} ]);
studentsServices.factory('employeesList',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/stud/all', {}, {
        getEmployeeList: {method: 'GET', params: {employeeId: 'all'}, isArray: true}
    });
} ]);