/**
 * Created by Administrator on 30.07.2014.
 */
//var appForStudent = angular.module('appForStudent',['studentsControllers']);
//var studentsControllers = angular.module('studentsControllers',['ngTable']);
var ctrlForStudent = studentsControllers.controller('ctrlForStudent',['$scope','$q','$http','StudentInfoCtrl', function($scope,$q,$http,StudentInfoCtrl) {
    var getStudentInfo = function() {
        var deferred = $q.defer();
        $http.get('/rest/me').success(function (data) {
            $scope.studentInfo = data;
        });
        deferred.resolve($scope.studentInfo);
    };
   /* var getSkillSet = function() {
        var deferred = $q.defer();
        $http.get('/rest/types/skill/get').success(function(data){
            $scope.skillTypes = data;
        });
        deferred.resolve($scope.skillTypes);
    }
    $scope.englishLevels = [
        {value: "beginner", name: "Beginner"},
        {value: "elementary", name: "Elementary"},
        {value: "preintermediate",name: "Pre-Intermediate"},
        {value: "intermediate",name: "Intermediate"},
        {value: "upperintermediate", name: "Upper-Intermediate"},
        {value: "advanced", name: "Advanced"}
    ];
    getSkillSet();
    getStudentInfo();
    var getSkillId = function(name) {
        for(skill in $scope.skillTypes) {
            if(skill.name == name) {
                return skill.id;
            }
        }
    }
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
    };*/
    $scope.ehglishLevels = StudentInfoCtrl.englishLevels;
    StudentInfoCtrl.getSkillSet($scope, $http, $q);
    getStudentInfo();
    $scope.addExam = function () {
        StudentInfoCtrl.addExam($scope);
    };
    $scope.sendStudentInfo = function () {
        StudentInfoCtrl.sendStudentInfo($scope, $http);
    };
    $scope.addSkill = function () {
        StudentInfoCtrl.addSkill($scope);
    };
    $scope.deleteSkill = function () {
        StudentInfoCtrl.deleteSkill($scope);
    };
    $scope.deleteExam = function () {
        StudentInfoCtrl.deleteExam($scope);
    };
}]);