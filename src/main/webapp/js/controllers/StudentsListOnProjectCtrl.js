/**
 * Created by Administrator on 08.08.2014.
 */
studentsControllers.controller('StudentsListOnProjectCtrl', ['$scope', 'StudentsListOnProjectFactory','$q', function($scope,StudentsListOnProjectFactory,$q) {
    var reloadStudentsOnProject = function(){
        if($scope.studentsListOnProjectId == null)
        return;
        var deferred = $q.defer();
        StudentsListOnProjectFactory.getStudentsListOnProject({projectId: $scope.studentsListOnProjectId},function(data){
            $scope.studentsOnProjectList = data;
        });
        deferred.resolve($scope.studentsOnProjectList);
    };
    $scope.$watch("studentsListOnProjectId", function(){
        if($scope.studentsListOnProjectId == null)
            return;
        var deferred = $q.defer();
        StudentsListOnProjectFactory.getStudentsListOnProject({projectId: $scope.studentsListOnProjectId},function(data){
            $scope.studentsOnProjectList = data;
        });
        deferred.resolve($scope.studentsOnProjectList);
    });
}]);