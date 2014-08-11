/**
 * Created by Administrator on 08.08.2014.
 */
studentsControllers.controller('StudentsListOnProjectCtrl', ['$scope', 'StudentsListOnProjectFactory','$q', function($scope,StudentsListOnProjectFactory,$q) {
    var reloadStudentsOnProject = function(){

        var deferred = $q.defer();
        StudentsListOnProjectFactory.getStudentsListOnProject({projectId: $scope.studentsListOnProjectId},function(data){
            $scope.studentsListOnProject = data;
        });
        deferred.resolve($scope.studentsListOnProject);
    };
    $scope.$watch("studentsListOnProjectId", function(){
        if($scope.studentsListOnProjectId == null)
            return;
        reloadStudentsOnProject();
    });
}]);