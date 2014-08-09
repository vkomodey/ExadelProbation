/**
 * Created by Administrator on 09.08.2014.
 */
studentsControllers.controller('CuratorsListForAppointCtrl', ['$scope', '$http', function($scope,$http) {
    $scope.checkedCuratorArray = [];
    $scope.checkedCurator = function(id) {
        StudentListCtrl.checkElement(id,$scope.checkedCuratorArray);
    };
    $scope.appointCuratorsForStudents = function(){
        var checkedStudAndCurator = {
            studsId: $scope.checkedStudArray,
            cursId: $scope.checkedCuratorArray
        };
        $http.post('/rest/stud/attach/manytomany',checkedStudAndCurator)
            .error(function(status,data){
                alert(data);
        });
    };
}]);