/**
 * Created by Administrator on 08.08.2014.
 */
studentsControllers.controller('CreateProjectCtrl', ['$scope', '$http', function($scope,$http,$q) {
    $scope.createProject = function() {
        $http.post('/rest/proj/add',$scope.title).error(function(status,data) {
            alert('ERROR: ' + data);
        });
        $scope.reloadProjectList();
    }
}]);