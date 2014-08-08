/**
 * Created by Administrator on 08.08.2014.
 */
studentsServices.factory('StudentsListOnProjectFactory',['$resource', function($resource) {
    return $resource('/rest/proj/stud/all/:projectId',{},{
        getStudentsListOnProject: {method: 'GET', isArray: true}
    });
}])