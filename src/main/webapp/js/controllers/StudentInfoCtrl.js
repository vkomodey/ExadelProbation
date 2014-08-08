/**
 * Created by Administrator on 04.08.2014.
 */
var StudentInfoCtrl = studentsControllers.controller('StudentInfoCtrl',['$scope','$routeParams','$q','$http',function($scope,$routeParams,$q,$http) {
    /*var getStudentInfo = function () {
     var deferred = $q.defer();
     $http.get('../json/studentInfo.json').success(function(data){
     $scope.studentInfo = data;
     });
     deferred.resolve($scope.studentInfo);
     };*/
    if ($scope.studentInfo == null) { //make feedback-list-tab active
        $scope.active = 'active';
    }
    else {
        $scope.englishLevels = StudentInfoCtrl.englishLevels;
        StudentInfoCtrl.getSkillSet($scope, $http, $q);
        $scope.addExam = function () {
            StudentInfoCtrl.addExam($scope);

        };
        $scope.sendStudentInfo = function () {
            StudentInfoCtrl.sendStudentInfo($scope, $http, $routeParams.studId);
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
    }
}]);

/*StudentInfoCtrl.getStudentInfo = function ($scope,$http,$q,adress) {
 var deferred = $q.defer();
 $http.get(adress).success(function(data){
 $scope.studentInfo = data;
 });
 deferred.resolve($scope.studentInfo);
 };*/
StudentInfoCtrl.englishLevels = [
    {value: "beginner", name: "Beginner"},
    {value: "elementary", name: "Elementary"},
    {value: "preintermediate", name: "Pre-Intermediate"},
    {value: "intermediate", name: "Intermediate"},
    {value: "upperintermediate", name: "Upper-Intermediate"},
    {value: "advanced", name: "Advanced"}
];
/*StudentInfoCtrl.studentInfo = function ($q,$http) {
 var deferred = $q.defer();
 $http.get('../json/studentInfo.json').success(function (data) {
 deferred.resolve(data);
 });
 return deferred.promise;
 }*/
StudentInfoCtrl.getSkillSet = function($scope,$http,$q) {
    var deferred = $q.defer();
    $http.get('/rest/types/skill/get').success(function(data){
        $scope.skillTypes = data;
    });
    deferred.resolve($scope.skillTypes);
};
StudentInfoCtrl.addExam = function($scope){
    $scope.studentInfo.study.exams.push({
        grade: null,
        summer: true,
        course: null
    });
}
StudentInfoCtrl.sendStudentInfo = function($scope,$http,id) {
    $http.post('/rest/stud/'+id+'/edit',$scope.studentInfo)
        .success(function(){
            alert('the info is sent');
        })
        .error(function(data,status){
            alert('Error: '+status);
        });
};
StudentInfoCtrl.addSkill = function($scope) {
    $scope.studentInfo.skillSet.push( {
        level: null,
        id: 0,
        type: null
    })
};
StudentInfoCtrl.deleteSkill = function($scope,index) {
    $scope.studentInfo.skillSet.splice(index,1);
};
StudentInfoCtrl.deleteExam = function($scope,index) {
    $scope.studentInfo.study.exams.splice(index,1);
};