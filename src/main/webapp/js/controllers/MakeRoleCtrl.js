/**
 * Created by Administrator on 11.08.2014.
 */
studentsControllers.controller('MakeRoleCtrl', ['$scope','$http', function($scope, $http) {
    $http.get('/rest/me/role').success(function(data){
        switch(data) {
            case "ROLE_ADMIN":
                $scope.link_ProjectList = true;
                $scope.link_EmployeeList = true;
                $scope.link_Pdf_Excel = true;
                $scope.link_Email_AppointCurator = true;
                $scope.link_AddStudent = true;
                break;
            case "ROLE_PERSONNEL_DEPARTMENT":
                $scope.link_ProjectList = true;
                $scope.link_EmployeeList = true;
                $scope.link_Pdf_Excel = true;
                $scope.link_Email_AppointCurator = true;
                $scope.link_AddStudent = true;
                $scope.disableStudentInfo = true;
                break;
        }
    });
}]);
