/**
 * Created by Administrator on 08.08.2014.
 */
studentsControllers.controller('DeleteProjectCtrl', ['$scope', '$http', function($scope,$http) {
    $scope.deleteProject = function() {
        $http.post('/rest/proj/remove/'+$scope.deleteProjectId).success(function(){
            $scope.reloadProjectList();
        })
            .error(function(status,data){
            alert('ERROR:'+ data);
        });
    }
}]);