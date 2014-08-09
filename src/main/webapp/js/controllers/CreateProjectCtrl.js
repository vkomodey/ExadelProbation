/**
 * Created by Administrator on 08.08.2014.
 */
studentsControllers.controller('CreateProjectCtrl', ['$scope', '$http', function($scope,$http,$q) {
    $scope.createProject = function() {
        $http.post('/rest/proj/add',$scope.title).success(function(){
            $scope.title=null;
            $scope.reloadProjectList();
        })
            .error(function(status,data) {
            alert('ERROR: ' + data);
        });
    }
}]);