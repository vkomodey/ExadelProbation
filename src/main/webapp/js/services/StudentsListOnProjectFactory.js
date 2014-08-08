/**
 * Created by Administrator on 08.08.2014.
 */
studentsServices.factory('StudentsListOnProjectFactory',['$resource', function($resource) {
    return $resource('/rest/proj/:projectId/stud/all',{},{
        getStudentsListOnProject: {method: 'GET', isArray: true}
    });
}])