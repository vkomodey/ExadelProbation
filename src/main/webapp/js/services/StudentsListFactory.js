/**
 * Created by Administrator on 04.08.2014.
 */
studentsServices.factory('studentsListFactory',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/stud/:studId', {}, {
        getStudentsList: {method: 'GET',params: {studId: 'all'}, isArray: true},
        getStudent: {method: 'GET', isArray: false}
    });
} ]);
