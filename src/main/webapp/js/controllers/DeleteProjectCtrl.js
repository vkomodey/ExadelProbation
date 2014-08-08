/**
 * Created by Administrator on 08.08.2014.
 */
studentsControllers.controller('DeleteProjectCtrl', ['$scope', '$http', function($scope,$http) {
    $scope.deleteProject = function() {
        $http.get('/proj/remove/'+$scope.deleteProjectId).error(function(status,data){
            alert('ERROR:'+ data);
        });
        $scope.reloadProjectList();
    }
}]);