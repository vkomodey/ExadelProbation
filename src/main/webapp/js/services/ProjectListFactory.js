/**
 * Created by Administrator on 07.08.2014.
 */
studentsServices.factory('projectListFactory',['$resource', function($resource) {
    return $resource('/rest/proj/all', {}, {
        getProjectList: {method: 'GET', isArray: true}
    });
} ]);