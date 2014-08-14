/**
 * Created by Administrator on 11.08.2014.
 */
studentsControllers.controller('MakeRoleCtrl', ['$scope','$http', function($scope, $http) {
    $http.get('/rest/me/role').success(function(data){
        $scope.meRole = data;
        switch($scope.meRole) {
            case "ROLE_ADMIN":
                $scope.link_ProjectList = true;
                $scope.link_EmployeeList = true;
                $scope.link_Pdf_Excel = true;
                $scope.link_Email_AppointCurator = true;
                $scope.link_AddStudent = true;
                $scope.link_saveStudentInfo = true;
                $scope.link_projectHistory = true;
                break;
            case "ROLE_PERSONNEL_DEPARTMENT":
                $scope.link_ProjectList = true;
                $scope.link_EmployeeList = true;
                $scope.link_Pdf_Excel = true;
                $scope.link_Email_AppointCurator = true;
                $scope.link_AddStudent = true;
                $scope.disableStudentInfo = true;
                $scope.disableAddFeedback = true;
                $scope.link_saveStudentInfo = true;
                $scope.link_projectHistory = true;
                break;
            case "ROLE_CURATOR":
            case "ROLE_FEEDBACKER":
                $scope.disableStudentInfo = true;
                $scope.disableWorkInfo = true;
                $scope.disableCuratorInfo = true;
                break;
        }
    });
    $http.get('/rest/me/name').success(function(data) {
        $scope.meName = data;
    });
    $scope.parseRole = function(role) {
        if(role == null) {
            return;
        }
        var array = role.split('_');
        var result = '';
        for(var i=1;i<array.length;i++) {
            result=result+array[i]+' ';
        }
        return result.toLowerCase();
    }
}]);
