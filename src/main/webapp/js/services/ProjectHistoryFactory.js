/**
 * Created by Administrator on 12.08.2014.
 */
studentsServices.factory('ProjectHistoryFactory',['$resource', function($resource) {
    return $resource('/rest/stud/:studId/proj/history',{},{
        getProjectHistory: {method: 'GET', isArray: true}
    });
}]);
