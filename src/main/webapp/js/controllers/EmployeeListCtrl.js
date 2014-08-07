/**
 * Created by Administrator on 04.08.2014.
 */
var EmployeeListCtrl = studentsControllers.controller('EmployeeListCtrl', ['$scope', '$routeParams','employeesList','employees','$q', function($scope,$routeParams,employeesList,employees,$q) {

    $scope.reloadList = function (){
        var deferred = $q.defer();
        employeesList.getEmployeeList({employeeId: $routeParams.employeeId},function(data) {
            $scope.employees = data;
        });
        deferred.resolve($scope.employees);
    };
    // $scope.reloadList();
    $scope.employees = employees;


}]);
EmployeeListCtrl.employees = function(employeesList,$q,$route) {
    var deferred = $q.defer();
    employeesList.getEmployeeList(function(data){
            deferred.resolve(data);}
    );
    return deferred.promise;
}