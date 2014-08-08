/**
 * Created by Administrator on 08.08.2014.
 */
studentsControllers.controller('DeleteProjectCtrl', ['$scope', '$http', function($scope,$http) {
    $scope.deleteProject = function() {
        $http.post('/rest/proj/'+$scope.deleteProjectId+'/remove/').success(function(){
            $scope.reloadProjectList();
        })
            .error(function(status,data){
            alert('ERROR:'+ data);
        });
    }
}]);