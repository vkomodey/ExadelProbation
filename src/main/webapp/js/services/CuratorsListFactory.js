/**
 * Created by Administrator on 09.08.2014.
 */
studentsServices.factory('CuratorsListFactory',['$resource', function($resource) {
    return $resource('/rest/empl/all',{},{
        getCuratorsList:{method: 'GET', isArray: true}
    });
}]);