/**
 * Created by Administrator on 08.08.2014.
 */
studentsControllers.controller('StudentsListOnProjectCtrl', ['$scope', 'StudentListOnProjectFactory','$q', function($scope,StudentListOnProjectFactory,$q) {
    var reloadStudentsOnProject = function(){
        var deferred = $q.defer();
        StudentListOnProjectFactory.getStudentsListOnProject({projectId: $scope.studentsListOnProjectId},function(data){
            $scope.studentsOnProjectList = data;
        })
        deferred.resolve($scope.studentsOnProjectList);
    };
    $scope.$watch($scope.studentsListOnProjectId, reloadStudentsOnProject());
}]);