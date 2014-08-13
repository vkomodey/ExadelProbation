/**
 * Created by Administrator on 09.08.2014.
 */
studentsControllers.controller('CuratorsListForAppointCtrl', ['$scope', '$http','filterParamsFactory','$q', function($scope,$http,filterParamsFactory,$q) {
    $scope.checkedCuratorArray = [];
    $scope.checkedCurator = function(id) {
        StudentListCtrl.checkElement(id,$scope.checkedCuratorArray);
    };
    $scope.appointCuratorsForStudents = function(){
        var checkedStudAndCurator = {
            studsId: $scope.makeIdsArray($scope.checkedStudHash),
            cursId: $scope.checkedCuratorArray
        };
        $http.post('/rest/stud/attach/manytomany',checkedStudAndCurator)
            .error(function(status,data){
                alert(data);
        })
                .success(function(){
                $scope.reloadFilterParams();
                $scope.reloadList();
                });
    };
}]);