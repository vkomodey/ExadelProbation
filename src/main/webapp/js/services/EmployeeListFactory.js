/**
 * Created by Administrator on 04.08.2014.
 */
studentsServices.factory('employeesList',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/empl/all', {}, {
        getEmployeeList: {method: 'GET', isArray: true}
    });
} ]);