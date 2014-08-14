/**
 * Created by Administrator on 04.08.2014.
 */
var StudentPageCtrl = studentsControllers.controller('StudentPageCtrl',['$scope','$q','$http', function($scope,$q,$http) {
    var getStudentInfo = function() {
        var deferred = $q.defer();
        $http.get('/rest/me').success(function (data) {
            $scope.studentInfo = data;
        });
        deferred.resolve($scope.studentInfo);
    };
    $scope.englishLevels = StudentInfoCtrl.englishLevels;
    StudentInfoCtrl.getSkillSet($scope, $http, $q);
    getStudentInfo();
    StudentInfoCtrl.getUniversityList($scope, $http, $q);
    StudentInfoCtrl.getFacultyList($scope, $http, $q);

    /*$scope.addExam = function () {
        StudentInfoCtrl.addExam($scope);
    };*/
    $scope.sendStudentInfo = function () {
        StudentInfoCtrl.sendStudentInfo($scope, $http, $scope.studentInfo.id);
    };
    $scope.addSkill = function () {
        StudentInfoCtrl.addSkill($scope);
    };
    $scope.deleteSkill = function () {
        StudentInfoCtrl.deleteSkill($scope);
    };
    /*$scope.deleteExam = function () {
        StudentInfoCtrl.deleteExam($scope);
    };*/

}]);