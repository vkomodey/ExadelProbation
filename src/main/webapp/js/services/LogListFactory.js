/**
 * Created by Administrator on 11.08.2014.
 */
studentsServices.factory('LogListFactory',['$resource',function($resource) {
    return $resource('/rest/stud/:studId/get_log',{},{
        getLogList: {method: 'GET', isArray: true}
    })
}]);
