/**
 * Created by Administrator on 11.08.2014.
 */
studentsControllers.controller('MakeRoleCtrl', ['$scope','$http','$q', function($scope, $http,$q) {
    var deferred = $q.defer();
    $http.get('/rest/me/role').success(function(data){
        if(data=='ROLE_ADMIN' || data=='ROLE_FEEDBACKER') {
            $scope.link_ProjectList = true;
            $scope.link_EmployeeList = true;
            $scope.link_Pdf_Excel = true;
            $scope.link_Email_AppointCurator = true;
            $scope.link_AddStudent = true;
        }
    });
    deferred.resolve($scope.meRole);
}]);
