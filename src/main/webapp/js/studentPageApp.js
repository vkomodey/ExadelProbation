/**
 * Created by Administrator on 30.07.2014.
 */
var appForStudent = angular.module('appForStudent',['studentsControllers']);
var studentsControllers = angular.module('studentsControllers',['ngTable']);
var ctrlForStudent = studentsControllers.controller('ctrlForStudent',['$scope','$q','$http', function($scope,$q,$http) {
    var getStudentInfo = function() {
        var deferred = $q.defer();
        $http.get('/rest/me').success(function (data) {
            $scope.studentInfo = data;
        });
        deferred.resolve($scope.studentInfo);
      //  for (skillType in $scope.studentInfo.skillSet.ty) {//because ngModel compares by reference, not value

       // }
    };
    var getSkillSet = function() {
        var deferred = $q.defer();
        $http.get('/rest/types/skill/get').success(function(data){
            $scope.skillTypes = data;
        });
        deferred.resolve($scope.skillTypes);
    }
    getSkillSet();
    getStudentInfo();
    $scope.addExam = function() {
        $scope.studentInfo.study.exams.push({
            grade: null,
            summer: true,
            course: null
        });
    };
    $scope.sendStudentInfo = function() {
            $http.post('/rest/stud/'+$scope.studentInfo.id+'/edit',$scope.studentInfo)
                .success(function(){
                alert('the info is sent');
            })
                .error(function(data,status){
                    alert('Error: '+status);
                });
     };
    $scope.addSkill = function() {
        $scope.studentInfo.skillSet.push( {
            level: null,
            id: 0,
            type: null
        })
    };
    $scope.deleteSkill = function(index) {
        $scope.studentInfo.skillSet.splice(index,1);
    };
    $scope.deleteExam = function(index) {
        $scope.studentInfo.study.exams.splice(index,1);
    };
}]);