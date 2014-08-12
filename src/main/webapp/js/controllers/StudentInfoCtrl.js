
var StudentInfoCtrl = studentsControllers.controller('StudentInfoCtrl', ['$scope', '$routeParams','ProjectHistoryFactory', '$q', '$http', function ($scope, $routeParams,ProjectHistoryFactory, $q, $http) {
    if ($scope.studentInfo == null) { //make feedback-list-tab active
        $scope.active = 'active';
    }
    else {
        $scope.englishLevels = StudentInfoCtrl.englishLevels;
        $scope.salaries = StudentInfoCtrl.salaries;
        $scope.currentHours = StudentInfoCtrl.currentHours;
        $scope.states = StudentInfoCtrl.states;
        StudentInfoCtrl.getSkillSet($scope, $http, $q);
        StudentInfoCtrl.getProjectList($scope, $http, $q);
        $scope.addExam = function () {
            StudentInfoCtrl.addExam($scope);

        };
        $scope.sendStudentInfo = function () {
            StudentInfoCtrl.sendStudentInfo($scope, $http, $routeParams.studId);
        };
        $scope.addSkill = function () {
            StudentInfoCtrl.addSkill($scope);
        };
        $scope.deleteSkill = function (index) {
            StudentInfoCtrl.deleteSkill($scope,index);
        };
        $scope.deleteExam = function () {
            StudentInfoCtrl.deleteExam($scope);
        };
        $scope.addProject = function(){
            StudentInfoCtrl.addProject($scope);
        };
        $scope.deleteProject = function(index){
            StudentInfoCtrl.deleteProject($scope,index);
        }
//        $scope.reloadProjectHistory = function(){
//            $scope.projectHistoryList = ProjectHistoryFactory.getProjectHistory({studId: $scope.studentInfo.id});
//        };
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
StudentInfoCtrl.getSkillSet = function ($scope, $http, $q) {
    var deferred = $q.defer();
    $http.get('/rest/types/technology/get').success(function (data) {
        $scope.skillTypes = data;
    });
    deferred.resolve($scope.skillTypes);
};

StudentInfoCtrl.addExam = function ($scope) {
    $scope.studentInfo.study.exams.push({
        grade: null,
        summer: true,
        course: null
    });
}
StudentInfoCtrl.sendStudentInfo = function ($scope, $http, id) {
    $http.post('/rest/stud/' + id + '/edit', $scope.studentInfo)
        .success(function () {
            alert('the info is sent');
        })
        .error(function (data, status) {
            alert('Error: ' + status);
        });
};
StudentInfoCtrl.addSkill = function ($scope) {
    $scope.studentInfo.skillSet.push({
        level: null,
        id: 0,
        type: null
    })
};
StudentInfoCtrl.deleteSkill = function ($scope, index) {
    $scope.studentInfo.skillSet.splice(index, 1);
};
StudentInfoCtrl.deleteExam = function ($scope, index) {
    $scope.studentInfo.study.exams.splice(index, 1);
};
StudentInfoCtrl.salaries = [
    {name: 'Billable', value: true},
    {name: 'Not billable', value: false}
];

StudentInfoCtrl.currentHours = [
    {name: '20 hours', value: 20},
    {name: '30 hours', value: 30},
    {name: '40 hours', value: 40}
];

StudentInfoCtrl.states = [
    {name: 'Work', value: 'WORK'},
    {name: 'Practise', value: 'PRACTISE'},
    {name: 'Probation', value: 'PROBATION'}
];

StudentInfoCtrl.getProjectList = function ($scope, $http, $q) {
    var deferred = $q.defer();
    $http.get('/rest/proj/all').success(function (data) {
        $scope.projectNames = data;
    });
    deferred.resolve($scope.projectNames);

};
StudentInfoCtrl.addProject = function ($scope) {
    $scope.studentInfo.currentProjects.push({
        id: 0,
        title: null
    })
};

StudentInfoCtrl.deleteProject = function ($scope, index) {
    $scope.studentInfo.currentProjects.splice(index, 1);
};

